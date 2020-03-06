package com.example.testdagger.di;

import com.example.testdagger.models.Curso;

import dagger.Component;

@Component
public interface InterfazDaga {

    Curso getParrafo();
}
