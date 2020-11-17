/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import modele.Produit;

/**
 *
 * @author Val
 */
public class Piece {
    public String id;
    public Produit type;

    public Piece(String id, Produit type) {
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public Produit getType() {
        return type;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setType(Produit type) {
        this.type = type;
    }
    
    
}
