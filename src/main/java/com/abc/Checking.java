package com.abc;

/*
	This is a subclass of Account to handle the unique features of a Checking account, which mainly occurrs in the interestEarned() and the statement creation functions of Account
*/

public class Checking extends Account implements InterestCalc{

	/* Checking Constructor is just Account for now */
    public Checking(){
        super();
    }

/*    
	No params
	@Return - double interest earned from a checking account
	Calls on the sumTransactions() from Account and calculates the interest for a Checking account specifically
*/
    public double interestEarned(){
        double sumT = super.sumTransactions();
        return sumT * 0.001;       
    }
  
/*  
	@Params - StatementVisitor 
	No returns
	Calls on StatementVisitor's visit function of this specific type of Account
*/
    public void accept(StatementVisitor s){
        s.visit(this);
    }   
}
