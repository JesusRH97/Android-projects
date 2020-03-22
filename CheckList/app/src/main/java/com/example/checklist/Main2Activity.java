package com.example.checklist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    private Button boton;
    private Button cancelar;
    private TextView ventana;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        boton=(Button) findViewById(R.id.añadir);
        cancelar=(Button) findViewById(R.id.volver);
        ventana=(TextView) findViewById(R.id.caja);

        boton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                String texto="";
                texto=ventana.getText().toString();
                Intent activity1 = new Intent();
                activity1.putExtra("Test", texto);
                setResult(MainActivity.RESULT_OK, activity1);
                finish();

            }
        });

        cancelar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                String texto="";
                Intent activity1 = new Intent();
                activity1.putExtra("Test", texto);
                setResult(MainActivity.RESULT_FIRST_USER, activity1);
                finish();

            }
        });
    }
}
