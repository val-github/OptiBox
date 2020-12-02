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

/**
 *test
 * @author Val
 */
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public int Lprod;
    public int Hprod;
    public int NBprod;
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

    public void setHprod(int Hprod) {
        this.Hprod = Hprod;
    }

    public void setNBprod(int NBprod) {
        this.NBprod = NBprod;
    }
    
    
}
