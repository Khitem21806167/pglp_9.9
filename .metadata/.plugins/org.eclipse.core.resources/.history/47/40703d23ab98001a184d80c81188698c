package graphique.formes;

public class DrawingTUI {
	
	
	static String nom="",type="";
	public static boolean checkType(String type) {
		boolean a=false;
		if(type.equalsIgnoreCase("Cercle")  || type.equalsIgnoreCase("Carre") || type.equalsIgnoreCase("Triangle")|| type.equalsIgnoreCase("Rectangle")  )
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
		if(!(line.charAt(a+1)=='('))
		{
			System.out.println("Chaine erroné, Veuillez respectez la forme indiquée");
		}
		String aa=Character.toString(line.charAt(a+2));
		 try {
		        double d = Double.parseDouble(aa);
		    } catch (NumberFormatException nfe) {
		       System.out.println("C'est pas un nbr centre1");
		    }
		 if(!(line.charAt(a+3)==','))
			{
				System.out.println("virgule manquante");
			}
		 String bb=Character.toString(line.charAt(a+4));
		 try {
		        double d = Double.parseDouble(bb);
		    } catch (NumberFormatException nfe) {
		       System.out.println("C'est pas un nbr centre2  ");
		    }
		 if(!(line.charAt(a+5)==')'))
			{
				System.out.println("parenthèse fermante manquante");
			}
		 if(!(line.charAt(a+6)==','))
			{
				System.out.println("virgule manquante");
			}
		if(type.equalsIgnoreCase("cercle") || type.equalsIgnoreCase("carre") ) {
			String cc=Character.toString(line.charAt(a+7));
			 try {
			        double d = Double.parseDouble(cc);
			    } catch (NumberFormatException nfe) {
			    	if(type.equalsIgnoreCase("cercle")) 
					       System.out.println("C'est pas un nbr rayon");
					    	else if (type.equalsIgnoreCase("carre"))
							       System.out.println("C'est pas un nbr cote ");
			    }
			 if(!(line.charAt(a+8)==')'))
				{
					System.out.println("parenthèse fermante");
				}else {
					System.out.println("fin de la saisie!");
				}
		} 
		else if(type.equalsIgnoreCase("triangle")||type.equalsIgnoreCase("rectangle")) {
			String cc=Character.toString(line.charAt(a+7));
			 try {
			        double d = Double.parseDouble(cc);
			    } catch (NumberFormatException nfe) {
			    	if(type.equalsIgnoreCase("triangle")) 
			       System.out.println("C'est pas un nbr Base");
			    	else if (type.equalsIgnoreCase("rectangle"))
					       System.out.println("C'est pas un nbr Coté ");

			    }
			 if(!(line.charAt(a+8)==','))
				{
					System.out.println("virgule fermante");
				}
			 
			 String dd=Character.toString(line.charAt(a+9));
			 try {
			        double d = Double.parseDouble(dd);
			    } catch (NumberFormatException nfe) {
			       System.out.println("C'est pas un nbr CotéLong ou hauteur");
			    }
			 if(!(line.charAt(a+10)==')'))
				{
					System.out.println("parhenthèse fermante");
				}else {
					System.out.println("fin de la saisie! ");
				}
								 
		}			
		
		}
	}
	
	


}
