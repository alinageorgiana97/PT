package model;

public interface BankProc {

	void createUser(Person person);

	void addSavingAccount(String cnp, String password);

	void addSpendingAccount(String cnp, String password);

	void removeUser(String cnp);

	void removeAccount(int idAccount);

	Account readAccountData(int idAccount);

	//void writeAccountData(int idAccount,, Person person, String password);

	void reportReader();
}
