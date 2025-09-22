package model;

import interfaces.IAccount;
import java.util.ArrayList;
import java.util.List;

public abstract class Account implements IAccount {
  private static final int DEFAULT_BRANCH = 1;
  private static int SEQUENTIAL = 1;

  protected int branch;
  protected int number;
  protected double balance;
  protected Client client;
  protected List<Transaction> transactionHistory = new ArrayList<>();

  public Account(Client client) {
    this.branch = DEFAULT_BRANCH;
    this.number = SEQUENTIAL++;
    this.client = client;
  }

  @Override
  public void withdraw(double amount) {
    if (amount <= 0) {
      throw new IllegalArgumentException("Withdraw amount must be positive");
    }
    if (amount > balance) {
      throw new IllegalArgumentException("Insufficient funds");
    }

    balance -= amount;
    transactionHistory.add(new Transaction("Withdraw", amount, ""));
  }

  @Override
  public void deposit(double amount) {
    if (amount <= 0) {
      throw new IllegalArgumentException("Deposit amount must be positive");
    }
    
    balance += amount;
    transactionHistory.add(new Transaction("Deposit", amount, ""));
  }

  @Override
  public void transfer(double amount, IAccount destinationAccount) {
    if (destinationAccount == null) {
      throw new IllegalArgumentException("Destination account cannot be null");
    }

    this.withdraw(amount);
    destinationAccount.deposit(amount);
    transactionHistory.add(new Transaction("Transfer", amount, "To account " + ((Account) destinationAccount).getNumber()));
  }

  public int getBranch() {
    return branch;
  }

  public int getNumber() {
    return number;
  }

  public double getBalance() {
    return balance;
  }

  public List<Transaction> getTransactionHistory() {
    return transactionHistory;
  }

  protected void printCommonInfo() {
    System.out.println(String.format("Holder: %s", client.getName()));
    System.out.println(String.format("Branch: %d", branch));
    System.out.println(String.format("Number: %d", number));
    System.out.println(String.format("Balance: %.2f", balance));
  }
}
