package com.abc;
/*
	This is the interface that allows for some polymorphism to get rid of the switch - case statements and make the interestEarned() function within Account.java easier to manage and read. It is easily available to add onto (let's say there are new types of accounts created) and easy to modify existing accounts and how they calculate interest
*/
public interface InterestCalc{
    public double interestEarned();
}
