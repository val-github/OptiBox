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
public class Box {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Type_Box typeBox;
    private HashSet<Pile> ensemble_pile;

    public Box( Type_Box typeBox, HashSet<Pile> pile) {
       
        this.typeBox = typeBox;
        this.ensemble_pile = pile;
    }

   


    public HashSet<Pile> getEnsemble_pile() {
        return ensemble_pile;
    }

    

 

    public void setEnsemble_pile(HashSet<Pile> ensemble_pile) {
        this.ensemble_pile = ensemble_pile;
    }
    
    public void addPile(Pile pile){
        this.ensemble_pile.add(pile);
    }
}
