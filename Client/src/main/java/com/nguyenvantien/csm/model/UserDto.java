package com.nguyenvantien.csm.model;

public class UserDto {
    private String userName;
    private String id;
    private String role;
    public UserDto(){
        
    }
    
    public UserDto(String userName, String id, String role) {
        this.userName = userName;
        this.id = id;
        this.role = role;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    

    public String getUserName() {
        return userName;
    }

    public String getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "User{" + "userName=" + userName + ", id=" + id + ", role=" + role + '}';
    }
    
    
    
}
