
import java.util.ArrayList;
import java.util.HashSet;
import modele.Box;
import modele.Instance;
import modele.Piece;
import modele.Produit;
import modele.Solution;
import modele.Type_Box;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author felix
 */
public class Algorithme_rangement {
    
    /**
     * Chaque unité de chaque produit est stockée dans un box qu’on 
     * achète spécialement pour elle et dont les dimensions permettent de l’accueillir.
     * Cette solution est toujours réalisable mais peut être extrêmement mauvaise.
     * @param instance
     * @return 
     */
    private Solution solutionTriviale(Instance instance)
    {
        int i;
        HashSet<Produit> liste_produits = instance.getEnsemble_produit();
        HashSet<Type_Box> liste_type_box = instance.getEnsemble_type_box();
        
        
        for(Produit produit:liste_produits)
        {//On assigne les pièces aux piles de box
            HashSet<Piece> liste_piece = produit.getListe_piece();
            for(i=0;i<produit.getNBprod();i++)
            {//On crée le nombre de pièces renseignées dans produit dans l'attribut liste_piece
                Piece p = new Piece(produit);
                liste_piece.add(p);
            }
            produit.setListe_piece(liste_piece);
            
            for(Piece p:liste_piece)
            {
                for(Type_Box type_box:liste_type_box)
                {

                }
            }
            
        }
        Solution solution= new Solution();
        return solution;
    }
    
}
