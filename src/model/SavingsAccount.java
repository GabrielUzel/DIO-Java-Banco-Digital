package model;

public class SavingsAccount extends Account {
  private double interestRate = 0.01;

  public SavingsAccount(Client client) {
    super(client);
  }

  public void applyMonthlyInterest() {
    double interest = balance * interestRate;
    balance += interest;
    transactionHistory.add(new Transaction("Interest", interest, ""));
  }

  @Override
  public void printStatement() {
    System.out.println("=== Savings Account Statement ===");
    super.printCommonInfo();
    System.out.println("Transactions:");
    
    for (Transaction t : transactionHistory) {
      System.out.println(t);
    }
  }
}
