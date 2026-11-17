/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.iie.prog6112.bicylerentals;

/**
 *
 * @author anphewa
 */
// The class implements the IBicycleRentals interface.
// It must provide all four methods declared in the interface.
public class BicycleRentals implements IBicycleRentals {

    /*
     * STEP 1: STORE THE BICYCLE CATEGORIES
     *
     * Create a one-dimensional String array.
     * Each value represents a bicycle category.
     *
     * Index 0 = City Bike
     * Index 1 = Mountain Bike
     * Index 2 = Electric Bike
     */
    private final String[] bicycleCategories = {
        "City Bike",
        "Mountain Bike",
        "Electric Bike"
    };

    /*
     * STEP 2: STORE THE RENTAL DATA
     *
     * Create a two-dimensional integer array.
     *
     * Each row represents one year.
     * Each column represents one bicycle category.
     *
     * Row 0 = Year 1 (2025)
     * Row 1 = Year 2 (2026)
     *
     * Columns:
     * 0 = City Bike
     * 1 = Mountain Bike
     * 2 = Electric Bike
     */
    private final int[][] rentalData = {
        {120, 75, 45},
        {150, 95, 65}
    };

    /*
     * STEP 3: CALCULATE THE TOTAL FOR EACH YEAR
     *
     * This method returns a one-dimensional array
     * containing the total rentals for each year.
     */
    public int[] GetYearlyTotals() {

        // Create an array to store the yearly totals.
        // rentalData.length gives the number of rows (2).
        int[] yearlyTotals = new int[rentalData.length];

        // Outer loop: Go through each year.
        // row starts at 0 and increases by 1.
        for (int row = 0; row < rentalData.length; row++) {

            // Inner loop: Go through each bicycle category
            // within the current year.
            for (int col = 0;
                 col < rentalData[row].length;
                 col++) {

                // Add the current rental value to
                // the total for that year.
                // += means add to the existing value.
                yearlyTotals[row] += rentalData[row][col];
            }
        }

        // Return the array containing the yearly totals.
        return yearlyTotals;
    }

    /*
     * STEP 4: CALCULATE THE OVERALL TOTAL RENTALS
     *
     * This method adds every rental value
     * from both years.
     */
    @Override
    public int GetTotalRentals() {

        // Start the total at zero.
        int total = 0;

        // Outer loop: Go through each year in the array.
        // int[] year holds one row at a time.
        for (int[] year : rentalData) {

            // Inner loop: Go through every rental value
            // inside the current year.
            for (int rentals : year) {

                // Add the rental value to the total.
                total += rentals;
            }
        }

        // Return the overall total rentals.
        return total;
    }

    /*
     * STEP 5: CALCULATE THE AVERAGE RENTALS
     *
     * Average = Total Rentals / Number of Values
     */
    @Override
    public double GetAverageRentals() {

        // Create a counter for the number of rental values.
        int numberOfValues = 0;

        // Go through each year in the array.
        for (int[] year : rentalData) {

            // year.length counts the values in that row.
            // Add this number to numberOfValues.
            numberOfValues += year.length;
        }

        // Check whether there are any values.
        // This prevents division by zero.
        if (numberOfValues == 0) {
            return 0;
        }

        // GetTotalRentals() calculates the overall total.
        // (double) converts the total to a decimal type.
        // Divide the total by the number of values.
        return (double) GetTotalRentals() / numberOfValues;
    }

    /*
     * STEP 6: FIND THE HIGHEST OR LOWEST RENTAL
     *
     * This method searches the two-dimensional array.
     *
     * If highest is true, find the largest value.
     * If highest is false, find the smallest value.
     *
     * It returns the row and column where
     * the selected value was found.
     */
    private int[] FindExtremePosition(boolean highest) {

        // Assume the first value is highest or lowest.
        // Position [0][0] contains 120.
        int bestRow = 0;
        int bestColumn = 0;

        // Outer loop: Go through each year.
        for (int row = 0; row < rentalData.length; row++) {

            // Inner loop: Go through each bicycle category.
            for (int col = 0;
                 col < rentalData[row].length;
                 col++) {

                // Get the rental value currently being checked.
                int candidate = rentalData[row][col];

                // Get the best value found so far.
                int current = rentalData[bestRow][bestColumn];

                /*
                 * Check whether we have found a better value.
                 *
                 * If highest is true:
                 * Compare whether candidate > current.
                 *
                 * If highest is false:
                 * Compare whether candidate < current.
                 *
                 * && means AND.
                 * || means OR.
                 * ! means NOT.
                 */
                if ((highest && candidate > current)
                        || (!highest && candidate < current)) {

                    // Remember the row of the new best value.
                    bestRow = row;

                    // Remember the column of the new best value.
                    bestColumn = col;
                }
            }
        }

        // Return an array containing two positions:
        // Index 0 = Row position.
        // Index 1 = Column position.
        return new int[]{bestRow, bestColumn};
    }

    /*
     * STEP 7: GET THE MOST RENTED BICYCLE
     *
     * Find the highest individual rental value
     * and return the associated bicycle name.
     */
    @Override
    public String GetMostRentedBike() {

        // FindExtremePosition(true) finds the highest value.
        // [1] retrieves the column position.
        // bicycleCategories uses that column to get the name.
        return bicycleCategories[FindExtremePosition(true)[1]];
    }

    /*
     * STEP 8: GET THE LEAST RENTED BICYCLE
     *
     * Find the lowest individual rental value
     * and return the associated bicycle name.
     */
    @Override
    public String GetLeastRentedBike() {

        // FindExtremePosition(false) finds the lowest value.
        // [1] retrieves the column position.
        // Return the bicycle name at that position.
        return bicycleCategories[FindExtremePosition(false)[1]];
    }

    /*
     * STEP 9: GET THE HIGHEST RENTAL VALUE
     *
     * This method returns the actual highest number,
     * rather than the bicycle category name.
     */
    public int GetHighestRentalValue() {

        // Store the row and column of the highest value.
        int[] pos = FindExtremePosition(true);

        // pos[0] is the row index.
        // pos[1] is the column index.
        // Return the value at that position.
        return rentalData[pos[0]][pos[1]];
    }

    /*
     * STEP 10: GET THE LOWEST RENTAL VALUE
     *
     * This method returns the actual lowest number.
     */
    public int GetLowestRentalValue() {

        // Store the row and column of the lowest value.
        int[] pos = FindExtremePosition(false);

        // Return the value at the identified position.
        return rentalData[pos[0]][pos[1]];
    }

} // End of BicycleRentals class.