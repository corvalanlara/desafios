package cl.desafiolatam.desafio1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.imageViewLeft)
    ImageView imagenIzq;

    @BindView(R.id.imageViewCenter)
    ImageView imagenCen;

    @BindView(R.id.imageViewRight)
    ImageView imagenDer;

    @BindView(R.id.imageViewResult)
    ImageView imagenRes;

    @BindView(R.id.imageViewReplay)
    ImageView imagenReplay;

    @BindView(R.id.textView)
    TextView texto;

    Map<ImageView, Integer> mapa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        List<ImageView> lista = Arrays.asList(imagenIzq, imagenCen, imagenDer);
        List<Integer> imagenes = Arrays.asList(R.drawable.ic_gift_pizza, R.drawable.ic_gift_beach, R.drawable.ic_gift_music);
        Collections.shuffle(lista);

        Iterator it = imagenes.iterator();

        mapa = new HashMap<>();
        for(ImageView el: lista) {
            mapa.put(el, (int) it.next());
        }

    }

    @OnClick(R.id.imageViewReplay)
    public void replay() {
        this.recreate();
    }

    @OnClick({R.id.imageViewLeft, R.id.imageViewCenter, R.id.imageViewRight})
    public void comun(View view) {
        int res;
        switch (view.getId()) {
            case R.id.imageViewLeft:
                res = mapa.get(imagenIzq);
                imagenRes.setImageDrawable(getDrawable(res));
                imagenRes.setVisibility(View.VISIBLE);
                texto.setText(mensaje(res));
                break;
            case R.id.imageViewCenter:
                res = mapa.get(imagenCen);
                imagenRes.setImageDrawable(getDrawable(res));
                imagenRes.setVisibility(View.VISIBLE);
                texto.setText(mensaje(res));
                break;
            case R.id.imageViewRight:
                res = mapa.get(imagenDer);
                imagenRes.setImageDrawable(getDrawable(res));
                imagenRes.setVisibility(View.VISIBLE);
                texto.setText(mensaje(res));
                break;
        }
        for(ImageView el: mapa.keySet()) {
            el.setImageDrawable(getDrawable(mapa.get(el)));
        }

        imagenReplay.setImageDrawable(getDrawable(R.drawable.ic_replay));
        imagenReplay.setVisibility(View.VISIBLE);
        imagenCen.setClickable(false);
        imagenDer.setClickable(false);
        imagenIzq.setClickable(false);
    }

    private String mensaje(int res) {
        if (res == R.drawable.ic_gift_pizza)
            return "¡Felicidades, ganaste una pizza!";
        else if (res == R.drawable.ic_gift_beach)
            return "¡Felicidades, ganaste un viaje a la plaza!";
        else if (res == R.drawable.ic_gift_music)
            return "¡Felicidades, ganaste Spotify Premium por un año!";
        else
            return "?";
    }
}
