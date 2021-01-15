package algorithme;


import java.sql.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
    
    public static Solution solution1(Instance instance)
    {
        int i;
        Set<Produit> ensemble_produits = instance.getEnsemble_produit();
        Set<Type_Box> ensemble_type_box = instance.getEnsemble_type_box();
        HashSet<Box> ensemble_box = new HashSet<Box>();
        
        
        for(Produit produit:ensemble_produits)
        {//On assigne les pièces aux piles de box
            HashSet<Piece> liste_piece = new HashSet<Piece>();//peut-être inutile
            for(i=0;i<produit.getNBprod();i++)
            {//On crée le nombre de pièces renseignées dans produit dans l'attribut liste_piece
                Piece p = new Piece(i,produit);
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
    
    
    //2eme solution
    public static Solution solution2(Instance instance, int indicTri)
    {
        int i;
        Set<Produit> ensemble_produits = instance.getEnsemble_produit();
        Set<Type_Box> ensemble_type_box = instance.getEnsemble_type_box();
        HashSet<Box> ensemble_box = new HashSet<Box>();
        
        //algorithme de tri des box par ordre croissant de prix

        
        
        
        /* * * * * * * ** * * * * * ** * */
        //produits triés par surface
        if (indicTri == 0){
            ensemble_produits = new HashSet<>(triA(ensemble_produits));
            ensemble_type_box = new HashSet<>(triTBP(ensemble_type_box));
        }
        
        //produits et Type_Box triés par longeur (décroissant)
        if (indicTri == 1){
            ensemble_produits = new HashSet<>(triL(ensemble_produits));
            ensemble_type_box = new HashSet<>(triTBL(ensemble_type_box));
        }
        
        
        //produits triés par hauteur
        if (indicTri == 2){
            ensemble_produits = new HashSet<>(triH(ensemble_produits));
            ensemble_type_box = new HashSet<>(triTBH(ensemble_type_box));
        }
        
        
        for(Produit produit:ensemble_produits)
        {//On assigne les pièces aux piles de box
            HashSet<Piece> liste_piece = new HashSet<Piece>();//peut-être inutile
            for(i=0;i<produit.getNBprod();i++)
            {//On crée le nombre de pièces renseignées dans produit dans l'attribut liste_piece
                Piece p = new Piece(i, produit);
                liste_piece.add(p);
            }
        
            for(Piece p:liste_piece)
            {
                //indicateur pour savoir si la piece est déja placée
                int indic = 0;
                System.out.println("\n\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
                System.out.println("nouvelle piece");
                //tri des box par ordre crois
                ensemble_box = new HashSet<>(triBL(ensemble_box));
                
                //on parcourt les box déja achetés
                for(Box box:ensemble_box)
                {
                    if (indic == 0){
                        int Loccupee = 0;
                        System.out.println("vérif piles");
                        //on parcourt les piles déja placées dans le box
                        for (Pile pile:box.getEnsemble_pile())
                        {
                            Loccupee = Loccupee + pile.getLPileBase();
                            System.out.println("getLPileBase" + pile.getLPileBase());
                            System.out.println("pile:" + Loccupee);
                            //on vérifie si la piéce peut être placée sur la pile
                            if (indic == 0){
                                if (p.getProduit().getLprod() <= pile.getLPileSommet())
                                {
                                    System.out.println("piece peut tenir sur la pile");
                                    if (pile.getHPile() + p.getProduit().getHprod() < box.getTypeBox().getHbox())
                                    {   
                                        System.out.println("\tajout dans la pile");
                                        pile.addPiece(p);
                                        indic = 1;
                                    }
                                }
                            }
                        }
                    
                        if (indic == 0)
                        {
                            //on vérifie si on peut placer la piéce sur une nouvelle pile dans le boxe
                            int L = p.getProduit().getLprod();
                            System.out.println("piece " + L);
                            System.out.println("occupée " + Loccupee);
                            if (L + Loccupee <= box.getTypeBox().getLbox())
                            {
                                //On crée la pile
                                System.out.println("\tcréation pile");
                                Pile pile = new Pile();
                                pile.addPiece(p);
                                box.addPile(pile);
                                indic = 1;
                            }
                        }
                    }
                    
                }    
                
                
                if (indic == 0)
                {
                    for(Type_Box type_box:ensemble_type_box)
                    {//On prend la première boîte qui peut accueillir la pièce
                        if (p.getProduit().getHprod()<type_box.getHbox() 
                            && p.getProduit().getLprod()<type_box.getLbox())
                        {//On crée une entité box qui correspondra à cette boîte
                            if(indic == 0){
                                //On crée la pile
                                ArrayList<Piece> liste_piece_pile = new ArrayList<Piece>();
                                liste_piece_pile.add(p);
                                Pile pile = new Pile(liste_piece_pile);
                                //On crée l'ensemble de pile
                                HashSet<Pile> ensemble_pile = new HashSet<Pile>();
                                ensemble_pile.add(pile);
                                //On crée la box
                                Box box1 = new Box(type_box,ensemble_pile);
                                //On ajoute à l'ensemble de box qui sera ajouté à la solution
                                ensemble_box.add(box1);
                                System.out.println("\t\tcréation box");
                                indic = 1;
                            }
                            
                        }
                    }
                } 
            } 
        }
        Solution solution= new Solution(ensemble_box);
        
        solution.setPrix(solution.calculPrixSolution()); 
        
        return solution;
    }
    //algorithme de tri des produit par ordre décroissant de longueur
    public static List<Produit> triL(Set<Produit> ensemble_produits){
        boolean sorted = false;
        int n = ensemble_produits.size();
             
        List<Produit> lp = new ArrayList<>(ensemble_produits); 
        while(!sorted) {
            sorted = true;
            for (int x = 0; x < n - 1; x++) {
                Produit  p1 = lp.get(x);
                Produit  p2 = lp.get(x+1);
                if (p1.getLprod() < p2.getLprod()) {
                    lp.set(x, p2);
                    lp.set(x+1, p1);
                    sorted = false;
                }
            }
        }
    return(lp);
    }    
    //algorithme de tri des produit par ordre décroissant de hauteur
    public static List<Produit> triH(Set<Produit> ensemble_produits){
        boolean sorted = false;
        int n = ensemble_produits.size();
             
        List<Produit> lp = new ArrayList<>(ensemble_produits); 
        while(!sorted) {
            sorted = true;
            for (int x = 0; x < n - 1; x++) {
                Produit  p1 = lp.get(x);
                Produit  p2 = lp.get(x+1);
                if (p1.getHprod() < p2.getHprod()) {
                    lp.set(x, p2);
                    lp.set(x+1, p1);
                    sorted = false;
                }
            }
        }
    return(lp);
    }
    //algorithme de tri des produit par ordre décroissant de surface
    public static List<Produit> triA(Set<Produit> ensemble_produits){
        boolean sorted = false;
        int n = ensemble_produits.size();
             
        List<Produit> lp = new ArrayList<>(ensemble_produits); 
        while(!sorted) {
            sorted = true;
            for (int x = 0; x < n - 1; x++) {
                Produit  p1 = lp.get(x);
                Produit  p2 = lp.get(x+1);
                if (p1.getLprod()*p1.getHprod() < p2.getLprod()*p1.getHprod()) {
                    lp.set(x, p2);
                    lp.set(x+1, p1);
                    sorted = false;
                }
            }
        }
    return(lp);
    }
    //fonction pour trier des Type_Box par ordre décroissant de longueur
    public static List<Type_Box> triTBL(Set<Type_Box> ensemble_box){
        int n = ensemble_box.size();
        boolean sorted = false;
             
        List<Type_Box> lb = new ArrayList<>(ensemble_box); 
        
        while(sorted==false) {
            sorted = true;
            for (int x = 0; x < n - 1; x++) {
                Type_Box  b1 = lb.get(x);
                Type_Box  b2 = lb.get(x+1);
                if (b1.getLbox() < b2.getLbox()) {
                    lb.set(x, b2);
                    lb.set(x+1, b1);
                    sorted = false;
                }
            }
        }
        return lb;
    }
    //fonction pour trier des Type_Box par ordre décroissant de longueur
    public static List<Type_Box> triTBH(Set<Type_Box> ensemble_box){
        int n = ensemble_box.size();
        boolean sorted = false;
             
        List<Type_Box> lb = new ArrayList<>(ensemble_box); 
        
        while(sorted==false) {
            sorted = true;
            for (int x = 0; x < n - 1; x++) {
                Type_Box  b1 = lb.get(x);
                Type_Box  b2 = lb.get(x+1);
                if (b1.getHbox() < b2.getHbox()) {
                    lb.set(x, b2);
                    lb.set(x+1, b1);
                    sorted = false;
                }
            }
        }
        return lb;
    }
    //fonction pour trier des Type_Box par ordre croissant de prix
    public static List<Type_Box> triTBP(Set<Type_Box> ensemble_box){
        int n = ensemble_box.size();
        boolean sorted = false;
             
        List<Type_Box> lb = new ArrayList<>(ensemble_box); 
        
        while(sorted==false) {
            sorted = true;
            for (int x = 0; x < n - 1; x++) {
                Type_Box  b1 = lb.get(x);
                Type_Box  b2 = lb.get(x+1);
                if (b1.getLbox() > b2.getLbox()) {
                    lb.set(x, b2);
                    lb.set(x+1, b1);
                    sorted = false;
                }
            }
        }
        return lb;
    }
    
    //fonction pour trier des Box par ordre décroissant de longueur
    public static List<Box> triBL(Set<Box> ensemble_box){
        int n = ensemble_box.size();
        boolean sorted = false;
             
        List<Box> lb = new ArrayList<>(ensemble_box); 
        
        while(sorted==false) {
            sorted = true;
            for (int x = 0; x < n - 1; x++) {
                Box  b1 = lb.get(x);
                Box  b2 = lb.get(x+1);
                if (b1.getTypeBox().getLbox() < b2.getTypeBox().getLbox()) {
                    lb.set(x, b2);
                    lb.set(x+1, b1);
                    sorted = false;
                }
            }
        }
        return lb;
    }
    //fonction pour trier des Box par ordre décroissant de longueur
    public static List<Box> triBH(Set<Box> ensemble_box){
        int n = ensemble_box.size();
        boolean sorted = false;
             
        List<Box> lb = new ArrayList<>(ensemble_box); 
        
        while(sorted==false) {
            sorted = true;
            for (int x = 0; x < n - 1; x++) {
                Box  b1 = lb.get(x);
                Box  b2 = lb.get(x+1);
                if (b1.getTypeBox().getHbox() < b2.getTypeBox().getHbox()) {
                    lb.set(x, b2);
                    lb.set(x+1, b1);
                    sorted = false;
                }
            }
        }
        return lb;
    }
    //fonction pour trier des Box par ordre croissant de prix
    public static List<Box> triBP(Set<Box> ensemble_box){
        int n = ensemble_box.size();
        boolean sorted = false;
             
        List<Box> lb = new ArrayList<>(ensemble_box); 
        
        while(sorted==false) {
            sorted = true;
            for (int x = 0; x < n - 1; x++) {
                Box  b1 = lb.get(x);
                Box  b2 = lb.get(x+1);
                if (b1.getTypeBox().getPrixBox() < b2.getTypeBox().getPrixBox()) {
                    lb.set(x, b2);
                    lb.set(x+1, b1);
                    sorted = false;
                }
            }
        }
        return lb;
    }
}

    
        
