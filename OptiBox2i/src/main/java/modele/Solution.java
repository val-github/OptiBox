/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.HashSet;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Val
 */
public class Solution {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private HashSet<Box> ensemble_box;
    private double prix;
    

    public Solution( HashSet<Box> ensemble_box, int prix) {
        
        this.ensemble_box = ensemble_box;
        this.prix = prix;
        
    }

    

    public Solution(HashSet<Box> ensemble_box) {
        this.ensemble_box = ensemble_box;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
    
    

    public long getId() {
        return id;
    }

    public HashSet<Box> getEnsemble_box() {
        return ensemble_box;
    }

    public double getPrix() {
        return prix;
    }

    /**
     * Calcul le prix de la solution
     */
    public double calculPrixSolution()
    {
        double prixTotal = 0;
        for (Box box:this.ensemble_box)
        {
            prixTotal += box.getTypeBox().getPrixBox();
        }
        this.prix = prixTotal;
        return prixTotal;
    }

    @Override
    public String toString() {
        return "Solution{" + "ensemble_box=" + ensemble_box + ", prix=" + prix + '}';
    }
    
    

    
}
