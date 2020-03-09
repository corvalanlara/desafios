package com.example.passwordstrength.models;

import android.widget.TextView;

public interface IPresenterView {

    void evaluarPassword(TextView view, String pass);
    void cambiarTexto(TextView view, int intensidad);
    void cambiarColor(TextView view, int intensidad);
}
