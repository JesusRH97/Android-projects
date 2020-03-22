package com.example.checklist;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager pager;
    private SliderPagerAdapter pagerAdapter;
    private ArrayList<String> data;
    private ArrayList<String> paginas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = new ArrayList<String>();
        paginas=new ArrayList<String>();
        paginas.add("");

        pagerAdapter = new SliderPagerAdapter(getSupportFragmentManager(), data);

        pager =  findViewById(R.id.pager);

        pager.setAdapter(pagerAdapter);

        
    }

    /*Con este método mostramos y ocultamos el menú*/
    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.checklist, menu);

        return true;

    }

    /*Método para mostrar las diferentes opciones*/
    public boolean onOptionsItemSelected(MenuItem item){

        /*Recuperamos el item que se está pulsando*/
        int id=item.getItemId();

        if(id==R.id.item1){
            Intent activity1 = new Intent(MainActivity.this,Main2Activity.class);
            startActivityForResult(activity1,0);
        }

        if(id==R.id.item2){
            Intent activity1 = new Intent(MainActivity.this,Main3Activity.class);
            startActivityForResult(activity1,0);
        }

            return super.onOptionsItemSelected(item);
    }

    public void onActivityResult(int RequestCode, int ResultCode, Intent datos) {

        super.onActivityResult(RequestCode, ResultCode, datos);
        if (datos != null) {
            String titulo = datos.getStringExtra("Test");

            if(ResultCode==-1){
                if (paginas.contains("" + titulo) == false) {
                    data.add("" + titulo);
                    pagerAdapter.notifyDataSetChanged();
                    paginas.add("" + titulo);
                }
                else {
                    Toast.makeText(this, "Ya existe esa página", Toast.LENGTH_LONG).show();

                }
            }

            if(ResultCode==1)
                Toast.makeText(this, "Operación cancelada", Toast.LENGTH_LONG).show();
        }
    }

    protected void onResume(){
        super.onResume();

    }
}
