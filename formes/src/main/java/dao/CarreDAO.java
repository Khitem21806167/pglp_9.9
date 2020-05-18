package dao;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import graphique.formes.*;

public class CarreDAO extends DAO<Carre> {
	Statement stmt = null;
    ResultSet result = null;
   
	@Override
	public Carre create(Carre obj) {
		try {
			PreparedStatement prepare = connect.prepareStatement("INSERT INTO Carre(idCarre, abscisse, ordonnee, longueur) VALUES(?, ?, ?, ?)");
			prepare.setString(1, obj.getId());
			prepare.setInt(2, obj.getAbscisse());
			prepare.setInt(3, obj.getOrdonnee());
			prepare.setDouble(4, obj.getLongueur());
			int result = prepare.executeUpdate();
			assert result == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;		
	}


	@Override
	public Carre find(String idCarre) {
		Carre obj = new Carre();
		try {
			PreparedStatement prepare = connect.prepareStatement("SELECT * FROM Carre WHERE idCarre=?");
			prepare.setString(1, idCarre);
			ResultSet result = prepare.executeQuery();
			while(result.next()) {
				System.out.println("uu");
				obj = new Carre(idCarre, result.getInt("abscisse"), result.getInt("ordonnee"), result.getDouble("longueur"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public List<Carre> findAll() {
		List<Carre> carres = new ArrayList<Carre>();
		try {
			PreparedStatement prepare = connect.prepareStatement("SELECT * FROM Carre");
			ResultSet result = prepare.executeQuery();
			while(result.next()) {
				carres.add(new Carre(result.getString("idCarre"), result.getInt("abscisse"), result.getInt("ordonnee"), result.getDouble("longueur")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return carres;
	}

	@Override
	public Carre update(Carre obj) {
		try {
			PreparedStatement prepare = connect.prepareStatement("UPDATE Carre SET abscisse = ?, ordonnee = ?, longueur = ? WHERE idCarre = ?");
			prepare.setInt(1, obj.getAbscisse());
			prepare.setInt(2, obj.getOrdonnee());
			prepare.setDouble(3, obj.getLongueur());
			prepare.setString(4, obj.getId());
			int result = prepare.executeUpdate();
			assert result == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public void delete(Carre obj) {
		try {
			PreparedStatement prepare = connect.prepareStatement("DELETE Carre WHERE idCarre = ?");
			prepare.setString(1, obj.getId());
			int result = prepare.executeUpdate();
			assert result == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
}
