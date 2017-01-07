package DataManagement;
import  java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import Graphics.DossierStagiaireFrame;

public class GestionBD {
	//Les variables BD-----------------------------------
		Connection maConnection=null; //Variable de connexion
		Statement stm=null; //Requete
		ResultSet res;     //Resultat de la requete Select
		//---------------------------------------------------
		
		
	    public GestionBD()
	    {
	    	connexion_BD();
	    }
	    
		//----------------------------------------------------------------------------------------
	    //Méthode de connexion--------------------------------------------------------------------
	    void connexion_BD()
	    {
	    	String pilote="com.mysql.jdbc.Driver";
	    	String url="jdbc:mysql://localhost/drhdatabase";
	    	String nom_utilisateur="root";
	    	String motdepasse="2000";
	    	
	    	//1)Etape 1:	Charger un pilote driver ==>
	    	try
	    	{
	    		Class.forName (pilote);
	    	}
	    	catch(ClassNotFoundException e)
	    	{
	    		System.err.println("Driver loading error: " + e); 
	    	}
	    	
	    	//2)Etape 2:	Etablir une connexion ==>
	    	try
	    	{
	    		maConnection = DriverManager.getConnection(url,nom_utilisateur,motdepasse);
	    	}
	    	catch(SQLException e)
	    	{
	    		System.err.println("Error opening SQL connection: " + e); 
	    	}
	    	
	    	
	    	//3)Etape 3:	Créer un objet Statement ==>
	    	try
	    	{
	    		stm = maConnection.createStatement();
	    	}
	    	catch(SQLException e)
	    	{
	    		System.err.println("Error creating SQL statement: " + e); 
	    	}
	    }
	    
	  //----------------------------------------------------------------------------------------
	    public int requeteModification(String requete)
	    {
	    	try
	    	{
	    		int resUpd=stm.executeUpdate(requete);
	    		return resUpd;
	    	}
	    	catch(SQLException e)
	    	{
	    		System.err.println("Error executing query: " + e); 
	    	}
	    	return 0;
	    }
	    
	  //----------------------------------------------------------------------------------------
	    public DefaultTableModel requeteSelection(String requete, DefaultTableModel model)
	    {
	    	try
	    	{
	    		model.setRowCount(0);
	    		res=stm.executeQuery(requete);
	    		Object ligne[]=new Object[model.getColumnCount()];
	    		while(res.next())
	    		{
	    			for(int i=0;i<ligne.length;i++)
	    			{
	    				ligne[i]=res.getString(i+1);
	    			}
	    			model.addRow(ligne);
	    		}
	    	}
	    	catch(SQLException e)
	    	{
	    		System.err.println("Error executing query: " + e); 
	    	}
	    	return model;
	    }

	    public DefaultComboBoxModel requeteSelectionToCombo(String requete, DefaultComboBoxModel model)
	    {
	    	try
	    	{
	    		model.removeAllElements();
	    		res=stm.executeQuery(requete);
	    		while(res.next())
	    		{
	    			model.addElement(res.getString(2));
	    		}
	    	}
	    	catch(SQLException e)
	    	{
	    		System.err.println("Error executing query: " + e); 
	    	}
	    	return model;
	    }
}
