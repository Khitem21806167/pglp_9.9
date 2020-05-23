package graphique.formes;

public class Cercle extends Forme {
	
	private double rayon;
	
	public Cercle()
	{
		
	}
	

	public Cercle(String id, int abscisse, int ordonnee, double rayon) {
		super(id, abscisse, ordonnee);
		this.rayon = rayon;
	}

	public double getRayon() {
		return rayon;
	}

	public void setRayon(double rayon) {
		this.rayon = rayon;
	}
	
	@Override
	public void print() {
		System.out.println(this);
	}
	
	@Override
	public String toString() {
		return "Cercle(centre=("+getAbscisse()+", "+getOrdonnee()+"), rayon="+getRayon()+")";
	}

	@Override
	public String afficher() {
		// TODO Auto-generated method stub
		return "Cercle(centre=("+getAbscisse()+", "+getOrdonnee()+"), rayon="+getRayon()+")\n";
	}
	
}
