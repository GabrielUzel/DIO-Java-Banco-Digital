package model;

public class SavingsAccount extends Account {
  public SavingsAccount(Client client) {
    super(client);
  }

  @Override
  public void printStatement() {
    System.out.println("=== Savings Account Statement ===");
    super.printCommonInfo();
  }
}
