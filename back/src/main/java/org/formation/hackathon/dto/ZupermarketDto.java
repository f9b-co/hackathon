package org.formation.hackathon.dto;

import java.util.ArrayList;

public class ZupermarketDto {
    private  ClientDto[] clients;
    private CheckoutDto[] checkouts;

    public ZupermarketDto() {
        //
    };
    public ZupermarketDto(ClientDto[] clients, CheckoutDto[]checkouts) {
        //
    };

    public ClientDto[] getClients(){
        return this.clients;
    }
    public void setClients(ClientDto[] clients) {
        this.clients = clients;
    }
    public CheckoutDto[] getCheckouts(){
        return this.checkouts;
    }
    public void setCheckouts(CheckoutDto[] checkouts) {
        this.checkouts = checkouts;
    }

}
