package ax.ha.it.codetest;

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

    public double calcPayment(){
        double result=0;
        result=loan*(interest*Utils.power(1+interest,years*12))/(Utils.power(1+interest,years*12)-1);
        return result/100;
    }
}