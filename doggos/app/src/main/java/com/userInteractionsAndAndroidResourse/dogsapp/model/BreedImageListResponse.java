package com.userInteractionsAndAndroidResourse.dogsapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class BreedImageListResponse {
        @SerializedName("message")
    private ArrayList<String> imageUrl;

    public ArrayList<String> getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(ArrayList<String> imageUrl) {
        this.imageUrl = imageUrl;
    }

}
