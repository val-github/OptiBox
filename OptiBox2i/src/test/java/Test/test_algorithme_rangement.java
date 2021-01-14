/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;


import static algorithme.Algorithme_rangement.solution1;
import static algorithme.Algorithme_rangement.solution2;
import io.InstanceReader;
import java.util.HashSet;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import modele.Box;
import modele.Instance;
import modele.Pile;
import modele.Produit;
import modele.Solution;
import modele.Type_Box;

/**
 *
 * @author felix
 */
public class test_algorithme_rangement {
    public static void main(String[] args) {
        
        //Création ensemble_box
        HashSet<Box> ensemble_box=null;
        
        //Création Type_Box
        Type_Box typebox1 = new Type_Box(5, 6, 3, ensemble_box);
        Type_Box typebox2 = new Type_Box(2, 4, 2, ensemble_box);
        Type_Box typebox3 = new Type_Box(8, 9, 5, ensemble_box);
        Type_Box typebox4 = new Type_Box(10, 12, 7, ensemble_box);
        Type_Box typebox5 = new Type_Box(5, 5, 3, ensemble_box);
        Type_Box typebox6 = new Type_Box(12, 11, 10, ensemble_box);
        
        //Création ensemble_type_box
        HashSet<Type_Box> ensemble_type_box= new HashSet<Type_Box>();
        ensemble_type_box.add(typebox1);
        ensemble_type_box.add(typebox2);
        ensemble_type_box.add(typebox3);
        ensemble_type_box.add(typebox4);
        ensemble_type_box.add(typebox5);
        ensemble_type_box.add(typebox6);
        
        //Création Produit
        Produit produit1 = new Produit(2,2,4);
        Produit produit2 = new Produit(1,3,5);
        Produit produit3 = new Produit(5,4,6);
        Produit produit4 = new Produit(6,8,3);
        Produit produit5 = new Produit(3,2,9);
        Produit produit6 = new Produit(4,4,8);
        Produit produit7 = new Produit(3,5,7);
        Produit produit8 = new Produit(7,6,5);
        Produit produit9 = new Produit(2,5,4);
        Produit produit10 = new Produit(9,8,3);
        
        //Création ensemble_produit
        HashSet<Produit> ensemble_produit=new HashSet<Produit>();
        ensemble_produit.add(produit1);
        ensemble_produit.add(produit2);
        ensemble_produit.add(produit3);
        ensemble_produit.add(produit4);
        ensemble_produit.add(produit5);
        ensemble_produit.add(produit6);
        ensemble_produit.add(produit7);
        ensemble_produit.add(produit8);
        ensemble_produit.add(produit9);
        ensemble_produit.add(produit10);
        
        //Création Instance
        Instance instance1 = new Instance("Instance_Test", ensemble_type_box, ensemble_produit);
        
        Instance instance_1 = new Instance();
        
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Projet");
        final EntityManager em = emf.createEntityManager();
        try{
            final EntityTransaction et = em.getTransaction();
            try{
                    
                et.begin();
                InstanceReader reader = new InstanceReader("../instances/instance_1.csv");
                instance_1 = reader.readInstance();
                
                    
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
        System.out.println("résultats instance crée:");
        
        System.out.println("test solution1");
        Solution solution1 = solution1(instance1);
        System.out.println(solution1.toString());
        
        System.out.println("test triA");
        Solution solutionA = solution2(instance1, 0);
        System.out.println(solutionA.toString());
        
        System.out.println("test triL");
        Solution solutionL = solution2(instance1, 1);
        System.out.println(solutionL.toString());
        
        System.out.println("test triH");
        Solution solutionH = solution2(instance1, 2);
        System.out.println(solutionH.toString());
        
        System.out.println("résultats instance_1:");
        
        System.out.println("test solution1");
        Solution solution11 = solution1(instance_1);
        System.out.println(solution11.toString());
        
        System.out.println("test triA");
        Solution solution1A = solution2(instance_1, 0);
        System.out.println(solution1A.toString());
        
        System.out.println("test triL");
        Solution solution1L = solution2(instance_1, 1);
        System.out.println(solution1L.toString());
        
        System.out.println("test triH");
        Solution solution1H = solution2(instance_1, 2);
        System.out.println(solution1H.toString());
    }
    
}
