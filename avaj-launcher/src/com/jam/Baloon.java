package com.jam;



public class Baloon   extends Aircraft implements  Flyable{
    WeatherTower weatherTower;
    public static String ToBeWritten = "";

    public Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    //    System.out.println("a ballon has been created, with name " + name);


    }


    public  String print() {
        return ToBeWritten;
    }

    public void updateConditions(){


        String weather = weatherTower.getWeather(coordinates);

        if (weather.equals("RAIN")){

            coordinates = new Coordinates(coordinates.getLongitude() + 5 ,coordinates.getLatitude(),coordinates.getHeight() - 5);
            this.ToBeWritten = "Baloon#" + this.name + " " + this.id+  " its rainning\n" ;
            System.out.println("Baloon#" + this.name + "(" + this.id + ") " + "Raining");
        }
        else if (weather.equals("SNOW")){

            coordinates = new Coordinates(coordinates.getLongitude(),coordinates.getLatitude(),coordinates.getHeight() - 1);
            this.ToBeWritten = "Baloon#" + this.name + " " + this.id+  " its snowing \n" ;
           System.out.println("Baloon#" + this.name + "(" + this.id + ") " + "snowing");

        }

        else if (weather.equals("SUN")){

            coordinates = new Coordinates(coordinates.getLongitude() + 2,coordinates.getLatitude(),coordinates.getHeight() + 4);
            this.ToBeWritten = "Baloon#" + this.name + " " + this.id+  " its sunny \n " ;
            System.out.println("Baloon#" + this.name + "(" + this.id + ") " + "sunny");
        }

        else if (weather.equals("FOG")){

            coordinates = new Coordinates(coordinates.getLongitude() + 1 ,coordinates.getLatitude(),coordinates.getHeight() - 3 );
            this.ToBeWritten = "Baloon#" + this.name + " " + this.id+  " its foggy\n" ;
            System.out.println("Baloon#" + this.name + "(" + this.id + ") " + "foggy");
        }
        if((this.coordinates.getHeight()) <= 0 ) {

            System.out.println("the ballon has been unregistered");
            weatherTower.unregister(this);
        }


    }

    public  void registerTower(WeatherTower weatherTower){

        this.weatherTower = weatherTower;
        weatherTower.register(this);
        this.ToBeWritten  = "Tower says: Baloon#" + this.name + "(" + this.id + ") registered to weather tower.\n";
        System.out.println("Tower says: Baloon#" + this.name + "(" + this.id + ") " + "registered to weather tower");


    }

}
