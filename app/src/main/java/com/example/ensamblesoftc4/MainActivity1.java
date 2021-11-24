package com.example.ensamblesoftc4;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.LayoutInflaterCompat;

import com.example.ensamblesoftc4.db.DbHelper;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity1 extends AppCompatActivity {

    Spinner spinner1;
    Button B3;
    EditText E1, E2, E3, E4, E5, E6;
    TextInputLayout txtInputEmail, txtInputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);


        spinner1 = (Spinner) findViewById(R.id.spinner);
        B3 = (Button) findViewById(R.id.btn_ckeckin_main1);
        E1 = (EditText) findViewById(R.id.eNumberIdentification);
        E2 = (EditText) findViewById(R.id.eName);
        E3 = (EditText) findViewById(R.id.eLastName);
        E4 = (EditText) findViewById(R.id.ePhone);
        E5 = (EditText) findViewById(R.id.eEmail);
        E6 = (EditText) findViewById(R.id.ePassword);
        txtInputEmail = (TextInputLayout) findViewById(R.id.txtInputEmail);
        txtInputPassword = (TextInputLayout) findViewById(R.id.txtInputPassword);

        String [] opciones = {"Selecciona el tipo de identificación", "CEDULA DE CUIDADANIA", "TARJETA DE IDENTIDAD", "REGISTRO CIVIL", "CEDULA DE EXTRANGERIA", "PASAPORTE", "SALVOCONDUCTO"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, opciones);
        spinner1.setAdapter(adapter);

        B3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num_ident, nombre, apellido, num_tel, correo, contraseña;
                boolean v1,v2,v3,v4,v5,v6;
                num_ident=E1.getText().toString();
                nombre=E2.getText().toString();
                apellido=E3.getText().toString();
                num_tel=E4.getText().toString();
                correo=E5.getText().toString();
                contraseña=E6.getText().toString();

                v1=num_ident.matches("[0-9].*");
                v2=nombre.matches("[A-Z].*");
                v3=apellido.matches("[A-Z].*");
                v4=num_tel.matches("[0-9].*");
                v5=correo.matches("[-\\w\\.]+@\\w+\\.\\w+");
                v6=contraseña.matches("(?=.*[@#$%^&+=])"+"(?=\\S+$)"+".{8,}"+"$");

                DbHelper dbHelper = new DbHelper(MainActivity1.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                if (v1==true && v2==true && v3==true && v4==true && v5==true && v6==true){
                    Toast.makeText(MainActivity1.this,"DATOS INGRESADOS CORRECTAMENTE Y BASE DE DATOS CREADA",Toast.LENGTH_LONG).show();
                    Intent B3 = new Intent(MainActivity1.this, MainActivity.class);
                    startActivity(B3);
                } else {
                    Toast.makeText(MainActivity1.this,"DATOS INCORRECTOS",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}