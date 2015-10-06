package com.abc;

import java.util.ArrayList;
import java.util.Arrays;

/*

    This class creates a customer with a name and / or some accounts on creation. Allows other classes to get the first name and account list size for the customer. Allows for the customer to add more accounts, deposit money, withdraw money, calculate the total amount of interest earned for all the accounts of this customer, and create a statement for all the accounts of this customer

*/

public class Customer {
	/* Name of customer and accounts they hold */
    private String name;
    private ArrayList<Account> accounts;

	/* Customer Constructor; optional parameters for multiple accounts they might hold */
    public Customer(String name, Account... acc) {
        this.name = name;
        this.accounts = new ArrayList<Account>();
        if (acc != null){
			this.accounts = new ArrayList<Account>(Arrays.asList(acc));
		} 
    }

	/* Getter for customer name */
    public String getName() {
        return name;
    }

	/* Getter for account size */
    public int getNumberOfAccounts() {
        return accounts.size();
    }

/*
	@Params - a single account, optional many accounts
	No returns
	Allows for a customer to open up one or many bank accounts at a time
*/
    public void openAccount(Account first, Account... account) {
        accounts.add(first);
		if(account != null){
			for(Account a : account){
				accounts.add(a);
			}
		}
    }

/*
	@Params - double amount to deposit, Account to deposit into
	No returns
	Determines if the amount a customer wants to deposit is valid (not negative) and then either throws an exception or creates the transaction to that specific account
*/
	public void deposit(double amount, Account acc) {
		if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        } else {
            acc.addTransaction(new Transaction(amount));
        }
	}

/*
	@Params - double amount to withdraw, Account to withdraw from
	No returns
	Determines if the amount to withdraw is correct (no negatives, must be less than or equal to the amount within the account) and then withdraws money from that specific account
*/
	public void withdraw(double amount, Account acc){
		double cur_amt = acc.sumTransactions();
		if (amount <= 0) {
        	throw new IllegalArgumentException("Amount must be greater than zero");
        } else if (amount > cur_amt){
			throw new IllegalArgumentException("Amount must be less than current amount " + toDollars(cur_amt));
        } else {
            acc.addTransaction(new Transaction(-amount));
		}
	}   

/*
	No params
	@Returns - double total amount of interest earned for all accounts
	Runs the interestEarned() function on all accounts for this customer and totals the amount
*/    public double totalInterestEarned() {
        double total = 0;
        for (Account a : accounts)
            total += a.interestEarned();
        return total;
    }

/*
    No params
    @Return - formatted String 
    Creates a statement for this specific customer that contains the statement for their accounts
*/
    public String getStatement() {
        String statement = null;
        statement = "Statement for " + name + "\n";
        double total = 0.0;
        for (Account a : accounts) {
            statement += "\n" + a.statementForAccount() + "\n";
            total += a.sumTransactions();
        }
        statement += "\nTotal In All Accounts " + toDollars(total);
        return statement;
    }

/*
    @Params - double dollar amount
    @Return - formatted String
    Creates a $##.## format for the amount passed in
*/
    private String toDollars(double d){
        return String.format("$%,.2f", Math.abs(d));
   }
}
