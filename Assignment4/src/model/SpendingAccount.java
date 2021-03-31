package model;
public class SpendingAccount extends Account {

	public SpendingAccount(int idAccount, Person person, String password, double balance) {
		super(idAccount, person, password, balance);

	}

	public void addMoney(double money) {
		setBalance(getBalance() + money);
		setChanged();
		notifyObservers();

	}

	public void withdrawMoney(double money) {
		setBalance(getBalance() - money);
		setChanged();
		notifyObservers();

	}
}
