/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import io.InstanceReader;
import io.ReaderException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import modele.Instance;

/**
 *
 * @author alice
 */
public class Main {
    
      
     public static void main(String[] args) {
         Instance InstanceT = new Instance();
         try {
                String currentDirectory = System.getProperty("user.dir") + "/../instances/instance_1.csv";
                System.out.println("The current working directory is " + currentDirectory);
                InstanceReader InstanceTest= new InstanceReader(currentDirectory);
                InstanceT = InstanceTest.readInstance();
                InstanceT.display();
            } catch (ReaderException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
         
        /* List <Instance> BaseReturn = new ArrayList<Instance>();
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
        }*/
      
    }
             
    
}