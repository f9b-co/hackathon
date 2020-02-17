package org.formation.hackathon.dto;

public class CheckoutDto {

    private int id;

    private int velocity;

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
}
