/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modele.Box;
import modele.Instance;
import modele.Piece;
import modele.Pile;
import modele.Produit;
import modele.Solution;

/**
 *
 * @author alice
 */
public class BaseDeDonnee {
    
    
    private Connection connect;

     public void connect() throws ClassNotFoundException, SQLException  {
        String driverClass = "org.apache.derby.jdbc.ClientDriver";
        String urlDatabase = "jdbc:derby://localhost:1527/OptiBox";
        String user = "root";
        String pwd = "root";
        Class.forName(driverClass);
        this.connect = DriverManager.getConnection(urlDatabase, user, pwd);
           
    }
     
      private int ajouteBox(Box b) throws SQLException {

        String sql = "Insert into box (id,Lbox, Hbox, prixBox) "
                + "VALUES (?,?,?,?)";

        PreparedStatement pst = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        pst.setString(1, b.getId());
        pst.setInt(2, b.getLbox());
        pst.setInt(3, b.getHbox());
        pst.setDouble(4, b.getPrixBox());

        pst.executeUpdate();
        ResultSet rs = pst.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }
       private int ajouteProduit(Produit o) throws SQLException {

        String sql = "Insert into produit (id,Lprod, Hprod, NBprod) "
                + "VALUES (?,?,?,?)";

        PreparedStatement pst = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        pst.setString(1, o.getId());
        pst.setInt(2, o.getLprod());
        pst.setInt(3, o.getHprod());
        pst.setInt(4, o.getNBprod());

        pst.executeUpdate();
        ResultSet rs = pst.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }
       
      private int ajoutePiece(Piece p) throws SQLException {

        String sql = "Insert into piece (id,type) "
                + "VALUES (?,?)";

        PreparedStatement pst = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        pst.setString(1, p.getId());
        //2, p.getType());
        

        pst.executeUpdate();
        ResultSet rs = pst.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }
      private int ajoutePile(Pile i) throws SQLException {

        String sql = "Insert into pile (id) "
                + "VALUES (?)";

        PreparedStatement pst = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        pst.setLong(1, i.getId());
        //2, p.getType());
        

        pst.executeUpdate();
        ResultSet rs = pst.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }
      
       private int ajouteSolution(Solution s) throws SQLException {

        String sql = "Insert into solution (id,prix) "
                + "VALUES (?,?)";

        PreparedStatement pst = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        pst.setLong(1, s.getId());
        pst.setInt(2, s.getPrix());
        

        pst.executeUpdate();
        ResultSet rs = pst.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }
       
         private int ajouteInstance(Instance n) throws SQLException {

        String sql = "Insert into instance (id,nom) "
                + "VALUES (?,?)";

        PreparedStatement pst = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        pst.setLong(1, n.getId());
        pst.setString(2, n.getNom());
        

        pst.executeUpdate();
        ResultSet rs = pst.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }
      
}