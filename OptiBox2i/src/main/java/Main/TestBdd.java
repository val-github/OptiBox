/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import io.InstanceReader;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import modele.Box;
import modele.Instance;
import modele.Solution;

/**
 *
 * @author alice
 */
public class TestBdd {
    
    public static void main(String[] args) 
    {
        for (int i = 1; i < 11; i++){
            final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Projet");
            final EntityManager em = emf.createEntityManager();
            try{
                final EntityTransaction et = em.getTransaction();
                try{
                    
                    et.begin();
                    InstanceReader reader = new InstanceReader("../instances/instance_" + i + ".csv");
                    Instance instance = reader.readInstance();
                    em.persist(instance);
                    
                    et.commit();
                    
                }catch (Exception ex) {
                    et.rollback();
                    System.err.println("rollback");
                    System.out.println(ex);
                }
            } finally {
                if(em != null && em.isOpen()){
                System.err.println("close");
                em.close();
                }
                if(emf != null && emf.isOpen()){
                emf.close();
                }
            } 
        }
        
        
            
    }
    
}
    
