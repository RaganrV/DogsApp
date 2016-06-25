package dogs_application_client;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Veterinaire;
import services.IVeterinaireService;

public class TestOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		IVeterinaireService vetServ;
		
		try {
			Context docContext=new InitialContext();
			vetServ=(IVeterinaireService)docContext.lookup("/dogs_application/VeterinaireService!services.IVeterinaireService");
			Veterinaire vet= new Veterinaire();
			//vet.setNom("kacem");
			//vet.setPrenom("2pac");
			vetServ.getAllVeterinaire();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
