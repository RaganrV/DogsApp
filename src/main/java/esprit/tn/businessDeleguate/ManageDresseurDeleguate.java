package esprit.tn.businessDeleguate;



import java.util.List;

import entities.Dresseur;
import esprit.tn.serviceLocator.ServiceLocator;
import services.IDresseurService;


public class ManageDresseurDeleguate {
	
	private static String jndiName ="/dogs_application/DresseurService!services.IDresseurService";

	public static IDresseurService getInstance(){
		return (IDresseurService) ServiceLocator.getInstance().getRemoteProxy(jndiName);
	}
	
	public void addDresseur(Dresseur d) {
		getInstance().addDresseur(d);
		
	}


	public void deleteDresseur(Dresseur d) {
		getInstance().deleteDresseur(d);
	}


	public void updateDresseur(Dresseur d) {
		getInstance().updateDresseur(d);
		
	}


	public List<Dresseur> getAllDresseur() {
		System.out.println(getInstance().getDresseur().get(0).getAdresse());
		return getInstance().getDresseur();
	}

}
