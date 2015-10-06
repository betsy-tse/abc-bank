package com.abc;

import java.util.ArrayList;
<<<<<<< HEAD
/*
	This class creates a completely new bank with the ability to add customers, check the total amount of interest of these customers, get a formatted summary of the customers, and get the name of the first customer of the bank
*/
public class Bank {
	/* Where customers are stored */
    private ArrayList<Customer> customers;

	/* Bank constructor */
=======
import java.util.List;

public class Bank {
    private List<Customer> customers;

>>>>>>> 904098dd6376871b53f0db7560eb02526c92d0b4
    public Bank() {
        customers = new ArrayList<Customer>();
    }

<<<<<<< HEAD
/*
	@Params - one customer, optional many customers
	No returns
	Adds the customers to the customers list in order
	varargs in case there is more than one customer to be added at this bank
*/
    public void addCustomer(Customer first, Customer... customer) {
		customers.add(first);
		if(customer != null){
		    for(Customer c : customer){
				customers.add(c);
			}
		}
    }

/*	
	No params
	returns String of a summary
	Creates a formatted summary of all the customers within the bank, showing the number of accounts at this certain bank that they have
*/
=======
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

>>>>>>> 904098dd6376871b53f0db7560eb02526c92d0b4
    public String customerSummary() {
        String summary = "Customer Summary";
        for (Customer c : customers)
            summary += "\n - " + c.getName() + " (" + format(c.getNumberOfAccounts(), "account") + ")";
        return summary;
    }

<<<<<<< HEAD
/*	
	@Params - int number, String word
	@Return - formatted String
    Make sure correct plural of word is created based on the number passed in:
    If number passed in is 1 just return the word otherwise add an 's' at the end
*/
=======
    //Make sure correct plural of word is created based on the number passed in:
    //If number passed in is 1 just return the word otherwise add an 's' at the end
>>>>>>> 904098dd6376871b53f0db7560eb02526c92d0b4
    private String format(int number, String word) {
        return number + " " + (number == 1 ? word : word + "s");
    }

<<<<<<< HEAD
/*
	No params
	@Return - double total amount of interest
	Calculates the total interest of all the customers within the bank
*/
	public double totalInterestPaid() {
=======
    public double totalInterestPaid() {
>>>>>>> 904098dd6376871b53f0db7560eb02526c92d0b4
        double total = 0;
        for(Customer c: customers)
            total += c.totalInterestEarned();
        return total;
    }

<<<<<<< HEAD
/*
	No params
	@Return - String result
	Grabs the first customer from the customers list of this bank
	@Exception - IndexOutOfBoundsException for get() function
	Not sure why this is here, since we do not use it, and it is pretty uninformative at the moment. I decided to refactor this instead of remove it because it might be used for something later on (congratulate the first customer, etc?)
*/
    public String getFirstCustomer() {
		String result = "";
        try {
            result = (customers.get(0)).getName();
        } catch (IndexOutOfBoundsException e){
			System.err.println(e.getMessage());
			result = "Index out of bounds";
		}
		return result;
=======
    public String getFirstCustomer() {
        try {
            customers = null;
            return customers.get(0).getName();
        } catch (Exception e){
            e.printStackTrace();
            return "Error";
        }
>>>>>>> 904098dd6376871b53f0db7560eb02526c92d0b4
    }
}
