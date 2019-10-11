package com.fraz7.myapplication;

public class BSortResource {
    private int resourceID;
    private int description;

    public int getResourceID() {
        return resourceID;
    }

    public void setResourceID(int resourceID) {
        this.resourceID = resourceID;
    }

    public int getDescription() {
        return description;
    }

    public void setDescription(int description) {
        this.description = description;
    }

    public BSortResource(int resourceID, int description) {
        this.resourceID = resourceID;
        this.description = description;
    }

    @Override
    public String toString() {
        return "BSortResource{" +
                "resourceID=" + resourceID +
                ", description='" + description + '\'' +
                '}';
    }
}