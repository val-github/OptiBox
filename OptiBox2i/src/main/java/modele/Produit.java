/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.ArrayList;
import java.util.HashSet;

/**
 *test
 * @author Val
 */
public class Produit {
    private String id;
    private int Lprod;
    private int Hprod;
    private int NBprod;
    private HashSet<Piece> liste_piece;

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

    public HashSet<Piece> getListe_piece() {
        return liste_piece;
    }

    public void setListe_piece(HashSet<Piece> liste_piece) {
        this.liste_piece = liste_piece;
    }
    
  
    
}
