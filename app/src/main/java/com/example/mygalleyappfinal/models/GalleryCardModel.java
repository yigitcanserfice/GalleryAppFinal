package com.example.mygalleyappfinal.models;

public class GalleryCardModel {
    String label;
    String description;
    String img_url;

    String user_name;

    public GalleryCardModel() {
    }

    public GalleryCardModel(String label, String description, String img_url, String user_name) {
        this.label = label;
        this.description = description;
        this.img_url = img_url;
        this.user_name = user_name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}
