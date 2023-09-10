package com.mycompany.implemations;

import static com.mycompany.data.Conexion.*;
import com.mycompany.interfaces.IUser;
import com.mycompany.objects.User;
import java.util.ArrayList;
import java.sql.*;
import javax.swing.JOptionPane;

public class IMUser implements IUser{

    private static final String INSERT_USER ="call sp_insert_user(?,?,?,?,?)"; 
    private static final String UPDATE_USER ="call sp_update_user(?,?,?,?,?)"; 
    private static final String SELECT_LOGINGMAIL ="call sp_select_user_logingmail(?,?)"; 
    private static final String SELECT_LOGINUSER="call sp_select_loginuser(?,?)";  
    private static final String SELECT_ALL ="call sp_select_user_all ";
    private static final String DELETE_USER ="call sp_delete_user(?)";
    @Override
    public int insertUser(User userIN) { 
        Connection connect =null; 
        PreparedStatement staments =null; 
        int results =0;
        
        try {
            connect = getConnection(); 
            staments = connect.prepareCall(INSERT_USER); 
            staments.setString(1,userIN.getUsername()); 
            staments.setString(2,userIN.getName()); 
            staments.setString(3,userIN.getLastame()); 
            staments.setString(4,userIN.getPassword()); 
            staments.setString(5,userIN.getGmail());   
            
            results= staments.executeUpdate(); 
           
        } catch (SQLException ex) { 
            JOptionPane.showMessageDialog(null, ex.getMessage()); 
        } 
        
        return results;
    }

    @Override
    public int updateUser(User userUP) { 
         Connection connect =null; 
        PreparedStatement staments =null; 
        int results =0;
        
        try {
            connect = getConnection(); 
            staments = connect.prepareCall(UPDATE_USER); 
            staments.setString(1,userUP.getUsername()); 
            staments.setString(2,userUP.getName()); 
            staments.setString(3,userUP.getLastame()); 
            staments.setString(4,userUP.getPassword()); 
            staments.setString(5,userUP.getGmail());   
            
            results= staments.executeUpdate();
        } catch (SQLException ex) { 
            JOptionPane.showMessageDialog(null, ex.getMessage()); 
           
        }
        return results;
    }

    @Override
    public User selectLoginUser(User searchUser) {
          Connection connect =null; 
        PreparedStatement staments =null;  
        ResultSet resultset =null;
        User user =null;
        
        try {
            connect = getConnection(); 
            staments = connect.prepareCall(SELECT_LOGINUSER); 
            staments.setString(1,searchUser.getUsername()); 
            staments.setString(2,searchUser.getPassword()); 
            
            resultset = staments.executeQuery(); 
            
            while (resultset.next()){
                String username = resultset.getString("username");
                String name = resultset.getString("name");
                String lastname = resultset.getString("lastname"); 
                String password = resultset.getString("password");
                String gmail = resultset.getString("gmail"); 
                
               user = new User(username,name,lastname,password,gmail);
            }
            
            
        } catch (SQLException ex) { 
            JOptionPane.showMessageDialog(null, ex.getMessage()); 
            return user =null;
        }
        return user;
    }

    @Override
    public User selectUserLoginGmail(User userGmail){ 
        Connection connect =null; 
        PreparedStatement staments =null;  
        ResultSet resultset =null;
        User user =null;
        
        try {
            connect = getConnection(); 
            staments = connect.prepareCall(SELECT_LOGINGMAIL); 
            staments.setString(1,userGmail.getGmail()); 
            staments.setString(2,userGmail.getPassword()); 
            
            resultset = staments.executeQuery(); 
            
            while (resultset.next()){
                String username = resultset.getString("username");
                String name = resultset.getString("name");
                String lastname = resultset.getString("lastname"); 
                String password = resultset.getString("password");
                String gmail = resultset.getString("gmail"); 
                
               user = new User(username,name,lastname,password,gmail);
            }
            
            
        } catch (SQLException ex) { 
            JOptionPane.showMessageDialog(null, ex.getMessage()); 
            return user =null;
        }
        return user;
    }

    @Override
    public ArrayList<User> selectUserAll(){
        ArrayList<User> listUser = new ArrayList<>(); 
        
        Connection connect =null; 
        PreparedStatement staments =null;   
        ResultSet resultset =null;
        User user =null;
        
        try {
            connect = getConnection(); 
            staments = connect.prepareCall(SELECT_ALL); 
            
            resultset = staments.executeQuery(); 
            
            while (resultset.next()){
                String username = resultset.getString("username");
                String name = resultset.getString("name");
                String lastname = resultset.getString("lastname"); 
                String password = resultset.getString("password");
                String gmail = resultset.getString("gmail");  
                String registrationDate = resultset.getString("registrationDate");
                String updateDate = resultset.getString("updateDate");
               user = new User(username,name,lastname,password,gmail,registrationDate,updateDate); 
               listUser.add(user);  
               
            }
            
            
        } catch (SQLException ex) { 
            JOptionPane.showMessageDialog(null, ex.getMessage()); 
        } 
        return listUser;
    }

    @Override
    public int deleteUser(User userDEL) {
         Connection connect =null; 
        PreparedStatement staments =null; 
        int results =0;
        
        try {
            connect = getConnection(); 
            staments = connect.prepareCall(DELETE_USER); 
            staments.setString(1,userDEL.getUsername()); 
            
            results= staments.executeUpdate(); 
           
        } catch (SQLException ex) { 
            JOptionPane.showMessageDialog(null, ex.getMessage()); 
        } 
        
        return results;
    }
    
}
