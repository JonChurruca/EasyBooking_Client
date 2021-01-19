package GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.Controller;



public class RegisterWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private Controller controller; 
	JButton  bRegister, bAtras;
	JLabel lEmail, lPassword,  lDefaultAirport, lCardNumber, lAuthorizationSystem; 
	JTextField tfEmail, tfPassword, tfDefaultAirport, tfCardNumber, tfAuthorizationSystem; 

	long cardNumber;


	public RegisterWindow(Controller controller) {
		this.controller = controller; 

		setSize(600,400);
		setLocation(700, 200);

		setTitle("Registro");
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );


		JPanel pSuperior = new JPanel();
		getContentPane().add(pSuperior, BorderLayout.NORTH);
	


		JPanel pCentral = new JPanel(); 


		getContentPane().add(pCentral, BorderLayout.CENTER);
		pCentral.setLayout(new BoxLayout(pCentral, WIDTH));

		
		lEmail = new JLabel("Email :"); 
		lPassword = new JLabel("Password :");
		
		lDefaultAirport = new JLabel("DefaultAirport: "); 
		lCardNumber = new JLabel("Card number: "); 

		lAuthorizationSystem = new JLabel("Authorization system: "); 
		

		tfEmail = new JTextField(20); 
		tfPassword = new JTextField(10); 
	
		tfCardNumber = new JTextField(15);
		tfDefaultAirport = new JTextField(10);
		tfAuthorizationSystem = new JTextField(30); 
		


		pCentral.add(lEmail);
		pCentral.add(tfEmail);

		pCentral.add(lPassword);
		pCentral.add(tfPassword); 

		pCentral.add(lCardNumber); 
		pCentral.add(tfCardNumber);

		pCentral.add(lDefaultAirport); 
		pCentral.add(tfDefaultAirport);
		
		pCentral.add(lAuthorizationSystem); 
		pCentral.add(tfAuthorizationSystem); 

		JPanel pBotonera = new JPanel(); 
		getContentPane().add(pBotonera, BorderLayout.SOUTH);


		bRegister = new JButton("Registrar"); 
		bAtras = new JButton("Atras");

		pBotonera.add(bAtras); 

		pBotonera.add(bRegister); 


		// Action Events 

	

		bRegister.addActionListener((ActionEvent e) -> {Registrar();} ); 
		setVisible(true);
	}




	public void Registrar() {
		controller.registerUser(tfEmail.getText().toLowerCase(), tfPassword.getText(), tfCardNumber.getText(), tfDefaultAirport.getText(), tfAuthorizationSystem.getText());
		
		/*
		Thread t1 = new Thread() {
			public void run() {
				setVisible(false);
				//SearchFlight.main(null); 
				controller.sfw.setVisible(true);
	
				dispose();
			}				
		}; 
		t1.start();
	
		*/

	}
	



}


