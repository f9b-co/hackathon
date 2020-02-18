package org.formation.hackathon.utils;
import org.formation.hackathon.dto.CheckoutDto;
import org.formation.hackathon.dto.ClientDto;
import java.util.Arrays;


public class Dispatcher {
    private ClientDto[] clients;
    private CheckoutDto[] checkouts;

    public Dispatcher(ClientDto[] clients, CheckoutDto[] checkouts){
        this.clients = clients;
        this.checkouts = checkouts;
    }
    public int totalItems(ClientDto[] clients){
        int result=0;
        for (ClientDto c: clients) {
            result =+ c.getItems();
        }
        return result;
        }
    public int totalVelocity(CheckoutDto[] checkouts){
        int result=0;
        for (CheckoutDto c: checkouts) {
            result =+ c.getVelocity();
        }
        return result;
    }
    public CheckoutDto[] sortCheckoutByVelocity(){
        Arrays.sort(checkouts);
        return checkouts;
    }






}


