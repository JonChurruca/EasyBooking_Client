package controller;


import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import GUI.LogInWindow;
import GUI.RegisterWindow;
import GUI.SearchFlightWindow;
import remote.RMIServiceLocator;

public class Controller {
	@SuppressWarnings("unused")
	private RMIServiceLocator rsl;
	public RegisterWindow rw; 
	public SearchFlightWindow sfw; 
	
	public Controller(String[] args) throws RemoteException {


		rsl = new RMIServiceLocator(); 
		rsl.setService(args[0], args[1], args[2]);

		new LogInWindow(this);
		
		rw = new RegisterWindow(this); 
		rw.setVisible(false);
		
		sfw = new SearchFlightWindow(this); 
		sfw.setVisible(true);
		
		

	}

	public boolean validateUser(String email, String password){
		try{


			boolean validation = (rsl.getService()).validateUser(email, password);

			return validation; 

		} catch(Exception e){
			System.out.println("$ Error: " + e.getMessage());
		}
		return false; 
	}

	public void registerUser(String email, String password, String CardNumber, String DefaultAirport, String AuthorizationService) {
		try{


			(rsl.getService()).registerUser(email,  password,  CardNumber,  DefaultAirport, AuthorizationService);



		} catch(Exception e){
			System.out.println("$ Error: " + e.getMessage());

		}

	}
	
	public List<Integer> getFlights(String depAirport, String arrivalAirport, String depDate) {
		
		List<Integer> flights = new ArrayList<>();
		
		try {
			flights = (rsl.getService()).getFlights(depAirport, arrivalAirport, depDate); 
		}catch(Exception e) {
			System.out.println("$ Error: " + e.getMessage());
		}
		
	
		return flights;
	}
	
	/*
	public List<FlightDTO> getFlights(String depAirport, String arrivalAirport, String depDate) {
		
		List<FlightDTO> flights = new ArrayList<>();
		
		try {
			flights = (rsl.getService()).getFlights(depAirport, arrivalAirport, depDate); 
		}catch(Exception e) {
			System.out.println("$ Error: " + e.getMessage());
		}
		
	
		return flights;
	}
	*/
	public void makeReservation(Integer flightID, Integer numSeats, String userEmail) {
		try{

			(rsl.getService()).makeReservation(flightID,  numSeats,  userEmail);


		} catch(Exception e){
			System.out.println("$ Error: " + e.getMessage());

		}
		
	}
	
	
}

