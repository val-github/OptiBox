/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

/**
 *
 * @author Val
 */
public class EmptyFieldException extends ReaderException {
    public EmptyFieldException (int numLigne, int numColonne) {
        super("La ligne numéro "+numLigne+" du fichier est incorrecte",
                "Assurez-vous que ligne numéro "+numLigne+" en colonne "+numColonne+" ne soit pas vide");
    }
}
