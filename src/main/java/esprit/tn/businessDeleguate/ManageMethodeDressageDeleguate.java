package esprit.tn.businessDeleguate;

import java.util.List;



import entities.MethodeDressage;
import esprit.tn.serviceLocator.ServiceLocator;
import services.IMethodeDressageService;

public class ManageMethodeDressageDeleguate {

	private static String jndiName ="/dogs_application/MethodeDressageService!services.IMethodeDressageService";

	public static IMethodeDressageService getInstance(){
		return (IMethodeDressageService) ServiceLocator.getInstance().getRemoteProxy(jndiName);
	}
	
	public void addMethodeDressage(MethodeDressage m) {
		getInstance().addMethodeDressage(m);
		
	}


	public void deleteMethodeDressage(MethodeDressage m) {
		getInstance().deleteMethodeDressage(m);
	}


	public void updateMethodeDressage(MethodeDressage m) {
		getInstance().updateMethodeDressage(m);
		
	}


	public List<MethodeDressage> getAllMethodeDressage() {
		return getInstance().getAllMethodeDressage();
	}

	
}
