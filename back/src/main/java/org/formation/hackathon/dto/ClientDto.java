package org.formation.hackathon.dto;

public class ClientDto {
    private int id;
    private int items;

    public int getId(){
        return id;
    };
    public int getItems(){
        return items;
    }

    @Override
    public String toString() {
        return "ClientDto{" +
                "id=" + id +
                ", items=" + items +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setItems(int items) {
        this.items = items;
    }
}
