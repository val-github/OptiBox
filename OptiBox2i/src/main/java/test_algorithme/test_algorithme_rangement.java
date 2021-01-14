/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_algorithme;


import static algorithme.Algorithme_rangement.solution2;
import io.InstanceReader;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import modele.Box;
import modele.Instance;
import modele.Pile;
import modele.Solution;

/**
 *
 * @author felix
 */
public class test_algorithme_rangement {
    public static void main(String[] args) {
        
        
        
        for (int i = 1; i<11; i++){
            Instance instance = new Instance();
            final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Projet");
            final EntityManager em = emf.createEntityManager();
            try{
                final EntityTransaction et = em.getTransaction();
                try{
                    
                    et.begin();
                    InstanceReader reader = new InstanceReader("../instances/instance_" + i + ".csv");
                    instance = reader.readInstance();
                
                    
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
        
        System.out.println("\n\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\n\n");
            
        System.out.println("instance en cours de traitement:\n" + instance.toString() + "\n");
        
        System.out.println("résultats instance " + i + " :\n\n");
        
        System.out.println("test triA");
        Solution solutionA = solution2(instance, 0);
        for (Box box: solutionA.getEnsemble_box()){
            System.out.println("box:");
            System.out.println(box.toString());
            for (Pile pile:box.getEnsemble_pile()){
                System.out.println();
            }
        }
        System.out.println(solutionA.toString());
        
        System.out.println("test triL");
        Solution solutionL = solution2(instance, 1);
        for (Box box: solutionL.getEnsemble_box()){
            System.out.println("box:");
            System.out.println(box.toString());
        }
        System.out.println(solutionL.toString());
        
        System.out.println("test triH");
        Solution solutionH = solution2(instance, 2);
        for (Box box: solutionH.getEnsemble_box()){
            System.out.println("box:");
            System.out.println(box.toString());
        }
        System.out.println(solutionH.toString());
        
        System.out.println("\n\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\n");
        }
          
        
    }
    
}
