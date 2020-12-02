/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.HashSet;
import java.util.List;

/**
 *
 * @author Val
 */
public class Solution {
    public long id;
    public HashSet<Box> ensemble_box;
    public int prix;
    

    public Solution(long id, HashSet<Box> ensemble_box, int prix) {
        this.id = id;
        this.ensemble_box = ensemble_box;
        this.prix = prix;
        
    }

    public long getId() {
        return id;
    }

    public HashSet<Box> getEnsemble_box() {
        return ensemble_box;
    }

    public int getPrix() {
        return prix;
    }


    public void setId(long id) {
        this.id = id;
    }

    public void setEnsemble_box(HashSet<Box> ensemble_box) {
        this.ensemble_box = ensemble_box;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    
}
