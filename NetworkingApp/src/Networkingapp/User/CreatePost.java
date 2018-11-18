/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Networkingapp.User;

import Networkingapp.Connector.PostConnector;
import javax.swing.JOptionPane;

/**
 *
 * @author peichen
 */
public class CreatePost extends javax.swing.JFrame {

    /**
     * Creates new form CreatePost
     */
    public CreatePost() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        postTitle_txt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        postContent_txt = new javax.swing.JTextPane();
        jComboBox1 = new javax.swing.JComboBox<>();
        save_button = new javax.swing.JButton();
        cancel_button = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Title");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(80, 80, 36, 21);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Category");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 130, 80, 16);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Content");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(60, 180, 70, 21);
        getContentPane().add(postTitle_txt);
        postTitle_txt.setBounds(140, 80, 280, 26);

        jScrollPane1.setViewportView(postContent_txt);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(140, 180, 280, 180);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(140, 130, 280, 27);

        save_button.setText("Save");
        save_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                save_buttonMouseClicked(evt);
            }
        });
        getContentPane().add(save_button);
        save_button.setBounds(150, 380, 90, 29);

        cancel_button.setText("Cancel");
        cancel_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancel_buttonMouseClicked(evt);
            }
        });
        getContentPane().add(cancel_button);
        cancel_button.setBounds(330, 380, 86, 29);

        jLabel5.setFont(new java.awt.Font("Songti TC", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Create New Post");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(170, 20, 180, 35);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Networkingapp/Pictures/User-Main-background.jpg"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 500, 450);

        setSize(new java.awt.Dimension(489, 455));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void save_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_save_buttonMouseClicked
        // TODO add your handling code here:
        String pTitle = postTitle_txt.getText();
        String pContent = postContent_txt.getText();
        pTitle = pTitle.trim();
        if( pTitle.isEmpty() || pTitle.equals("")){
            JOptionPane.showMessageDialog(null, "Title Cannot Be Blank.", "CREATE ERROR", JOptionPane.ERROR_MESSAGE);
            dispose();
            return;
        }
        PostConnector.createPost(pTitle, pContent);         
        dispose();
        new UserPost().setVisible(true);
        //UserPost.refreshPostPage();
    }//GEN-LAST:event_save_buttonMouseClicked

    private void cancel_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel_buttonMouseClicked
        // TODO add your handling code here:
        dispose();
        new UserPost().setVisible(true);
    }//GEN-LAST:event_cancel_buttonMouseClicked

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
            java.util.logging.Logger.getLogger(CreatePost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreatePost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreatePost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreatePost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreatePost().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel_button;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane postContent_txt;
    private javax.swing.JTextField postTitle_txt;
    private javax.swing.JButton save_button;
    // End of variables declaration//GEN-END:variables
}
