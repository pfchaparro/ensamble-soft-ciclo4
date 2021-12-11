package com.example.ensambest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class PrincipalActivity extends AppCompatActivity {

    private Button carrit;
    private Button categorias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        carrit = (Button) findViewById(R.id.btcarrito);

        carrit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(HomeActivity.this,LoginActivity.class);
                Intent intent = new Intent(PrincipalActivity.this,CarritoActivity.class);
                startActivity(intent);
            }
        });


        categorias = (Button) findViewById(R.id.btcategorias);

        categorias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PrincipalActivity.this,CatalogoActivity.class);
                startActivity(intent);
            }
        });




    }
}