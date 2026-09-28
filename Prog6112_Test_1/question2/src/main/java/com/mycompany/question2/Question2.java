package com.mycompany.question2;

import com.mycompany.question2.Question2.main.SalesReportInterface;
import com.mycompany.question2.Question2.main.SalesReportInterface;
import java.util.Scanner;



/**
 *
 * @author Student
 */
public class Question2 {

    public static void main(String[] args) {










// Step 1: Define the interface
interface SalesReportInterface {
    String getConsoleType();
    String getStore();
    int getTotalSales();
    void displayReport();
}

// Step 2: Implement the interface in a class
public class consolesevicesales implements SalesReportInterface {
    private String consoleType;
    private String store;
    private int[][] sales;       // 2D array: rows = months, columns = devices
    private String[] devices;    // 1D array for device names
    private int[] totalSales;    // 1D array for total sales per device
    private int months;

    // Constructor to initialize and collect sales data
    public consolesevicesales() {
        Scanner scanner = new Scanner(System.in);

        // Store name
        System.out.print("Enter store name: ");
        store = scanner.nextLine();

        // Console type (category)
        System.out.print("Enter console type category (e.g., Gaming Consoles): ");
        consoleType = scanner.nextLine();

        // Device names
        devices = new String[]{"PlayStation", "Xbox", "Nintendo Switch"};

        // Ask for number of months
        System.out.print("Enter number of months to record sales: ");
        if (!scanner.hasNextInt() || (months = scanner.nextInt()) <= 0) {
            System.out.println("Invalid input. Months must be a positive integer.");
            System.exit(1);
        }

        // Initialize arrays
        sales = new int[devices.length][months];
        totalSales = new int[devices.length];

        // Input sales data
        System.out.println("\nEnter sales data for each device:");
        for (int i = 0; i < devices.length; i++) {
            System.out.println("Device: " + devices[i]);
            for (int j = 0; j < months; j++) {
                System.out.print("  Month " + (j + 1) + " sales: ");
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter integers only.");
                    System.exit(1);
                }
                int value = scanner.nextInt();
                if (value < 0) {
                    System.out.println("Sales cannot be negative.");
                    System.exit(1);
                }
                sales[i][j] = value;
                totalSales[i] += value;
            }
        }
        scanner.close();
    }

    // Step 3: Implement interface methods
    @Override
    public String getConsoleType() {
        return consoleType;
    }

    @Override
    public String getStore() {
        return store;
    }

    @Override
    public int getTotalSales() {
        int grandTotal = 0;
        for (int total : totalSales) {
            grandTotal += total;
        }
        return grandTotal;
    }

    @Override
    public void displayReport() {
        System.out.println("\nStore: " + getStore());
        System.out.println("Console Type: " + getConsoleType());
        System.out.println("Console Device Sales Report");
        System.out.println("---------------------------");
        for (int i = 0; i < devices.length; i++) {
            System.out.print(devices[i] + ": ");
            for (int j = 0; j < months; j++) {
                System.out.print(sales[i][j] + " ");
            }
            System.out.println("| Total: " + totalSales[i]);
        }
        System.out.println("\nGrand Total Sales: " + getTotalSales());
    }

    // Step 4: Main method
    public static void main(String[] args) {
        ConsoleDeviceSales report = new ConsoleDeviceSales();
        report.displayReport();
    }


