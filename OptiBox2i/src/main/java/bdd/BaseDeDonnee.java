/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdd;
/*
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import io.InstanceReader;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
//import modele.Box;
import modele.Instance;/*
import modele.Piece;
import modele.Pile;
import modele.Produit;*/


/**
 *
 * @author alice
 */
public class BaseDeDonnee {
    
    
    static public  List <Instance> afficherInstance(){
         List <Instance> BaseReturn = new ArrayList<Instance>();
        final String query = "SELECT * FROM Instance" ;
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Projet");
        final EntityManager em = emf.createEntityManager();
        try{
           Query querySent = em.createQuery(query);
           BaseReturn = querySent.getResultList();
        } catch(Exception ie){
        System.out.println(ie.getMessage());}
        finally {
            if(em != null && em.isOpen()){
                System.err.println("close");
                em.close();
            }
            if(emf != null && emf.isOpen()){
                emf.close();
            }
        }
        return BaseReturn;
    }
    
    static public boolean enregistrerInstance(String cheminInstance, String nomInstance)
    {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Projet");
            final EntityManager em = emf.createEntityManager();
            try{
                final EntityTransaction et = em.getTransaction();
                try{
                    
                    et.begin();
                    InstanceReader reader = new InstanceReader(cheminInstance);
                    Instance instance = reader.readInstance();
                    instance.setNom(nomInstance);
                    System.out.println("marche");
                    em.persist(instance);
                    
                    et.commit();
                    
                }catch (Exception ex) {
                    et.rollback();
                    System.err.println("rollback");
                    System.out.println(ex);
                    return false;
                }
            } finally {
                if(em != null && em.isOpen()){
                System.err.println("closeas");
                em.close();
                }
                if(emf != null && emf.isOpen()){
                emf.close();
                }
            }
        return true;
    }
    
    public static List <String> getNameInstances()
    {
        List <String> nameInstances = new ArrayList<String>();
        final String query = "SELECT * FROM instance" ;
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Projet");
        final EntityManager em = emf.createEntityManager();
        
        
        try{
            
           //Query querySent = em.createQuery("Select nom FROM instance");
           
           nameInstances = em.createNamedQuery("instance.findAll").getResultList();//querySent.getResultList();
        } catch(Exception ie){
        System.out.println(ie.getMessage());}
        finally {
            if(em != null && em.isOpen()){
                System.err.println("close");
                em.close();
            }
            if(emf != null && emf.isOpen()){
                emf.close();
            }
        }
        return nameInstances;
    }

    /*
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

        String sql = "Insert into instance (id,nom,ensemble_type_box,ensemble_produit) "
                + "VALUES (?,?,?,?)";

        PreparedStatement pst = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        pst.setLong(1, n.getId());
        pst.setString(2, n.getNom());
        

        pst.executeUpdate();
        ResultSet rs = pst.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }*/


      
}
