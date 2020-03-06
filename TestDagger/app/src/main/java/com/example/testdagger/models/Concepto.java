package com.example.testdagger.models;

import javax.inject.Inject;

public class Concepto {

    private Clase clase;

    @Inject
    public Concepto(Clase clase) {
        this.clase = clase;
    }

    public String lineConcepto() {
        return "he aprendido nuevos conceptos en esta materia " + clase.lineClase();
    }

}
