package controller;

import dto.CheckoutDto;
import dto.ClientDto;
import dto.ZupermarketDto;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;


@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class Zupermarket {
    @PostMapping("/shop")
    public void populateQueue(@Valid @RequestBody ZupermarketDto zupermarketDto )
    {
        ArrayList<ClientDto> clients = zupermarketDto.getClients();
        ArrayList<CheckoutDto> checkouts = zupermarketDto.getCheckouts();

        for(ClientDto client : clients) {
            System.out.println("Client n°"+client.getId());
        }
        for(CheckoutDto checkout : checkouts){
            System.out.println("Caisse n°"+checkout.getId());
        }

    }
    @GetMapping()
    public String message(){
        return "toto";
    }

}
