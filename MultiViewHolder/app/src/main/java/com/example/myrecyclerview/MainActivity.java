package com.example.myrecyclerview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecycler;
    private DailyMenuAdapter mAdapter;
    private ArrayList<Item> mItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        init();
    }
    private void init() {
        mRecycler = findViewById(R.id.recyclerView);
        mAdapter = new DailyMenuAdapter(this, mItems);
        mRecycler.setAdapter(mAdapter);
        mRecycler.setHasFixedSize(true);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
    }
    private void initData() {
        mItems = new ArrayList<>();
        mItems.add(new Item("Hoy"));
        mItems.add(new Item(
                "Hoy una rica cena con mi polola, ¿será un momento de comida japonesa?",
                R.drawable.sushi,
                "2:30 pm",
                true));
        mItems.add(new Item(
                "Crep que me toca cocina en casa, quizás un delicioso pollo.",
                R.drawable.ic_pollo,
                "6:30 pm",
                true));
        mItems.add(new Item());
        mItems.add(new Item("Mañana"));
        mItems.add(new Item(
                "En el trabajo, a veces tomo una merienda en las tardes, hoy toco un \"Sopaipilla\".",
                "4:30 pm"
        ));
        mItems.add(new Item(
                "Celebrando el cumpleaños de mi hermana, ya son 30 años.",
                R.drawable.ic_cake,
                "8:00 pm",
                true
        ));
        mItems.add(new Item());
        mItems.add(new Item("Próxima Semana"));
        mItems.add(new Item(
                "Hoy quiero comer algo dulce en la mañana.",
                R.drawable.ic_cupcake,
                "8:30 am",
                true
        ));
        mItems.add(new Item(
                "En la tarde debo ir a buscar comida a que la tía Rosa",
                "8:30 am"
        ));
        mItems.add(new Item(
                "Voy a salir a celebrar el cumple de Pancho",
                R.drawable.ic_beer,
                "8:30 am",
                true
        ));
        mItems.add(new Item());
    }
}