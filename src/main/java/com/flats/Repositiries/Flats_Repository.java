package com.flats.Repositiries;

import com.flats.Models.Flat;
import com.flats.Models.Owner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Repository
public class Flats_Repository {
    List<Owner> owners;
    List<Flat> flats;

    public boolean AddOwner(String name, String secondName, int phone) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1/postgres?currentSchema=FLATS", "postgres", "");
            // "jdbc:postgresql://localhost/postgres?currentSchema=education", "postgres", "123456"

            PreparedStatement quary = connection.prepareStatement("insert into flats.owners (name, secondName, phone) values (?, ?, ?);");

            //Set the given
            quary.setString(1, name);
            quary.setString(2, secondName);
            quary.setInt(3, phone);

            // quary is now ready
            quary.execute();

        } catch (ClassNotFoundException | SQLException e) {
            // If any exception - go away!
            System.out.println("errou");
            return false;
        }

        return true;
    }

    public boolean AddFlat(String adress, int numOfRooms, int ownerId, int price) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1/postgres?currentSchema=FLATS", "postgres", "");
            // "jdbc:postgresql://localhost/postgres?currentSchema=education", "postgres", "123456"

            /* If we dont have owner id...

            PreparedStatement quarryFindOwner = connection.prepareStatement("select id from owners where name like ? and secondName like ? and phone like ?;");

            quarryFindOwner.setString(1, owner.name);
            quarryFindOwner.setString(1, owner.secondName);
            quarryFindOwner.setString(1, String.valueOf(owner.phone));

            ResultSet resultOfQuarry = quarryFindOwner.executeQuery();

            if (!resultOfQuarry.next()) {
                return "Владелец " + owner.name + " " + owner.secondName + " " + owner.phone + " не зарегистрирован.";
            }
            */

            PreparedStatement quarryAddSellingFlatToOwner = connection.prepareStatement("insert into flats (ownerid, adress, numOfRooms, price) values (?, ?, ?, ?)");

            quarryAddSellingFlatToOwner.setInt(1, ownerId);
            quarryAddSellingFlatToOwner.setString(2, adress);
            quarryAddSellingFlatToOwner.setInt(3, numOfRooms);
            quarryAddSellingFlatToOwner.setInt(4, price);

            quarryAddSellingFlatToOwner.execute();

        } catch (ClassNotFoundException | SQLException e) {
            return false;
        }

        return true;
    }

    public boolean AddFlatWithIMGs(String adress, int numOfRooms, int ownerId, int price, List<String> imgs) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1/postgres?currentSchema=FLATS", "postgres", "");


            PreparedStatement quarryAddSellingFlatToOwner = connection.prepareStatement("insert into flats (ownerid, adress, numOfRooms, price) values (?, ?, ?, ?)");

            quarryAddSellingFlatToOwner.setInt(1, ownerId);
            quarryAddSellingFlatToOwner.setString(2, adress);
            quarryAddSellingFlatToOwner.setInt(3, numOfRooms);
            quarryAddSellingFlatToOwner.setInt(4, price);

            quarryAddSellingFlatToOwner.execute();

            // Find ID of flat------------------------
            PreparedStatement ConnflatId = connection.prepareStatement("select id from FLATS.flats where adress = ? and numOfRooms = ? and ownerId = ? and price = ?");

            //TODO: Спросить у Антона, как можно отличить две квартиры на одном этаже, от одного человека по одной цене. Без использования id

            ConnflatId.setString(1,adress);
            ConnflatId.setInt(2, numOfRooms);
            ConnflatId.setInt(3, ownerId);
            ConnflatId.setInt(4, price);

            ResultSet flatId = ConnflatId.executeQuery();
            flatId.next();
            //-----------------------------------------

            for(int i = 0; i < imgs.size(); ++i) {
                PreparedStatement addImg = connection.prepareStatement("insert into flats_imgs (flat_id, img_url) values (?, ?)");

                addImg.setInt(1, flatId.getInt("id")); // TODO: Result set not... Error whed adding an IMG here. Use DEBUGGER.
                addImg.setString(2, imgs.get(i));

                addImg.execute();
            }

        } catch (ClassNotFoundException | SQLException e) {
            return false;
        }

        return true;
    }

    public boolean refresh() {
        owners.clear();
        flats.clear();

        try {
            Class.forName("org.postgresql.Driver");

            Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1/postgres?currentSchema=FLATS", "postgres", "");
            // "jdbc:postgresql://localhost/postgres?currentSchema=education", "postgres", "123456"

            Statement statment = connection.createStatement();

            ResultSet resultOwners = statment.executeQuery("select id, name, secondName, phone from FLATS.owners");

            while (resultOwners.next()) {
                owners.add(new Owner(resultOwners.getString("name"), resultOwners.getString("secondName"), resultOwners.getInt("phone")));

                PreparedStatement quarryForGetFlats = connection.prepareStatement("select adress, numOfRooms, price from FLATS.flats where ownerid = ?");

                quarryForGetFlats.setInt(1, resultOwners.getInt("id"));

                try {
                    ResultSet resultFlatsForCurrentOwner = quarryForGetFlats.executeQuery();
                    while (resultFlatsForCurrentOwner.next()) {
                        flats.add(new Flat(resultFlatsForCurrentOwner.getString("adress"), resultFlatsForCurrentOwner.getInt("numOfRooms"), owners.get(owners.size() - 1).getId(), resultFlatsForCurrentOwner.getInt("price")));
                    }
                } catch (SQLException e) {
                    // pass
                }
            }

        } catch (ClassNotFoundException | SQLException e) {
            //System.out.println(e);
            return false;
        }

        //System.out.println(owners.size());
        return true;
    }


    public Flats_Repository() {
        this.flats = new ArrayList<Flat>();
        this.owners = new ArrayList<Owner>();

        refresh();
    }

    public List<Owner> getOwners() {
        return owners;
    }

    public List<Flat> getFlats() {
        return flats;
    }
}
