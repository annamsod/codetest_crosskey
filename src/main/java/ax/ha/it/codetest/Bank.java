package ax.ha.it.codetest;

import java.util.ArrayList;

/**
 * Class for representing a bank
 * Each bank have a list of customers
 * Possible improvement: a bank should of course have more information like name
 * and address, but since that wasn't asked for I left it out
 */
public class Bank {

    /** An ArrayList of customers in the bank*/
    private final ArrayList<Customer> prospects = new ArrayList<>();

    /**
     * Method for adding the information about a customer
     * @param name The name of the customer
     * @param loan The amount of thw loan in Euros
     * @param interest The interest of the loan in percent
     * @param years The number of years to pay back the loan
     */
    public void addCustomer(String name, double loan, double interest, int years){
        prospects.add(new Customer(name, loan, interest,years));
    }

    /**
     * A method for producing a list of all the customers in the bank
     * in the required format
     * @return A StringBuilder with all the prospects or a message
     * that there are no prospects
     */
    public StringBuilder getAllProspects(){
        StringBuilder allPros = new StringBuilder();
        // If the list is empty
        if (prospects.isEmpty()){
            allPros.append("There are no prospects!");
        }
        // If the list is not empty, travers the list and append the
        // information about each prospect
        else{
            int i = 1;
            for(Customer customer: prospects){
                allPros.append("****************************************************************************************************\n" +
                        "Prospect ").append(i).append(": ").append(customer.printCustomer())
                        .append("\n")
                        .append("****************************************************************************************************\n\n");
                i++;
            }
        }
        return allPros;
    }

}
