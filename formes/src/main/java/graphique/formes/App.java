package graphique.formes;

/**
 * Hello world!
 * execution : mvn package exec:java
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	GroupeForme g = new GroupeForme();
    	Cercle c = new Cercle("cercle",15,10,11);
    	Cercle c1 = new Cercle("cercle1",15,10,11);
    	g.addForme(c);
    	g.addForme(c1);
        g.print();
    }
}
