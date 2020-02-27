package com.example.desafio3;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.example.desafio3.api.Api;
import com.example.desafio3.api.RetrofitClient;
import com.example.desafio3.beans.Pregunta;
import com.example.desafio3.beans.PreguntasLista;
import com.example.desafio3.fragments.Fragmento;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "LogGSON";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Api service = RetrofitClient.getRetrofitInstance().create(Api.class);
        Call<PreguntasLista> call = service.getQuestion();

        call.enqueue(new Callback<PreguntasLista>() {
            @Override
            public void onResponse(Call<PreguntasLista> call, Response<PreguntasLista> response) {
                PreguntasLista preguntas = response.body();
                if (preguntas != null) {
                    Pregunta pregunta;
                    pregunta =  preguntas.getResults().get(0);

                    Fragmento frag = null;

                    try {
                        frag = Fragmento.newInstance(
                                URLDecoder.decode(pregunta.getQuestion(), "UTF-8"),
                                URLDecoder.decode(pregunta.getCategory(), "UTF-8"),
                                URLDecoder.decode(pregunta.getDifficulty(), "UTF-8"),
                                URLDecoder.decode(pregunta.getCorrect_answer(), "UTF-8")
                        );
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }

                    getSupportFragmentManager()
                            .beginTransaction()
                            .add(R.id.fragment_container, frag, "FRAGMENTO")
                            .commit();
                }
            }

            @Override
            public void onFailure(Call<PreguntasLista> call, Throwable t) {
                Toast.makeText(getApplicationContext(), getString(R.string.error_gson), Toast.LENGTH_SHORT);
            }
        });
    }
}
