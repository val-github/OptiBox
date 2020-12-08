/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.HashSet;
import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Val
 */
public class Box {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Type_Box typeBox;
    private HashSet<Pile> ensemble_pile;

    public Box( Type_Box typeBox, HashSet<Pile> pile) {
       
        this.typeBox = typeBox;
        this.ensemble_pile = pile;
    }

    public Box(Type_Box typeBox) {
        this.typeBox = typeBox;
    }

    
    @ManyToOne
    @JoinColumn(name="id")
    public Solution solution;
    
    @ManyToOne
    @JoinColumn(name="id_type_box")
    public Box box;


    public HashSet<Pile> getEnsemble_pile() {
        return ensemble_pile;
    }

    public Type_Box getTypeBox() {
        return typeBox;
    }

    

 

    public void setEnsemble_pile(HashSet<Pile> ensemble_pile) {
        this.ensemble_pile = ensemble_pile;
    }
    
    public void addPile(Pile pile){
        this.ensemble_pile.add(pile);
    }

    @Override
    public String toString() {
        return "Box{" + "typeBox=" + typeBox  + ", solution=" + solution + ", box=" + box + '}';
    }
    
    
}
