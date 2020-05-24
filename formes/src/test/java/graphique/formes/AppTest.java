package graphique.formes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import dao.CarreDAO;

/**
 * Unit test for simple App.
 */
public class AppTest 
{//creatin d un cercle
   @Test 
   public void creationCercle(){
	   Carre cr=new Carre();
			cr.setAbscisse(4);
			cr.setOrdonnee(5);
			cr.setLongueur(12);	
			String d= cr.afficher();
			
			  assertEquals("Carre(coin=(4, 5), longueur=12.0)\n", d);
			  
			  cr.move(7, 7);
			  String t=cr.afficher();
			  System.out.println("here"+t);
   }
   
   //creation d'un triangle
   @Test 
   public void creationTriangle(){
	   Triangle tr=new Triangle();
		tr.setAbscisse(15);
		tr.setOrdonnee(18);
		tr.setHauteur(10);
		tr.setBase(7);
			String d= tr.afficher();
			  assertEquals("Triangle(coin=(15, 18), hauteur=10.0, base=7.0)\n", d);
			  
   }
   
   @Test 
   public void creationEnsemble(){
	  //creation des fomrs a ajoutés nuls
	   Carre cr=new Carre();
	    cr.setAbscisse(41);
		cr.setOrdonnee(7);
		cr.setLongueur(12);	
		
	   Triangle tr=new Triangle();
	   	tr.setAbscisse(5);
		tr.setOrdonnee(1);
		tr.setHauteur(1);
		tr.setBase(7);
		
	   Triangle tr2=new Triangle();
	   	tr2.setAbscisse(5);
		tr2.setOrdonnee(8);
		tr2.setHauteur(40);
		tr2.setBase(7);
	   
	   //creation de l 'ensemble
   GroupeForme gf = new GroupeForme();
	ArrayList<Graphic> listeg = new ArrayList<Graphic>();
	listeg.add(cr);
	listeg.add(tr);
	listeg.add(tr2);
	gf.setChildren(listeg);
	String f = gf.afficher();
	assertEquals("Carre(coin=(41, 7), longueur=12.0)\n" + 
			"Triangle(coin=(5, 1), hauteur=1.0, base=7.0)\n"
			+ "Triangle(coin=(5, 8), hauteur=40.0, base=7.0)\n", f);
	
	//TEST D UN DEPLACEMENT D UN ENSEMBLE 
	gf.move(8,7);
	String ff = gf.afficher();
	assertEquals("Carre(coin=(49, 14), longueur=12.0)\n" + 
			"Triangle(coin=(13, 8), hauteur=1.0, base=7.0)\n"
			+ "Triangle(coin=(13, 15), hauteur=40.0, base=7.0)\n", ff);
	
   }
   		
   
    
}
