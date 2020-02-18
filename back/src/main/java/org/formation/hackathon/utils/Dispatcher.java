package org.formation.hackathon.utils;

import org.formation.hackathon.dto.CheckoutDto;
import org.formation.hackathon.dto.ClientDto;

import java.util.Arrays;


public class Dispatcher {
    private ClientDto[] clients;
    private int totalItems;

    public int getQueueLength() {
        return queueLength;
    }

    public void setQueueLength(int queueLength) {
        this.queueLength = queueLength;
    }

    private int queueLength;
    private int totalVelocity;
    private CheckoutDto[] checkouts;

    public Dispatcher(ClientDto[] clients, CheckoutDto[] checkouts) {
        this.clients = clients;
        this.checkouts = checkouts;
        this.queueLength = clients.length;
        this.totalItems = calcTotalItems(clients);
        this.totalVelocity = calcTotalVelocity(checkouts);
    }

    private int calcTotalItems(ClientDto[] clients) {
        int result = 0;
        for (ClientDto c : clients) {
            result = +c.getItems();
        }
        return result;
    }


    private int calcTotalVelocity(CheckoutDto[] checkouts) {
        int result = 0;
        for (CheckoutDto c : checkouts) {
            result = +c.getVelocity();
        }
        return result;
    }


    public CheckoutDto[] sortCheckoutByVelocity() {
        Arrays.sort(checkouts);
        return checkouts;
    }

    public void dispatch() {
        for (CheckoutDto c : checkouts) {
            c.setQueue(new ClientDto[this.queueLength]);
            c.setCapacity(c.getVelocity()/this.totalVelocity*totalItems);
            c.setLastEmptyIndex(queueLength-1);

        }
        for (ClientDto cl: clients)
        {
            for (CheckoutDto c: checkouts) {
                if(c.getCapacity()>=cl.getItems()){
                    c.getQueue()[c.getLastEmptyIndex()]=cl;
                    c.setLastEmptyIndex(c.getLastEmptyIndex()-1);
                    c.setCapacity(c.getCapacity()-cl.getItems());
                    System.out.println(c);
                }
                else{
                    checkouts[0].getQueue()[c.getLastEmptyIndex()]=cl;
                    checkouts[0].setLastEmptyIndex(checkouts[0].getLastEmptyIndex()-1);
                    checkouts[0].setCapacity(checkouts[0].getCapacity()-cl.getItems());
                    System.out.println(checkouts[0]);
                }
            }
        }


    }


}


