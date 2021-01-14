package com.flats.Models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Flat {
    String adress;
    int numOfRooms;
    Owner owner;
    int price;
    int ownerId;
    List<String> imgs;

    @JsonCreator
    public Flat(@JsonProperty("adress") String adress, @JsonProperty("numOfRooms") int numOfRooms, @JsonProperty("ownerId") int ownerId, @JsonProperty("price") int price, @JsonProperty("imgs") List<String> imgs) {
        this.adress = adress;
        this.numOfRooms = numOfRooms;
        this.ownerId = ownerId;
        this.price = price;
        this.imgs = imgs;
    }

    @JsonCreator
    public Flat(@JsonProperty("adress") String adress, @JsonProperty("numOfRooms") int numOfRooms, @JsonProperty("ownerId") int ownerId, @JsonProperty("price") int price) {
        this.adress = adress;
        this.numOfRooms = numOfRooms;
        this.ownerId = ownerId;
        this.price = price;

        this.imgs = new ArrayList<>();
    }

    @JsonCreator
    public Flat(@JsonProperty("adress") String adress, @JsonProperty("numOfRooms") int numOfRooms, @JsonProperty("owner") Owner owner, @JsonProperty("price") int price, @JsonProperty("imgs") List<String> imgs) {
        this.adress = adress;
        this.numOfRooms = numOfRooms;
        this.owner = owner;
        this.price = price;
        this.imgs = imgs;
    }

    @JsonCreator
    public Flat(@JsonProperty("adress") String adress, @JsonProperty("numOfRooms") int numOfRooms, @JsonProperty("owner") Owner owner, @JsonProperty("price") int price) {
        this.adress = adress;
        this.numOfRooms = numOfRooms;
        this.owner = owner;
        this.price = price;

        this.imgs = new ArrayList<>();
    }



    public String getAdress() {
        return adress;
    }

    public int getNumOfRooms() {
        return numOfRooms;
    }

    public Owner getOwner() {
        return owner;
    }

    public int getPrice() { return price; }

    public int getOwnerId() { return ownerId; }

    public List<String> getImgs() { return imgs; }

    public String getImgByIndex(int index) {
        if (index + 1 <= imgs.size() ) {
            return imgs.get(index);
        }

        return "";
    }
}
