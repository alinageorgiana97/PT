package presentation;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Application {
	private JLabel nameLbl;
	private JLabel emailLbl;
	private JLabel addressLbl;

	private JTextField nameTF;
	private JTextField emailTF;
	private JTextField addressTF;

	private JButton cancelBtn;
	private JButton addClientBtn;

	private JPanel panel1;
	
	
	private JLabel nameLbl2;
	private JLabel priceLbl;
	private JLabel qtyLbl;

	private JTextField nameTF2;
	private JTextField priceTF;
	private JTextField qtyTF;

	private JButton cancelBtn2;
	private JButton addProductBtn;

	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setTitle("Calculator de polinoame");
	this.setSize(800, 600);

	panel1 = new JPanel();
	panel1.setLayout(null);
	panel1.setSize(800, 350);
	panel1.setBackground(Color.lightGray);
	this.add(panel1);

	panel2 = new JPanel();
	panel2.setLayout(null);
	panel2.setSize(800, 350);
	panel2.setBackground(Color.white);
	this.add(panel2);

	titlu = new JLabel("");
	titlu.setFont(new Font("Arial", Font.BOLD, 20));
	titlu.setBounds(250, 20, 300, 20);
	panel1.add(titlu);

	p1 = new JLabel("");
	p1.setFont(new Font("Arial", Font.BOLD, 18));
	p1.setBounds(10, 50, 100, 100);
	panel1.add(p1);

	text1 = new JTextField(" ", 10);
	text1.setEditable(true);
	text1.setFont(new Font("Arial", Font.BOLD, 18));
	text1.setBounds(150, 85, 470, 30);
	panel1.add(text1);

	adaugaA = new JButton("");
	adaugaA.setFont(new Font("Arial", Font.BOLD, 15));
	adaugaA.setBounds(680, 60, 100, 30);
	adaugaA.setBackground(Color.white);
	adaugaA.setForeground(Color.black);
	panel1.add(adaugaA);

	clear = new JButton("clear");
	clear.setFont(new Font("Arial", Font.BOLD, 15));
	clear.setBounds(680, 120, 100, 30);
	clear.setBackground(Color.white);
	clear.setForeground(Color.black);
	panel1.add(clear);

	adaugaB = new JButton("");
	adaugaB.setFont(new Font("Arial", Font.BOLD, 15));
	adaugaB.setBounds(680, 180, 100, 30);
	adaugaB.setBackground(Color.white);
	adaugaB.setForeground(Color.black);
	panel1.add(adaugaB);

	p2 = new JLabel(":");
	p2.setFont(new Font("Arial", Font.BOLD, 18));
	p2.setBounds(10, 120, 100, 100);
	panel1.add(p2);

	text2 = new JTextField(" ", 10);
	text2.setEditable(true);
	text2.setFont(new Font("Arial", Font.BOLD, 18));
	text2.setBounds(150, 153, 470, 30);
	panel1.add(text2);

	adunare = new JButton("+");
	adunare.setFont(new Font("Arial", Font.BOLD, 70));
	adunare.setBounds(150, 230, 80, 80);
	adunare.setBackground(Color.white);
	adunare.setForeground(Color.black);
	panel1.add(adunare);

	scadere = new JButton("-");
	scadere.setFont(new Font("Arial", Font.BOLD, 70));
	scadere.setBounds(280, 230, 80, 80);
	scadere.setBackground(Color.white);
	scadere.setForeground(Color.black);
	panel1.add(scadere);

	inmultire = new JButton("*");
	inmultire.setFont(new Font("Arial", Font.BOLD, 70));
	inmultire.setBounds(410, 230, 80, 80);
	inmultire.setBackground(Color.white);
	inmultire.setForeground(Color.black);
	panel1.add(inmultire);

	derivare = new JButton("'");
	derivare.setFont(new Font("Arial", Font.BOLD, 70));
	derivare.setBounds(540, 230, 80, 80);
	derivare.setBackground(Color.white);
	derivare.setForeground(Color.black);
	panel1.add(derivare);

	rezultat1 = new JLabel("");
	rezultat1.setFont(new Font("Arial", Font.BOLD, 18));
	rezultat1.setBounds(10, 340, 100, 100);
	panel2.add(rezultat1);
	
	rezultat2 = new JLabel("");
	rezultat2.setFont(new Font("Arial", Font.BOLD, 18));
	rezultat2.setBounds(10, 390, 100, 100);
	panel2.add(rezultat2);
	
	rezultat3 = new JLabel("");
	rezultat3.setFont(new Font("Arial", Font.BOLD, 18));
	rezultat3.setBounds(10, 440, 100, 100);
	panel2.add(rezultat3);
	
	rezultat4 = new JLabel("");
	rezultat4.setFont(new Font("Arial", Font.BOLD, 18));
	rezultat4.setBounds(10, 490, 100, 100);
	panel2.add(rezultat4);

	text3 = new JTextField(" ", 10);
	text3.setEditable(true);
	text3.setFont(new Font("Arial", Font.BOLD, 18));
	text3.setBounds(150, 370, 470, 30);
	panel2.add(text3);

	text4 = new JTextField(" ", 10);
	text4.setEditable(true);
	text4.setFont(new Font("Arial", Font.BOLD, 18));
	text4.setBounds(150, 420, 470, 30);
	panel2.add(text4);
	
	text5 = new JTextField(" ", 10);
	text5.setEditable(true);
	text5.setFont(new Font("Arial", Font.BOLD, 18));
	text5.setBounds(150, 470, 470, 30);
	panel2.add(text5);
	
	text6 = new JTextField(" ", 10);
	text6.setEditable(true);
	text6.setFont(new Font("Arial", Font.BOLD, 18));
	text6.setBounds(150, 520, 470, 30);
	panel2.add(text6);
}

