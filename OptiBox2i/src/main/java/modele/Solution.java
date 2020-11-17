/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.List;

/**
 *
 * @author Val
 */
public class Solution {
    public long id;
    public List<Box> ensemble_box;
    public int prix;
    public List<Piece> ens_piece;

    public Solution(long id, List<Box> ensemble_box, int prix, List<Piece> ens_piece) {
        this.id = id;
        this.ensemble_box = ensemble_box;
        this.prix = prix;
        this.ens_piece = ens_piece;
    }

    public long getId() {
        return id;
    }

    public List<Box> getEnsemble_box() {
        return ensemble_box;
    }

    public int getPrix() {
        return prix;
    }

    public List<Piece> getEns_piece() {
        return ens_piece;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setEnsemble_box(List<Box> ensemble_box) {
        this.ensemble_box = ensemble_box;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public void setEns_piece(List<Piece> ens_piece) {
        this.ens_piece = ens_piece;
    }
    
    
}
