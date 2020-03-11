package com.example.passwordstrength.models;


import androidx.databinding.BindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.passwordstrength.R;

public class MyViewModel extends ViewModel {

    private MutableLiveData<Integer> myColor = new MutableLiveData<>();
    private MutableLiveData<Integer> myText = new MutableLiveData<>();
    private MutableLiveData<String> myPass = new MutableLiveData<>();

    public LiveData<Integer> getColor() {
        return myColor;
    }

    public LiveData<Integer> getText() {
            return myText;
    }

    public LiveData<String> getPass() {
        return myPass;
    }

    public void setPass(String s) {
        myPass.setValue(s);
    }

    public void setData(String s) {
        int intensidad = Verifier.howStrength(s);
        switch(intensidad) {
            case 1:
                myColor.setValue(R.color.colorWeak);
                myText.setValue(R.string.weak);
                break;
            case 2:
                myColor.setValue(R.color.colorMedium);
                myText.setValue(R.string.medium);
                break;
            case 3:
                myColor.setValue(R.color.colorStrong);
                myText.setValue(R.string.strong);
                break;
            case 4:
                myColor.setValue(R.color.colorVeryStrong);
                myText.setValue(R.string.very_strong);
                break;
        }
    }

}
