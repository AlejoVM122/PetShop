package com.Alejandro.PetShop.Model;

public class Usuario {



    //Atributos
    public String UserName;

    public String Pasword;



    //Usuario constructor
    public Usuario( String userName, String pasword) {
        this.UserName = userName;
        this.Pasword = pasword;
    }

    //constructor vacio

    public Usuario (){

    }


    //Metodos

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPasword() {
        return Pasword;
    }

    public void setPasword(String pasword) {
        Pasword = pasword;
    }
}
