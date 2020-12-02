/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
    @ManyToOne
    private Produit type;

    public Piece( Produit type) {
        
        this.type = type;
    }
    
 

  

    public Produit getType() {
        return type;
    }

    public void setType(Produit type) {
        this.type = type;
    }
    
    
}
