package com.flats.Models;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Owner {
    String name;
    String secondName;
    int phone;
    int id;

    @JsonCreator
    public Owner(@JsonProperty("name") String name, @JsonProperty("secondName") String secondName, @JsonProperty("phone") int phone) {
        this.name = name;
        this.secondName = secondName;
        this.phone = phone;
    }

    @JsonCreator
    public Owner(@JsonProperty("name") String name, @JsonProperty("secondName") String secondName, @JsonProperty("phone") int phone, @JsonProperty("id") int id) {
        this.name = name;
        this.secondName = secondName;
        this.phone = phone;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getPhone() {
        return phone;
    }

    public int getId() { return id; }

    @Override
    public String toString() {
        return "<h2>Owner</h2> {" +
                "name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", phone=" + phone +
                '}';
    }
}
