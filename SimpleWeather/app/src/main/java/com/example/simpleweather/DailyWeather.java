package com.example.simpleweather;

import android.graphics.drawable.Drawable;

public class DailyWeather {

    String city;
    String date;
    Drawable weatherImage;
    int temperature;
    String degrees;

    public DailyWeather(String city, String date, Drawable weatherImage, int temperature, String degrees) {
        this.city = city;
        this.date = date;
        this.weatherImage = weatherImage;
        this.temperature = temperature;
        this.degrees = degrees;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Drawable getWeatherImage() {
        return weatherImage;
    }

    public void setWeatherImage(Drawable weatherImage) {
        this.weatherImage = weatherImage;
    }

    public String getTemperature() {
        return String.valueOf(temperature);
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public String getDegrees() {
        return degrees;
    }

    public void setDegrees(String degrees) {
        this.degrees = degrees;
    }
}
