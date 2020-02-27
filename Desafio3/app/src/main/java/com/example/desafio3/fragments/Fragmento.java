package com.example.desafio3.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.desafio3.R;

import java.util.Objects;

public class Fragmento extends Fragment {
    int valorBoton = 0;
    private TextView preguntaView, categoriaView, dificultadView;
    private RadioGroup grupoRespuestasView;
    private RadioButton respuestaUno, respuestaDos;

    public static Fragmento newInstance (String pregunta,
                                         String categoria,
                                         String dificultad,
                                         String respuestaCorrecta) {
        Fragmento fragmento = new Fragmento();
        Bundle arguments = new Bundle();
        arguments.putString("PREGUNTA", pregunta);
        arguments.putString("CATEGORIA", categoria);
        arguments.putString("DIFICULTAD", dificultad);
        arguments.putString("RESPUESTA_CORRECTA", respuestaCorrecta);
        fragmento.setArguments(arguments);
        return fragmento;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout, container, false);

        final String pregunta = Objects.requireNonNull(getArguments().getString("PREGUNTA"));
        final String categoria = Objects.requireNonNull(getArguments().getString("CATEGORIA"));
        final String dificultad = Objects.requireNonNull(getArguments().getString("DIFICULTAD"));
        final String respuestaCorrecta = Objects.requireNonNull(getArguments().getString("RESPUESTA_CORRECTA"));

        initilizeViews(view);

        preguntaView.setText(pregunta);
        categoriaView.setText(categoria);
        dificultadView.setText(dificultad);

        grupoRespuestasView.setOnCheckedChangeListener((group, checkedId) -> {
            if(respuestaUno.isChecked()) {
                valorBoton = 1;
            } else if (respuestaDos.isChecked()){
                valorBoton = 0;
            }
        });

        Button boton = view.findViewById(R.id.f_boton);
        boton.setOnClickListener(v -> {
            if(respuestaUno.isChecked() && respuestaCorrecta.equals("True")) {
                Toast.makeText(getContext(), getString(R.string.correcto), Toast.LENGTH_SHORT).show();

            } else if(respuestaDos.isChecked() && respuestaCorrecta.equals("False")) {
                Toast.makeText(getContext(), getString(R.string.correcto), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), getString(R.string.incorrecto), Toast.LENGTH_SHORT).show();

            }
        });

        return view;
    }

    private void initilizeViews(View view) {
        preguntaView = view.findViewById(R.id.f_pregunta_r);
        categoriaView = view.findViewById(R.id.f_categoria_r);
        dificultadView = view.findViewById(R.id.f_dificultad_r);
        grupoRespuestasView = view.findViewById(R.id.f_radio_grupo);
        respuestaUno = view.findViewById(R.id.f_primero);
        respuestaDos = view.findViewById(R.id.f_segundo);
    }

}
