package cmd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Vector;

import dao.GroupeFormeDAO;
import dao.RectangleDAO;
import graphique.formes.GroupeForme;
import graphique.formes.Rectangle;

public class CreateEnsembleCommand implements Command {
	
	private GroupeForme gf;
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
				GroupeFormeDAO re = new GroupeFormeDAO();
			re.connect=co;
			GroupeForme car=new GroupeForme();
			car=re.find(gf.getIdEnsemble());
			if(car==null)
			{
				re.create1(gf);
			}
			else {
				System.out.println("Groupe Forme Existe");
			}
			}
				
	}
	public GroupeForme getGf() {
		return gf;
	}
	public void setGf(GroupeForme gf) {
		this.gf = gf;
	}


}

