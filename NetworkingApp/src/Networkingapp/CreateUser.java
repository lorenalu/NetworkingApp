/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Networkingapp;

import Networkingapp.Database.DatabaseManager;
import java.sql.*;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.*;
/**
 *
 * @author Jade
 */
public class CreateUser extends javax.swing.JFrame {
     private Connection con;
//    String newUserID;
//    String newUserPassword;
//    String newUserName;
//    String newUserAge;
//    String newUserLocation;
//    String newUserGender;

    /**
     * Creates new form CreateUser
     */
    public CreateUser() {
        initComponents();
        
       
    }
    
    private void createNewUser(String uId, String upassword) {
        System.out.println("insert into App_User values ('u"
                + uId + "','" + upassword + "')");
        String createU = "insert into App_User values ('u"
                + uId + "','" + upassword + "')";
        // uId = "u" + uId;
        DatabaseManager dbm = DatabaseManager.getInstance();
        try {
            dbm.updateStatement(createU);
            
            } 
        
        catch (SQLException ex) {
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            JOptionPane.showMessageDialog(frame, "This User ID has already been used", "ERROR", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(CreateUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void createNewUserProfile(String uid, String uName, String uAge, String uLoc, String uGender) {
        DatabaseManager dbm = DatabaseManager.getInstance();
        String profileID = "p" + uid;
        uid = "u" + uid;
        String createProfile = "INSERT INTO PROFILE values('" + profileID + "','" + uName 
                + "','" + uAge + "','" + uLoc + "','" + uGender + "','" + uid + "')";
        System.out.println("INSERT INTO PROFILE values('" + profileID + "','" + uName 
                + "','" + uAge + "','" + uLoc + "','" + uGender + "','" + uid + "')");
        try {
            dbm.updateStatement(createProfile);
            } 
        catch (SQLException ex) {
            Logger.getLogger(CreateUser.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        uPassword = new javax.swing.JPasswordField();
        uAge = new javax.swing.JTextField();
        uHometown = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        uName = new javax.swing.JTextField();
        signUpButton = new javax.swing.JButton();
        uGender = new javax.swing.JComboBox<>();
        UserIDjText = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        jLabel1.setText("Welcome, new friend!");

        jPanel5.setBackground(new java.awt.Color(0, 18, 50));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Welcome to new world!");
        setBackground(new java.awt.Color(255, 255, 255));
        setSize(new java.awt.Dimension(1089, 436));
        getContentPane().setLayout(null);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(805, 301, 0, 0);

        jPanel2.setBackground(new java.awt.Color(32, 47, 90));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 0, 0);

        jLabel8.setFont(new java.awt.Font("Sinhala Sangam MN", 1, 24)); // NOI18N
        jLabel8.setText("Hello New Friend! Tell us about yourself");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(174, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(190, 0, 620, 80);

        jPanel4.setBackground(new java.awt.Color(32, 47, 90));

        uPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                uPasswordFocusGained(evt);
            }
        });

        uAge.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                uAgeFocusGained(evt);
            }
        });
        uAge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uAgeActionPerformed(evt);
            }
        });

        uHometown.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                uHometownFocusGained(evt);
            }
        });
        uHometown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uHometownActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Sinhala Sangam MN", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Your Password*:");

        jLabel4.setFont(new java.awt.Font("Sinhala Sangam MN", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Your Name:");

        jLabel5.setFont(new java.awt.Font("Sinhala Sangam MN", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Your Age:");

        jLabel9.setFont(new java.awt.Font("Sinhala Sangam MN", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Your User Id*:");

        jLabel6.setFont(new java.awt.Font("Sinhala Sangam MN", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Your Location:");

        jLabel7.setFont(new java.awt.Font("Sinhala Sangam MN", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Your Gender:");

        uName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                uNameFocusGained(evt);
            }
        });
        uName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                uNameMouseClicked(evt);
            }
        });
        uName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uNameActionPerformed(evt);
            }
        });

        signUpButton.setBackground(new java.awt.Color(255, 255, 255));
        signUpButton.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        signUpButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Networkingapp/Pictures/internationalIcon.png"))); // NOI18N
        signUpButton.setText("Sign Up!");
        signUpButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signUpButtonMouseClicked(evt);
            }
        });
        signUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpButtonActionPerformed(evt);
            }
        });

        uGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "......", "Secret", "Female", "Male", "Alien" }));
        uGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uGenderActionPerformed(evt);
            }
        });

        UserIDjText.setText("7 digits, numeric only");
        UserIDjText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                UserIDjTextFocusGained(evt);
            }
        });
        UserIDjText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UserIDjTextMouseClicked(evt);
            }
        });
        UserIDjText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserIDjTextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(signUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(228, 228, 228))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(uHometown, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(uAge, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(uPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(uName, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UserIDjText, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(117, 117, 117))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(uGender, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(UserIDjText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(uPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(uName, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(uAge, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(uHometown, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(uGender, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(signUpButton)
                .addGap(19, 19, 19))
        );

        getContentPane().add(jPanel4);
        jPanel4.setBounds(0, 80, 680, 360);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Networkingapp/Pictures/SmallUserIcon.png"))); // NOI18N
        jLabel10.setText("jLabel10");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(60, 10, 51, 42);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void uAgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uAgeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uAgeActionPerformed

    private void uGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uGenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uGenderActionPerformed

    private void uHometownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uHometownActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uHometownActionPerformed

    private void signUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_signUpButtonActionPerformed

    private void uNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uNameMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_uNameMouseClicked

    private void UserIDjTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UserIDjTextMouseClicked
        // TODO add your handling code here:
        UserIDjText.setText("");
    }//GEN-LAST:event_UserIDjTextMouseClicked

    private void UserIDjTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserIDjTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserIDjTextActionPerformed

    private void UserIDjTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UserIDjTextFocusGained
        // TODO add your handling code here:
        // jtextField.setText(""); 
        UserIDjText.setText("");
    }//GEN-LAST:event_UserIDjTextFocusGained

    private void uNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uNameActionPerformed

    private void signUpButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signUpButtonMouseClicked
        // TODO add your handling code here:
        
        String iUloc = uHometown.getText();
        String iUID = UserIDjText.getText();
        String iUpassword = String.valueOf(uPassword.getPassword());
        String iUname = uName.getText();
        String iUage = uAge.getText();
        String iUgender = String.valueOf(uGender.getSelectedItem());
        
        if (iUID.length() > 7) {
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            JOptionPane.showMessageDialog(frame, "User ID cannot have more than 7 digits", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (iUpassword.length()==0) {
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            JOptionPane.showMessageDialog(frame, "User password cannot be empty", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;     
        }
        createNewUser(iUID, iUpassword);
        if (iUname != "" && iUloc != "" && iUage != ""&& iUgender != "......") {
            createNewUserProfile (iUID,iUname , iUage, iUloc, iUgender);
            System.out.println(iUID + " " + iUpassword + " "+ iUname + iUgender);
        } else {
            System.out.println("No profile is created for user " + iUID);
        }
        JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                JOptionPane.showMessageDialog(frame, "Your user id is u" + iUID ,"Welcome! "+uName, JOptionPane.INFORMATION_MESSAGE);
            dispose();
            new FirstPage().setVisible(true);
    }//GEN-LAST:event_signUpButtonMouseClicked

    private void uPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_uPasswordFocusGained
        // TODO add your handling code here:
        uPassword.setText("");
    }//GEN-LAST:event_uPasswordFocusGained

    private void uNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_uNameFocusGained
        uName.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_uNameFocusGained

    private void uAgeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_uAgeFocusGained
        // TODO add your handling code here:
        uAge.setText("");
    }//GEN-LAST:event_uAgeFocusGained

    private void uHometownFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_uHometownFocusGained
        // TODO add your handling code here:
        uHometown.setText("");
    }//GEN-LAST:event_uHometownFocusGained

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
            java.util.logging.Logger.getLogger(CreateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField UserIDjText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton signUpButton;
    private javax.swing.JTextField uAge;
    private javax.swing.JComboBox<String> uGender;
    private javax.swing.JTextField uHometown;
    private javax.swing.JTextField uName;
    private javax.swing.JPasswordField uPassword;
    // End of variables declaration//GEN-END:variables
}
