/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Networkingapp;

/**
 *
 * @author Linda <lujiecanada@gmail.com>
 */
public class NetworkingApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Login login = new Login();
                login.setVisible(true);
                login.setSize(620,370);
                login.setLocationRelativeTo(null);
            }
        });
    }
    
}
