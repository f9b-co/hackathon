package org.formation.hackathon.dto;

public class ClientDto {
    private int id;
    private int items;
    private boolean queued = false;

    public ClientDto() {
        //
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getItems(){

        return items;
    }
    public void setItems(int items) { this.items = items; }
    public boolean isQueued() { return queued; }
    public void setQueued(boolean queued) { this.queued = queued; }


    @Override
    public String toString() {
        return "ClientDto{" +
                "id=" + id +
                ", items=" + items +
                ", queued=" + queued +
                '}';
    }
}
