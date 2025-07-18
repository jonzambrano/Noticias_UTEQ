package com.example.noticias_uteq;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // 1. Encontrar el botón por su ID
        Button btnVerNoticias = findViewById(R.id.btnVerNoticias);

        // 2. Configurar el listener para el clic
        btnVerNoticias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 3. Crear un Intent para abrir MainActivity
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}