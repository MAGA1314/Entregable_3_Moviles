package com.maga.entregable3_moviles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Date;
// Se crean los datos y se envian a la saiguiente pantalla
public class MainActivity extends AppCompatActivity {

    ListView ListarCorreos;
    // Recuperar el mensaje extra del Intent
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Intent intent1 = getIntent();
        if (intent1 != null) {
            String mensajess = intent1.getStringExtra("mensaje");

            // Mostrar el mensaje en un TextView u otro componente según tu diseño
            TextView textView = findViewById(R.id.tvmensaje);
            textView.setText(mensajess);
        }*/


        String[] nombres = {
                "Luis Edwardo",
                "Juan Jose",
                "Maria Fernanda",
                "Facebook",
                "Gmail",
                "GitHub",
                "FIFA"
        };
        String[] telefonos = {
                "3002347021",
                "3002347022",
                "3002347023",
                "0",
                "0",
                "0",
                "*432#"
        };
        String[] fechas = {
                "15/03/2024",
                "11/02/2024",
                "09/02/2024",
                "01/01/2024",
                "02/02/2024",
                "24/03/2024",
                "17/03/2024"
        };
        String[] mensaje = {
                "mensaje 1",
                "mensaje 2",
                "mensaje 3",
                "mensaje 4",
                "mensaje 5",
                "mensaje 6",
                "mensaje 7"
        };
        int[] fotoperfil = {
                R.drawable.hombre1,
                R.drawable.hombre2,
                R.drawable.mujer1,
                R.drawable.facebook,
                R.drawable.gmail,
                R.drawable.github,
                R.drawable.fifa
        };
        // Crear una lista para almacenar el estado de leído de cada mensaje
        //boolean[] mensajesLeidos = new boolean[nombres.length];

        /*// Verificar el estado de cada mensaje
        SharedPreferences sharedPreferences = getSharedPreferences("MisPreferencias", MODE_PRIVATE);
        for (int i = 0; i < nombres.length; i++) {
            mensajesLeidos[i] = sharedPreferences.getBoolean(nombres[i], false);
        }*/

        // Pasar la información de mensajes leídos al adaptador
        ListAdapter personas = new ListAdapter(MainActivity.this, nombres, telefonos, fechas, mensaje, fotoperfil);
        ListarCorreos = (ListView) findViewById(R.id.listausuarios);
        ListarCorreos.setAdapter(personas);

        ListarCorreos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> lista, View vista, int posicion, long id) {
                // Marcar el email como leído
                SharedPreferences sharedPreferences = getSharedPreferences("MisPreferencias", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean(nombres[posicion], true); // Usar el nombre como clave
                editor.apply();

                Intent enviarInfo = new Intent(MainActivity.this, SegundaPantalla.class)
                        .putExtra("nombre", nombres[posicion])
                        .putExtra("telefono", telefonos[posicion])
                        .putExtra("fecha", fechas[posicion])
                        .putExtra("mensaje", mensaje[posicion])
                        .putExtra("imagen", fotoperfil[posicion]);

                startActivity(enviarInfo);
            }
        });
    }
}