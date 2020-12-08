/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.io.Serializable;
import java.util.HashSet;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author felix
 */
@Entity
public class Type_Box implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int Lbox;
    private int Hbox;
    private double prixBox;
    @OneToMany(mappedBy = "typeBox")
    private HashSet<Box> ensemble_box;

    public Type_Box(int Lbox, int Hbox, double prixBox, HashSet<Box> ensemble_box) {
        this.Lbox = Lbox;
        this.Hbox = Hbox;
        this.prixBox = prixBox;
        this.ensemble_box = ensemble_box;
    }

    
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Type_Box)) {
            return false;
        }
        Type_Box other = (Type_Box) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
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

    @Override
    public String toString() {
        return "Type_Box{" + "Lbox=" + Lbox + ", Hbox=" + Hbox + ", prixBox=" + prixBox + '}';
    }
    
    

    
}
