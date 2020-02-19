package org.formation.hackathon.dto;

public class ZupermarketDto {
    private ClientDto[] clients;
    private CheckoutDto[] checkouts;

    public ZupermarketDto() {
        //
    };
    public ZupermarketDto(ClientDto[] clients, CheckoutDto[]checkouts) {
        //
    };
    public void setClients(ClientDto[] clients) {
        this.clients = clients;
    }
    public ClientDto[] getClients(){
      return this.clients;
    }
    public CheckoutDto[] getCheckouts() {
        return this.checkouts;
    }
    public void setCheckouts(CheckoutDto[] checkouts) {
        this.checkouts = checkouts;
    }

}
