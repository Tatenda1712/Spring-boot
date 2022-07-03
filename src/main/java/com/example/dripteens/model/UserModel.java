package com.example.dripteens.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "users")
public class UserModel {
    String fnames, lnames;
    int age;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    public UserModel() {
    }
    public UserModel(String fnames, String lnames, int age) {
        this.age=age;
        this.lnames=lnames;
        this.fnames=fnames;
    }

    public String getFnames() {
        return fnames;
    }

    public void setFnames(String fnames) {
        this.fnames = fnames;
    }

    public String getLnames() {
        return lnames;
    }

    public void setLnames(String lnames) {
        this.lnames = lnames;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }
}
