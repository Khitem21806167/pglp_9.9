package cmd;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

import dao.CarreDAO;
import dao.CercleDAO;
import dao.TriangleDAO;
import dao.RectangleDAO;
import graphique.formes.Carre;
import graphique.formes.Cercle;
import graphique.formes.Graphic;
import graphique.formes.GroupeForme;
import graphique.formes.Rectangle;
import graphique.formes.Triangle;

public class DrawingTUI {
	
	
	static String nom="",type="";
	static //fonction stop()
	//fonction start()
	
	int abscisse;
	static int ordonnee;
	static double rayon;
	static double hauteur;
	static double base;
	static double largeur;
	static double longueur;
	
	static CreateCercleCommand commandcercle = new CreateCercleCommand();
	static CreateCarreCommand commandcarre = new CreateCarreCommand();
	static CreateTriangleCommand commandtriangle = new CreateTriangleCommand();
	static CreateRectangleCommand commandrectangle = new CreateRectangleCommand();
	static CommandMove commandmove=new CommandMove();
	static CreateEnsembleCommand commandensemble=new CreateEnsembleCommand();
	
	
	
	
	
	public static boolean checkType(String type) {
		
		boolean a=false;
		
		if(type.equalsIgnoreCase("Cercle")  || type.equalsIgnoreCase("Carre") || type.equalsIgnoreCase("Triangle")|| type.equalsIgnoreCase("Rectangle") || type.equalsIgnoreCase("GroupeForme")  )
		{
			 a=true;
		}
		else
		{
			a=false;
		}
		return a;
		
	}
	public static void NextCommand(String line) {
		int a=0;
		if(!line.contains("move")) {
		if(!line.contains("=") || !line.contains("(") || !line.contains(")"))
		{
			System.out.println("Chaine erronée !");
		}
		else 
		{
		for(int i=0;i<line.length();i++)
		{
			if(line.charAt(i)=='=')
			{
				a=i;
				i=line.length();
			}
			else 
			{
				nom+=line.charAt(i);
				
			}
		}
		
		for (int i=a+1; i<line.length();i++) 
		{
			if(line.charAt(i)=='(')
			{
				a=i;
				i=line.length();
			}
			else 
			{
				type+=line.charAt(i);
				
			}
		}
		
		boolean c=checkType(type);
		if(c==false)
		{
			System.out.println("Type inconnu");
		}
		
		if(type.equalsIgnoreCase("GroupeForme"))
		{
			String idensemble = "";
			
			Vector <String> vecteurdeforme = new Vector<String>() ;
			
			
			if(!(line.charAt(a)=='('))
			{
				System.out.println("Chaine erronée, Veuillez respecter la forme indiquée");
			}
			else {
				a++;
				
				do {
					idensemble+=line.charAt(a);
					a++;
				}while((line.charAt(a)!=','));
				a++;
				String s="";
				do{
					
					s+=line.charAt(a);
					a++;
					if(line.charAt(a)==',')
					{
						vecteurdeforme.addElement(s);
						s="";
						a++;
					}
					
				}while(line.charAt(a)!=')');
				vecteurdeforme.addElement(s);
				
			}
			//Hna diri commandGroupeForme
			GroupeForme g=new GroupeForme();
			g.setIdEnsemble(idensemble);
			g.setIdFormes(vecteurdeforme);
			commandensemble.setGf(g);
			commandensemble.execute();
		}
		
		else {
			
		if(!(line.charAt(a+1)=='('))
		{
			System.out.println("Chaine erroné, Veuillez respectez la forme indiquée");
		}
		
		a+=2;
		String aa="";
		do {
			aa+=Character.toString(line.charAt(a));
			a++;
		}while(line.charAt(a) !=',');
		
		
		 try {
		       abscisse = Integer.parseInt(aa);
		      
		    } catch (NumberFormatException nfe) {
		       System.out.println("C'est pas un nbr centre1");
		    }
		 if(!(line.charAt(a)==','))
			{
			
				System.out.println("virgule manquante");
			}
		 a+=1;
		 String bb="";
		 do {
				bb+=Character.toString(line.charAt(a));
				a++;
			}while(line.charAt(a) !=')');


		 try {
			 ordonnee=Integer.parseInt(bb);
		    } catch (NumberFormatException nfe) {
		       System.out.println("C'est pas un nbr centre2  ");
		    }
		
		 if(!(line.charAt(a)==')'))
			{
				System.out.println("parenthèse fermante manquante");
			}
		 if(!(line.charAt(a+1)==','))
			{
				System.out.println("virgule manquante");
			}
		
		
		}
		if(type.equalsIgnoreCase("cercle") || type.equalsIgnoreCase("carre") ) 
		{
			a+=2;
			String cc="";//Character.toString(line.charAt(a+2));
			do {
				cc+=Character.toString(line.charAt(a));
				a++;
			}while(line.charAt(a) !=')');
		
		
		
			 try {
			        rayon = Double.parseDouble(cc);
			    } catch (NumberFormatException nfe) {
			    	if(type.equalsIgnoreCase("cercle")) 
					       System.out.println("C'est pas un nbr rayon");
					    	else if (type.equalsIgnoreCase("carre"))
							       System.out.println("C'est pas un nbr cote ");
			    }
			 if(!(line.charAt(a)==')'))
				{
					System.out.println("parenthèse fermante");
				}
			 else {
				 System.out.println("fin de la saisie!");
					if(type.equalsIgnoreCase("cercle"))
					{
												
						Cercle cercle=new Cercle();
						cercle.setId(nom);
						cercle.setAbscisse(abscisse);
						cercle.setOrdonnee(ordonnee);
						cercle.setRayon(rayon);
						commandcercle.setCercle(cercle);
						commandcercle.execute();
						nom="";
						type="";
					
						
					}
					else if(type.equalsIgnoreCase("carre")) 
					{
						Carre carre=new Carre();
						carre.setId(nom);
						carre.setAbscisse(abscisse);
						carre.setOrdonnee(ordonnee);
						carre.setLongueur(rayon);
						commandcarre.setCarre(carre);
						commandcarre.execute();
						nom="";
						type="";
					}
			 }
					
		}
		
		
		else if(type.equalsIgnoreCase("triangle")||type.equalsIgnoreCase("rectangle")) {
		if(!(line.charAt(a+1)==','))
		{
			System.out.println("vergule manquante");
		}
		
		else {
			a+=2;
			String cc="";
			do {
				cc+=line.charAt(a);
				a++;
				
			}while(line.charAt(a)!=',');
			
		
			
			 try {
			        base = Double.parseDouble(cc);
			    } catch (NumberFormatException nfe) {
			    	if(type.equalsIgnoreCase("triangle")) 
			       System.out.println("C'est pas un nbr Base");
			    	else if (type.equalsIgnoreCase("rectangle"))
					       System.out.println("C'est pas un nbr largeur ");
			    				    }
		}
			 if(!(line.charAt(a)==','))
				{
					System.out.println("virgule fermante");
				}
			 a+=1;

			 
			 String dd="";
			 do {
				 dd+=line.charAt(a);
				 a++;
			 }while(line.charAt(a)!=')');
			 try {
			       hauteur = Double.parseDouble(dd);
			    } catch (NumberFormatException nfe) {
			       System.out.println("C'est pas un nbr CotéLong ou longeur");
			    }
			 if(!(line.charAt(a)==')'))
				{
					System.out.println("parhenthèse fermante");
				}else {
					System.out.println("fin de la saisie! ");
					
					if(type.equalsIgnoreCase("triangle"))
					{
												
						Triangle t=new Triangle();
						t.setId(nom);
						t.setAbscisse(abscisse);
						t.setBase(base);
						t.setHauteur(hauteur);
						t.setOrdonnee(ordonnee);
						commandtriangle.setTriangle(t);
						commandtriangle.execute();
						nom="";
						type="";
						 
						
					}
					else if(type.equalsIgnoreCase("Rectangle")) 
					{
						Rectangle r=new Rectangle();
						r.setId(nom);
						r.setAbscisse(abscisse);
						r.setOrdonnee(ordonnee);
						r.setLongueur(hauteur);
						r.setLargeur(base);
						commandrectangle.setRectangle(r);
						commandrectangle.execute();
						nom="";
						type="";
						
					}
					
					
					
				}
							 
		}			
		
		}
	}
	else
	{
		
		System.out.println("move sequence");
		
		if(!line.contains(",") || !line.contains("(") || !line.contains(")"))
		{
		
			System.out.println("Chaine erronée !");
		}
		else 
		{
			String ops="";
			do {
				ops+=line.charAt(a);
				a++;
			}while(line.charAt(a)!='(');
			if(!ops.equalsIgnoreCase("move"))
			{
				System.out.println("Opération est move(Nom,(abscisse,ordonnee)), vous avez saisie: "+ops )  ;
				
			}else
			{
				if(line.charAt(a)!='(')
				{
					System.out.println("paranthèse aprés move");
				}
				else
				{
					a+=1;
					String id="";
					do
					{
						id+=line.charAt(a);
						a++;
					}while(line.charAt(a)!=',');
					
				a+=1;
				if(line.charAt(a)!='(') {
					String par="";
					do
					{
						par+=line.charAt(a);
						a++;
					}while(line.charAt(a)!='(');
					if(!par.equals("(")) System.out.println("respectez la syntaxe");
				}
				else
				{
					a+=1;
					String x="";
					do {
						x+=line.charAt(a);
						a++;
					}while(line.charAt(a)!=',');
					try {
						 abscisse = Integer.parseInt(x);
					    } catch (NumberFormatException nfe) {
					       System.out.println("C'est pas un nbr ou un entier");
					    }
					a+=1;
					String y="";
					do {
						y+=line.charAt(a);
						a++;
					}while(line.charAt(a)!=')');
					try {
						 ordonnee = Integer.parseInt(y);
					    } catch (NumberFormatException nfe) {
					    	System.out.println(y);
					       System.out.println("C'est pas un nbr ou un entier");
					    }
					
					if(line.charAt(a+1)!=')') System.out.println("veuillez respecter la syntaxe (pas de blanc)");
					else {
						System.out.println("fin de la saisie");
						commandmove.setId(id);
						commandmove.setX(abscisse);
						commandmove.setY(ordonnee);
						commandmove.execute();
					}
					
					
				}
				
				
				}
		
			}
		}
	
	
	}
		
	
		
		}
	
