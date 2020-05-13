package graphique.formes;

public abstract class Forme implements Graphic{
	
	private String id;
	private int abscisse, ordonnee;
	
	public Forme() {
		this("", 0, 0);
	}
	
	public Forme(String id, int abscisse, int ordonnee) {
		this.id = id;
		this.abscisse = abscisse;
		this.ordonnee = ordonnee;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAbscisse() {
		return abscisse;
	}

	public void setAbscisse(int abscisse) {
		this.abscisse = abscisse;
	}

	public int getOrdonnee() {
		return ordonnee;
	}

	public void setOrdonnee(int ordonnee) {
		this.ordonnee = ordonnee;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move(int dx, int dy) {
		// TODO Auto-generated method stub
		setAbscisse(getAbscisse() + dx);
		setOrdonnee(getOrdonnee() + dy);
		
	}


}
