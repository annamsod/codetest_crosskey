package ax.ha.it.codetest;

import java.text.DecimalFormat;

/**
 * Class for representing a customer
 * In this implementation of the application a customer can have only one loan
 * Possible improvement: create a separate Loan-class and allow a customer
 * to have a list of loans
 */
public class Customer {

    /** String representation for the customers name*/
    private String name;

    /**
     * The amount of the loan in Cents
     * Uses an integer instead of a double to lower the risks of
     * calculation error
     */

    private final int loan;

    /** The interest of the loan as a decimal*/
    private final double interest;

    /** The number of years to pay back the loan*/
    private final int years;

    /** The required monthly payment*/
    private final double payment;

    /**
     * Constructor
     * @param name The name of the customer
     * @param loan The amount of the loan in Euros
     * @param interest The interest of the loan in percent
     * @param years The number of years to pay back the loan
     */
    public Customer(String name, double loan, double interest, int years) {
        this.name = name;
        this.loan = (int) (loan*100);
        this.interest = interest/100;
        this.years = years;
        this.payment=this.calcPayment();
    }

    /**
     * @return The name of the customer
     */
    public String getName() {
        return name;
    }

    /**
     * @return The amount of the loan in Euros
     */
    public double getLoan() {
        return (double) loan /100;
    }

    /**
     * @return The interest of the loan in percent
     */
    public double getInterest() {
        return interest*100;
    }

    /**
     * @return The number of years to pay back the loan
     */
    public int getYears() {
        return years;
    }

    /**
     * @return The amount of the monthly payment in Euros
     */
    public double getPayment() {
        return payment;
    }

    /**
     * Method to change the name of a customer
     * @param name The new name for the customer
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method to get a specific string representation of a customers information
     * @return A string with a specific appearance
     */
    public String printCustomer() {
        DecimalFormat format = new DecimalFormat("#.00");
        return  name +
                " wants to borrow " + format.format((double)loan/100) +
                " € for a period of " + years +
                " years and pay " + format.format(payment) +
                " € each month." ;
    }

    /**
     * Method for calculating the monthly payment
     * @return The required monthly payment in Euros
     */
    public double calcPayment(){
        double result;
        double r = interest/12; //monthly interest
        result=loan*(r*Utils.power(1+r,years*12))/(Utils.power(1+r,years*12)-1);
        return result/100;
    }
}
