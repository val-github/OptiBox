/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.ArrayList;

/**
 *test
 * @author Val
 */
public class Produit {
    public String id;
    public int Lprod;
    public int Hprod;
    public int NBprod;
    public ArrayList<Piece> liste_piece;

    public Produit(String id, int Lprod, int Hprod, int NBprod) {
        this.id = id;
        this.Lprod = Lprod;
        this.Hprod = Hprod;
        this.NBprod = NBprod;
    }

    public String getId() {
        return id;
    }

    public int getLprod() {
        return Lprod;
    }

    public int getHprod() {
        return Hprod;
    }

    public int getNBprod() {
        return NBprod;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLprod(int Lprod) {
        this.Lprod = Lprod;
    }

    public void setHprod(int Hprod) {
        this.Hprod = Hprod;
    }

    public void setNBprod(int NBprod) {
        this.NBprod = NBprod;
    }
    
    
}
