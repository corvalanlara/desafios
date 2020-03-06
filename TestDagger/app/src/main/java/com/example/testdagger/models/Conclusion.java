package com.example.testdagger.models;

import javax.inject.Inject;

public class Conclusion {

    @Inject
    public Conclusion() {
    }

    public String lineConclusion() {
        return "estoy satisfechos con este comienzo.";
    }
}
