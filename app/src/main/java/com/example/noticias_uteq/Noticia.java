package com.example.noticias_uteq;

import com.google.gson.annotations.SerializedName;

public class Noticia {

    @SerializedName("ntTitular")
    private String titular;

    @SerializedName("ntFecha")
    private String fecha;

    @SerializedName("ntUrlNoticia")
    private String urlNoticiaParcial;

    @SerializedName("ntUrlPortada")
    private String urlPortadaParcial;

    // Getters para acceder a los datos
    public String getTitular() { return titular; }
    public String getFecha() { return fecha; }
    public String getUrlNoticiaParcial() { return urlNoticiaParcial; }
    public String getUrlPortadaParcial() { return urlPortadaParcial; }
}