package com.example.passwordstrength.models;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.passwordstrength.R;

public class MyViewModel extends ViewModel {

    private MutableLiveData<String> myText = new MutableLiveData<>();
    private MutableLiveData<String> myPass = new MutableLiveData<>();

    public LiveData<String> getText() {
            return myText;
    }

    public LiveData<String> getPass() {
        return myPass;
    }

    public void setPass(String s) {
        myPass.setValue(s);
    }

    public void setData(View view, String s) {
        int intensidad = Verifier.howStrength(s);
        switch(intensidad) {
            case 1:
                view.setBackground(view.getResources().getDrawable(R.color.colorWeak));
                myText.setValue(view.getResources().getString(R.string.weak));
                break;
            case 2:
                view.setBackground(view.getResources().getDrawable(R.color.colorMedium));
                myText.setValue(view.getResources().getString(R.string.medium));
                break;
            case 3:
                view.setBackground(view.getResources().getDrawable(R.color.colorStrong));
                myText.setValue(view.getResources().getString(R.string.strong));
                break;
            case 4:
                view.setBackground(view.getResources().getDrawable(R.color.colorVeryStrong));
                myText.setValue(view.getResources().getString(R.string.very_strong));
                break;
        }
    }

}
