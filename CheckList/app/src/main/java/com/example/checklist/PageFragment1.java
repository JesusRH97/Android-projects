package com.example.checklist;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class PageFragment1 extends Fragment {

    private ArrayList<String> itemList=new ArrayList<>();

        private ArrayAdapter<String> adapter;
        private String titulo;
        private String texto;

        private ListView list;
        private Button boton;
        private EditText edit_item;
        private TextView nombre;

        private int cont=0;


        static PageFragment1 newInstance(String palabra) { // Any argument can be used

            PageFragment1 fragment = new PageFragment1();
            Bundle args = new Bundle();
            args.putString("num", palabra);
            fragment.setArguments(args); // The bundle is available inside onCreate()
            return fragment;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            titulo = getArguments() != null ? getArguments().getString("num") : "";

        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.page_1, container, false);
            list = (ListView) rootview.findViewById(R.id.page1);
            boton = (Button) rootview.findViewById(R.id.añadir);
            edit_item = (EditText) rootview.findViewById(R.id.caja);
            nombre = (TextView) rootview.findViewById(R.id.texto);


            nombre.setText("Titulo: "+titulo);

            final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),
                    android.R.layout.simple_expandable_list_item_1, itemList);
            list.setAdapter(adapter);


            list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setTitle(R.string.confirmacion);
                    String msg=getResources().getString(R.string.confirmar);
                    builder.setMessage(msg);

                    builder.setPositiveButton(R.string.borrar, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            itemList.remove(position);
                            adapter.notifyDataSetChanged();

                        }
                    });

                    builder.setNegativeButton(android.R.string.cancel, null);
                    builder.create().show();
                    return true;
                }
            });

            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                    String item = adapter.getItem(position);
                        boolean tick=false;
                        String item_actualizado = new String();
                        item_actualizado="";

                        for(int i=0;i<item.length();i++){

                            char letra=item.charAt(i);

                            if(letra!='✓'){
                                tick=false;
                            }
                            else {
                                tick=true;
                                break;

                            }
                        }

                        if(tick==true){

                            for(int i=0;i<item.length();i++){

                                char letra=item.charAt(i);

                                if(letra!='✓'){
                                    item_actualizado =  item_actualizado+letra;
                                }
                                else
                                    break;
                            }

                            itemList.remove(position);
                            itemList.add(position, item_actualizado);
                            adapter.notifyDataSetChanged();
                        }

                        else {
                            Toast.makeText(getActivity(), "Has escogido '"+itemList.get(position)+"'", Toast.LENGTH_SHORT).show();
                            item_actualizado = "" + item + "✓";
                            itemList.remove(position);
                            itemList.add(position, item_actualizado);
                            adapter.notifyDataSetChanged();

                        }

                }
            });


            boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                texto=edit_item.getText().toString();

                    if(itemList.contains(""+texto)==false) {
                        itemList.add(texto);
                        edit_item.setText("");
                        adapter.notifyDataSetChanged();
                    }
            }

        });

        return rootview;

    }


}
