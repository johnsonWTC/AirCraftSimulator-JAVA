package com.jam;


import java.util.ArrayList;
import java.util.Random;

public class WeatherProvider {

    private  static  String[] weather = { "RAIN", "FOG", "SUN", "SNOW" };




    private  static WeatherProvider  weatherProvider = new WeatherProvider();




    private  WeatherProvider   WeatherProvider(){

        if (weatherProvider == null)
            weatherProvider = new WeatherProvider();
        return weatherProvider;



    }

    public static  WeatherProvider getProvider() {
        return weatherProvider;
    }

    public  static  String getCurrentWeather(Coordinates coordinates){
        int randomGenerator = new Random().nextInt(weather.length);
        String randomWeather = (weather[randomGenerator]);

        return randomWeather;
    }



}
