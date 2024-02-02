package ax.ha.it.codetest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The main class for Mortage plan application which runs the application
 */
public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        try {
            // Open the text file with the information and create a scanner object
            File myObj = new File("src/main/resources/prospects.txt");
            Scanner myReader = new Scanner(myObj);

            // Skip the first line with the titles
            if (myReader.hasNextLine()) {
                myReader.nextLine();
            }

            // Travers the lines in the text file
            while (myReader.hasNextLine()) {
                // Read one line at the time
                String line = myReader.nextLine().trim();

                // Split the line at each comma (except in " ")
                String[] customerInfo = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");

                // Check that the line consists of useful information, otherwise skip line
                if (customerInfo.length != 4) {
                    continue;
                }

                // Assign the right information to the right variable
                String name = customerInfo[0].replaceAll("\"", "").replace(",", " ").trim();
                double loan = Double.parseDouble(customerInfo[1]);
                double interest = Double.parseDouble(customerInfo[2]);
                int years = Integer.parseInt(customerInfo[3]);

                // Add the customer to the bank list
                bank.addCustomer(name,loan,interest,years);
            }

                myReader.close();
        } catch (FileNotFoundException e) {
            // If the file can't be found print an error message
            System.out.println("An error occurred.");
            e.printStackTrace();
        }



        // Show all the prospects in the terminal
        System.out.println(bank.getAllProspects());
    }
}
