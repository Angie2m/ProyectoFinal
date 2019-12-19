package com.example.proyectofinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.proyectofinal.Model.Ejercicio;

import java.util.ArrayList;



public class Adaptador extends BaseAdapter {

    private static LayoutInflater inflater = null;

    Context contexto;
    ArrayList<Ejercicio> datos;


    public Adaptador(Context contexto, ArrayList<Ejercicio> datos) {
        this.contexto = contexto;
        this.datos = datos;

        inflater = (LayoutInflater) contexto
                .getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return datos.size();
    }

    @Override
    public Object getItem(int position) {
        return datos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return datos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View vista = inflater.inflate(R.layout
                .elemento_lista, null);

        TextView tvNombre = vista.findViewById(R.id.tvNombre);
        TextView tvTipo = vista.findViewById(R.id.tvTipo);
        tvNombre.setText(datos.get(position).getNombre());
        tvTipo.setText(datos.get(position).getTipo());

        return vista;
    }
}
