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
//    public static ResultSet getCategory(int mode){
//        ResultSet res = null;
//        
//        try {
//            DatabaseManager dbm = DatabaseManager.getInstance();
//            if(mode == 1){
//                res = dbm.queryWithPrepareStatement ("SELECT * FROM Post WHERE user_ID = ?", 
//                                                            UserConnector.getUserID());
//            }
//            res = dbm.queryWithPrepareStatement ("SELECT * FROM Post, Post_Category WHERE Post.post_ID = Post_Category.post_ID");
//        } catch (SQLException ex) {
//            Logger.getLogger(PostConnector.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        
//        
//        return res;
//    }
    
    public static ResultSet getSelectedPostCategory(String postID){
        ResultSet res = null;
        String pID = postID.trim();
        
        try {
            DatabaseManager dbm = DatabaseManager.getInstance();
            res = dbm.queryWithPrepareStatement ("SELECT * FROM Post, Post_Category "
                                                 + "WHERE Post.post_ID = Post_Category.post_ID "
                                                    + "AND Post.post_ID = ?", postID);
        } catch (SQLException ex) {
            Logger.getLogger(PostConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return res;
        
    }
    
    
    public static ResultSet getAllCategoryName(){
        ResultSet res = null;

        try {
            DatabaseManager dbm = DatabaseManager.getInstance();
            res = dbm.queryWithPrepareStatement ("SELECT category_Name FROM Category");
        } catch (SQLException ex) {
            Logger.getLogger(CategoryConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
        
    }
    public static void delCategory(String postID){
        int res;
        String pID = postID.trim();
        DatabaseManager dbm = DatabaseManager.getInstance();
        try {
            res = dbm.updateWithPrepareStatement ("DELETE FROM Post_Category WHERE post_ID = ?", pID);
        } catch (SQLException ex) {
            Logger.getLogger(CategoryConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void insertCategory(String pID, String cName){
        //int res = 0;
        DatabaseManager dbm = DatabaseManager.getInstance();
        try {
            int res = dbm.updateWithPrepareStatement ("INSERT INTO Post_Category(post_ID, category_Name) "
                    + "VALUES(?,?)", pID, cName);
        } catch (SQLException ex) {
            Logger.getLogger(CategoryConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
