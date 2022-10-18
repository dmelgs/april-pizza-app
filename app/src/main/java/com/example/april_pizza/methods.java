package com.example.april_pizza;

import java.util.LinkedList;

public class methods {
    //Declare empty linked list
    LinkedList<Object> list;
    double totalamount;

    public methods() {
       list = new LinkedList<>();
       totalamount = 0;
    }

    public void addOrder(Object order){
        list.add(order);
    }
    public double getTotal(double totalamount){
       return totalamount;
    }
    public void displayOrder(){
        if (list.isEmpty()) {

            System.out.println("The list has no records\n");
        }
        // Iterating Record list
        for (Object s : list){
            System.out.println(s.toString());
        }
    }
}
