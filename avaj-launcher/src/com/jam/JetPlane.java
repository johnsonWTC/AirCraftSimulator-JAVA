package com.jam;

public class JetPlane extends Aircraft implements Flyable{

    WeatherTower weatherTower;

    public String ToBeWritten = "";





    JetPlane(String name, Coordinates coordinates) {


         super(name, coordinates);
     //   System.out.println("a JetPlane has been created, with name " + name);

    }
    public void updateConditions(){


        String weather = weatherTower.getWeather(coordinates);

        if (weather.equals("RAIN")){

            coordinates = new Coordinates(coordinates.getLongitude() + 5 ,coordinates.getLatitude() + 5,coordinates.getHeight());
            this.ToBeWritten = "JetPlane#" + this.name + " " + this.id+  " its raining\n" ;
           System.out.println("JetPlane#" + this.name + "(" + this.id + ") " + "Raining");
        }
        else if (weather.equals("SNOW")){

            coordinates = new Coordinates(coordinates.getLongitude(),coordinates.getLatitude(),coordinates.getHeight() - 7);
            this.ToBeWritten = "JetPlane#" + this.name + " " + this.id+  "  its snowing\n" ;
            System.out.println("JetPlane#" + this.name + "(" + this.id + ") " + "snowing");
        }

        else if (weather.equals("SUN")){

            coordinates = new Coordinates(coordinates.getLongitude() ,coordinates.getLatitude() + 10,coordinates.getHeight() + 2);
            this.ToBeWritten = "JetPlane#" + this.name + " " + this.id+  " its sunny\n" ;
            System.out.println("JetPlane#" + this.name + "(" + this.id + ") " + "sunny");
        }

        else if (weather.equals("FOG")){

            coordinates = new Coordinates(coordinates.getLongitude() + 0 ,coordinates.getLatitude() + 10,coordinates.getHeight() );
            this.ToBeWritten = "JetPlane#" + this.name + " " + this.id+  " its foggy \n" ;
            System.out.println("JetPlane#" + this.name + "(" + this.id + ") " + "foggy");
        }

    }
    public  void registerTower(WeatherTower weatherTower){

        this.weatherTower = weatherTower;
        weatherTower.register(this);
        this.ToBeWritten  = "Tower says: JetPlane#" + this.name + "(" + this.id + ") registered to weather tower.\n";
        System.out.println("Tower says: JetPlane#" + this.name + "(" + this.id + ") " + "registered to weather tower");


    }


    public String print() {
        return ToBeWritten;
    }
}
