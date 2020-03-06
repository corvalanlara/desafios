package com.example.testdagger.models;

import javax.inject.Inject;

public class Curso {

    private Concepto concepto;

    @Inject
    public Curso(Concepto concepto) {
        this.concepto = concepto;
    }

    public String lineCurso() {
        return "Con este curso de arquitectura de desafío latam " + concepto.lineConcepto();
    }

}
