package com.userInteractionsAndAndroidResourse.dogsapp.model;


import com.google.firebase.Timestamp;

public class FavoriteDog {

    String url;
    Timestamp timestamp;

    public FavoriteDog(String url, Timestamp timestamp) {
        this.url = url;
        this.timestamp = timestamp;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
