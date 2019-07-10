package com.jam;


import java.util.ArrayList;


public class Tower {


    private ArrayList<Flyable> observers = new ArrayList<Flyable>();
   private  ArrayList<Flyable> observerstwo = new ArrayList<Flyable>();



    public void register(Flyable flyable){

        observers.add(flyable);
        observerstwo.add(flyable);


    }

    public void unregister(Flyable flyable){

        observers.remove(flyable);
        System.out.println("removed");

    }

    protected void conditionsChanged() {



        for (Flyable flyable : observerstwo) {

            if(observers.contains(flyable)) {

                flyable.updateConditions();
            }
          else
                    System.out.println("this aircaft has landed");

            }
        }

    protected void conditionsChangedTwo() {



        for (Flyable flyable : observerstwo) {

            if(observers.contains(flyable)) {

                flyable.updateConditions();
            }
            else
                System.out.println("this aircaft has landed");

        }
    }




}


