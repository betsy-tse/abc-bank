package com.abc;

import java.util.ArrayList;
import java.util.List;
/*

	This class creates an Account. It is abstract because I used the visitor pattern to create the unique statements based on the Account type as opposed to the static final int from the original.  

*/
public abstract class Account{

	/* Transaction list and where the account summary will be stored */
	private ArrayList<Transaction> transactions;	
	public String summary;

	/* StatementVistor for writing the statement summary */
	private StatementVisitor statementVisitor = new StatementVisitor(this);
	/* Needed abstract void function for all Accounts for the statement creation */
	public abstract void accept(StatementVisitor s);

	/* Account constructor */
	public Account(){
		this.transactions = new ArrayList<Transaction>();
	}


/*	
	No Params
	@Returns - the current summary of this Account
	Calls on the accept method of the dynamic typing of the account using the statementVisitor that was made upon creation of the account to call on the correct beginning of the statement - See StatementVisitor.java
*/
    public String statementForAccount() {
		this.accept(statementVisitor);
		double total = 0.0;
        for (Transaction t : this.transactions) {
            this.summary += "  " + (t.amount < 0 ? "withdrawal" : "deposit") + " " + toDollars(t.amount) + "\n";
            total += t.amount;
        }
        this.summary += "Total " + toDollars(total);
		return this.summary;
    }

/*	
	@Params - Transaction to be added
	No returns
	Adds a transaction to the account; no optional parameters needed since withdraw and deposit only handle one transaction at a time
*/
	public void addTransaction(Transaction t){
		this.transactions.add(t);
	}

/*	
	No params
	@Return - double sum of transactions
	Goes through the list of transactions and returns the sum of all of them
*/
    public double sumTransactions(){
	  	double sumTrans = 0.0;
        for (Transaction t: transactions)
            sumTrans += t.amount;
        return sumTrans;
	}

/*	
	Copied function from Bank.java - refer to there
	Since I moved the statementForAccount() function to the account, which made more sense in my mind, I had to format to dollars, and this function condensed the String.format() I would need to use anyway
*/
    private String toDollars(double d){
        return String.format("$%,.2f", Math.abs(d));
    }

/*
	No params
	@Returns - the interestEarned from the dynamic type of this account
	Calls upon the correct interestEarned function from one of the subclasses
*/
	public double interestEarned(){
		return this.interestEarned();
	}
}
