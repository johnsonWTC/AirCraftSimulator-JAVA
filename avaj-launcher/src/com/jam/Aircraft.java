package com.jam;

public class Aircraft {

    protected long id = 0;
    protected String name;
    private static long idCounter = 0;
    protected Coordinates coordinates;

    protected Aircraft( String name, Coordinates coordinates) {
        this.id = nextId();
        this.name = name;
        this.coordinates = coordinates;
    }

    public long nextId(){
        return ++idCounter;
    }


    public static long getIdCounter() {
        return idCounter;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }


}
