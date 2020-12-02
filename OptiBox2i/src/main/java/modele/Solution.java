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
    public HashSet<Box> ensemble_box;
    public int prix;
    

    public Solution( HashSet<Box> ensemble_box, int prix) {
        
        this.ensemble_box = ensemble_box;
        this.prix = prix;
        
    }

    public Solution() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
