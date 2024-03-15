package com.maga.entregable3_moviles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView ListarCorreos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] nombres = {
                "Luis Edwardo",
                "Juan Jose",
                "Maria Fernanda",
                "Facebook",
                "Gmail",
                "GitHub"
        };
        String[] telefonos = {
                "3002347021",
                "3002347022",
                "3002347023",
                "0",
                "0",
                "0"
        };
        String[] fechas = {
                "15/03/2024",
                "11/02/2024",
                "09/02/2024",
                "01/01/2024",
                "02/02/2024",
                "24/03/2024"
        };
        int[] fotoperfil = {
                R.drawable.hombre1,
                R.drawable.hombre2,
                R.drawable.mujer1,
                R.drawable.facebook,
                R.drawable.gmail,
                R.drawable.github
        };
        ListAdapter personas = new ListAdapter(MainActivity.this, nombres, telefonos, fotoperfil);
        ListarCorreos = (ListView) findViewById(R.id.listausuarios);
        ListarCorreos.setAdapter(personas);

        ListarCorreos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> lista, View vista, int posicion, long id) {
                Intent enviarInfo = new Intent(MainActivity.this, SegundaPantalla.class)
                        .putExtra("nombre", nombres[posicion])
                        .putExtra("telefono", telefonos[posicion])
                        .putExtra("imagen", fotoperfil[posicion]);

                startActivity(enviarInfo);
            }
        });
    }
}