package com.abc;
/*
	This is the interface for StatementVisitor. As part of the Visitor design pattern, this would allow us to make different kinds of visitors provided that the name of the interface and file is changed. We could have different kinds of visits for different kinds of reasons, like earning interest; however, I had already implemented interestEarned by using subclasses instead, which I should change so that I am programming to an interface and not an implementation.
*/
public interface StringVisitor {
    void visit(Checking c);
    void visit(Savings s);
    void visit(MaxiSavings m);
}
