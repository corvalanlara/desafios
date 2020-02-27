package com.example.desafio3.api;

import com.example.desafio3.beans.PreguntasLista;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("api.php?amount=1&category=18&difficulty=medium&type=boolean&encode=url3986")
    Call<PreguntasLista> getQuestion();
}
