package com.abc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
<<<<<<< HEAD
import static org.junit.Assert.fail;
=======
>>>>>>> 904098dd6376871b53f0db7560eb02526c92d0b4

public class BankTest {
    private static final double DOUBLE_DELTA = 1e-15;

<<<<<<< HEAD
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
=======
    @Test
    public void customerSummary() {
        Bank bank = new Bank();
        Customer john = new Customer("John");
        john.openAccount(new Account(Account.CHECKING));
        bank.addCustomer(john);

        assertEquals("Customer Summary\n - John (1 account)", bank.customerSummary());
    }

    @Test
    public void checkingAccount() {
        Bank bank = new Bank();
        Account checkingAccount = new Account(Account.CHECKING);
        Customer bill = new Customer("Bill").openAccount(checkingAccount);
        bank.addCustomer(bill);

        checkingAccount.deposit(100.0);
>>>>>>> 904098dd6376871b53f0db7560eb02526c92d0b4

        assertEquals(0.1, bank.totalInterestPaid(), DOUBLE_DELTA);
    }

<<<<<<< HEAD
	//Test if a savings account was made using interest rate
    @Test
    public void savings_account() {
        Bank bank = new Bank();
        Account savingsAccount = new Savings();
		Customer bill = new Customer("Bill", savingsAccount);
        bank.addCustomer(bill);

        bill.deposit(1500.0, savingsAccount);
=======
    @Test
    public void savings_account() {
        Bank bank = new Bank();
        Account checkingAccount = new Account(Account.SAVINGS);
        bank.addCustomer(new Customer("Bill").openAccount(checkingAccount));

        checkingAccount.deposit(1500.0);
>>>>>>> 904098dd6376871b53f0db7560eb02526c92d0b4

        assertEquals(2.0, bank.totalInterestPaid(), DOUBLE_DELTA);
    }

<<<<<<< HEAD
	//test if a maxi savings account was made using interest rate
    @Test
    public void maxi_savings_account() {
        Bank bank = new Bank();
        Account maxiSavingsAccount = new MaxiSavings();
		Customer bill = new Customer("Bill", maxiSavingsAccount);
        bank.addCustomer(bill);

        bill.deposit(3000.0, maxiSavingsAccount);
=======
    @Test
    public void maxi_savings_account() {
        Bank bank = new Bank();
        Account checkingAccount = new Account(Account.MAXI_SAVINGS);
        bank.addCustomer(new Customer("Bill").openAccount(checkingAccount));

        checkingAccount.deposit(3000.0);
>>>>>>> 904098dd6376871b53f0db7560eb02526c92d0b4

        assertEquals(170.0, bank.totalInterestPaid(), DOUBLE_DELTA);
    }

<<<<<<< HEAD
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

=======
>>>>>>> 904098dd6376871b53f0db7560eb02526c92d0b4
}
