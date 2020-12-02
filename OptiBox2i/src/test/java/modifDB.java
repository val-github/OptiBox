
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Val
 */
public class modifDB {
    public static void main(String[]args) {
    final EntityManagerFactory emf=Persistence.createEntityManagerFactory("OptiBox");
    final EntityManager em=emf.createEntityManager();
    try{
        final EntityTransaction et=em.getTransaction();
        try{
        // creation d’une entite persistante*
        et.begin();
        Service serv1=new Service("bouffe","Bat A, 1er étage");
        Service serv2=new Service("test2","Bat B, 1er étage");
        Service serv3=new Service("cardio","Bat C, 1er étage");
        
        em.persist(serv1);
        em.persist(serv2);
        em.persist(serv3);
        serv1.setLocalisation("Bat D, 2ème étage");
        et.commit();
    }catch(Exception ex) {
        et.rollback();
    }
    }finally{
        if(em!=null&&em.isOpen()){
            em.close();
        }
        if(emf!=null&&emf.isOpen()){
            emf.close();
        }
    }
}
}