public void addAdListener(ActionListener listener) {
	addActionListener(listener);
}

public void addScadListener(ActionListener listener) {
	addActionListener(listener);
}

public void addInmultListener(ActionListener listener) {
	addActionListener(listener);
}

public void addDerivListener(ActionListener listener) {
	addActionListener(listener);
}

public void addClearListener(ActionListener listener) {
	addActionListener(listener);
}

public void addAdaugaAListener(ActionListener listener) {
	adaugaA.addActionListener(listener);
}

public void addAdaugaBListener(ActionListener listener) {
	adaugaB.addActionListener(listener);
}

public void setText1(String rezultat) {
	text1.setText(rezultat);
}

public void setText2(String rezultat) {
	text2.setText(rezultat);
}

public void setText3(String rezultat) {
	text3.setText(rezultat);
}
public void setText4(String rezultat) {
	text4.setText(rezultat);
}
public void setText5(String rezultat) {
	text5.setText(rezultat);
}
public void setText6(String rezultat) {
	text6.setText(rezultat);

	private JPanel panel2;
	nameLbl = new JLabel("Name:");
	nameLbl.setBounds(20, 20, 150, 20);
	nameLbl.setForeground(new Color(96, 114, 166));
	panel.add(nameLbl);

	nameTF = new JTextField();
	nameTF.setBounds(180, 20, 150, 20);
	panel.add(nameTF);

	emailLbl = new JLabel("E-mail:");
	emailLbl.setBounds(20, 50, 150, 20);
	emailLbl.setForeground(new Color(96, 114, 166));
	panel.add(emailLbl);

	emailTF = new JTextField();
	emailTF.setBounds(180, 50, 150, 20);
	panel.add(emailTF);
	roductFrame = new JFrame();
		productFrame.setSize(210, 300);
		JPanel productPanel = new JPanel();
		productPanel.add(new JLabel("Product name :"));
		JTextField productText=new JTextField("",15);
		productPanel.add(productText);
		productPanel.add(new JLabel("Quantity :"));
		JTextField quantityText=new JTextField("",15);
		productPanel.add(quantityText);
		JButton addProduct=new JButton();
		

}
