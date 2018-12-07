package com.example.leinadumbrae.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Serializable { // hay que hacer serializable esta madre, por que si no no jala

    // SE AGREGAR TODOS LOS COMPONENTES QUE SE VAN A USAR
    Button b1,bsig;
    RadioButton r1, r2;
    EditText n1;
    CheckBox c1;

    //ESTE LISTVIEW ES PARA VER EN TIEMPO REAL LOS OBJETOS QUE SE ESTAN AGREGANDO (SI QUIEREN NO LO AGREGEN NO ERA PARTE DE LA PRACTICA)
    ListView list;

    //ESTAS SON LAS CARACTERISTICAS DE NUESTRO OBJETO (LOS DATOS DE LAS PERSONAS, YA UDS PONGAN LOS QUE QUIERAN)
    String interes, nombre, sexo, guardar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();   //ESTA LINEA ES PARA QUITAR LA BARRA DE TAREAS (ES OPCIONAL)

        //ESTE ES EL SPINNER QUE PIDIO, YO LO ESTOY USANDO PARA GUARDAR VARIOS VALORES QUE SEGUN EL SELECCIONADO SE GUARDARA EN EL STRING "INTERES"
        final String [] array={"Sin Interes","pay","pastel","muffin"}; //CONTENIDO DEL ARREGLO
        ArrayAdapter <String> myadapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,array); //ACAPTADOR CONTENIENDO EL ARREGLO
        final Spinner l1 = (Spinner) findViewById(R.id.l1); //DECLARANCION DEL SPINER
        l1.setAdapter(myadapter); // LE DECIMOS AL LISTVIEW QUE LEA LO QUE TIENE EL ADAPTADOR (METEMOS EL ADAPTADOS EN EL LISTVIEW)


        // DECLARAMOS LOS BOTONES Y DEMAS COSAS QUE USAREMOS EN EL DISENIO
        b1 = (Button)findViewById(R.id.b1);
        bsig = (Button)findViewById(R.id.bsig);
        r1 = (RadioButton) findViewById(R.id.r1);
        r2 = (RadioButton) findViewById(R.id.r2);
        n1 = (EditText) findViewById(R.id.n1);
        c1 = (CheckBox) findViewById(R.id.c1);

        //DECLARACION DEL OBJETO TIPO DATOS
        final Datos[] datos = new Datos[1];
        list = (ListView) findViewById(R.id.list);
        // EN ARREGLO TIPO LISTA PARA METER LOS QUE CONTENGA NUESTRA LISTA
        final ArrayList  <Datos>  listadatos = new ArrayList <Datos>();



        // CUANDO YA HAYAMOS LLENADO CADA UNO DE LOS CAMPOS HACEMOS CLIC EN ESTE BOTON Y SERA QUIEN RECOLECTE LA INFORMACION
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                interes = l1.getSelectedItem().toString(); // ES PARA OBTENER LOS DATOS EN STRING SEGUN ESTE SELECCIONADO
                nombre = n1.getText().toString(); // OBTIENE EL NOMBRE EN STRING

                // ESTO ES PARA LA SELECCION DE SEXO (ES BHOMBRE, MUJER O SE QUEDA VACIO)
                if (r1.isChecked())
                    sexo = "mujer";// SI SELECCIONAMOS EL PRIMERO ES MUJER
                else if (r2.isChecked())
                    sexo = "hombre"; //SI SELECCIONAMOS EL SEGUNDO ES HOMBRE
                else
                    sexo = ""; //VACIO

                // ESTO ES PARA EL CHECK BOX QUE PIDIO, SOLO MUETRA UN MENSAJE EN PANTALLA SE SE GUARDO ALGO (LO QUITE, ES INECESARIO EL MENSAJE)
                if (c1.isChecked())
                    guardar = "Usuarios Guardado";
                else
                    guardar = "";

                //esta parte es despues de capturar los datos de la persona (los que llenaran el objeto)
                Datos datos2 = new Datos(nombre,sexo,interes); //son los 3 parametros que se piden
                listadatos.add(datos2); // agrega a la lista los datos


                // esto es para ver si esta capturando valores y verlos (no es parte de la practica pero igual lo puse)
                if (listadatos!=null)
                {
                    //en caso de no estar vacia lo muestra en el listview (es para verlo en tiempo real)
                    ArrayAdapter<Datos> ad = new ArrayAdapter<Datos>(MainActivity.this, android.R.layout.simple_expandable_list_item_1, listadatos);
                    list.setAdapter(ad);
                }
                else {
                    Toast toast = Toast.makeText(getApplicationContext(), "lista vacia", Toast.LENGTH_SHORT);
                    toast.show();
                }

                l1.setSelection(0); // le dimos a list view que se regrese a la posicion inicial
                limpiar(); // metodo para poner limpiar

            }
        });

        //este es el boton para ir al siguiente activity
        bsig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                Intent intent = new Intent(MainActivity.this, Main3Activity.class); // de decimos donde esta a donde va
                Bundle args = new Bundle(); // no no recuerdo para que vergas es pero lo lleva, pero es para enviar los datos
                args.putSerializable("A",(Serializable) listadatos); // le damos una llave, lo seializamos y le decimos que mandar
                intent.putExtra("B", args); //lo enviamos con la madre de arriba que no recuerdo como se llama
                startActivity(intent); // hacemos el envio


            }
        });

    }
                            //metodo para limpiar y negar (reiniciar)
    public void limpiar()
    {
        n1.setText("");
        r1.setChecked(false);
        r2.setChecked(false);
        c1.setChecked(false);
    }
}
