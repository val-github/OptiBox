/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import static bdd.BaseDeDonnee.enregistrerInstance;
import static bdd.BaseDeDonnee.getNameInstances;
import com.sun.beans.finder.FieldFinder;
import io.InstanceReader;
import io.ReaderException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alice
 */
public class Interface extends javax.swing.JFrame {

    /**
     * Creates new form Interface
     */
    private String instancePath;
    private String instanceName;
    public Interface() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        nomInstance = new javax.swing.JTextField();
        ajouterInstance = new javax.swing.JButton();
        InstanceSelect = new javax.swing.JComboBox<>();
        solution = new javax.swing.JButton();
        cheminInstance = new javax.swing.JTextField();
        affichageSolution = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        affichageSolution = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(1, 114, 193));

        nomInstance.setText("nomInstance");
        nomInstance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomInstanceActionPerformed(evt);
            }
        });

        ajouterInstance.setText("Ajouter");
        ajouterInstance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterInstanceActionPerformed(evt);
            }
        });

        InstanceSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        InstanceSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InstanceSelectActionPerformed(evt);
            }
        });

        solution.setText("Solution");
        solution.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solutionActionPerformed(evt);
            }
        });

        cheminInstance.setText("cheminInstance");
        cheminInstance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cheminInstanceActionPerformed(evt);
            }
        });

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
        });

            }
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nomInstance, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cheminInstance, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ajouterInstance)
                .addGap(62, 62, 62)
                .addComponent(InstanceSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(solution)
                .addContainerGap(556, Short.MAX_VALUE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(solution))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(InstanceSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(solution)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(InstanceSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(solution)))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomInstance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ajouterInstance))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cheminInstance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
                        .addComponent(cheminInstance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        affichageSolution.setColumns(20);
        affichageSolution.setRows(5);
        jScrollPane1.setViewportView(affichageSolution);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void InstanceSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InstanceSelectActionPerformed
        // TODO add your handling code here:
        //récupérer l'instance et l'afficher
    }//GEN-LAST:event_InstanceSelectActionPerformed

    private void ajouterInstanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterInstanceActionPerformed
        instanceName=nomInstance.getText();
        instancePath=cheminInstance.getText();
        if(instancePath!="cheminInstance")
        {//test ne marche pas, peut être pas besoin
            
            enregistrerInstance(instancePath, instanceName);
            rafraichirInstanceSelect();
        }
        //Ajouter Pop-up
    }//GEN-LAST:event_ajouterInstanceActionPerformed

    private void solutionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_solutionActionPerformed
        rafraichirInstanceSelect();
        System.out.println("instance");
        
        
        //System.out.println("Valeur: " + InstanceSelect.getSelectedItem().toString());  
                 //String instanceZ = System.getProperty("user.dir") + "/../instances/" +InstanceSelect.getSelectedItem().toString();
                       // reader = new InstanceReader( InstanceSelect.getSelectedItem().toString() );
                       // instance = reader.readInstance();
                
                
                    
            final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Projet");
            final EntityManager em = emf.createEntityManager();
            try{
                final EntityTransaction et = em.getTransaction();
                try{
                    
                    et.begin();
                    
                    
                    
                    solutionA = solution2(instance, 0);
                    em.persist(solutionA);
                    String affichage = solutionA.afficher();
                    affichageSolution.setText(affichage);
                    System.out.println("solution :" + solutionA );
                    et.commit();
                }catch (Exception ex) {
                    et.rollback();
                    System.err.println("rollback");
                    System.out.println(ex);
                    
                }
            } finally {
                if(em != null && em.isOpen()){
                    System.err.println("close");
                    em.close();
                }
            if(emf != null && emf.isOpen()){
                emf.close();
            }
            }
            
            
            
    }//GEN-LAST:event_solutionActionPerformed

    private void nomInstanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomInstanceActionPerformed
        
    }//GEN-LAST:event_nomInstanceActionPerformed

    private void cheminInstanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cheminInstanceActionPerformed
        
    }//GEN-LAST:event_cheminInstanceActionPerformed

    private void affichageSolutionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_affichageSolutionActionPerformed
        // TODO add your handling code here:
        while(true){
            System.out.println(solutionA.afficher());
        }
    }//GEN-LAST:event_affichageSolutionActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    
    private void rafraichirInstanceSelect()
    {
        List <String> nameInstances = new ArrayList<>();
        nameInstances = getNameInstances();
        InstanceSelect.removeAllItems();
        System.out.println("nomsInstances");
        for (String name : nameInstances)
        {
            InstanceSelect.addItem(name);
            System.out.println(name);
        }
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> InstanceSelect;
    private javax.swing.JTextArea affichageSolution;
    private javax.swing.JButton ajouterInstance;
    private javax.swing.JTextField cheminInstance;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nomInstance;
    private javax.swing.JButton solution;
    // End of variables declaration//GEN-END:variables
}
