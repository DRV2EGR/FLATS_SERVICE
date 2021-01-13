package com.flats.Controllers;

import com.flats.Models.Flat;
import com.flats.Models.Owner;
import com.flats.Repositiries.Flats_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

@Controller
public class restfull {

    private Flats_Repository myFlatsRep;

    @Autowired
    public restfull(Flats_Repository myFlatsRep) {
        this.myFlatsRep = myFlatsRep;
    }

    @RequestMapping(
            value = "/All",
            method = RequestMethod.GET
    )
    @ResponseBody
    public List<Owner> AllFlats() {
        myFlatsRep.refresh();

        return myFlatsRep.getOwners();
    }

    @RequestMapping(
            value = "/owners",
            method = RequestMethod.GET
    )
    public List<Owner> OwnersShow() {
        myFlatsRep.refresh();
        //System.out.println(myFlatsRep.owners);
        return myFlatsRep.getOwners();
    }

    // TODO: Добавить методы отображений просто квартиры и просто челика

    @RequestMapping("/ind")
    public String index(Model model) {
        myFlatsRep.refresh();

        model.addAttribute("flats", myFlatsRep.getFlats());
        //System.out.println(myFlatsRep.getFlats());

        return "index";
    }

    @RequestMapping(
            value = "/addOwner",
            method = RequestMethod.POST
    )
    public boolean addOwner(@RequestBody() Owner newOwner) {
        return myFlatsRep.AddOwner(newOwner.getName(), newOwner.getSecondName(), newOwner.getPhone());
    }

    @RequestMapping(
            value = "/addFlat",
            method = RequestMethod.POST
    )
    @ResponseBody
    public String addFlat(@RequestBody() Flat newFlat) {
        if (newFlat.getImgs() != null) {
            return myFlatsRep.AddFlatWithIMGs(newFlat.getAdress(), newFlat.getNumOfRooms(), newFlat.getOwnerId(), newFlat.getPrice(), newFlat.getImgs())==true?"ok":"error";
        }

        return myFlatsRep.AddFlat(newFlat.getAdress(), newFlat.getNumOfRooms(), newFlat.getOwnerId(), newFlat.getPrice())==true?"ok":"error";
    }
}