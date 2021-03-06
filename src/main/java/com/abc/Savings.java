package com.abc;
/*
	This is a subclass of Account that creates a Savings specific account. See InterestCalc.java for more.
*/
public class Savings extends Account implements InterestCalc{

	/* Savings constructor */
    public Savings(){
        super();
    }
    
/*
	No params
	@Returns - double interest earned for a Savings account
	Calculates the interest earned for a Savings account specifically
*/
    public double interestEarned(){
        double sumT = super.sumTransactions();
        return (sumT <= 1000) ? (sumT * 0.001) : (1 + ((sumT - 1000) * 0.002));       
    }    
    
/*
	@Params - StatementVisitor 
	No returns
	Calls on the visit function to create a statement based on this specific Account type
*/
    public void accept(StatementVisitor s){
        s.visit(this);
    }

}
