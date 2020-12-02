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
    public int prixBox;
    private HashSet<Pile> ensemble_pile;

    public Box(String id, int Lbox, int Hbox, int prixBox) {
        this.id = id;
        this.Lbox = Lbox;
        this.Hbox = Hbox;
        this.prixBox = prixBox;
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

    public int getPrixBox() {
        return prixBox;
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

    public void setPrixBox(int prixBox) {
        this.prixBox = prixBox;
    }
    
    
}
