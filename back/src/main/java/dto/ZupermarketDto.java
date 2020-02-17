package dto;

import java.util.ArrayList;

public class ZupermarketDto {
    private ArrayList<ClientDto> clients;
    private ArrayList<CheckoutDto> checkoutDtos;
    public ZupermarketDto(){};

    public  ZupermarketDto(ArrayList<ClientDto>clients,ArrayList<CheckoutDto>checkouts){
    };

    public ArrayList<ClientDto> getClients(){
        return this.clients;
    }
    public ArrayList<CheckoutDto> getCheckouts(){
        return this.checkoutDtos;
    }


}
