package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
  private final String type; 
  private final double amount;
  private final LocalDateTime dateTime;
  private final String details;

  public Transaction(String type, double amount, String details) {
    this.type = type;
    this.amount = amount;
    this.details = details;
    this.dateTime = LocalDateTime.now();
  }

  @Override
  public String toString() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    return String.format("[%s] %s: %.2f %s", dateTime.format(formatter), type, amount, details);
  }
}
