package org.formation.hackathon.dto;

import java.util.Arrays;

public class CheckoutDto implements Comparable<CheckoutDto> {

    private int id;
    private int velocity;
    private int capacity;
    private int doneItems;
    private ClientDto[] queue;
    private int lastEmptyIndex;

    public int getDoneItems() {
        return doneItems;
    }

    public void setDoneItems(int doneItems) {
        this.doneItems = doneItems;
    }

    public int getLastEmptyIndex() {
        return lastEmptyIndex;
    }

    public void setLastEmptyIndex(int lastEmptyIndex) {
        if (lastEmptyIndex >= 0) {
            this.lastEmptyIndex = lastEmptyIndex;
        }
    }

    @Override
    public String toString() {
        return "CheckoutDto{" +
                "id=" + id +
                ", velocity=" + velocity +
                ", capacity=" + capacity +
                ", doneItems=" + doneItems +
                ", queue=" + Arrays.toString(queue) +
                ", lastEmptyIndex=" + lastEmptyIndex +
                '}';
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public ClientDto[] getQueue() {
        return queue;
    }

    public void setQueue(ClientDto[] queue) {
        this.queue = queue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    @Override
    public int compareTo(CheckoutDto checkoutDto) {
        return checkoutDto.getVelocity() - this.velocity;
    }
}
