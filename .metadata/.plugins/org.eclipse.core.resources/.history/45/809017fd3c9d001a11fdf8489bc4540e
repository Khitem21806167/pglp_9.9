package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import graphique.formes.Cercle;
import graphique.formes.Forme;
import graphique.formes.Graphic;
import graphique.formes.GroupeForme;

public class GroupeFormeDAO extends DAO<GroupeForme> {
	Statement stmt = null;
    ResultSet result = null;

  
	@Override
	public GroupeForme create(GroupeForme obj) {
		// TODO Auto-generated method stub
		List<Graphic> l=obj.getChildren();
		
		 String idEns=obj.getIdEnsemble();
		 try {
			 stmt=connect.createStatement();
			for (int i=0; i<l.size();i++)
			{
				System.out.println(l.get(0));
				
				List<Forme> j = new ArrayList<Forme>(); 
				Forme f=(Forme) l.get(i);
				j.add(f);
				java.sql.PreparedStatement state = connect.prepareStatement("insert into ENSEMBLE (idEnsemble, idForme) values (?,?)");
				state.setString(1, obj.getIdEnsemble());
				state.setString(2,f.getId());
				state.executeUpdate();
				System.out.println("Groupe Forme ajoutée dans la BDD");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
		return obj;
	}

		 
	 public GroupeForme find(String idEnsemble) {
			 GroupeForme obj = new GroupeForme();
				 
			 PreparedStatement prepare;
			try {
				prepare = connect.prepareStatement("SELECT * FROM ENSEMBLE WHERE idEnsemble=?");
				prepare.setString(1, idEnsemble);
				ResultSet result = prepare.executeQuery();
				while(result.next()) { 
				
					obj = new GroupeForme(idEnsemble, result.getString("idForme"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
					
				return obj;
				}

	@Override
	public List<GroupeForme> findAll() {
		// TODO Auto-generated method stub
		GroupeForme obj = new GroupeForme();
		List<GroupeForme> GroupeFormes = new ArrayList<GroupeForme>();
		PreparedStatement prepare;
		try {
			prepare = connect.prepareStatement("SELECT * FROM ENSEMBLE");
			ResultSet result = prepare.executeQuery();
			while(result.next()) {
				GroupeFormes.add(new GroupeForme(result.getString("idEnsemble"),result.getString("idForme")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return GroupeFormes;
	}

	@Override
	public void delete(GroupeForme obj) {
		// TODO Auto-generated method stub
		try {
			java.sql.PreparedStatement state = connect.prepareStatement("Delete from ENSEMBLE where idEnsemble=? ");
			state.setString(1, obj.getIdEnsemble());
			state.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}



	@Override
	public GroupeForme update(GroupeForme obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
