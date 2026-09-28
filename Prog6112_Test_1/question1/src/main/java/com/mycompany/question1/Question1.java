package com.mycompany.question1;



/**
 *
 * @author Student
 */
public class Question1 {

    public static void main(String[] args) {



   // Cities and sales data
        String[] cities = {"Cape Town", "Port Elizabeth", "Pretoria"}; // 1D array for city names

        // 2D array: rows = cities, columns = sales figures
        int[][] sales = {
            {1000, 2000, 3000}, // Cape Town
            {1500, 2500, 3500}, // Port Elizabeth
            {1200, 2200, 3200}  // Pretoria
        };

        // 1D array to store total sales per city
        int[] totalSales = new int[cities.length];

        // Calculate total sales for each city
        for (int i = 0; i < cities.length; i++) {
            totalSales[i] = 0;
            for (int j = 0; j < sales[i].length; j++) {
                totalSales[i] += sales[i][j];
            }
        }

        // Display sales report
        System.out.println("Sales Report");
        System.out.println("------------");
        for (int i = 0; i < cities.length; i++) {
            System.out.print(cities[i] + ": ");
            for (int j = 0; j < sales[i].length; j++) {
                System.out.print(sales[i][j] + " ");
            }
            System.out.println(" | Total: " + totalSales[i]);
        }
    }
}



   
   
