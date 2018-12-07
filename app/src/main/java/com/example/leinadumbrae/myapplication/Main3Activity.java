package com.example.leinadumbrae.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity implements Serializable { //tambien lo hice serializable por si las dudas

Button b1; //boton para ver los objetos
ListView li; //listview para ver los objetos
   Spinner li2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        getSupportActionBar().hide();//quitar la toolbar
        b1 = (Button) findViewById(R.id.b1);
        li = (ListView) findViewById(R.id.li);


      //  final String [] array={"Sin Interes","pay","pastel","muffin"}; //CONTENIDO DEL ARREGLO
       // ArrayAdapter <String> myadapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,array); //ACAPTADOR CONTENIENDO EL ARREGLO
        //final Spinner l1 = (Spinner) findViewById(R.id.l1); //DECLARANCION DEL SPINER
        //l1.setAdapter(myadapter);



        //obtenemos los valores
        Intent i = getIntent();
        Bundle args = i.getBundleExtra("B"); // esta tiene que ser la misma que mandamos del activiti donde recojemos los valores

        final ArrayList<Datos> list=(ArrayList<Datos>) args.getSerializable("A"); //  recuperamos la lista de objetos, tiene que ser la misma llave

        //boton para ver las cosas (actualiza los datos, leeyendo la lista de objetos cada vez que se presiona)
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // es para ver las cosas, igual pueden sacarlo sdel boton y dejarlo directo pero yo lo puse asi para ver q pdo
            ArrayAdapter<Datos> ad = new ArrayAdapter<Datos>(Main3Activity.this,android.R.layout.simple_expandable_list_item_1,list);
            li.setAdapter(ad);// metemos el contenido del adaptador en la list view

                final Spinner li2 = (Spinner) findViewById(R.id.li2); //DECLARANCION DEL SPINER
                li2.setAdapter(ad);

            }
        });






    }
}
