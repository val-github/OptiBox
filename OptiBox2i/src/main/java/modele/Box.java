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
    public int Lbox;
    public int Hbox;
    public double prixBox;
    private HashSet<Pile> ensemble_pile;

    public Box( int Lbox, int Hbox, double prixBox, HashSet<Pile> pile) {
       
        this.Lbox = Lbox;
        this.Hbox = Hbox;
        this.prixBox = prixBox;
        this.ensemble_pile = pile;
    }

    @ManyToOne
    @JoinColumn(name="id")
    public Solution solution;
    
    @ManyToOne
    @JoinColumn(name="id_type_box")
    public Box box;

    public int getLbox() {
        return Lbox;
    }

    public int getHbox() {
        return Hbox;
    }

    public double getPrixBox() {
        return prixBox;
    }

    public HashSet<Pile> getEnsemble_pile() {
        return ensemble_pile;
    }

    

    public void setLbox(int Lbox) {
        this.Lbox = Lbox;
    }

    public void setHbox(int Hbox) {
        this.Hbox = Hbox;
    }

    public void setPrixBox(double prixBox) {
        this.prixBox = prixBox;
    }

    public void setEnsemble_pile(HashSet<Pile> ensemble_pile) {
        this.ensemble_pile = ensemble_pile;
    }
    
    public void addPile(Pile pile){
        this.ensemble_pile.add(pile);
    }
}