	static public int run()
	{
		int x=0;
		do
		{
			System.out.println("BIENVENU SUR NOTRE LOGICIEL DU DESSIN \n");
			System.out.println("Tapez 1 pour crée une forme : la sysntaxe est: nom de la forme= forme souhaitée (centre, rayon/hauteur/largeur...)\n");
			System.out.println("Pour un cercle: c1=Cercle((0,0),10) \n "
								+ "Pour un Carre: c2=Carre((12,10),14) \n"
								+ "Pour un Rectangle: r1=Rectangle((10,12),14,12) \n"
								+ "Pour un Triangle: t2=Triangle((12,10),14,18) \n");
			System.out.println("Tapez 2 pour deplacer une forme: la sysntaxe est: move(NOM DE LA FORME (entier,entier))\n");
			System.out.println("Tapez 3 pour crée un Groupe: la sysntaxe est: groupe1=GroupeForme(idGroupe,IdForme,IdForme,IdForme....)"
					+ "NOTEZ BIEN/ LA FORME DOIT ETRE DEJA EXISTEE (CREE) \n");
			System.out.println("Tapez 4 pour quitter le programme");
			Scanner s=new Scanner(System.in);
			x=s.nextInt();
			switch(x)
			{
			case 1:{
				String ss="";
				do {
					System.out.println("Entrer la syntaxe");
				Scanner s1=new Scanner(System.in);
				 ss=s1.nextLine();
				// System.out.println(ss);
				}while(ss.equals(""));
				System.out.println(ss);
				NextCommand(ss);
				run();
			}break;
			
			case 2:{
				String ss="";
				do {
					System.out.println("Entrer la syntaxe");
				Scanner s1=new Scanner(System.in);
				 ss=s1.nextLine();
				// System.out.println(ss);
				}while(ss.equals(""));
				System.out.println(ss);
				NextCommand(ss);
				run();
			}break;
			
			case 3:{
				String ss="";
				do {
					System.out.println("Entrer la syntaxe");
				Scanner s1=new Scanner(System.in);
				 ss=s1.nextLine();
				// System.out.println(ss);
				}while(ss.equals(""));
				System.out.println(ss);
				NextCommand(ss);
				run();
			}break;
			
			case 4:{
				System.out.println("VOUS AVEZ QUITTE LE PROGRAMME!");
				System.exit(0);} break;
			}
		}while(x!=4);
		return x;
	}

}
