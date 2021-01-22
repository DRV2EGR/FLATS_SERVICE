package com.flats.Models.DAO;

import com.flats.Models.Owner;

import java.util.List;

public interface FlatImpl {

    public String getAdress();

    public int getNumOfRooms();

    public Owner getOwner();

    public int getPrice();

    public int getOwnerId();

    public List<String> getImgs();

}
