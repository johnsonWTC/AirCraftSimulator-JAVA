package com.jam;

import java.io.FileWriter;

public class Helicopter extends Aircraft implements Flyable {

    WeatherTower weatherTower;


    public static String  ToBeWritten = "";


    public Helicopter(String name, Coordinates coordinates)  {
        super(name, coordinates);
      //  System.out.println("a helicopter has been created, with name " + name);
    }



    public void updateConditions(){

        String weather = weatherTower.getWeather(coordinates);

        if (weather.equals("RAIN")){

            coordinates = new Coordinates(coordinates.getLongitude() + 5 ,coordinates.getLatitude(),coordinates.getHeight());
            this.ToBeWritten = "Helicopter#" + this.name + " " + this.id+  " Raining\n" ;
            System.out.println("Helicopter#" + this.name + "(" + this.id + ") " + "Raining");


        }
        if (weather.equals("SNOW")) {

            coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 1);
            this.ToBeWritten = "Helicopter#" + this.name + " " + this.id+  " snowwing\n" ;
            System.out.println("Helicopter#" + this.name + "(" + this.id + ") " + "its snowing");
        }
        if (weather.equals("SUN")){

            coordinates = new Coordinates(coordinates.getLongitude() + 10,coordinates.getLatitude(),coordinates.getHeight() + 2);
            this.ToBeWritten = "Helicopter#" + this.name + " " + this.id+  " sunny\n" ;
            System.out.println("Helicopter#" + this.name + "(" + this.id + ") " + "its sunny");
        }

        if (weather.equals("FOG")){
            coordinates = new Coordinates(coordinates.getLongitude() + 1 ,coordinates.getLatitude(),coordinates.getHeight() );
            this.ToBeWritten = "Helicopter#" + this.name + " " + this.id+  " foggy \n" ;
            System.out.println("Helicopter#" + this.name + "(" + this.id + ") " + "its  foggy");
        }
        if((this.coordinates.getHeight()) <= 0 ) {

            this.ToBeWritten = this.name + " " + this.id+ " has landend\n" ;
            weatherTower.unregister(this);
        }


    }
    public  void registerTower(WeatherTower weatherTower){



        this.weatherTower = weatherTower;
        weatherTower.register(this);
        this.ToBeWritten  = "Tower says: Helicopter#" + this.name + "(" + this.id + ") registered to weather tower.\n";
        System.out.println("Tower says: Helicopter#" + this.name + "(" + this.id + ") " + "registered to weather tower");

    }


    public String print() {
        return ToBeWritten;
    }
}
