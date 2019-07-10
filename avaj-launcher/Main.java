package com.jam;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        File file = new File("/goinfre/jdubula//Desktop/simulator.txt");
        Flyable flyable = null;

        BufferedReader reader = new BufferedReader(new FileReader(file));

        String line = reader.readLine();
        if (line != null) {
            WeatherTower weatherTower = new WeatherTower();
            String splitsimulation[] = line.split(" ");
            int simulation = Integer.parseInt(splitsimulation[0]);
            System.out.println(simulation);
            //    int simulation = Integer.parseInt(line.split(" ") [0]);
            if (simulation <= 0) {
                System.out.println("Simulation count cannot be 0 or less than 0");
                System.exit(1);
            }



                while ((line = reader.readLine()) != null) {

                    String plit[] = line.split(" ");

                    if (plit.length == 5) {

                        int lat = Integer.parseInt(plit[2]);
                        int longi = Integer.parseInt(plit[3]);
                        int high = Integer.parseInt(plit[4]);
                        String type = plit[0];
                        String name = plit[1];
                        flyable = AircraftFactory.newAircraft(type, name, longi, lat, high);
                        flyable.registerTower(weatherTower);


                        String printThis = flyable.print();
                        FileWriter fw = new FileWriter("testfour.txt",true);
                        fw.write(printThis);
                        fw.close();


                        // System.out.println(line);


                    }

                }
                while(simulation > 0) {


                    weatherTower.conditionsChanged();
                    String printThis = flyable.print();
                    FileWriter fw = new FileWriter("testfour.txt",true);
                    fw.write(printThis);
                    fw.close();

                    simulation--;

                }


                //Coordinates coordinates = new Coordinates(10, 10, 10);
                //AircraftFactory aircraftFactory = new AircraftFactory();
                // System.out.println(Aircraft.getIdCounter());
                //  WeatherTower weatherTower = new WeatherTower();
                // Flyable flyable = aircraftFactory.newAircraft("Helicopter","SAAS",10,10,10);

                // flyable.registerTower(weatherTower);
                // flyable.updateConditions();


                // String printThis =  flyable.print();
                // String writer = printThis;
                // FileWriter fw= new FileWriter("testout.txt");
                //  fw.write(writer);

                //  System.out.println(Aircraft.getIdCounter());
                //  Flyable ballon = aircraftFactory.newAircraft("Helicopter","SAA",10,10,1);
                //  Flyable plan = aircraftFactory.newAircraft("Ballon","SA express",10,10,1);
                //  plan.registerTower(weatherTower);
                //   plan.updateConditions();
                //  System.out.println(Aircraft.getIdCounter());
                //  ballon.registerTower(weatherTower);
                //  ballon.updateConditions();

                //  String printThree = plan.print();
                //  String printTwo = ballon.print();
                //  System.out.println(Aircraft.getIdCounter());

                //  String written = printTwo;


                //   fw.write(written);
                //  fw.write(printThree);


                //  fw.close();


            }
           // for (int i = 0; i < simulation; i++)
          //  weatherTower.changeWeather();
        }

    }

