package com.example.themintempire.Models;

public class PlateModel {

    public PlateModel(){
        //empty constructor
    }
    private int plate_img;

    public PlateModel(int plate_img) {
        this.plate_img = plate_img;
    }

    //You generate setter and getter here
    public int getPlate_img() {
        return plate_img;
    }

    public void setPlate_img(int plate_img) {
        this.plate_img = plate_img;
    }
}
