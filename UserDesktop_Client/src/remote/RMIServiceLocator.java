package remote;

import java.util.HashMap;



public class RMIServiceLocator {

	
	private IReservationManager service;
	public HashMap<String, IReservationManager> serviceMap = new HashMap<String, IReservationManager>();


	/** Creates a new instance of RMIServiceLocator */
	public RMIServiceLocator(){ 

	}

	public void setService(String ip, String port, String serviceName) {    
		 
		if(serviceMap.containsKey(serviceName)) {
			service = serviceMap.get(serviceName); 

		}else {
			try {
				String name = "//" + ip + ":" + port + "/" + serviceName;
				
				serviceMap.put(serviceName, (IReservationmanager)java.rmi.Naming.lookup(name)); 
				service = serviceMap.get(serviceName); 

			} catch (Exception e) {
				System.err.println("- Exception running the client: " + e.getMessage());
			}
		}

	}

	public IReservationManager getService() {    

		return service;
	}




}
