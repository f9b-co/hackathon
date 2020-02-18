package org.formation.hackathon.controller;

import org.formation.hackathon.dto.CheckoutDto;
import org.formation.hackathon.dto.ClientDto;
import org.formation.hackathon.dto.ZupermarketDto;
import org.formation.hackathon.utils.Dispatcher;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class Zupermarket {
    @PostMapping("/shop")
    public void populateQueue(@Valid @RequestBody ZupermarketDto zupermarketDto )
    {
        ClientDto[] clients = zupermarketDto.getClients();
        CheckoutDto[] checkouts = zupermarketDto.getCheckouts();

        Dispatcher dispatcher = new Dispatcher(clients, checkouts);
        dispatcher.sortCheckoutByVelocity();
        dispatcher.dispatch();
        for(ClientDto client : clients) {
            System.out.println("Client n°"+client.getId()+", "+client.getItems()+" items.");
        }
        for(CheckoutDto checkout : checkouts){
            System.out.println("Caisse n°"+checkout.getId()+", "+checkout.getVelocity()+" items/min.");
        }
    }


}
