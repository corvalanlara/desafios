package com.userInteractionsAndAndroidResourse.dogsapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class BreedListResponse {

    @SerializedName("message")
    private ArrayList<String> breedList;
    private String status;

    public ArrayList<String> getBreedList() {
        return breedList;
    }

    public void setBreedList(ArrayList<String> breedList) {
        this.breedList = breedList;
    }
}
