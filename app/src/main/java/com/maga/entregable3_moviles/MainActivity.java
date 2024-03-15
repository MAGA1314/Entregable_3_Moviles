package com.maga.entregable3_moviles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView ListarCorreos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] nombres = {
                "Luis",
                "Juan",
                "Pedro"
        };
        String[] telefonos = {
                "123",
                "345",
                "678"
        };
        int[] fotoperfil = {
                R.drawable.img2,
                R.drawable.img3,
                R.drawable.img4
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