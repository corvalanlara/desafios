package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String url = getString(R.string.url);
        ImageView imagen = findViewById(R.id.imagen);
        Picasso.get().load(url).into(imagen);
        final Context context = getApplicationContext();
        final Button boton = findViewById(R.id.botonlogin);
        boton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        EditText user = findViewById(R.id.usuario);
                        String usertexto = user.getText().toString();
                        EditText pass = findViewById(R.id.password);
                        String passtexto = pass.getText().toString();

                        if(!passtexto.isEmpty() && !usertexto.isEmpty()) {
                            Intent intent = new Intent(MainActivity.this, Home.class);
                            startActivity(intent);
                        } else {
                            Toast toast = Toast.makeText(context, getString(R.string.fallo), Toast.LENGTH_SHORT);
                            toast.show();
                        }
                    }
                }
        );

        final Button botonregistro = findViewById(R.id.botonregistro);
        botonregistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegistroUsuario.class);
                startActivity(intent);
            }
        });
    }
}
