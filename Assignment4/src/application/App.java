package application;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.KeyStore.Entry;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import model.*;
public class App extends JFrame{


	private static final long serialVersionUID = 1L;
	private JPanel panel=new JPanel();
	private	Bank bank;
	public App(){
		
		this.add(panel);

		
		this.setTitle("Bank");
		
		this.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	bank.reportGenerator();
		    }
		});	


		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createLogInPanel();
		this.setVisible(true);
	}
	
	private void createLogInPanel(){
		this.setSize(500, 500);
		
		JButton newAccount=new JButton("New Account");
		JLabel labelName=new JLabel("Name");
		
		
		logIn.addActionListener(new ActionListener() {
			
	