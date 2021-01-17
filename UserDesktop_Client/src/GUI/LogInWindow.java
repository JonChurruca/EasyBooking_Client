package GUI;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

import javax.swing.*;

import controller.Controller;



public class LogInWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	private Controller controller;
	JButton bConfirmar, bRegistrar;
	JLabel lEmail, lPassword,lLogin; 
	JTextField tfEmail; 
	JTextField jpPassword; 
	//private static JDialog v;


	public LogInWindow(Controller controller) {
		this.controller = controller;
		setSize(600,400);
		setLocation(300, 200);
		setTitle("LOG IN");
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );



		JPanel pSuperior = new JPanel();
		getContentPane().add(pSuperior, BorderLayout.NORTH);
		lLogin = new JLabel("LOG IN");
		lLogin.setFont(new java.awt.Font("Tahoma", 1, 18));
		pSuperior.add(lLogin);


		JPanel pInfoCompra = new JPanel(); 


		pInfoCompra.setBackground(Color.white);
		getContentPane().add(pInfoCompra, BorderLayout.NORTH);

		JPanel pCentral = new JPanel(); 

		getContentPane().add(pCentral, BorderLayout.CENTER);


		lEmail = new JLabel("Email :"); 
		lPassword = new JLabel("Password :");

		tfEmail = new JTextField(10); 
		jpPassword = new JPasswordField(10);


		pCentral.add(lEmail);
		pCentral.add(tfEmail);

		pCentral.add(lPassword);
		pCentral.add(jpPassword); 


		JPanel pBotonera = new JPanel(); 
		getContentPane().add(pBotonera, BorderLayout.SOUTH);

		bConfirmar = new JButton("Confirm"); 

		//bConfirmar.setBackground(Color.cyan);
		bRegistrar = new JButton("Register"); 



		pBotonera.add(bConfirmar); 
		pBotonera.add(bRegistrar); 


		// Action Events para los botones 

		bConfirmar.addActionListener((ActionEvent e) -> {SearchFlight();});
		bRegistrar.addActionListener((ActionEvent e) -> {Regsiter();} );

	}

	private void SearchFlight() {
		boolean validation = controller.validateUser(tfEmail.getText().toLowerCase(), jpPassword.getText()); 
		if (validation == true) {
			// if it returns true let me enter the window  
			// else do nothing (show validation error)
			Thread t1 = new Thread() {
				public void run() {
					//LogIn.guardaConfig();

					setVisible(false);
					controller.sfw.getUser(tfEmail.getText().toLowerCase()); 
					controller.sfw.setVisible(true);
					//SearchFlight.main(null); 

					dispose();
				}				
			}; 
			t1.start();
		}else {

		}

	}


	private void Regsiter() {

		Thread t2 = new Thread() {
			public void run() {

				setVisible(false);
				controller.rw.setVisible(true);

				dispose();
			}				
		}; 
		t2.start();
	}





}