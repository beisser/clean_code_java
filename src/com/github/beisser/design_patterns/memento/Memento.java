package com.github.beisser.design_patterns.memento;

/**
 * Memento
 *
 * Is an object / token / handle which represents a snapshot of an object state
 * With this token the state of an object can be set back to the snapshot state
 *
 * difference to Command-Pattern: Command records every Change, Memento only stores a specific snapshot
 */

// class to store a snapshot
class Memento
{
    public int balance;

    public Memento(int balance)
    {
        this.balance = balance;
    }
}

class BankAccount
{
    private int balance;

    public BankAccount(int balance)
    {
        this.balance = balance;
    }

    // method to get a snapshot of the current object
    public Memento deposit(int amount)
    {
        balance += amount;
        return new Memento(balance);
    }

    // class to restore the object to the given snapshot
    public void restore(Memento m)
    {
        balance = m.balance;
    }

    @Override
    public String toString()
    {
        return "BankAccount{" +
                "balance=" + balance +
                '}';
    }
}

class MementoDemo
{
    public static void main(String[] args)
    {
        BankAccount ba = new BankAccount(100);
        Memento m1 = ba.deposit(50); // 150
        Memento m2 = ba.deposit(25); // 175
        System.out.println(ba);

        // restore to m1
        ba.restore(m1);
        System.out.println(ba);

        // restore to m2
        ba.restore(m2);
        System.out.println(ba);
    }
}