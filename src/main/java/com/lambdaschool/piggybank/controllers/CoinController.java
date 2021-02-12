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

//    private List<Coin> findCoins(List<Coin> myList, CheckCoin tester)
//    {
//        List<Coin> tempList = new ArrayList<>();
//
//        for (Coin c : myList)
//        {
//            if (tester.test(c))
//            {
//                tempList.add(c);
//            }
//        }
//
//        return tempList;
//    }

    @Autowired
    CoinRepository coinrepos;

    //http://localhost:2019/total
    @GetMapping(value = "/total", produces = {"application/json"})
    public ResponseEntity<?> listPiggyBankContents()
    {
        List<Coin> myList = new ArrayList<>();
        coinrepos.findAll().iterator().forEachRemaining(myList::add);


//        int quantity = 0;
//        for (Coin c : myList)
//        {
//            quantity = quantity + c.getQuantity();
//        }


        myList.forEach((c) -> {if(c.getQuantity() != 1) {
            System.out.println(c.getQuantity() + " " + c.getNameplural());
            } else {System.out.println(c.getQuantity() + " " + c.getName());}
        });






        System.out.println();
//        myList.forEach((c) -> System.out.println(c.getName()));
//        System.out.println();
//        myList.forEach((c) -> System.out.println(c.getNameplural()));
//        System.out.println();
//        myList.forEach((c) -> System.out.println(c.getValue()));
//        System.out.println();


//        int quantity = 0;
//        for (Coin c : myList)
//        {
//            quantity = quantity + c.getQuantity();
//        }
//
//        String name = "";
//        for (Coin c : myList)
//        {
//            name = name + c.getName();
//        }
//
//        double total = 0;
//        for (Coin c : myList)
//        {
//            total = total + c.getValue();
//        }
//
//
//            System.out.println(rtnList);
//        System.out.println(quantity + " " + name);
//        System.out.println("The Piggy Bank holds " + total);

       // System.out.println(myList);


        return new ResponseEntity<>(myList, HttpStatus.OK);
    }
}
