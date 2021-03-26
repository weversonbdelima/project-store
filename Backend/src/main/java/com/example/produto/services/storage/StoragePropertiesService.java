package com.example.produto.services.storage;

public class StoragePropertiesService{
    private String location = "src/main/resources/static/upload";

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}