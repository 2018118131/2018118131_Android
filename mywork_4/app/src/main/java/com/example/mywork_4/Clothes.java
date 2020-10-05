package com.example.mywork_4;

public class Clothes {

    private String name;
    private int imageId;

    public Clothes(String name,int imageId){
        this.name = name;
        this.imageId = imageId;
    }

    public String getName(){
        return name;
    }

    public int getImageId(){
        return  imageId;
    }

}
