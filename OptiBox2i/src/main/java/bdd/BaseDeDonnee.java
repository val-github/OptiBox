/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdd;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import modele.Instance;


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
}