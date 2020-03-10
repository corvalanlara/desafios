package com.example.passwordstrength.models;

import static com.example.passwordstrength.models.Verifier.howStrength;

public class IPresenterView {

    View view;

    public IPresenterView(View view) {
        this.view = view;
    }

    public void evaluarPassword(String pass) {
        int intensidad = howStrength(pass);
        switch(intensidad) {
            case 1:
                view.cambiarWeak();
                break;
            case 2:
                view.cambiarMedium();
                break;
            case 3:
                view.cambiarStrong();
                break;
            case 4:
                view.cambiarSuperStrong();
                break;
        }
    }

    public interface View {
        void cambiarWeak();
        void cambiarMedium();
        void cambiarStrong();
        void cambiarSuperStrong();
    }
}
