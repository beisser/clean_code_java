package com.github.beisser.design_patterns.nullObject;

/**
 * Null Object
 *
 * if A gets B injected, but we don't want that every functionality of B is performed in A we use
 * a NullObject
 * a NullObject has the same API as and instance of B but does nothing
 *
 * for hard dependencies it is used because we must not pass null, because it leads to exceptions and errors
 */
interface Log
{
    void info(String msg);
    void warn(String msg);
}

// this is the class injected into the bank account and logs things
class ConsoleLog implements Log
{

    @Override
    public void info(String msg)
    {
        System.out.println(msg);
    }

    @Override
    public void warn(String msg)
    {
        System.out.println("WARNING: " + msg);
    }
}

class BankAccount
{
    private Log log;
    private int balance;

    // now if we don't want to log anything we need a NullObject
    public BankAccount(Log log)
    {
        this.log = log;
    }

    public void deposit(int amount)
    {
        log.info("" + this.balance);
    }

}

// with this NullObject injected into the bank account no logging is performed
final class NullLog implements Log
{

    @Override
    public void info(String msg)
    {

    }

    @Override
    public void warn(String msg)
    {

    }
}
