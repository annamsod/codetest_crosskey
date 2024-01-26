package ax.ha.it.codetest;

import java.text.DecimalFormat;

public class Customer {
    private String name;
    private final int loan;
    private final double interest;
    private final int years;
    private final double payment;

    public Customer(String name, double loan, double interest, int years) {
        this.name = name;
        this.loan = (int) (loan*100);
        this.interest = interest/100;
        this.years = years;
        this.payment=this.calcPayment();
    }

    public String getName() {
        return name;
    }

    public double getLoan() {
        return (double) loan /100;
    }

    public double getInterest() {
        return interest*100;
    }

    public int getYears() {
        return years;
    }

    public double getPayment() {
        return payment;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String printCustomer() {
        DecimalFormat format = new DecimalFormat("#.00");
        return  name +
                " wants to borrow " + format.format(loan/100) +
                " € for a period of " + years +
                " years and pay " + format.format(payment) +
                " € each month." ;
    }

    public double calcPayment(){
        double result;
        double r = interest/12; //monthly interest
        result=loan*(r*Utils.power(1+r,years*12))/(Utils.power(1+r,years*12)-1);
        return result/100;
    }
}
