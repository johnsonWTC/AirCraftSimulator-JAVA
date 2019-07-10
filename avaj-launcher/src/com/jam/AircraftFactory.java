package com.jam;

public class AircraftFactory {

    public static Flyable newAircraft(String type,String name,int longitude, int latitude, int height){

        Coordinates coordinates = new Coordinates( longitude,latitude,height);

        if (type.equalsIgnoreCase("Helicopter" )) {
            Helicopter helicopter = new Helicopter(name, coordinates);
            return helicopter;
        }
        else if (type.equalsIgnoreCase( "JetPlane")){
            JetPlane jetPlane = new JetPlane(name,coordinates);
            return jetPlane;
        }
        else if (type.equalsIgnoreCase("Baloon")){
            Baloon Baloon = new Baloon(name,coordinates);
            return  Baloon;
        }

        return null;

    }



}
