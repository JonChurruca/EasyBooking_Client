package GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Controller;


public class SearchFlightWindow  extends JFrame{

	private static final long serialVersionUID = 1L;
	private Controller controller; 
	JButton  bSearch, bBook;
	JLabel lDepAirport, lArrivalAirport, lDepDate, lSeatNum; 
	JTextField tfDepAirport, tfArrivalAirport, tfDepDate, tfSeatNum; 
	//JComboBox<FlightDTO> flightsCombo; 
	//private List<FlightDTO> flightsDTO = new ArrayList<FlightDTO>();
	
	JComboBox<Integer> flightsCombo; 
	private List<Integer> flights = new ArrayList<Integer>();
	static String userEmail; 



	public SearchFlightWindow(Controller controller) {

		setSize(600,400);
		setLocation(300, 200);

		setTitle("Registro");
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );


	
		JPanel pFirst = new JPanel(); 


		getContentPane().add(pFirst, BorderLayout.NORTH);
		pFirst.setLayout(new BoxLayout(pFirst, WIDTH));

		
		lDepAirport = new JLabel("Departure Airport :"); 
		lArrivalAirport = new JLabel("Arrival Airport  :");
		
		lDepDate = new JLabel("Departure date: "); 

		

		tfDepAirport = new JTextField(20); 
		tfArrivalAirport = new JTextField(20); 
	
		tfDepDate = new JTextField(20);
		


		pFirst.add(lDepAirport);
		pFirst.add(tfDepAirport);

		pFirst.add(lArrivalAirport);
		pFirst.add(tfArrivalAirport); 



		pFirst.add(lDepDate); 
		pFirst.add(tfDepDate);


		JPanel pBotonera = new JPanel(); 
		getContentPane().add(pBotonera, BorderLayout.CENTER);


		bSearch = new JButton("Search flights"); 


		pBotonera.add(bSearch); 
		
		JPanel pLast = new JPanel(); 
		getContentPane().add(pLast, BorderLayout.SOUTH);

		pLast.add(flightsCombo); 
		
		lSeatNum = new JLabel("Number of seats: "); 
		tfSeatNum = new JTextField(3); 
		
		pLast.add(lSeatNum);
		pLast.add(tfSeatNum); 

	
		pLast.add(bBook); 
		
		// Action Events 

		bSearch.addActionListener((ActionEvent e) -> {SearchFlights();} ); 
		bBook.addActionListener((ActionEvent e) -> {BookFlight();} );
		
		
	}

	public void SearchFlights() {
		flights = controller.getFlights(tfDepAirport.getText().toLowerCase(), tfArrivalAirport.getText().toLowerCase(),tfDepDate.getText().toLowerCase());
		for (Integer flight : flights) {
			
			flightsCombo.addItem(flight); 
			
		}
		
	

	}

	/*
	public void SearchFlights() {
		flightsDTO = controller.getFlights(tfDepAirport.getText().toLowerCase(), tfArrivalAirport.getText().toLowerCase(),tfDepDate.getText().toLowerCase());
		for (FlightDTO flight : flightsDTO) {
			
			flightsCombo.add(flight); 
			
		}
		
	

	}
	*/
	
	
	public static void getUser(String email) {
		 userEmail = email; 
	}
	
	public void BookFlight() {
		Integer flight = (Integer) flightsCombo.getSelectedItem(); 
		
		
		//Integer numSeats = Integer.parseInt(tfSeatNum); 
		
		controller.makeReservation(flight, 2, userEmail); 
	
		

	}
	/*
	public void BookFlight() {
		FlightDTO flightDTO = flightsCombo.getSelectedItem(); 
		
		Integer flightID = flightDTO.getFlightID(); 
		Integer numSeats = Integer.parseInt(tfSeatNum); 
		
		controller.makeReservation(flightID, numSeats, userEmail); 
	
		

	}
	*/



}




