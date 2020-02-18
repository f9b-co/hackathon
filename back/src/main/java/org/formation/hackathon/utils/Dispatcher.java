package org.formation.hackathon.utils;

import org.formation.hackathon.dto.CheckoutDto;
import org.formation.hackathon.dto.ClientDto;

import java.util.Arrays;

public class Dispatcher {
    private ClientDto[] clients;
    private CheckoutDto[] checkouts;
    private int totalItems;
    private int queueLength;
    private int totalVelocity;

    public Dispatcher(ClientDto[] clients, CheckoutDto[] checkouts) {
        this.clients = clients;
        this.checkouts = checkouts;
        this.queueLength = clients.length;
        this.totalItems = calcTotalItems(clients);
        this.totalVelocity = calcTotalVelocity(checkouts);
    }

    public int getQueueLength() {
        return queueLength;
    }
    public void setQueueLength(int queueLength) {
        this.queueLength = queueLength;
    }

    private int calcTotalItems(ClientDto[] clients) {
        int result = 0;
        for (ClientDto c : clients) {
            result += c.getItems();
        }
        return result;
    }
    private int calcTotalVelocity(CheckoutDto[] checkouts) {
        int result = 0;
        for (CheckoutDto c : checkouts) {
            result += c.getVelocity();
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
            double capacity = c.getVelocity()/(double)this.totalVelocity*this.totalItems;
            c.setCapacity((int)capacity);
            c.setLastEmptyIndex(queueLength-1);
            System.out.println(c);
        }
        for (int i = 0; i < clients.length; i++) {
            ClientDto cl = clients[i];
            double maxCapacity = 0.0;
            int bestCheckout = 0;
            for (int j = 0; j < checkouts.length && !(cl.isQueued()); j++) {
                CheckoutDto c = checkouts[j];
                if(c.getCapacity()>=cl.getItems()) {
                    c.getQueue()[c.getLastEmptyIndex()]=cl;
                    c.setLastEmptyIndex(c.getLastEmptyIndex()-1);
                    c.setCapacity(c.getCapacity()-cl.getItems());
                    cl.setQueued(true);
                    //System.out.println(c);
                }
            }
            if (!(cl.isQueued())) {
                for (int k = 0; k < checkouts.length; k++) {
                    CheckoutDto c = checkouts[k];
                    if (maxCapacity <= c.getCapacity()) {
                        maxCapacity = c.getCapacity();
                        bestCheckout = k;
                    }
                }
                CheckoutDto c = checkouts[bestCheckout];
                c.getQueue()[c.getLastEmptyIndex()]=cl;
                c.setLastEmptyIndex(c.getLastEmptyIndex()-1);
                c.setCapacity(c.getCapacity()-cl.getItems());
                cl.setQueued(true);
                //System.out.println(c);
            }
        }
        System.out.println("-----------------------------");
        for (CheckoutDto c : checkouts) {
            System.out.println(c);
        }
    }
}


