package dao;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class DAO<T> {
	
	public Connection connect;
    protected Statement stmt = null;

	
	public DAO() {
		try {	 
		 String dbURL = "jdbc:derby:myDB;create=true";
		 // Create database connection         
         connect = DriverManager.getConnection(dbURL); 

	         stmt = connect.createStatement();
	 
	         String sqlForme = "CREATE TABLE ENSEMBLE(idEnsemble VARCHAR(100), idForme VARCHAR(100) )";
	         
	         String sqlCarre = "CREATE TABLE CARRE " +
                     "(idCarre VARCHAR(100) PRIMARY KEY,"+
                     " abscisse INTEGER ,"+
        	         "ordonnee INTEGER ," +
                     " longueur DOUBLE)";
                     
	         
	         String sqlTriangle= "CREATE TABLE TRIANGLE " +
                     "(idTriangle VARCHAR(100) PRIMARY KEY,"+
                     " abscisse INTEGER,"+
        	         "ordonnee INTEGER, "+
                     " hauteur DOUBLE, " +
                     " base DOUBLE) ";
                    
	         
	         String sqlRectangle= "CREATE TABLE RECTANGLE " +
                     "(idRectangle VARCHAR(100) PRIMARY KEY,"+
                     " abscisse INTEGER,"+
        	         "ordonnee INTEGER, "+
                     " longueur DOUBLE, " +
                     " largeur DOUBLE )";
	         
	         String sqlCercle= "CREATE TABLE CERCLE " +
                     "(idCercle VARCHAR(100) PRIMARY KEY,"+
                     " abscisse INTEGER,"+
        	         "ordonnee INTEGER, "+
                     " rayon DOUBLE)";
	        
	       DatabaseMetaData dbm = connect.getMetaData();
	      // check if "FORME" table is there
	      ResultSet tables = dbm.getTables(null, null, "ENSEMBLE", null);
	      if (!tables.next()) 
	      {
	    	  PreparedStatement pstmt = connect.prepareStatement(sqlForme);
		    	 	    	 
	    	  pstmt.executeUpdate();
	      }
	    
	      tables = dbm.getTables(null, null, "CERCLE", null);
	      if (!tables.next()) {
	    	  PreparedStatement pstmt = connect.prepareStatement(sqlCercle);
		    	 	    	 
	    	  pstmt.executeUpdate();
		    	
		      }     
	      tables = dbm.getTables(null, null, "TRIANGLE", null);
	      if (!tables.next()) {
	    	  PreparedStatement pstmt = connect.prepareStatement(sqlTriangle);
		    	    	 
	    	  pstmt.executeUpdate();
		    	  
		      }     
	      tables = dbm.getTables(null, null, "CARRE", null);
	      if (!tables.next()) {
	    	  PreparedStatement pstmt = connect.prepareStatement(sqlCarre);
		    	 	    	 
	    	  pstmt.executeUpdate();
		    			    
		      }  
	      tables = dbm.getTables(null, null, "RECTANGLE", null);
	      if (!tables.next()) {
	    	  PreparedStatement pstmt = connect.prepareStatement(sqlRectangle);
		    	 	    	 
	    	  pstmt.executeUpdate();
		      }     
	       
	        // System.out.println("tables created ");

		} catch(Exception e){
			e.printStackTrace();
		}finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            connect.close();
		      }catch(SQLException se){
		      }// do nothing
		      try{
		         if(connect!=null)
		            connect.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try	
	}
	  
	
	public abstract T create (T obj);
	public abstract T find (String id);
	public abstract List<T> findAll ();
	public abstract T update (T obj);
	public abstract void delete (T obj);


}
