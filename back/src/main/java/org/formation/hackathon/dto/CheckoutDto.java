package org.formation.hackathon.dto;

public class CheckoutDto implements Comparable<CheckoutDto>{

    private int id;
    private int velocity;

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setQueue(ClientDto[] queue) {
        this.queue = queue;
    }

    public int getCapacity() {
        return capacity;
    }

    public ClientDto[] getQueue() {
        return queue;
    }

    private int capacity;

    private ClientDto[] queue;

    public int getId(){
        return id;
    }

    public int getVelocity(){
        return velocity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    @Override
    public int compareTo(CheckoutDto checkoutDto) {
        return checkoutDto.getVelocity() - this.velocity;
    }
}
