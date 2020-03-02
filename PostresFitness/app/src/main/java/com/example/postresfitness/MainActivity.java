package com.example.postresfitness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private List<DessertFit> mDessertFit = new ArrayList<>();
    


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: started");
        crearPostres();
        initRecylerView();
        
    }

    private void crearPostres() {
        mDessertFit.add(new DessertFit(0, "Brownie Banana", R.drawable.brownie_banana));
        mDessertFit.add(new DessertFit(1, "Galletass rápidas de auyama y banano", R.drawable.galletas_rapidas_de_auyama_y_banano));
        mDessertFit.add(new DessertFit(2, "Mandocas Horneadas", R.drawable.mandocas_hormenadas));
        mDessertFit.add(new DessertFit(3, "Muffins Integrales", R.drawable.muffins_integrales));
        mDessertFit.add(new DessertFit(4, "Muffins de pan con zanahoria", R.drawable.muffins_de_pan_con_zanohoria));
        mDessertFit.add(new DessertFit(5, "Palmeritas de banana", R.drawable.palmeritas_de_banana));
        mDessertFit.add(new DessertFit(6, "Pan de calabacín", R.drawable.pan_de_calabacin_750x300));
        mDessertFit.add(new DessertFit(7, "Panquecas de cacao con topping de banana", R.drawable.panquecas_de_cacao_con_topping_de_banana));

    }

    private void initRecylerView() {
        Log.d(TAG, "initRecylerView: init recyclerview");
        RecyclerView mRecyclerView = findViewById(R.id.recyclerView);
        RecyclerViewAdapter mAdapter = new RecyclerViewAdapter(mDessertFit, this);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2)); //OR RELATIVE?
    }
}
