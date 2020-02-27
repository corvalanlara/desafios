package com.example.desafio3.beans;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class PreguntasLista {

    @SerializedName("response_code")
    private int response_code;

    @SerializedName("results")
    private List<Pregunta> results;

    public int getResponse_code() {
        return response_code;
    }

    public void setResponse_code(int response_code) {
        this.response_code = response_code;
    }

    public List<Pregunta> getResults() {
        if(results == null) {
            results = new ArrayList<>();
        }
        return results;
    }

    public void setResults(List<Pregunta> results) {
        this.results = results;
    }
}
