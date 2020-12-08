/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.ArrayList;
import java.util.HashSet;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *test
 * @author Val
 */
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int Lprod;
    private int Hprod;
    private int NBprod;
    @OneToMany(mappedBy="produit")
    private HashSet<Piece> liste_piece;

    public Produit(int Lprod, int Hprod, int NBprod) {
        this.Lprod = Lprod;
        this.Hprod = Hprod;
        this.NBprod = NBprod;
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

    public void setLprod(int Lprod) {
        this.Lprod = Lprod;
    }

    public HashSet<Piece> getListe_piece() {
        return liste_piece;
    }

    public void setListe_piece(HashSet<Piece> liste_piece) {
        this.liste_piece = liste_piece;
    }

    @Override
    public String toString() {
        return "Produit{" + "Lprod=" + Lprod + ", Hprod=" + Hprod + ", NBprod=" + NBprod + '}';
    }
    
    
    
}
