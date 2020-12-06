/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import modele.Box;
import modele.Solution;

/**
 *
 * @author alice
 */
public class TestBdd {
    
    public static void main(String[] args) 
    {
        
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Projet");
            final EntityManager em = emf.createEntityManager();
            try{
                final EntityTransaction et = em.getTransaction();
                try{
                    et.begin();
                    Box b = new Box(1,2,3);
                    Solution s = new Solution(12);
                    em.persist(s);
                    
                    et.commit();
                }catch (Exception ex) {
                    et.rollback();
                    System.err.println("rollback");
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
    
