/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.anurag.navigatingtheskies.models;

/**
 *
 * @author guler
 */
public class Passenger {
    private String userName;
    private String name;
    private String mail;
    private String tel;
    private int age;
    private String gender;
    private String password;
    
    public Passenger(){}
    
    public void setUserName(String userName){
        this.userName = userName;
    }
    
    public String getUserName(){
        return userName;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public void setMail(String mail){
        this.mail = mail;
    }
    
    public String getMail(){
        return mail;
    }
    
    public void setTel(String tel){
        this.tel = tel;
    }
    
    public String getTel(){
        return tel;
    }
    
    public void setAge(int age){
        this.age = age;
    }
    
    public int getAge(){
        return age;
    }
    
    public void setGender(String gender){
        this.gender = gender;
    }
    
    public String getGender(){
        return  gender;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getPassword(){
        return password;
    }
}
