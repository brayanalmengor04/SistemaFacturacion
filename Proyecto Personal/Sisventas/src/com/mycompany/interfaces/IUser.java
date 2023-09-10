
package com.mycompany.interfaces;

import com.mycompany.objects.User;
import java.util.ArrayList;

public interface IUser {
    int insertUser (User userIN);
    int updateUser (User userUP); 
    User selectLoginUser (User searchUser);  
    User selectUserLoginGmail (User userGmail);
    ArrayList<User> selectUserAll();
    int deleteUser(User userDEL);
    
}
