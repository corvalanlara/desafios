package com.example.passwordstrength.models;

import android.widget.EditText;
import android.widget.TextView;

import static com.example.passwordstrength.models.Verifier.howStrength;

public class IPresenterView {

    View view;

    public IPresenterView(View view) {
        this.view = view;
    }

    public void evaluarPassword(String pass) {
        int intensidad = howStrength(pass);
        view.cambiarTextoYColor(intensidad);
    }

    public interface View {

        void cambiarTextoYColor(int intensidad);
    }
}
