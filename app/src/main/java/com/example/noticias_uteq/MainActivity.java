package com.example.noticias_uteq;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar; // Importante: Añadir este import
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import okhttp3.OkHttpClient; // Importar OkHttpClient
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private NoticiasAdapter noticiasAdapter;
    private List<Noticia> listaDeNoticias = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // --- CÓDIGO AÑADIDO PARA CONFIGURAR LA TOOLBAR ---
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Últimas Noticias");
        }
        // ----------------------------------------------

        // Configurar el RecyclerView (código que ya tenías)
        recyclerView = findViewById(R.id.recyclerViewNoticias);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        noticiasAdapter = new NoticiasAdapter(this, listaDeNoticias);
        recyclerView.setAdapter(noticiasAdapter);

        // Llamar al método para obtener los datos de la API (código que ya tenías)
        obtenerDatosDeNoticias();
    }

    private void obtenerDatosDeNoticias() {
        // Configurar Retrofit (código que ya tenías)
        OkHttpClient okHttpClient = UnsafeOkHttpClient.getUnsafeOkHttpClient();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://apiws.uteq.edu.ec/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);
        Call<List<Noticia>> call = apiService.getNoticias(ApiService.TOKEN);

        call.enqueue(new Callback<List<Noticia>>() {
            @Override
            public void onResponse(Call<List<Noticia>> call, Response<List<Noticia>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    listaDeNoticias.clear();
                    listaDeNoticias.addAll(response.body());
                    noticiasAdapter.notifyDataSetChanged();
                } else {
                    Log.e("API_ERROR", "Respuesta no exitosa o cuerpo nulo");
                }
            }

            @Override
            public void onFailure(Call<List<Noticia>> call, Throwable t) {
                Log.e("API_FAILURE", "Error al conectar con la API: " + t.getMessage());
            }
        });
    }
}