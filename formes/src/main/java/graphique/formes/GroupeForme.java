package graphique.formes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GroupeForme implements Graphic {
	private List<Graphic> children = new ArrayList<Graphic>(); 
	
	public void addForme(Graphic g) {
		children.add(g);
	}
	
	public void removeForme(Graphic g) {
		children.remove(g);
	}
	
	public Iterator getChildren() {
        return children.iterator();
    }

	@Override
	public void print() {
		// TODO Auto-generated method stub
		for (Iterator i = children.iterator(); i.hasNext(); ) {
            Object object = i.next();			
            Graphic forme = (Graphic)object;
            forme.print();
           }
		
	}
	

	@Override
	public void move(int dx, int dy) {
		// TODO Auto-generated method stub
		for (Iterator i = children.iterator(); i.hasNext(); ) {
            Object object = i.next();			
            Graphic forme = (Graphic)object;
            forme.move(dx, dy);
        }	
		
	}

	@Override
	public String afficher() {
		String g="";
		// TODO Auto-generated method stub
		for (Iterator i = children.iterator(); i.hasNext(); ) {
            Object object = i.next();			
            Graphic forme = (Graphic)object;
           // forme.print();
            g+=forme.afficher();
           }
		return g;
	}


}
