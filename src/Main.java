import model.Client;
import model.Account;
import model.CheckingAccount;
import model.SavingsAccount;

public class Main {
	public static void main(String[] args) {
		Client client = new Client();
		client.setName("Gabriel");
		
		Account clientAccount = new CheckingAccount(client);
		Account clientSavings = new SavingsAccount(client);

		clientAccount.deposit(100);
		clientAccount.transfer(100, clientSavings);
		
    clientAccount.printStatement();
    clientSavings.printStatement();
	}
}
