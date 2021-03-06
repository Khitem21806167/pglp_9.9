package cmd;

import java.sql.Connection;
import java.sql.DriverManager;

import dao.CercleDAO;
import graphique.formes.Carre;
import graphique.formes.Cercle;

//enregistrement du cercle créé par l'utilisateur
public class CreateCercleCommand implements Command {

	private Cercle cercle;
	

	public Cercle getCercle() {
		return cercle;
	}

	public void setCercle(Cercle cercle) {
		this.cercle = cercle;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		Connection co=null;
		try {
	    	co = DriverManager.getConnection("jdbc:derby:myDB"); 

	    	}catch(Exception except) {
	  	            except.printStackTrace();
	 	       }
	    	
	    	
			if(co==null)
			{
				System.out.println("Not Connected to DB");
			}
			else
			{ 	
	
		CercleDAO cd=new CercleDAO();
		cd.connect=co;
		Cercle car=new Cercle();
		if(cd.find(cercle.getId())==null)
			cd.create(cercle);
		else System.out.println("Forme deja existe");
			}
	}

}
