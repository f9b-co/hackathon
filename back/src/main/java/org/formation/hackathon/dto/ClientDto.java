package org.formation.hackathon.dto;

public class ClientDto {
    private int id;
    private int items;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItems() {
        return items;
    }

    public void setItems(int items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "ClientDto{" +
                "id=" + id +
                ", items=" + items +
                '}';
    }
}
