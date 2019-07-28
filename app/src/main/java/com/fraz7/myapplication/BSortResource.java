package com.fraz7.myapplication;

public class BSortResource {
    private int resourceID;
    private String description;

    public int getResourceID() {
        return resourceID;
    }

    public void setResourceID(int resourceID) {
        this.resourceID = resourceID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BSortResource(int resourceID, String description) {
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