package graphique.formes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import dao.*;


/**
 * Hello world!
 * @author KHAMARI Nor El Khitem - 21806167
 * MAIN
 * execution : mvn package exec:java
 * execution avec les tests unitaire : mvn clean install
 *
 */
public class App 
{
    public static void main( String[] args ) 
    {   Connection co = null;

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
			/*CREATION CERCLE*/
			Cercle c=new Cercle();
			c.setId("cercle N° 1");
			c.setAbscisse(2);
				c.setOrdonnee(5);
				c.setRayon(10);
				//c.print();
				CercleDAO cd=new CercleDAO();
				cd.connect=co;
				Cercle ce=cd.find(c.getId());
				if(ce==null) {
				cd.create(c);
				}
				else {
					System.out.println("Cercle existe");
					}
			
				
				
				/*CREATION RECTANGLE*/
				Triangle t=new Triangle();
				t.setId("triangle N° 1");
				t.setAbscisse(4);
					t.setOrdonnee(5);
					t.setHauteur(10);
					t.setBase(16);
					//t.print();
					TriangleDAO p=new TriangleDAO();
					p.connect=co;
					Triangle tr=p.find(t.getId());
					if(tr==null) {
						p.create(t);
						
						}
						else {
							
					
							System.out.println("TRIANGLE existe");
						}
					
					/*CREATION carre*/
					Carre cr=new Carre();
					cr.setId("carre N° 1");
					cr.setAbscisse(4);
						cr.setOrdonnee(5);
						cr.setLongueur(12);					
						//t.print();
						CarreDAO cp=new CarreDAO();
						cp.connect=co;
						Carre r=cp.find(cr.getId());
						if(r==null) {
							cp.create(cr);
							
							}
							else {
								
								System.out.println("CARRE existe");
							}
					
						/*CREATION ENSEMBEL*/
					GroupeForme gf = new GroupeForme();
						gf.setIdEnsemble("groupe forme N°1");
						ArrayList<Graphic> listeg = new ArrayList<Graphic>();
						listeg.add(cr);
						listeg.add(t);
						listeg.add(c);
						gf.setChildren(listeg);
						
						GroupeFormeDAO gfdao = new GroupeFormeDAO();
						gfdao.connect=co;
		
						GroupeForme b = gfdao.find(gf.getIdEnsemble());
						

						if(b==null) {
							gfdao.create(gf);
						}else {
							System.out.println(b.getIdEnsemble());//test
							System.out.println("EMSEMBLE existe");
							
						}

		}
		
    }

	
}
