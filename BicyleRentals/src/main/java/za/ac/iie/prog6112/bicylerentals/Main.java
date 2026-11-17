/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.iie.prog6112.bicylerentals;

/**
 *
 * @author anphewa
 */
// Main class starts the Java application.
public class Main {

    /*
     * This is the main method.
     *
     * Java starts executing the application here.
     *
     * public means the method is accessible.
     * static means it can run without creating a Main object.
     * void means it does not return a value.
     * String[] args holds command-line arguments.
     */
    public static void main(String[] args) {

        /*
         * STEP 1:
         * Create an object of the BicycleRentals class.
         *
         * This object contains our rental data
         * and all the calculation methods.
         */
        BicycleRentals rentals = new BicycleRentals();

        /*
         * STEP 2:
         * Create an object of PrintBicycleRentals.
         *
         * Pass the rentals object to its constructor
         * so the printing class can access the calculations.
         */
        PrintBicycleRentals printer =
            new PrintBicycleRentals(rentals);

        /*
         * STEP 3:
         * Call the PrintReport() method.
         *
         * This generates and displays the complete
         * rental report in the NetBeans Output window.
         */
        printer.PrintReport();
    }

} // End of Main class.
