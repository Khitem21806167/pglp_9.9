package cmd;

import java.sql.Connection;
import java.sql.DriverManager;

import dao.CarreDAO;
import dao.CercleDAO;
import dao.RectangleDAO;
import dao.TriangleDAO;
import graphique.formes.Carre;
import graphique.formes.Cercle;
import graphique.formes.Rectangle;
import graphique.formes.Triangle;

public class CommandMove implements Command {
	static CarreDAO cd=new CarreDAO(); 
	static CercleDAO cerd = new CercleDAO();
	static TriangleDAO td=new TriangleDAO();
	static RectangleDAO rd = new RectangleDAO();
	static private String id;
	static int x,y;
	public static int getX() {
		return x;
	}
	public static void setX(int x) {
		CommandMove.x = x;
	}
	public static int getY() {
		return y;
	}
	public static void setY(int y) {
		CommandMove.y = y;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		 //traitement de move(interaction avec la bdd)
		Connection c=null;
		try {
	    	c = DriverManager.getConnection("jdbc:derby:myDB"); 

	    	}catch(Exception except) {
	  	            except.printStackTrace();
	 	       }
	    	
	    	
			if(c==null)
			{
				System.out.println("Not Connected to DB");
			}
			else
			{ 	        
	
		cd.connect=c;
		Carre r=cd.find(id);
		cerd.connect=c;
		Cercle cc=cerd.find(id);
		td.connect=c;
		Triangle t=td.find(id);
		rd.connect=c;
		Rectangle re=rd.find(id);
		if(r==null && cc==null && r==null && re==null  )
		{
			
			System.out.println("Forme nn trouvé");
		}
		else if(r!=null)
		{
			r.move(x, y);
			cd.update(id,x,y);
			System.out.println("Forme deplacé");
			
		}
		else if(cc!=null)
		{
			cc.move(x, x);
			cerd.update(id, x, y);
			System.out.println("Forme deplacé");
		}
		else if(t!=null)
		{
			t.move(x, y);
			td.update(id,x,y);
			System.out.println("Forme deplacé");
		}
		else if(re!=null)
		{
			re.move(x, y);
			rd.update(id,x,y);
			System.out.println("Forme deplacé");
		}
		
	}
	}
	public static String getId() {
		return id;
	}
	public static void setId(String id) {
		CommandMove.id = id;
	}

	
	
}
