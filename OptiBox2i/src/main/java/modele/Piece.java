/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import modele.Produit;

/**
 *
 * @author Val
 */
public class Piece {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public Produit type;

    public Piece(String id, Produit type) {
        
        this.type = type;
    }
    
    public Piece(Produit type) {
       
        this.type = type;
    }

  

    public Produit getType() {
        return type;
    }

    public void setType(Produit type) {
        this.type = type;
    }
    
    
}
