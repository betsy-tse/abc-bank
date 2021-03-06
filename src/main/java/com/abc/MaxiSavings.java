package com.abc;
/*
	This is a subclass of Account that creates a Maxi Savings account. See InterestCalc.java
*/
public class MaxiSavings extends Account implements InterestCalc{

	/* Maxi Savings constructor */
    public MaxiSavings(){
        super();
    }
    
/*
	No params
	@Return - double interest depending on the amount
	Calls upon Account's sumTransaction() to calculate the amount of interest earned for a maxi savings account
	I could have gotten rid of the if - else statements using polymorphism, but I could not justify the use for a simple case
*/
    public double interestEarned(){
        double sumT = super.sumTransactions();
        if (sumT <= 1000){
            return sumT * 0.02;
        } else if (sumT <= 2000){
            return 20 + ((sumT-1000) * 0.05);
        } else {
            return 70 + ((sumT-2000) * 0.1);
        }
    }

/*
	@Params - StatementVistior
	No returns
	Calls on StatementVisitor's visit function of this specific type of Account based on the dynamic typing
*/
    public void accept(StatementVisitor s){
        s.visit(this);
    }
}
