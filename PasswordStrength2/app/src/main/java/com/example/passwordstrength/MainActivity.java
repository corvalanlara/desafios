package com.example.passwordstrength;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.example.passwordstrength.databinding.ActivityMainBinding;
import com.example.passwordstrength.models.MyViewModel;

public class MainActivity extends AppCompatActivity {

    TextView feed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        EditText pass = findViewById(R.id.pass_view);
        feed = findViewById(R.id.feedback_view);

        final MyViewModel modelo = ViewModelProviders.of(this).get(MyViewModel.class);
        modelo.getPass().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                modelo.setData(s);
            }
        });

        binding.setInfo(modelo);

        binding.setLifecycleOwner(this);

        pass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                modelo.setPass(s.toString());
            }
        });
    }

}
