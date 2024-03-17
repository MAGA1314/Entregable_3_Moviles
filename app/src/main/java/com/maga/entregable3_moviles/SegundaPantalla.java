package com.maga.entregable3_moviles;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class SegundaPantalla extends AppCompatActivity {
    String nombre, telefono, fecha, mensaje;
    int imagen;
    CircleImageView foto;
    TextView textoNombre, textoTelefono, textoFecha, textoMensaje;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_items);
        textoNombre = findViewById(R.id.nombre);
        textoTelefono = findViewById(R.id.telefono);
        textoFecha = findViewById(R.id.fecha);
        textoMensaje = findViewById(R.id.mensajeu);
        foto = findViewById(R.id.fotoperfilusuario);

        Intent recibir = this.getIntent();
        if(recibir != null) {
            nombre = recibir.getStringExtra("nombre");
            telefono = recibir.getStringExtra("telefono");
            fecha = recibir.getStringExtra("fecha");
            mensaje = recibir.getStringExtra("mensaje");
            imagen = recibir.getIntExtra("imagen", R.drawable.imagenpordefecto);

            // Falta asignar el nombre y telefono al Textview correspondiente
            // la imagen al circleimagen
            textoNombre.setText(nombre);
            textoTelefono.setText(telefono);
            textoFecha.setText(fecha);
            textoMensaje.setText(mensaje);

            // Assigning image resource to CircleImageView
            foto.setImageResource(imagen);

            // Verificar si el email ha sido leído
            SharedPreferences sharedPreferences = getSharedPreferences("MisPreferencias", MODE_PRIVATE);
            boolean emailLeido = sharedPreferences.getBoolean(nombre, false);

            // Actualizar la interfaz de usuario basada en si el email ha sido leído
            if (emailLeido) {
                // Cambiar la apariencia del email para indicar que ha sido leído
                // Por ejemplo, cambiar el color de fondo de un elemento de la vista
                textoNombre.setBackgroundColor(Color.GRAY);
            }
            Button buttonVolver = findViewById(R.id.buttonVolver);
            buttonVolver.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    finish(); // Finaliza la actividad actual, regresando a la anterior.
                }
            });
        }
    }

}

