package model;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank implements BankProc {

	private Map<Person, List<Account>> bank = new HashMap<Person, List<Account>>();
	private static final String PATH = "C:\\Users\\Alina\\Desktop\\New folder\\Tema4\\bank.ser";
	private static int id = 0;

	@Override
	public void createUser(Person person) {
		assert person != null;
		assert person.getName() != null;
		bank.put(person, new ArrayList<Account>());

	}

	@Override
	public void addSpendingAccount(String cnp, String password) {
		Person person = null;

		for (Person p : bank.keySet()) {
			if (p.getCnp().equals(cnp)) {
				person = p;
			}
		}
		List<Account> accounts = bank.get(person);

		accounts.add(new SpendingAccount(++id, person, password, 0));
	}

	@Override
	public void addSavingAccount(String cnp, String password) {
		Person person = null;

		for (Person p : bank.keySet()) {
			if (p.getCnp().equals(cnp)) {
				person = p;
			}
		}
		List<Account> accounts = bank.get(person);

		accounts.add(new SavingAccount(++id, person, password, 0));

	}

	@Override
	public void removeUser(String cnp) {
		Person person = null;

		for (Person p : bank.keySet()) {
			if (p.getCnp().equals(cnp)) {
				person = p;
			}
		}
		bank.remove(person);

	}

	@Override
	public void removeAccount(int idAccount) {

		for (List<Account> listAcc : bank.values()) {
			for (Account acc : listAcc) {
				if (acc.getIdAccount() == idAccount) {
					listAcc.remove(acc);
				}

			}
		}
	}

	@Override
	public Account readAccountData(int idAccount) {

		for (List<Account> listAcc : bank.values()) {
			for (Account acc : listAcc) {
				if (acc.getIdAccount() == idAccount) {
					return acc;
				}

			}
		}
		return null;
	}

	@Override
	/*public void writeAccountData(int idAccount, Person person, String password) {
		Account account = null;
		for (List<Account> listAcc : bank.values()) {
			for (Account acc : listAcc) {
				if (acc.getIdAccount() == idAccount) {
					account = acc;
				}
			}
		}

		removeAccount(idAccount);
		if (account instanceof SavingAccount) {
			addSavingAccount(person.getCnp(), password);
		} else {
			addSpendingAccount(person.getCnp(), password);
		}
	}
*/
	@Override
	public void reportReader() { // SERIALIZATION
		try {
			FileOutputStream fileOut = new FileOutputStream(PATH);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(bank);
			out.close();
			fileOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void reportReader() { // DESERIALIZATION
		try {
			FileInputStream fileIn = new FileInputStream(PATH);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			bank = (Map<Person, List<Account>>) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void addObservers() {
		for (Person person : bank.keySet()) {
			for (Account account : bank.get(person)) {
				account.addObserver(person);
			}
		}
	}

}
