package com.example.simpleweather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.simpleweather.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DailyWeather hoy = new DailyWeather("Santiago", "05-03-2020", getDrawable(R.drawable.ic_wb_sunny_black_24dp), 24, "°C");
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.setTiempo(hoy);

    }
}
