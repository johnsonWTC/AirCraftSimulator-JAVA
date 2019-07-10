
package com.jam;


import java.io.*;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) throws IOException {

        File file = new File("/goinfre/jdubula//Desktop/scenario.txt");
          WeatherTower weatherTower = new WeatherTower();
          WeatherTower weatherTowers = new WeatherTower();
          Flyable flyabletwo = null;
          int i = 0;

          ArrayList<Flyable> listOfFlyable = new ArrayList<Flyable>();

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        if (line != null) {

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
                         flyabletwo = AircraftFactory.newAircraft(type, name, longi, lat, high);
                        flyabletwo.registerTower(weatherTower);
                        listOfFlyable.add(flyabletwo);

                    //    String printThis = flyable.print();
                     //   FileWriter fw = new FileWriter("testout.txt", true);
                     //   fw.write(printThis);

                        // System.out.println(line);

                        String printThis = flyabletwo.print();
                        FileWriter fw = new FileWriter("nowtwo111.txt", true);
                        fw.write(printThis);
                        fw.close();

 //                         System.out.println(line);

                    }



                }
        //       for (int i = 0; i < simulation; i++){
       //    weatherTower.register(flyable);
       //        }

       File filetwo = new File("/goinfre/jdubula//Desktop/scenario.txt");
          BufferedReader readerTwo = new BufferedReader(new FileReader(filetwo));
        String lineTwo = readerTwo.readLine();
        if (lineTwo != null) {

            String splitsimulations[] = lineTwo.split(" ");
            int simulations = Integer.parseInt(splitsimulations[0]);
            System.out.println(simulations);
            //    int simulation = Integer.parseInt(line.split(" ") [0]);
            if (simulations <= 0) {
                System.out.println("Simulation count cannot be 0 or less than 0");
                System.exit(1);
            }

            while ((lineTwo = readerTwo.readLine())  != null ) {

//
                    String plit[] = lineTwo.split(" ");



                    if (plit.length == 5) {
//
                        int lat = Integer.parseInt(plit[2]);
                        int longi = Integer.parseInt(plit[3]);
                        int high = Integer.parseInt(plit[4]);
                        String type = plit[0];
                        String name = plit[1];
                        for(Flyable flyables : listOfFlyable) {
                            weatherTower.register(flyables);
                            weatherTower.conditionsChanged();
                            String printThis = flyables.print();
                            FileWriter fw = new FileWriter("nowtwo111.txt",true);
                            fw.write(printThis);


                            i++;
                           fw.close();
                        }



                        }


                    }





                }




            }
}

        }

