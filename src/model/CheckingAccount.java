package model;

public class CheckingAccount extends Account {
  private double overdraftLimit = 500;

  public CheckingAccount(Client client) {
    super(client);
  }

  @Override
  public void withdraw(double amount) {
    if (amount <= 0) {
      throw new IllegalArgumentException("Withdraw amount must be positive");
    }

    if (amount > balance + overdraftLimit) {
      throw new IllegalArgumentException("Insufficient funds, including overdraft limit");
    }

    balance -= amount;
    transactionHistory.add(new Transaction("Withdraw", amount, ""));
  }

  @Override
  public void printStatement() {
    System.out.println("=== Checking Account Statement ===");
    super.printCommonInfo();
    System.out.println("Transactions:");

    for (Transaction t : transactionHistory) {
      System.out.println(t);
    }
  }
}
