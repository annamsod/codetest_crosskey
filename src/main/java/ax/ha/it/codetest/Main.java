package ax.ha.it.codetest;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        try {
            File myObj = new File("src/main/resources/prospects.txt");
            Scanner myReader = new Scanner(myObj);

            if (myReader.hasNextLine()) {
                myReader.nextLine();
            }

            while (myReader.hasNextLine()) {
                String line = myReader.nextLine().trim();

                String[] customerInfo = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
                if (customerInfo.length != 4) {
                    continue;
                }

                String name = customerInfo[0].replaceAll("\"", "").replace(",", " ").trim();
                double loan = Double.parseDouble(customerInfo[1]);
                double interest = Double.parseDouble(customerInfo[2]);
                int years = Integer.parseInt(customerInfo[3]);
                bank.addCustomer(name,loan,interest,years);
            }

                myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        JOptionPane.showMessageDialog(null,bank.getAllProspects());
        //System.out.println(bank.getAllProspects());
    }
}
