
package com.mycompany.objects;

public class User {
    private String username , name ,lastame,password,gmail ,registrationDate,updateDate; 

    public User() {
    }

    public User(String username, String name, String lastame, String password, String gmail, String registrationDate, String updateDate) {
        this.username = username;
        this.name = name;
        this.lastame = lastame;
        this.password = password;
        this.gmail = gmail;
        this.registrationDate = registrationDate;
        this.updateDate = updateDate;
    }

    public User(String username, String name, String lastame, String password, String gmail) {
        this.username = username;
        this.name = name;
        this.lastame = lastame;
        this.password = password;
        this.gmail = gmail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastame() {
        return lastame;
    }

    public void setLastame(String lastame) {
        this.lastame = lastame;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }
    
    
}
