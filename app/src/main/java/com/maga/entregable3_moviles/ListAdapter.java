package com.maga.entregable3_moviles;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListAdapter extends BaseAdapter {
    Context Contexto;
    String[] Nombres, NumeroTelefono;
    int[] IdImagen;
    LayoutInflater inflater; //-> sirve para poner datos (inflar) en una interfaz grafica

    public ListAdapter (Context contexto,String[] nombres, String[] numeroTelefono, int[] idImagen) {
        this.Contexto = contexto;
        this.Nombres = nombres;
        this.NumeroTelefono = numeroTelefono;
        this.IdImagen = idImagen;
        inflater = LayoutInflater.from(Contexto);


    }

    @Override
    public int getCount() {
        return Nombres.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // Identificar quienes son
        view = inflater.inflate(R.layout.list_items, null);
        ImageView fotoperfil = view.findViewById(R.id.fotoperfilusuario);
        TextView nombreusuario = view.findViewById(R.id.nombre);
        TextView telefonousuario = view.findViewById(R.id.telefono);
        // mostrar datos
        fotoperfil.setImageResource(IdImagen[i]);
        nombreusuario.setText(Nombres[i]);
        telefonousuario.setText(NumeroTelefono[i]);
        return view;
    }
}
