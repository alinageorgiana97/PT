package model;
public class SavingAccount extends Account {

	public SavingAccount(int idAccount, Person person, String password, double balance) {
		super(idAccount, person, password, balance);
	}

	public void addMoney(double money) {

		setBalance(getBalance() + money);
		setChanged();
		notifyObservers(money);
	}

}
