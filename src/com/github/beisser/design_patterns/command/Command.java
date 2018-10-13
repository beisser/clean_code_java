package com.github.beisser.design_patterns.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Command
 *
 * an object which stores single commands / operations to
 *      - undo or redo those statements
 *      - play them in reverse order (like in an editor)
 *      - record macros and play them
 *      - record all changes made
 *
 * storing the operation in an object is perfect for serialization
 */

// in this case all changes to a bank account should be recorded
class BankAccount {
    private int balance;
    private int limit = -500;

    public void addMoney(int amount) {
        this.balance += amount;
    }

    public void getMoney(int amount) {
        if(this.balance - amount >= this.limit) {
            this.balance -= amount;
        }
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "balance=" + balance +
                '}';
    }
}

//interface for a command
interface Command {

    // record the command
    void call();

    // undo the command
    void undo();
}

// this object stores a single change to the given bank account
// can later be used in a list to record all transactions
class BankAccountCommand implements Command {
    private BankAccount account;
    private Action action;
    private int amount;

    public enum Action {
        ADD,
        GET
    }

    public BankAccountCommand(BankAccount account, Action action, int amount) {
        this.account = account;
        this.action = action;
        this.amount = amount;
    }

    @Override
    public void call() {
        switch (action) {
            case ADD:
                this.account.addMoney(this.amount);
                break;
            case GET:
                this.account.getMoney(this.amount);
                break;
        }
    }

    @Override
    public void undo() {
        // undo the logic
    }
}

class CommandDemo {

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();

        // record all changes
        List<BankAccountCommand> command = new ArrayList<>();
        command.add(new BankAccountCommand(bankAccount, BankAccountCommand.Action.ADD, 100));
        command.add(new BankAccountCommand(bankAccount, BankAccountCommand.Action.ADD, 100));
        command.add(new BankAccountCommand(bankAccount, BankAccountCommand.Action.GET, 200));


    }
}