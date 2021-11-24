package com.example.ensamblesoftc4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.text.BreakIterator;


public class MainActivity extends AppCompatActivity {
    Button B1, B2;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        B1 = (Button) findViewById(R.id.btn_login);
        B2 = (Button) findViewById(R.id.btn_ckeckin_main);
        img = (ImageView) findViewById(R.id.img1);

        B2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent B2 = new Intent(MainActivity.this, MainActivity1.class);
                startActivity(B2);
            }
        });
    }
}

