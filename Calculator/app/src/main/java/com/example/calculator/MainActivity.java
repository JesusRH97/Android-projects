package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    /*Botones que vamos a utilizar en la calculadora*/
    private Button boton0;
    private Button boton1;
    private Button boton2;
    private Button boton3;
    private Button boton4;
    private Button boton5;
    private Button boton6;
    private Button boton7;
    private Button boton8;
    private Button boton9;
    private Button suma;
    private Button resta;
    private Button multiplicacion;
    private Button division;
    private Button igual;
    private Button CE;
    private Button Cientifica;
    private Button Autor;
    private Button decimal;

    /*Texto donde mostramos el resultado*/
    private TextView texto;

    double num1=0,num2=0,resultado=0;
    int opcion, k=1,x=0;

    /*X indica que ya se ha tecleado una operación. Opción indica que operación en concreto se ha tecleado.
    * K indica que se ha tecleado el botón de igual*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Declaración de botones*/
        boton0=(Button) findViewById(R.id.boton0);
        boton1=(Button) findViewById(R.id.boton1);
        boton2=(Button) findViewById(R.id.boton2);
        boton3=(Button) findViewById(R.id.boton3);
        boton4=(Button) findViewById(R.id.boton4);
        boton5=(Button) findViewById(R.id.boton5);
        boton6=(Button) findViewById(R.id.boton6);
        boton7=(Button) findViewById(R.id.boton7);
        boton8=(Button) findViewById(R.id.boton8);
        boton9=(Button) findViewById(R.id.boton9);
        CE=(Button) findViewById(R.id.CE);
        multiplicacion=(Button) findViewById(R.id.multiplicacion);
        division=(Button) findViewById(R.id.division);
        suma=(Button) findViewById(R.id.suma);
        resta=(Button) findViewById(R.id.resta);
        igual=(Button) findViewById(R.id.igual);
        Autor=(Button) findViewById(R.id.Nombre);
        Cientifica=(Button) findViewById(R.id.Activity);
        decimal=(Button) findViewById(R.id.decimal);

        /*Declaración de la pantalla*/
        texto=(TextView) findViewById(R.id.texto);


        texto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }

        });

        decimal.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String text = texto.getText().toString();
                if (!text.contains(".")){
                    text = text + ".";
                    texto.setText(text);
                }
            }
        });

        Autor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //texto.setText("Jesús Rueda Huélamo (NIA: 100345844)");
                Intent activity1 = new Intent(MainActivity.this, Main3Activity.class);
                startActivityForResult(activity1, 0);
            }

        });

        Cientifica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent activity1 = new Intent(MainActivity.this, Main2Activity.class);
                if(!texto.getText().equals("")) {
                    String mensaje = texto.getText().toString();
                    activity1.putExtra("contador", mensaje);
                    startActivityForResult(activity1, 0);
                }
                else{
                    String mensaje= new Double(num1).toString();
                    activity1.putExtra("contador", mensaje);
                    startActivityForResult(activity1, 0);
                }
            }

        });

        CE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                texto.setText("0");
                num1=0;
                num2=0.0;
                resultado=0.0;
                x=0;

            }

        });

        boton0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = texto.getText().toString();

                if(k==0){
                    if(text=="0"||text=="0.0"){
                        texto.setText("0");
                    }else{
                        text = text + "0";
                        texto.setText(text);}
                }else{
                    texto.setText("0");
                    k=0; }
            }

        });

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = texto.getText().toString();

                if(k==0){
                    if(text=="0"||text=="0.0"){
                        texto.setText("1");
                    }else{
                        text = text + "1";
                        texto.setText(text);}
                }else{
                    texto.setText("1");
                    k=0; }
            }

        });

        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = texto.getText().toString();

                if(k==0){
                    if(text=="0"||text=="0.0"){
                        texto.setText("2");
                    }else{
                        text = text + "2";
                        texto.setText(text);}
                }else{
                    texto.setText("2");
                    k=0; }
            }

        });

        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String text = texto.getText().toString();

                if(k==0){
                    if(text=="0"||text=="0.0"){
                        texto.setText("3");
                    }else{
                        text = text + "3";
                        texto.setText(text);}
                }else{
                    texto.setText("3");
                    k=0; }
            }

        });

        boton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = texto.getText().toString();

                if(k==0){
                    if(text=="0"||text=="0.0"){
                        texto.setText("4");
                    }else{
                        text = text + "4";
                        texto.setText(text);}
                }else{
                    texto.setText("4");
                    k=0; }
            }

        });

        boton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = texto.getText().toString();

                if(k==0){
                    if(text=="0"||text=="0.0"){
                        texto.setText("5");
                    }else{
                        text = text + "5";
                        texto.setText(text);}
                }else{
                    texto.setText("5");
                    k=0; }
            }

        });

        boton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = texto.getText().toString();

                if(k==0){
                    if(text=="0"||text=="0.0"){
                        texto.setText("6");
                    }else{
                        text = text + "6";
                        texto.setText(text);}
                }else{
                    texto.setText("6");
                    k=0; }


            }

        });

        boton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = texto.getText().toString();

                if(k==0){
                    if(text=="0"||text=="0.0"){
                        texto.setText("7");
                    }else{
                        text = text + "7";
                        texto.setText(text);}
                }else{
                    texto.setText("7");
                    k=0; }
            }

        });

        boton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = texto.getText().toString();

                if(k==0){
                    if(text=="0"||text=="0.0"){
                        texto.setText("8");
                    }else{
                        text = text + "8";
                        texto.setText(text);}
                }else{
                    texto.setText("8");
                    k=0; }
            }

        });

        boton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = texto.getText().toString();

                if(k==0){
                    if(text=="0"||text=="0.0"){
                        texto.setText("9");
                    }else{
                        text = text + "9";
                        texto.setText(text);}
                }else{
                    texto.setText("9");
                    k=0; }
            }

        });

        multiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!texto.getText().equals("")) {
                    if (((num1 == 0) || (num1 == resultado)) && (x == 0)) {
                        String aux1 = texto.getText().toString();
                        x = 1;
                        num1 = Double.parseDouble(aux1);
                        texto.setText("");
                        opcion = 3;
                    }
                }
            }

        });

        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!texto.getText().equals("")) {
                    if(((num1==0)||(num1==resultado))&&(x==0)){
                        String aux1= texto.getText().toString();
                        num1= Double.parseDouble(aux1);
                        x=1;
                        texto.setText("");
                        opcion=4; }
                }

            }

        });

        suma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!texto.getText().equals("")) {
                    if(((num1==0)||(num1==resultado))&&(x==0)){
                        String aux1= texto.getText().toString();
                        num1= Double.parseDouble(aux1);
                        x=1;
                        texto.setText("");
                        opcion=1; }
                }

            }

        });

        resta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                k=0;
                if (!texto.getText().equals("")) {
                    if(((num1==0)||(num1==resultado))&&(x==0)){
                        String aux1= texto.getText().toString();
                        num1= Double.parseDouble(aux1);
                        x=1;
                        texto.setText("");
                        opcion=2;
                    }}else if(opcion==3||opcion==4){
                    texto.setText("-"); }
            }

        });

        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!texto.getText().equals("")) {
                    String aux2= texto.getText().toString();
                    num2= Double.parseDouble(aux2);
                    texto.setText("");

                    if (opcion==1){
                        resultado=num1+num2;
                        texto.setText(""+resultado);
                        num1=resultado;
                        x=0;
                        k=1;
                        opcion=0;
                    }else if (opcion==2){
                        resultado=num1-num2;
                        texto.setText(""+resultado);
                        num1=resultado;
                        x=0;
                        k=1;
                        opcion=0;
                    }else if (opcion==3){
                        resultado=num1*num2;
                        texto.setText(""+resultado);
                        num1=resultado;
                        x=0;
                        k=1;
                        opcion=0;
                    }else if (opcion==4){
                        try {
                            resultado = num1 / num2;
                            texto.setText("" + resultado);
                            num1 = resultado;
                            k=1;
                            x = 0;
                            opcion=0;
                        }catch(NumberFormatException e){} }
                }

                else
                    resultado = num1;
                    texto.setText("" + resultado);
                    x = 0;
                    k = 1;
                    opcion=0;


                }



        });

    }


    public void onActivityResult(int RequestCode, int ResultCode, Intent data) {

        super.onActivityResult(RequestCode,ResultCode,data);
        if(data!=null){
            String dato=data.getStringExtra("Test");
            resultado=new Double(dato).doubleValue();
            texto.setText(""+resultado);
            num1=resultado;
        }
    }


    protected void onResume(){
        super.onResume();

    }
}

