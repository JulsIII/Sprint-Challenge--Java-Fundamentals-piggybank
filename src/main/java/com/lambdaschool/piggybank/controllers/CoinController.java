package com.lambdaschool.piggybank.controllers;


import com.lambdaschool.piggybank.models.Coin;
import com.lambdaschool.piggybank.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CoinController
{

    @Autowired
    CoinRepository coinrepos;

    //http://localhost:2019/total
    @GetMapping(value = "/total", produces = {"application/json"})
    public ResponseEntity<?> listPiggyBankContents()
    {
        List<Coin> myList = new ArrayList<>();
        coinrepos.findAll().iterator().forEachRemaining(myList::add);


        myList.forEach((c) -> {if(c.getQuantity() != 1) {
            System.out.println(c.getQuantity() + " " + c.getNameplural());
            } else {System.out.println(c.getQuantity() + " " + c.getName());}
        });

        double total = 0.0;
        for (Coin c : myList)
        {
            total = total + c.getQuantity() * c.getValue();
        }

        System.out.println("The Piggy Bank holds " + total);


        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
