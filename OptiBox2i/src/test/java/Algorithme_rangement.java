
import java.util.HashSet;
import modele.Instance;
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
        {
            for(i=0;i<produit.NBprod;i++)
            {
                
            }
            
        }
        Solution solution= new Solution();
        return solution;
    }
}
