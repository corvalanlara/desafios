package com.example.desafio4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Objects;

import javax.xml.transform.Result;

public class ResultActivity extends AppCompatActivity {

    static final int REQUEST_SHARE = 2;
    static final int REQUEST_WEB = 3;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Bundle datosMain = getIntent().getExtras();
        final String web = Objects.requireNonNull(datosMain).getString("String");
        final String todo = Objects.requireNonNull(datosMain).toString();

        Button botonweb = findViewById(R.id.abrir_web_r);
        botonweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(web));
                setResult(Activity.RESULT_OK);
                startActivityForResult(intent, REQUEST_WEB);
            }
        });

        Button botonshare = findViewById(R.id.compartir_r);
        botonshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, todo);
                intent.setType("text/plain");
                setResult(Activity.RESULT_OK);
                startActivityForResult(intent, REQUEST_SHARE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_SHARE && resultCode == Activity.RESULT_OK) {
            Toast.makeText(ResultActivity.this, getString(R.string.shareok), Toast.LENGTH_SHORT).show();
        } else if (requestCode == REQUEST_WEB && resultCode == Activity.RESULT_OK) {
            Toast.makeText(ResultActivity.this, getString(R.string.webok), Toast.LENGTH_SHORT).show();
        }
    }

}
