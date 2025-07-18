package com.example.noticias_uteq;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface ApiService {
    // Token de acceso
    String TOKEN = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJfeDF1c2VyZGV2IiwiaWF0IjoxNzUyODY4NjIwLCJleHAiOjE3NTI5NTUwMjB9.tZPdC3XwEOhgHZz_QFk5TQa2SrFXimlgVSFa6cwhiwY";

    // Endpoint para obtener las noticias
    @GET("h6RPoSoRaah0Y4Bah28eew/functions/information/entity/1")
    Call<List<Noticia>> getNoticias(@Header("Authorization") String token);
}