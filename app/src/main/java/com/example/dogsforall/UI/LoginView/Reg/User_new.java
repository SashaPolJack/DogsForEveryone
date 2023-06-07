package com.example.dogsforall.UI.LoginView.Reg;

public class User_new {
    private String name_str;
    private String email;
    private String pass;
    private String id;
    private int countWalk;
    private int countTake;
    private int countSubcribe;
    private int achive;


    public int getCountWalk() {
        return countWalk;
    }

    public int getCountTake() {
        return countTake;
    }

    public int getCountSubcribe() {
        return countSubcribe;
    }

    public int getAchive() {
        return achive;
    }

    public String getDogs() {
        return dogs;
    }

    public int getDollars() {
        return dollars;
    }

    public String getDescr() {
        return descr;
    }

    private String dogs;
    private int dollars;
    private String descr = "Напиши свой девиз!";

    public User_new(String name_str, String email, String pass) {
        this.name_str = name_str;
        this.email = email;
        this.pass = pass;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName_str() {
        return name_str;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }

    public String getId() {
        return id;
    }
}
