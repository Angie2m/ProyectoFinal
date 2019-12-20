package com.example.proyectofinal;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.proyectofinal.Model.Ejercicio;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MainActivity extends AppCompatActivity implements Response.Listener<String>, Response.ErrorListener {
    /* Elementos gráficos */
    private ProgressBar pbConexion;
    private TextView tvEspere;
    private ListView lv;
    private Typeface fuenteFrontier;

    /* Elementos para volley */
    RequestQueue queue;
    StringRequest stringRequest;

    ByteArrayInputStream inputStream;
    ArrayList<Ejercicio> datos = new ArrayList<Ejercicio>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pbConexion = findViewById(R.id.pbConexion);
        lv = findViewById(R.id.lv);
        tvEspere = findViewById(R.id.tvEspere);
        fuenteFrontier = Typeface.createFromAsset(getAssets(), "Quicksand-Bold.otf");
        tvEspere.setTypeface(fuenteFrontier);
        queue = Volley.newRequestQueue(this);
        stringRequest = new StringRequest(Request.Method.GET,"http://192.168.100.184:8080/verEjercicios", this, this);
        queue.add(stringRequest);

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        pbConexion.setVisibility(View.GONE);

        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Aviso")
                .setMessage("Servicio no disponible en estos momentos.")
                .setPositiveButton("Reintentar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        queue.add(stringRequest);
                    }
                }).setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                queue.add(stringRequest);
            }
        }).setNegativeButton("Salir", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        })
                .show();
    }

    @Override
    public void onResponse(String response) {
        Log.d("DEPURACION", "+++++" + response.toString());
        pbConexion.setVisibility(View.GONE);
        inputStream = new ByteArrayInputStream(response.toString().getBytes());


        try {
            JSONArray ejercicios = new JSONArray(response.toString());
            for (int i = 0; i < ejercicios.length(); i++){
                JSONObject ob1 = new JSONObject(ejercicios.get(i).toString());
                Ejercicio ejercicioTemp = new Ejercicio();
                ejercicioTemp.setId(ob1.getLong("id"));
                ejercicioTemp.setNombre(ob1.getString("nombre"));
                ejercicioTemp.setTipo(ob1.getString("tipo"));
                datos.add(ejercicioTemp);
            }
            Adaptador adaptador = new Adaptador(MainActivity.this, datos);
            lv.setAdapter(adaptador);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(MainActivity.this,
                            Main2Activity.class);

                    Ejercicio tmp = (Ejercicio) parent.getItemAtPosition(position);

                    Bundle bundle = new Bundle();
                    bundle.putLong("ID",id);
                    bundle.putString("Nombre",tmp.getNombre());
                    bundle.putString("Maquina",tmp.getMaquina());
                    bundle.putString("Reps",tmp.getRepeticiones());
                    bundle.putString("Series",tmp.getSeries());
                    bundle.putString("Tipo",tmp.getTipo());
                    bundle.putString("Calentamiento",tmp.getCalentamiento());

                    intent.putExtras(bundle);
                    startActivity(intent);



                }
            });


        }catch (Exception e){
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Aviso")
                    .setMessage("Servicio no disponible en estos momentos.")
                    .setPositiveButton("Reintentar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            queue.add(stringRequest);
                        }
                    }).setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    queue.add(stringRequest);
                }
            }).setNegativeButton("Salir", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            })
                    .show();
        }
    }
}
