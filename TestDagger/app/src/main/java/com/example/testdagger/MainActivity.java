package com.example.testdagger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.testdagger.di.DaggerInterfazDaga;
import com.example.testdagger.di.InterfazDaga;

import com.example.testdagger.models.Curso;

public class MainActivity extends AppCompatActivity {

    Button mostrar;
    Button limpiar;
    TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializar();

        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show();
            }
        });

        limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
            }
        });


    }

    private void inicializar() {
        mostrar = findViewById(R.id.mostrar);
        limpiar = findViewById(R.id.limpiar);
        texto = findViewById(R.id.texto);
    }

    private void show() {
        InterfazDaga daga = DaggerInterfazDaga.create();
        Curso parrafo = daga.getParrafo();
        texto.setText(parrafo.lineCurso());
    }

    private void clear() {
        texto.setText("");
    }
}
