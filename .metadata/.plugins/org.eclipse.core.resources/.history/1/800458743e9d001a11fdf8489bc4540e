package cmd;

import java.sql.Connection;
import java.sql.DriverManager;

import dao.CarreDAO;
import dao.RectangleDAO;
import graphique.formes.Cercle;
import graphique.formes.Rectangle;

public class CreateRectangleCommand implements Command{
	private Rectangle rectangle;
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
			RectangleDAO re = new RectangleDAO();
			re.connect=co;
			Rectangle car=new Rectangle();
			if(re.find(rectangle.getId())==null)
				re.create(rectangle);
			else System.out.println("Forme deja existe");
				
			}
		
	}
	public Rectangle getRectangle() {
		return rectangle;
	}
	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}

}
