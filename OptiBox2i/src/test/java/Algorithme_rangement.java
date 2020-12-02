
import java.util.HashSet;
import modele.Instance;
import modele.Piece;
import modele.Produit;
import modele.Solution;

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
        
        for(Produit produit:liste_produits)
        {//On assigne les pièces aux piles de box
            for(i=0;i<produit.getNBprod();i++)
            {//On crée le nombre de pièces renseignées dans produit dans l'attribut liste_piece
                Piece p = new Piece(produit);
                produit.liste_piece.add(p);
            }
            
            for(Piece p:produit.liste_piece)
            {
                
            }
            
        }
        Solution solution= new Solution();
        return solution;
    }
    
}
