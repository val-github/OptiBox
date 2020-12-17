package algorithme;


import java.util.ArrayList;
import java.util.HashSet;
import modele.Box;
import modele.Instance;
import modele.Piece;
import modele.Pile;
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
    //à faire, emiler des produits pour avoir des box complètes
    
    //stockage en base de données visualiser et réfléchir à un meilleur algorithme
    //stockage instance, stockage solution associer plusieurs solutions à une même instance
    /**
     * Chaque unité de chaque produit est stockée dans un box qu’on 
     * achète spécialement pour elle et dont les dimensions permettent de l’accueillir.
     * Cette solution est toujours réalisable mais peut être extrêmement mauvaise.
     * @param instance
     * @return 
     */
    public static Solution solutionTriviale(Instance instance)
    {
        int i;
        HashSet<Produit> ensemble_produits = instance.getEnsemble_produit();
        HashSet<Type_Box> ensemble_type_box = instance.getEnsemble_type_box();
        HashSet<Box> ensemble_box = new HashSet<Box>();
        
        
        for(Produit produit:ensemble_produits)
        {//On assigne les pièces aux piles de box
            HashSet<Piece> liste_piece = new HashSet<Piece>();//peut-être inutile
            for(i=0;i<produit.getNBprod();i++)
            {//On crée le nombre de pièces renseignées dans produit dans l'attribut liste_piece
                Piece p = new Piece(produit);
                liste_piece.add(p);
            }
            produit.setListe_piece(liste_piece);
            
            for(Piece p:liste_piece)
            {
                for(Type_Box type_box:ensemble_type_box)
                {//On prend la première boîte qui peut accueillir la pièce
                    if (p.getProduit().getHprod()<type_box.getHbox() 
                            && p.getProduit().getLprod()<type_box.getLbox())
                    {//On crée une entité box qui correspondra à cette boîte
                        
                        //On crée la pile
                        ArrayList<Piece> liste_piece_pile = new ArrayList<Piece>();
                        liste_piece_pile.add(p);
                        Pile pile = new Pile(liste_piece_pile);
                        //On crée l'ensemble de pile
                        HashSet<Pile> ensemble_pile = new HashSet<Pile>();
                        ensemble_pile.add(pile);
                        //On crée la box
                        Box box = new Box(type_box,ensemble_pile);
                        //On ajoute à l'ensemble de box qui sera ajouté à la solution
                        ensemble_box.add(box);
                     
                    }
                }
            }
            
        }
        Solution solution= new Solution(ensemble_box);
        
        solution.setPrix(solution.calculPrixSolution()); 
        
        return solution;
    }
    
}
