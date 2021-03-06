package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import graphique.formes.Rectangle;

public class RectangleDAO extends DAO<Rectangle>{
	Statement stmt = null;
    ResultSet result = null;

	@Override
	public Rectangle create(Rectangle obj) {
		try {
			PreparedStatement prepare = connect.prepareStatement("INSERT INTO Rectangle(idRectangle, abscisse, ordonnee, longueur, largeur) VALUES(?, ?, ?, ?, ?)");
			prepare.setString(1, obj.getId());
			prepare.setInt(2, obj.getAbscisse());
			prepare.setInt(3, obj.getOrdonnee());
			prepare.setDouble(4, obj.getLongueur());
			prepare.setDouble(5, obj.getLargeur());

			int result = prepare.executeUpdate();
			assert result == 1;
			System.out.println("Rectangle ajoutée dans la BDD");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;	
	}

	@Override
	public Rectangle find(String idRectangle) {
		Rectangle obj =null;
		try {
			PreparedStatement prepare = connect.prepareStatement("SELECT * FROM Rectangle WHERE idRectangle=?");
			prepare.setString(1, idRectangle);
			ResultSet result = prepare.executeQuery();
			while(result.next()) {
				obj = new Rectangle(idRectangle, result.getInt("abscisse"), result.getInt("ordonnee"), result.getDouble("longueur"), result.getDouble("largeur"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public List<Rectangle> findAll() {
		List<Rectangle> rectangles = new ArrayList<Rectangle>();
		try {
			PreparedStatement prepare = connect.prepareStatement("SELECT * FROM Rectangle");
			ResultSet result = prepare.executeQuery();
			while(result.next()) {
				rectangles.add(new Rectangle(result.getString("idRectangle"), result.getInt("abscisse"), result.getInt("ordonnee"), result.getDouble("longueur"), result.getDouble("largeur")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rectangles;
	}

	@Override
	public Rectangle update(Rectangle obj) {
		try {
			PreparedStatement prepare = connect.prepareStatement("UPDATE Rectangle SET abscisse = ?, ordonnee = ?, longueur = ?, largeur = ? WHERE idRectangle = ?");
			prepare.setInt(1, obj.getAbscisse());
			prepare.setInt(2, obj.getOrdonnee());
			prepare.setDouble(3, obj.getLongueur());
			prepare.setDouble(4, obj.getLargeur());
			prepare.setString(5, obj.getId());
			int result = prepare.executeUpdate();
			assert result == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	//pour la maj dans la bdd apres avoir déplacer un rectangle
	public void update(String obj, int x, int y) {
		try {
			PreparedStatement prepare = connect.prepareStatement("UPDATE Rectangle SET abscisse = ?, ordonnee = ? WHERE idRectangle = ?");
			prepare.setInt(1, x);
			prepare.setInt(2,y);
			prepare.setString(3, obj);
			int result = prepare.executeUpdate();
			assert result == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

	@Override
	public void delete(Rectangle obj) {
		try {
			PreparedStatement prepare = connect.prepareStatement("DELETE Rectangle WHERE idRectangle = ?");
			prepare.setString(1, obj.getId());
			int result = prepare.executeUpdate();
			assert result == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}

}

