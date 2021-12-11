package com.example.ensambest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    private Button botonUsuario, botonAdmin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        botonUsuario = (Button) findViewById(R.id.botonusuario);

        botonUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(HomeActivity.this,LoginActivity.class);
                Intent intent = new Intent(HomeActivity.this,PrincipalActivity.class);
                startActivity(intent);
            }
        });


    }
}