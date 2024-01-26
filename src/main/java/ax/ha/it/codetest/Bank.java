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

    public StringBuilder getAllProspects(){
        StringBuilder allPros = new StringBuilder();
        if (prospects.isEmpty()){
            allPros.append("There are no prospects!");
        }
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
