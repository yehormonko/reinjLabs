package edu.sumdu.monopoly;

public abstract class OwnedCell extends Cell {
    private boolean available = true;

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
