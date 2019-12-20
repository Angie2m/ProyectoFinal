package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    private final static String LOGTAG = "DEPURACION";

    TextView tvNombre,tvDescrip,tvCompl;
    Button btnEmpezar;
    ImageView ivEjercicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle bundle = this.getIntent().getExtras();

        Long id = bundle.getLong("ID");
        final String nombre = bundle.getString("Nombre");
        final String maquina = bundle.getString("Maquina");
        final String tipo = bundle.getString("Tipo");
        final String series = bundle.getString("Series");
        final String repeticiones = bundle.getString("Reps");
        final String calentamiento = bundle.getString("Calentamiento");

        tvNombre = findViewById(R.id.tvNombre);
        tvDescrip = findViewById(R.id.tvDescrip);
        tvCompl = findViewById(R.id.tvComp);
        ivEjercicio = findViewById(R.id.ivEjercicio);
        btnEmpezar = findViewById(R.id.btnEmpezar);

        tvNombre.setText(nombre);

        if(tipo.equals("1")){
            tvDescrip.setText("Este ejercicio es parte de tu rutina de cardio.");
        }else if (tipo.equals("2")){
            tvDescrip.setText("Este ejercicio es parte de tu rutina de estiramiento.");
        }else if (tipo.equals("3")){
            tvDescrip.setText("Este ejercicio es parte de tu rutina de fuerza.");
        }
        Log.d(LOGTAG,"Series "+nombre+" maquina "+maquina);

        tvCompl.setText("Para este ejercicio necesitas "+maquina+"\n"+
                        "Se recomienda hacer "+series+" series, "+repeticiones+" repeticiones y "+
                        "antes que nada tener un calentamiento de "+calentamiento);

        btnEmpezar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Ejercicio: "+nombre+" comenzando...",Toast.LENGTH_LONG);
            }
        });

        switch (nombre){
            case "Pesas":
                ivEjercicio.setImageResource(R.drawable.img1);
                break;
            case "Spining":
                ivEjercicio.setImageResource(R.drawable.img2);
                break;
            case "Remo":
                ivEjercicio.setImageResource(R.drawable.img3);
                break;
            case "Box":
                ivEjercicio.setImageResource(R.drawable.img4);
                break;
            case "Yoga":
                ivEjercicio.setImageResource(R.drawable.img5);
                break;
            case "Karate":
                ivEjercicio.setImageResource(R.drawable.img6);
                break;
            case "Push ups":
                ivEjercicio.setImageResource(R.drawable.img7);
                break;
            case "Abs":
                ivEjercicio.setImageResource(R.drawable.img8);
                break;
            case "Sentadillas":
                ivEjercicio.setImageResource(R.drawable.img9);
                break;
            case "Correr":
                ivEjercicio.setImageResource(R.drawable.img10);
                break;

        }
    }
}
