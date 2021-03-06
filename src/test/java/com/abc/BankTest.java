package com.abc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class BankTest {
    private static final double DOUBLE_DELTA = 1e-15;

	//Test if the customer summary works
    @Test
    public void customerSummary() {
        Bank bank = new Bank();
        Customer john = new Customer("John", new Checking());
		Customer jo = new Customer("Jo", new Savings());
		Customer henry = new Customer("Henry", new MaxiSavings(), new Checking());

        bank.addCustomer(john, jo, henry);

        assertEquals("Customer Summary\n - John (1 account)\n - Jo (1 account)\n - Henry (2 accounts)", bank.customerSummary());
    }

	//Test if a checking account was made using interest rate
    @Test
    public void checkingAccount() {
        Bank bank = new Bank();
        Account checkingAccount = new Checking();
        Customer bill = new Customer("Bill", checkingAccount);
        bank.addCustomer(bill);

        bill.deposit(100.0, checkingAccount);
    }

	//Test if a savings account was made using interest rate
    @Test
    public void savings_account() {
        Bank bank = new Bank();
        Account savingsAccount = new Savings();
		Customer bill = new Customer("Bill", savingsAccount);
        bank.addCustomer(bill);

        bill.deposit(1500.0, savingsAccount);
    }

	//Test if a maxi savings account was made using interest rate
    @Test
    public void maxi_savings_account() {
        Bank bank = new Bank();
        Account maxiSavingsAccount = new MaxiSavings();
		Customer bill = new Customer("Bill", maxiSavingsAccount);
        bank.addCustomer(bill);

        bill.deposit(3000.0, maxiSavingsAccount);
    }

	//Test for the getFirstCustomer() function
	@Test
	public void getFirstTest(){
		Bank b = new Bank();
		Customer bill = new Customer("Bill", new MaxiSavings());
		Customer jo = new Customer("Jo");
		Customer henry = new Customer("Henry", new Checking());
		b.addCustomer(bill, jo, henry);
		assertEquals("Bill", b.getFirstCustomer());
	}

	//Test if the getFirstCustomer fails correctly
	@Test
	public void getFirstFail(){
		Bank b = new Bank();
		//get() can only throw an IndexOutOfBounds exception
		assertEquals("Index out of bounds", b.getFirstCustomer());
	}
}
