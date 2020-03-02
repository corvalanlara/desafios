package com.example.postresfitness;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

public class DetailActivity extends AppCompatActivity {

    private TextView mTitulo;
    private ImageView mImagen;
    private TextView mId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle datosMain = getIntent().getExtras();
        String titulo = datosMain.getString("TITULO");
        int imagen = datosMain.getInt("IMAGEN");
        int id = datosMain.getInt("ID");

        mTitulo = findViewById(R.id.detalle_postre_titulo);
        mId = findViewById(R.id.detalle_postre_id);
        mImagen = findViewById(R.id.detalle_postre_imagen);

        mTitulo.setText(titulo);
        mId.setText(Integer.toString(id));
        Glide.with(this)
                .load(imagen)
                .centerCrop()
                .into(mImagen);

    }
}
