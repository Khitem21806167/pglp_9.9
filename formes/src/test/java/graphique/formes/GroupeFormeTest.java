package graphique.formes;
import graphique.formes.*;
import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;

public class GroupeFormeTest {
	/*@Test
	public void test() {
		fail("Not yet implemented");
	}
	 */
	
	@Test
	public void GroupeformeTest() {
		GroupeForme g = new GroupeForme();
    	Cercle c = new Cercle("cercle1",15,10,11);
    	Triangle t = new Triangle("triangle1", 2, 3, 8, 19);
    	g.addForme(c);
    	g.addForme(t);
        String d=g.afficher();
       System.out.println("d="+d);
        
       assertEquals("Cercle(centre=(15, 10)), longueur=\n",d);
     
	}
	


	
}
