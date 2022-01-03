/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ProTech
 */
public class signUpController {
                conn con = new conn();
    public int signUP(String username, String name, String pass, String combobox1, String ans){
         int i = 0;            
        try {
                        String sql = "insert into account(username, name, password, sec_q, sec_ans) values(?, ?, ?, ?, ?)";
                        PreparedStatement st = con.c.prepareStatement(sql);
                        
                        st.setString(1, username);
                        st.setString(2, name);
                        st.setString(3,pass);
                        st.setString(4, combobox1);
                        st.setString(5, ans);
                           
                       i = st.executeUpdate();
                        return i;
                    } catch (SQLException ex) {
                        Logger.getLogger(signUpController.class.getName()).log(Level.SEVERE, null, ex);
                    }
        return i;
    }
}
