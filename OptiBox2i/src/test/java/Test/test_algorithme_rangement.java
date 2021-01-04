/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;


import static algorithme.Algorithme_rangement.solution2;
import java.util.HashSet;
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
        Type_Box typebox1 = new Type_Box(5, 5, 1, ensemble_box);
        
        //Création ensemble_type_box
        HashSet<Type_Box> ensemble_type_box= new HashSet<Type_Box>();
        ensemble_type_box.add(typebox1);
       
        //Création Produit
        Produit produit1 = new Produit(2,2,4);
        
        //Création ensemble_produit
        HashSet<Produit> ensemble_produit=new HashSet<Produit>();
        ensemble_produit.add(produit1);
        
        
        //Création Instance
        Instance instance = new Instance("Instance_Test", ensemble_type_box, ensemble_produit);
        
        System.out.println("hello");
        Solution solution = solution2(instance);
        System.out.println(solution.toString());
    }
    
}
