package com.example.testdagger.models;

import javax.inject.Inject;

public class Clase {

    private Conclusion conclusion;

    @Inject
    public Clase(Conclusion conclusion) {
        this.conclusion = conclusion;
    }

    public String lineClase() {
        return "y con este buen grupo, me siento motivado y " + conclusion.lineConclusion();
    }
}
