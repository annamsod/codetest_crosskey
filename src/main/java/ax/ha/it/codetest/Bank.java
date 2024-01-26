package ax.ha.it.codetest;

import java.util.ArrayList;

public class Bank {
    private final ArrayList<Customer> prospects = new ArrayList<>();

    public void addCustomer(String name, double loan, double interest, int years){
        prospects.add(new Customer(name, loan, interest,years));
    }

    public Customer getProspect(int index) {
        return prospects.get(index);
    }

}
