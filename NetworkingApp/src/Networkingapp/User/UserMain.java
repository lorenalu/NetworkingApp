/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Networkingapp.User;

/**
 *
 * @author Linda <lujiecanada@gmail.com>
 */
public class UserMain extends javax.swing.JFrame {

    /**
     * Creates new form UserMain
     */
    public UserMain() {
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

        editProfile_frame = new javax.swing.JInternalFrame();
        save_button = new javax.swing.JButton();
        cancel_button = new javax.swing.JButton();
        name_label = new javax.swing.JLabel();
        gender_label = new javax.swing.JLabel();
        age_label = new javax.swing.JLabel();
        about_label = new javax.swing.JLabel();
        userName_txt = new javax.swing.JFormattedTextField();
        age_txt = new javax.swing.JFormattedTextField();
        plain_label = new javax.swing.JLabel();
        editProfile_txtpanel = new javax.swing.JScrollPane();
        about_txt = new javax.swing.JTextArea();
        gender_cb = new javax.swing.JComboBox<>();
        editProfile_bg_label = new javax.swing.JLabel();
        bg_panel = new javax.swing.JPanel();
        myPost_button = new javax.swing.JButton();
        allPost_button = new javax.swing.JButton();
        editProfile_button = new javax.swing.JButton();
        msg_button = new javax.swing.JButton();
        userID_label = new javax.swing.JLabel();
        select_uID = new javax.swing.JLabel();
        logout_button = new javax.swing.JButton();
        display_txtPanel = new javax.swing.JScrollPane();
        display_txt = new javax.swing.JTextPane();
        bg_label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("User Main Page");
        setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().setLayout(null);

        editProfile_frame.setBackground(new java.awt.Color(255, 255, 255));
        editProfile_frame.setClosable(true);
        editProfile_frame.setTitle("Edit Profile");
        editProfile_frame.setVisible(false);
        editProfile_frame.getContentPane().setLayout(null);

        save_button.setText("Save");
        editProfile_frame.getContentPane().add(save_button);
        save_button.setBounds(80, 310, 90, 29);

        cancel_button.setText("Cancel");
        cancel_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancel_buttonMouseClicked(evt);
            }
        });
        editProfile_frame.getContentPane().add(cancel_button);
        cancel_button.setBounds(250, 310, 86, 29);

        name_label.setText("User Name");
        editProfile_frame.getContentPane().add(name_label);
        name_label.setBounds(49, 36, 68, 16);

        gender_label.setText("Gender");
        editProfile_frame.getContentPane().add(gender_label);
        gender_label.setBounds(49, 124, 44, 16);

        age_label.setText("Age");
        editProfile_frame.getContentPane().add(age_label);
        age_label.setBounds(49, 80, 24, 16);

        about_label.setText("About Yourself");
        editProfile_frame.getContentPane().add(about_label);
        about_label.setBounds(30, 200, 94, 16);
        editProfile_frame.getContentPane().add(userName_txt);
        userName_txt.setBounds(161, 31, 158, 26);
        editProfile_frame.getContentPane().add(age_txt);
        age_txt.setBounds(161, 75, 158, 26);

        plain_label.setForeground(new java.awt.Color(102, 102, 102));
        plain_label.setText("Not required, but suggest to fill in information.");
        editProfile_frame.getContentPane().add(plain_label);
        plain_label.setBounds(40, 280, 298, 16);

        about_txt.setColumns(20);
        about_txt.setLineWrap(true);
        about_txt.setRows(5);
        editProfile_txtpanel.setViewportView(about_txt);

        editProfile_frame.getContentPane().add(editProfile_txtpanel);
        editProfile_txtpanel.setBounds(147, 163, 190, 100);

        gender_cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Female", "Male", "Girl", "Boy", "Secret" }));
        editProfile_frame.getContentPane().add(gender_cb);
        gender_cb.setBounds(160, 120, 160, 27);

        editProfile_bg_label.setBackground(new java.awt.Color(204, 204, 204));
        editProfile_bg_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Networkingapp/Pictures/edit-profile.png"))); // NOI18N
        editProfile_frame.getContentPane().add(editProfile_bg_label);
        editProfile_bg_label.setBounds(-100, -50, 500, 450);

        getContentPane().add(editProfile_frame);
        editProfile_frame.setBounds(10, 10, 389, 381);

        bg_panel.setBackground(new java.awt.Color(255, 255, 255));
        bg_panel.setLayout(null);

        myPost_button.setText("My Post");
        myPost_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                myPost_buttonMouseClicked(evt);
            }
        });
        bg_panel.add(myPost_button);
        myPost_button.setBounds(470, 70, 93, 29);

        allPost_button.setText("All Post");
        allPost_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                allPost_buttonMouseClicked(evt);
            }
        });
        bg_panel.add(allPost_button);
        allPost_button.setBounds(470, 110, 92, 29);

        editProfile_button.setText("Edit Profile");
        editProfile_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editProfile_buttonMouseClicked(evt);
            }
        });
        bg_panel.add(editProfile_button);
        editProfile_button.setBounds(470, 210, 112, 29);

        msg_button.setText("Message");
        msg_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                msg_buttonMouseClicked(evt);
            }
        });
        bg_panel.add(msg_button);
        msg_button.setBounds(470, 160, 98, 29);

        userID_label.setText("User ID:");
        bg_panel.add(userID_label);
        userID_label.setBounds(44, 29, 50, 16);

        select_uID.setText("jLabel2");
        bg_panel.add(select_uID);
        select_uID.setBounds(112, 29, 45, 16);

        logout_button.setText("Logout");
        bg_panel.add(logout_button);
        logout_button.setBounds(470, 300, 88, 29);

        display_txt.setEditable(false);
        display_txt.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "User Profile"));
        display_txtPanel.setViewportView(display_txt);

        bg_panel.add(display_txtPanel);
        display_txtPanel.setBounds(40, 70, 383, 263);

        getContentPane().add(bg_panel);
        bg_panel.setBounds(80, 50, 600, 370);

        bg_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Networkingapp/Pictures/User-Main-background.jpg"))); // NOI18N
        getContentPane().add(bg_label);
        bg_label.setBounds(0, 0, 760, 460);

        setSize(new java.awt.Dimension(760, 482));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void myPost_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myPost_buttonMouseClicked
        // TODO add your handling code here:
        dispose();
        new MyPost().setVisible(true);
        
    }//GEN-LAST:event_myPost_buttonMouseClicked

    private void allPost_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_allPost_buttonMouseClicked
        // TODO add your handling code here:
        dispose();
        new AllPost().setVisible(true);
    }//GEN-LAST:event_allPost_buttonMouseClicked

    private void msg_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_msg_buttonMouseClicked
        // TODO add your handling code here:
        dispose();
        new Message().setVisible(true);
    }//GEN-LAST:event_msg_buttonMouseClicked

    private void editProfile_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editProfile_buttonMouseClicked
        // TODO add your handling code here:
        
        editProfile_frame.setVisible(true);
        
    }//GEN-LAST:event_editProfile_buttonMouseClicked

    private void cancel_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel_buttonMouseClicked
        // TODO add your handling code here:
        about_txt.setText(""); 
        age_txt.setText(""); 
        userName_txt.setText(""); 
        gender_cb.setSelectedIndex(0);
        editProfile_frame.setVisible(false);
        
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
            java.util.logging.Logger.getLogger(UserMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel about_label;
    private javax.swing.JTextArea about_txt;
    private javax.swing.JLabel age_label;
    private javax.swing.JFormattedTextField age_txt;
    private javax.swing.JButton allPost_button;
    private javax.swing.JLabel bg_label;
    private javax.swing.JPanel bg_panel;
    private javax.swing.JButton cancel_button;
    private javax.swing.JTextPane display_txt;
    private javax.swing.JScrollPane display_txtPanel;
    private javax.swing.JLabel editProfile_bg_label;
    private javax.swing.JButton editProfile_button;
    private javax.swing.JInternalFrame editProfile_frame;
    private javax.swing.JScrollPane editProfile_txtpanel;
    private javax.swing.JComboBox<String> gender_cb;
    private javax.swing.JLabel gender_label;
    private javax.swing.JButton logout_button;
    private javax.swing.JButton msg_button;
    private javax.swing.JButton myPost_button;
    private javax.swing.JLabel name_label;
    private javax.swing.JLabel plain_label;
    private javax.swing.JButton save_button;
    private javax.swing.JLabel select_uID;
    private javax.swing.JLabel userID_label;
    private javax.swing.JFormattedTextField userName_txt;
    // End of variables declaration//GEN-END:variables
}
