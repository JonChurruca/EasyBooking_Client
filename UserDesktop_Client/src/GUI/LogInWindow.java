package GUI;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.*;

import controller.Controller;
import server.datanucleous.FlightDTO; 

public class LogInWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	private Controller controller;
	JButton bConfirmar, bSearch, bBook;
	JLabel lEmail, lPassword,lLogin, lArrivalAirp, lDepAirport, lDepDate, lnumSeats, lFlightID, lInfoFLights; 
	JTextField tfEmail, tfArrivalAirp, tfDepAirport,tfDepDate, tfnumSeats, tfFlightID ; 
	JTextField jpPassword; 

	//private static JDialog v;

	

	public LogInWindow(Controller controller) {
		this.controller = controller;
		setSize(600,400);
		setLocation(100, 200);
		setTitle("LOG IN");
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );



		JPanel pSuperior = new JPanel();
		getContentPane().add(pSuperior, BorderLayout.NORTH);
		lLogin = new JLabel("LOG IN");
		lLogin.setFont(new java.awt.Font("Tahoma", 1, 18));
		pSuperior.add(lLogin);
		

		

		JPanel pCentral = new JPanel(); 

		getContentPane().add(pCentral, BorderLayout.NORTH);
		pCentral.setLayout(new BoxLayout(pCentral, WIDTH));

		
		lEmail = new JLabel("Email :"); 
		lPassword = new JLabel("Password :");

		tfEmail = new JTextField(10); 
		jpPassword = new JPasswordField(10);
		bConfirmar = new JButton("Login"); 
		

		pCentral.add(lEmail);
		pCentral.add(tfEmail);

		pCentral.add(lPassword);
		pCentral.add(jpPassword); 
		
		
		pCentral.add(bConfirmar);
		
		pCentral.add(Box.createRigidArea(new Dimension(5,0)));
		


		// Action Events para los botones 

		bConfirmar.addActionListener((ActionEvent e) -> {Login();});
	
		this.setVisible(true);
	}

	private void Login() {
		//controller.sfw.setVisible(true);
		boolean validation = controller.validateUser(tfEmail.getText().toLowerCase(), jpPassword.getText()); 
		//System.out.println("False");
		
		if (validation == true) {
			
			// if it returns true let me enter the window  
			// else do nothing (show validation error)
			//controller.sfw.setVisible(true);
			JOptionPane.showMessageDialog(new JOptionPane(), "User registred");
			//controller.lw.repaint();
			
			JPanel pSearch = new JPanel(); 
			getContentPane().add(pSearch, BorderLayout.CENTER);
			pSearch.setLayout(new BoxLayout(pSearch, WIDTH));

			lArrivalAirp = new JLabel("Arrival Airp :"); 
			lDepAirport = new JLabel("Dep Airport :");
			lDepDate = new JLabel("Dep Date :");

			tfArrivalAirp = new JTextField(10); 
			tfDepAirport = new JTextField(10);
			tfDepDate = new JTextField(10); 
			
			pSearch.add(lArrivalAirp);
			pSearch.add(tfArrivalAirp);
			
			pSearch.add(lDepAirport);
			pSearch.add(tfDepAirport);
			
			pSearch.add(lDepDate);
			pSearch.add(tfDepDate);
	 	
			//bConfirmar.setBackground(Color.cyan);
			bSearch = new JButton("Search FLight"); 
		
			pSearch.add(bSearch); 
			

			
			bSearch.addActionListener((ActionEvent e) -> {SearchFlights();} );
			
			
		
		}else {
			
			JOptionPane.showMessageDialog(new JOptionPane(), "User not registred");
			controller.lw.repaint();

		}
			
	}


	private void SearchFlights() {
		
		
		
		List<FlightDTO> flights = new ArrayList<>();  
		flights = (controller.getFlights(tfDepAirport.getText(), tfArrivalAirp.getText(), tfDepDate.getText()));
	

		//lInfoFLights.setText("");
		
		JPanel pInfoCompra = new JPanel(); 
		pInfoCompra.setBackground(Color.white);
		getContentPane().add(pInfoCompra, BorderLayout.SOUTH); 
		
		
		for (FlightDTO fDTO : flights) {
			
			FlightDTO f = (FlightDTO) flights.get(0); 
			
			lInfoFLights = new JLabel(f.getFlightID() + "-"+ f.getAirline() +"\n"); 
			
		}
	
	
		
		lFlightID = new JLabel("FlightID:"); 
		lnumSeats = new JLabel("NumSeats:");
		
		tfFlightID = new JTextField(10); 
		tfnumSeats = new JTextField(10);
		
		pInfoCompra.add(lInfoFLights); 
		
		pInfoCompra.add(Box.createRigidArea(new Dimension(5,0)));
		
		pInfoCompra.add(lFlightID); 
		
		pInfoCompra.add(lFlightID);
		pInfoCompra.add(tfFlightID);
		
		pInfoCompra.add(lnumSeats);
		pInfoCompra.add(tfnumSeats);
		
		bBook = new JButton("Book"); 
	
		pInfoCompra.add(bBook); 
		
		bBook.addActionListener((ActionEvent e) -> {Book();} );

		
		
		
		
		
	}
	
	private void Book() {
		
		int flightID = Integer.parseInt(tfFlightID.getText()); 
		int numSeats = Integer.parseInt(tfnumSeats.getText()); 
		
		controller.makeReservation(flightID, numSeats, tfEmail.getText());
		
	
		
	}
	
	





}