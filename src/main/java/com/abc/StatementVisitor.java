package com.abc;
/*
	This is a class that will implement the StringVisitor class to fully implement the Visitor design pattern to implement polymorphism and get rid of the need for switch-case in statement creation.
	This can be modified for later use in an easier-to-read way and new kinds of accounts can be added just as easy as well.
	The reason why I chose the Visitor pattern for statement creation was to eliminate the need for the switch-case statement that relied heavily on a static final variable that was from Account. I didn't want to have unnecessary variables if I can eliminate it by creating subclasses and then working around those subclasses for more condensed code
*/
public class StatementVisitor implements StringVisitor {

    private Account acc;

    /* StatementVisitor constructor */
    public StatementVisitor(Account acc_in){
        this.acc = acc_in;
    } 

/*
    @Params - Checking accounts only
    No returns
    The visit function for Checking accounts; sets the account's summary to the type of account that we are summarizing
*/
    public void visit(Checking c){
        acc.summary = "Checking Account\n";
    }

/*
    @Params - Savings accounts only
    No returns
    The visit function for Savings accounts; sets the account's summary to the type of account that we are summarizing
*/
    public void visit(Savings s){
        acc.summary = "Savings Account\n";
    }

/*
    @Params - Maxi Savings accounts only
    No returns
    The visit function for Maxi Savings accounts; sets the account's summary to the type of account that we are summarizing
*/
    public void visit(MaxiSavings m){
        acc.summary = "Maxi Savings Account\n";
    }

}
