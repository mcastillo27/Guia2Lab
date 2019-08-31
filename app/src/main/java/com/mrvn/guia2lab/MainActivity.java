package com.mrvn.guia2lab;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnDatos;
    Button btnIniciar;
    EditText Correo, Password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Correo = findViewById(R.id.txtCorreo);
        Password = findViewById(R.id.txtPassword);
        btnDatos = findViewById(R.id.btnMisDatos);
        btnIniciar = findViewById(R.id.btnIniciar);
        btnDatos.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), Datos.class);
                startActivityForResult(i, 0);
            }
        });
        btnIniciar.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v) {
                if(Validacion()) {
                    Intent i = new Intent(v.getContext(), Activity_AutoComplete.class);
                    startActivityForResult(i, 0);
                }
                return false;
            }
        });
    }
    public boolean Validacion(){
        boolean valor=false;
        if (Correo.getText().toString().isEmpty() && Password.getText().toString().isEmpty()){
            Toast.makeText(this,"Los Campos no pueden quedar vacios",Toast.LENGTH_SHORT).show();
        }else{
            valor=true;
        }

        return valor;
    }
}
