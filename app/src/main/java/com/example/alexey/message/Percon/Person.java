package com.example.alexey.message.Percon;

import android.graphics.Bitmap;
import android.net.Uri;

import java.util.HashMap;

public class Person {

    private String name, name_second, name_third, mail, phone, gender, login, password;
    private Bitmap selectedImage;
    public static HashMap<String, Person> hm = new HashMap<>();

    public Person(String name, String name_second, String name_third, String mail, String phone, String gender, String login, String password, Bitmap selectedImage) {
        this.name = name;
        this.name_second = name_second;
        this.name_third = name_third;
        this.mail = mail;
        this.phone = phone;
        this.gender = gender;
        this.login = login;
        this.password = password;
        this.selectedImage = selectedImage;
    }

    public Bitmap getSelectedImage() {
        return selectedImage;
    }

    public void setSelectedImage(Bitmap selectedImage) {
        this.selectedImage = selectedImage;
    }

    public String getfullName() {
        return name_second + " " + name + " " + name_third;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName_second() {
        return name_second;
    }

    public void setName_second(String name_second) {
        this.name_second = name_second;
    }

    public String getName_third() {
        return name_third;
    }

    public void setName_third(String name_third) {
        this.name_third = name_third;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
