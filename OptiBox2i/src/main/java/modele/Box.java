/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.HashSet;

/**
 *
 * @author Val
 */
public class Box {
    public String id;
    public int Lbox;
    public int Hbox;
    public double prixBox;
    private HashSet<Pile> ensemble_pile;

    public Box(String id, int Lbox, int Hbox, double prixBox, HashSet<Pile> pile) {
        this.id = id;
        this.Lbox = Lbox;
        this.Hbox = Hbox;
        this.prixBox = prixBox;
        this.ensemble_pile = pile;
    }

    public String getId() {
        return id;
    }

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

    public void setId(String id) {
        this.id = id;
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
