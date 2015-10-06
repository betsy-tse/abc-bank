package com.abc;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
<<<<<<< HEAD
import static org.junit.Assert.fail;

public class CustomerTest {
    private static final double DOUBLE_DELTA = 1e-15;

    @Test //Test customer statement generation
    public void statementTest(){

        Account checkingAccount = new Checking();
        Account savingsAccount = new Savings();

        Customer henry = new Customer("Henry");

		henry.openAccount(checkingAccount);
		henry.openAccount(savingsAccount);

        henry.deposit(100.0, checkingAccount);
        henry.deposit(4000.0, savingsAccount);
        henry.withdraw(200.0, savingsAccount);
=======

public class CustomerTest {

    @Test //Test customer statement generation
    public void testApp(){

        Account checkingAccount = new Account(Account.CHECKING);
        Account savingsAccount = new Account(Account.SAVINGS);

        Customer henry = new Customer("Henry").openAccount(checkingAccount).openAccount(savingsAccount);

        checkingAccount.deposit(100.0);
        savingsAccount.deposit(4000.0);
        savingsAccount.withdraw(200.0);
>>>>>>> 904098dd6376871b53f0db7560eb02526c92d0b4

        assertEquals("Statement for Henry\n" +
                "\n" +
                "Checking Account\n" +
                "  deposit $100.00\n" +
                "Total $100.00\n" +
                "\n" +
                "Savings Account\n" +
                "  deposit $4,000.00\n" +
                "  withdrawal $200.00\n" +
                "Total $3,800.00\n" +
                "\n" +
                "Total In All Accounts $3,900.00", henry.getStatement());
    }

<<<<<<< HEAD
	//Test Customer constructor, getNumberofAccounts, and varargs
    @Test
    public void testOneAccount(){
        Customer oscar = new Customer("Oscar", new Checking());
        assertEquals(1, oscar.getNumberOfAccounts());
    }

	//Test Customer constructor, getNumberofAccounts, and varargs
    @Test
    public void testTwoAccount(){
        Customer oscar = new Customer("Oscar", new Savings(), new Checking());
        assertEquals(2, oscar.getNumberOfAccounts());
    }

	//Test Customer constructor, getNumberofAccounts, and varargs
    @Test
    public void testThreeAcounts() {
        Customer oscar = new Customer("Oscar", new Savings(), new Checking(), new MaxiSavings());
        assertEquals(3, oscar.getNumberOfAccounts());
    }

	//Test getName()
	@Test
	public void nameTest(){
		Customer jo = new Customer("Jo");
		assertEquals("Jo", jo.getName());
	}
	
	//Test if deposit works
	@Test
	public void depositTest(){
		Customer jo = new Customer("Jo");
		Account checking = new Checking();
		jo.openAccount(checking);
		jo.deposit(100.0, checking);

		assertEquals("Statement for Jo\n" +
                "\n" +
                "Checking Account\n" +
                "  deposit $100.00\n" +
                "Total $100.00\n" +
                "\n" +
                "Total In All Accounts $100.00", jo.getStatement());
	}

	//Test if deposit catches the wrong input
	@Test 
	public void failedDepositTest(){
		Customer jo = new Customer("Jo");
		Account checking = new Checking();
		jo.openAccount(checking);

		try{ 
			jo.deposit(-90.0, checking);
			fail("Missed exception");
		} catch (Exception e){
			String ex = "Amount must be greater than zero";
			assertEquals(ex, e.getMessage());
		}	

	}

	//Test if withdraw works
	@Test
	public void withdrawTest(){
		Customer jo = new Customer("Jo");
		Account checking = new Checking();
		jo.openAccount(checking);
		jo.deposit(90.0, checking);
		jo.withdraw(90.0, checking);

		assertEquals("Statement for Jo\n" +
                "\n" +
                "Checking Account\n" +
                "  deposit $90.00\n" +
				"  withdrawal $90.00\n" +
                "Total $0.00\n" +
                "\n" +
                "Total In All Accounts $0.00", jo.getStatement());
	}
	
	//Test if withdraw will fail if the amount is more than what is in the account
	@Test
	public void withdrawTooMuchTest(){
		Customer jo = new Customer("Jo");
		Account checking = new Checking();
		jo.openAccount(checking);
		jo.deposit(90.0, checking);		

		try {  
			jo.withdraw(900.0, checking);
			fail("Missed exception");
		} catch (Exception e){
			String ex = "Amount must be less than current amount $90.00";
			assertEquals(ex, e.getMessage());
		}	
	}

	//Test if withdraw will fail if the amount is negative
	@Test
	public void withdrawNegativeTest(){
		Customer jo = new Customer("Jo");
		Account checking = new Checking();
		jo.openAccount(checking);
		jo.deposit(90.0, checking);

		try {
			jo.withdraw(-8921.0, checking);
			fail("Skipped exception");
		} catch (Exception e){
			String ex = "Amount must be greater than zero";
			assertEquals(ex, e.getMessage());
		}
	}

	//Test if totalInterest() works
	@Test
	public void totalInterestTest(){
		Customer jo = new Customer("Jo");
		Account checking = new Checking();
		Account savings = new Savings();

		jo.openAccount(checking, savings);

		jo.deposit(100.0, checking);
		jo.deposit(100.0, savings);	

		assertEquals(0.2, jo.totalInterestEarned(), DOUBLE_DELTA);
	}

=======
    @Test
    public void testOneAccount(){
        Customer oscar = new Customer("Oscar").openAccount(new Account(Account.SAVINGS));
        assertEquals(1, oscar.getNumberOfAccounts());
    }

    @Test
    public void testTwoAccount(){
        Customer oscar = new Customer("Oscar")
                .openAccount(new Account(Account.SAVINGS));
        oscar.openAccount(new Account(Account.CHECKING));
        assertEquals(2, oscar.getNumberOfAccounts());
    }

    @Ignore
    public void testThreeAcounts() {
        Customer oscar = new Customer("Oscar")
                .openAccount(new Account(Account.SAVINGS));
        oscar.openAccount(new Account(Account.CHECKING));
        assertEquals(3, oscar.getNumberOfAccounts());
    }
>>>>>>> 904098dd6376871b53f0db7560eb02526c92d0b4
}
