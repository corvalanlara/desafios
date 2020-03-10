package com.example.passwordstrength;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.example.passwordstrength.models.IPresenterView;

import org.w3c.dom.Text;

import static com.example.passwordstrength.models.Verifier.howStrength;

public class MainActivity extends AppCompatActivity implements IPresenterView.View {

    TextView feed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText pass = findViewById(R.id.pass_view);
        feed = findViewById(R.id.feedback_view);

        final IPresenterView presenter = new IPresenterView(this);

        pass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                presenter.evaluarPassword(s.toString());
            }
        });
    }

    @Override
    public void cambiarWeak() {
        feed.setText(R.string.weak);
        feed.setBackgroundColor(getColor(R.color.colorWeak));
    }

    @Override
    public void cambiarMedium() {
        feed.setText(R.string.medium);
        feed.setBackgroundColor(getColor(R.color.colorMedium));
    }

    @Override
    public void cambiarStrong() {
        feed.setText(R.string.strong);
        feed.setBackgroundColor(getColor(R.color.colorStrong));
    }

    @Override
    public void cambiarSuperStrong() {
        feed.setText(R.string.very_strong);
        feed.setBackgroundColor(getColor(R.color.colorVeryStrong));
    }

}
