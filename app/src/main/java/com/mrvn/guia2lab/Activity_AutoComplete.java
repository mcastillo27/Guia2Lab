package com.mrvn.guia2lab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class Activity_AutoComplete extends AppCompatActivity {
    AutoCompleteTextView Pais;
    AutoCompleteTextView Carrera;
    AutoCompleteTextView Equipo;
    Button Procesar;
    int Progreso=0;
    ProgressBar Barra;
    boolean ValidacionClick=false;
    String [] listPaises = {"El Salvador","Guatemala","Honduras","Costa Rica","Nicaragua","Panama"};
    String [] listCarreras = {"Sistemas","Industrial","Electrica","Agronegocios"};
    String [] listEquipos = {"Barcelona","Real Madrid","Valencia","Atletico de Madrid","Cadiz","Villareal"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__auto_complete);
        Procesar = findViewById(R.id.btnProcesar);
        Pais = findViewById(R.id.txtPais);
        Carrera = findViewById(R.id.txtCarrera);
        Equipo = findViewById(R.id.txtEquipo);
        Barra = findViewById(R.id.Barra);
        ArrayAdapter<String> AdapterPais = new ArrayAdapter<>(this, android.R.layout.select_dialog_item, listPaises);
        Pais.setThreshold(1);
        Pais.setAdapter(AdapterPais);

        ArrayAdapter<String> AdapterCarrera = new ArrayAdapter<>(this, android.R.layout.select_dialog_item, listCarreras);
        Carrera.setThreshold(1);
        Carrera.setAdapter(AdapterCarrera);

        ArrayAdapter<String> AdapterEquipo = new ArrayAdapter<>(this, android.R.layout.select_dialog_item, listEquipos);
        Equipo.setThreshold(1);
        Equipo.setAdapter(AdapterEquipo);

        Procesar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            setProgressValue(0);
            MostrarToast();
        }
    });
    }
    public void MostrarToast(){
        Toast.makeText(this,"Pais Seleccionado: " + Pais.getText()+"\n"+
        "Carrera Seleccionada: " + Carrera.getText()+"\n"+"Equipo Seleccionado: " + Equipo.getText(),Toast.LENGTH_SHORT).show();
    }
    private void setProgressValue(final int progress){
        Barra.setProgress(progress);
        Progreso = progress;
        Thread  thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                setProgressValue(progress+10);
            }
        });
        thread.start();
    }
}
