package graphique.formes;

public class Triangle extends Forme {
	
	private double hauteur, base;
	

	public Triangle() {
		this("", 0, 0, 0, 0);
	}

	public Triangle(String id, int abscisse, int ordonnee, double hauteur, double base) {
		super(id, abscisse, ordonnee);
		this.hauteur = hauteur;
		this.base = base;
	}
	public double getHauteur() {
		return hauteur;
	}

	public void setHauteur(double hauteur) {
		this.hauteur = hauteur;
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}
	
	@Override
	public void print() {
		System.out.println(this);
	}
	
	@Override
	public String toString() {
		return "Triangle(coin=("+getAbscisse()+", "+getOrdonnee()+"), hauteur="+getHauteur()+", base="+getBase()+")";
	}

	@Override
	public String afficher() {
		// TODO Auto-generated method stub
		return "Triangle(coin=("+getAbscisse()+", "+getOrdonnee()+"), hauteur="+getHauteur()+", base="+getBase()+")\n";
		}



}
