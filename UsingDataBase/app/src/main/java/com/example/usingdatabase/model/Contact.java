package com.example.usingdatabase.model;

public class Contact {
    private int Id;
    private String Name;
    private String PhoneNumber;

    public Contact(String name, String phoneNumber) {

        // we are not giving id to it because we want database to manage our id
//      Id = id;
        Name = name;
        PhoneNumber = phoneNumber;
    }


    // IF SOMEONE GIVES ID TO IT
    public Contact(int id, String name, String phoneNumber) {
        Id = id;
        Name = name;
        PhoneNumber = phoneNumber;
    }


    // IF SOMEONE DOES'T GIVE ANYTHING
    public Contact(){

    }

// Now assigning getter and setter
// SHORTCUT cmd+n -> Getter and Setter


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
}
