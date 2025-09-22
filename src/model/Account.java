package model;

import interfaces.IAccount;

public abstract class Account implements IAccount {
  private static final int DEFAULT_BRANCH = 1;
  private static int SEQUENTIAL = 1;

  protected int branch;
  protected int number;
  protected double balance;
  protected Client client;

  public Account(Client client) {
    this.branch = Account.DEFAULT_BRANCH;
    this.number = SEQUENTIAL++;
    this.client = client;
  }

  @Override
  public void withdraw(double amount) {
    balance -= amount;
  }

  @Override
  public void deposit(double amount) {
    balance += amount;
  }

  @Override
  public void transfer(double amount, IAccount destinationAccount) {
    this.withdraw(amount);
    destinationAccount.deposit(amount);
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

  protected void printCommonInfo() {
    System.out.println(String.format("Holder: %s", this.client.getName()));
    System.out.println(String.format("Branch: %d", this.branch));
    System.out.println(String.format("Number: %d", this.number));
    System.out.println(String.format("Balance: %.2f", this.balance));
  }
}
