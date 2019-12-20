package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

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
        String maquina = bundle.getString("Maquina");
        String tipo = bundle.getString("Tipo");
        String series = bundle.getString("Series");
        String repeticiones = bundle.getString("Reps");
        String calentamiento = bundle.getString("Calentamiento");

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

        tvCompl.setText("Para este ejercicio necesitas "+maquina+"\n"+
                        "Se recomienda hacer "+series+" series, "+repeticiones+" repeticiones y "+
                        "antes que nada tener un calentamiento de "+calentamiento);

        btnEmpezar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Ejercicio: "+nombre+" comenzando...",Toast.LENGTH_LONG);
            }
        });

        switch (Integer.parseInt(""+id)){
            case 1:
                ivEjercicio.setImageResource(R.drawable.img1);
                break;
            case 2:
                ivEjercicio.setImageResource(R.drawable.img2);
                break;
            case 3:
                ivEjercicio.setImageResource(R.drawable.img3);
                break;
            case 4:
                ivEjercicio.setImageResource(R.drawable.img4);
                break;
            case 5:
                ivEjercicio.setImageResource(R.drawable.img5);
                break;
            case 6:
                ivEjercicio.setImageResource(R.drawable.img6);
                break;
            case 7:
                ivEjercicio.setImageResource(R.drawable.img7);
                break;
            case 8:
                ivEjercicio.setImageResource(R.drawable.img8);
                break;
            case 9:
                ivEjercicio.setImageResource(R.drawable.img9);
                break;
            case 10:
                ivEjercicio.setImageResource(R.drawable.img10);
                break;

        }
    }
}
