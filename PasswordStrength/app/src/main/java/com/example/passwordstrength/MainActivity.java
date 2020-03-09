package com.example.passwordstrength;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.example.passwordstrength.models.IPresenterView;

import static com.example.passwordstrength.models.Verifier.howStrength;

public class MainActivity extends AppCompatActivity implements IPresenterView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText pass = findViewById(R.id.pass_view);
        final TextView feed = findViewById(R.id.feedback_view);

        pass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                evaluarPassword(feed, s.toString());
            }
        });
    }

    @Override
    public void evaluarPassword(TextView view, String pass) {
        int intensidad = howStrength(pass);
        cambiarTexto(view, intensidad);
        cambiarColor(view, intensidad);
    }

    @Override
    public void cambiarTexto(TextView view, int intensidad) {
        switch(intensidad) {
            case 1:
                view.setText(R.string.weak);
                break;
            case 2:
                view.setText(R.string.medium);
                break;
            case 3:
                view.setText(R.string.strong);
                break;
            case 4:
                view.setText(R.string.very_strong);
                break;
        }
    }

    @Override
    public void cambiarColor(TextView view, int intensidad) {
        switch(intensidad) {
            case 1:
                view.setBackgroundColor(getColor(R.color.colorWeak));
                break;
            case 2:
                view.setBackgroundColor(getColor(R.color.colorMedium));
                break;
            case 3:
                view.setBackgroundColor(getColor(R.color.colorStrong));
                break;
            case 4:
                view.setBackgroundColor(getColor(R.color.colorVeryStrong));
                break;
        }
    }
}
