package graphique.formes;

public class Rectangle extends Forme {
	
	private double longueur, largeur;
	
	public Rectangle() {
		this("", 0, 0, 0, 0);
	}

	public Rectangle(String id, int abscisse, int ordonnee, double longueur, double largeur) {
		super(id, abscisse, ordonnee);
		this.longueur = longueur;
		this.largeur = largeur;
	}


	public double getLongueur() {
		return longueur;
	}

	public void setLongueur(double longueur) {
		this.longueur = longueur;
	}

	public double getLargeur() {
		return largeur;
	}

	public void setLargeur(double largeur) {
		this.largeur = largeur;
	}

}