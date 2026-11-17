/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.iie.prog6112.bicylerentals;

/**
 *
 * @author anphewa
 */

// This class is responsible for displaying
// the bicycle rental report in the Output window.
public class PrintBicycleRentals {

    /*
     * STEP 1: DECLARE THE OBJECT
     *
     * Create a variable that will store a reference
     * to the BicycleRentals object.
     *
     * This allows us to access the calculation methods
     * from the BicycleRentals class.
     */
    private final BicycleRentals rentals;

    /*
     * STEP 2: CONSTRUCTOR
     *
     * The constructor receives a BicycleRentals object.
     * We store the object so that other methods
     * in this class can use it.
     */
    public PrintBicycleRentals(BicycleRentals rentals) {

        // Assign the object received from the constructor
        // to our class-level variable.
        this.rentals = rentals;
    }

    /*
     * STEP 3: PRINT THE COMPLETE REPORT
     *
     * This method calls the other printing methods
     * to display the full report.
     */
    public void PrintReport() {

        // Display the report heading.
        System.out.println("BICYCLE RENTAL REPORT - 2026");

        // Display a separator line.
        System.out.println("************************************************");

        // Display the totals for Year 1 and Year 2.
        PrintYearlyTotals();

        // Display the total rentals for both years.
        PrintOverallTotal();

        // Display the average rentals.
        PrintAverage();

        // Display the highest and lowest rental values.
        PrintHighestAndLowest();

        // Display the closing separator.
        System.out.println("************************************************");
    }

    /*
     * STEP 4: PRINT YEARLY TOTALS
     *
     * This method displays the total number
     * of rentals for each year.
     */
    public void PrintYearlyTotals() {

        // Call the method that calculates the yearly totals.
        // The method returns a one-dimensional integer array.
        int[] yearlyTotals = rentals.GetYearlyTotals();

        // Loop through each value in the yearlyTotals array.
        for (int i = 0; i < yearlyTotals.length; i++) {

            // Display the year and its total rentals.
            // i + 1 makes the year numbering start at 1.
            // %d is used to display integer values.
            // %n moves the output to a new line.
            System.out.printf(
                "YEAR %d RENTALS: %d%n",
                i + 1,
                yearlyTotals[i]
            );
        }
    }

    /*
     * STEP 5: PRINT OVERALL TOTAL
     *
     * This method displays the total rentals
     * across both years.
     */
    public void PrintOverallTotal() {

        // Call GetTotalRentals() from BicycleRentals
        // and display the returned value.
        System.out.println(
            "TOTAL RENTALS: " + rentals.GetTotalRentals()
        );
    }

    /*
     * STEP 6: PRINT THE AVERAGE
     *
     * This method displays the average rentals
     * to two decimal places.
     */
    public void PrintAverage() {

        // Call GetAverageRentals() to retrieve the average.
        // %.2f displays the number to two decimal places.
        // %n moves the output to the next line.
        // No additional import is needed.
        System.out.printf(
            "AVERAGE RENTALS: %.2f%n",
            rentals.GetAverageRentals()
        );
    }

    /*
     * STEP 7: PRINT THE HIGHEST AND LOWEST RENTALS
     *
     * This method displays the names of the most
     * and least rented bicycles, including their values.
     */
    public void PrintHighestAndLowest() {

        // Display the bicycle with the highest rental value.
        // %s displays a String (bicycle name).
        // %d displays an integer (rental value).
        System.out.printf(
            "MOST RENTED BIKE: %s (%d)%n",
            rentals.GetMostRentedBike(),
            rentals.GetHighestRentalValue()
        );

        // Display the bicycle with the lowest rental value.
        System.out.printf(
            "LEAST RENTED BIKE: %s (%d)%n",
            rentals.GetLeastRentedBike(),
            rentals.GetLowestRentalValue()
        );
    }

} // End of PrintBicycleRentals class.