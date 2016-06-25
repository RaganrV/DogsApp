package esprit.tn.businessDeleguate;

import java.util.List;

import entities.Veterinaire;
import esprit.tn.serviceLocator.ServiceLocator;
import services.IVeterinaireService;

public class ManageVeterinaireDeleguate {

	private static String jndiName ="/dogs_application/VeterinaireService!services.IVeterinaireService";

	public static IVeterinaireService getInstance(){
		return (IVeterinaireService) ServiceLocator.getInstance().getRemoteProxy(jndiName);
	}
	
	public void addVeterinaire(Veterinaire v) {
		getInstance().addVeterinaire(v);
		
	}


	public void deleteVeterinaire(Veterinaire v) {
		getInstance().deleteVeterinaire(v);
	}


	public void updateVeterinaire(Veterinaire v) {
		getInstance().updateVeterinaire(v);
		
	}


	public List<Veterinaire> getAllVeterinaire() {
		return getInstance().getAllVeterinaire();
	}
}
