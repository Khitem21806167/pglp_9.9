package cmd;

import java.sql.Connection;
import java.sql.DriverManager;

import dao.TriangleDAO;
import graphique.formes.Carre;
import graphique.formes.Triangle;

public class CreateTriangleCommand implements Command {
	private Triangle triangle;
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
				TriangleDAO tr = new TriangleDAO();
				tr.connect=co;
				Triangle car=new Triangle();
				if(tr.find(triangle.getId())==null)
					tr.create(triangle);
				else System.out.println("Forme deja existe");
				
			}
	}
	public Triangle getTriangle() {
		return triangle;
	}
	public void setTriangle(Triangle triangle) {
		this.triangle = triangle;
	}

}
