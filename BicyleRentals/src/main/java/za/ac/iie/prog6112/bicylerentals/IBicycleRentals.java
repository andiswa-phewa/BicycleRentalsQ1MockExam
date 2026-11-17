/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.ac.iie.prog6112.bicylerentals;

/**
 *
 * @author anphewa
 */

// This interface contains the required method declarations.
// The BicycleRentals class must implement these methods.
public interface IBicycleRentals {

    // Method that returns the total number of rentals.
    // int means the method must return a whole number.
    int GetTotalRentals();

    // Method that calculates the average rentals.
    // double allows the result to contain decimal values.
    double GetAverageRentals();

    // Method that returns the name of the most rented bike.
    // String means the method returns text.
    String GetMostRentedBike();

    // Method that returns the name of the least rented bike.
    String GetLeastRentedBike();
}