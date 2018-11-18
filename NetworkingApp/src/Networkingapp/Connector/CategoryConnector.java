/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Networkingapp.Connector;

import Networkingapp.Database.DatabaseManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author peichen
 */
public class CategoryConnector {
    
    
    // (mode == 0) AllPost
    // (mode == 1) MyPost
    // Select...From...Where
    public static ResultSet getCategory(int mode){
        ResultSet res = null;
        
        try {
            DatabaseManager dbm = DatabaseManager.getInstance();
            if(mode == 1){
                res = dbm.queryWithPrepareStatement ("SELECT * FROM Post WHERE user_ID = ?", 
                                                            UserConnector.getUserID());
            }
            res = dbm.queryWithPrepareStatement ("SELECT * FROM Post, Post_Category WHERE Post.post_ID = Post_Category.post_ID");
        } catch (SQLException ex) {
            Logger.getLogger(PostConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return res;
    }
}
