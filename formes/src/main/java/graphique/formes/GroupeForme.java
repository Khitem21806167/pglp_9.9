package graphique.formes;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class GroupeForme implements Graphic {
	private String idEnsemble;
	private ArrayList<Graphic> children = new ArrayList<Graphic>(); 
	private String idForme;
	private Vector <String> idFormes;
	public GroupeForme (String idEns,Vector <String> idForms)
	{
		this.idEnsemble=idEns;
		this.idFormes=idForms;
	}
	
	public Vector<String> getIdFormes() {
		return idFormes;
	}

	public void setIdFormes(Vector<String> idFormes) {
		this.idFormes = idFormes;
	}

	public GroupeForme (String idEns,String idFor)
	{
		this.idEnsemble=idEns;
		this.idForme=idFor;
	}
	
	public GroupeForme() {
		
	}
	
	public GroupeForme(String idEnsemble, Array children) {
		// TODO Auto-generated constructor stub
	
	}
	
	public void addForme(Graphic g) {
		children.add(g);
	}
	
	public void removeForme(Graphic g) {
		children.remove(g);
	}
	
	/*public Iterator getChildren() {
        return children.iterator();
    }*/
	
	public ArrayList<Graphic> getChildren() {
        return children;
    }
	
	public void setChildren(ArrayList<Graphic> children) {
		this.children = children;
	}

	public void setIdEnsemble(String IdEnsemble) {
        this.idEnsemble=IdEnsemble;
    }
	
	public String getIdEnsemble() {
        return idEnsemble;
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
	
	public void move2(int dx, int dy) {
		// TODO Auto-generated method stub
		for (int i=0; i<idFormes.size();i++) {
            Object object = idFormes.get(i);		
            Graphic forme = (Graphic)object;
            forme.move(dx, dy);
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

	public String getIdForme() {
		return idForme;
	}

	public void setIdForme(String idForme) {
		this.idForme = idForme;
	}


	


}
