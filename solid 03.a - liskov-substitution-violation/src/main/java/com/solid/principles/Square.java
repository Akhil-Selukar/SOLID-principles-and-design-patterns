package com.solid.principles;

public class Square extends Rectangle{

    public Square(int side) {
        super(side, side);
    }

    public void setWidth(int width) {
        setSide(width);
    }

    public void setHeight(int height) {
        setSide(height);
    }

    private void setSide(int side) {
        super.setWidth(side);
        super.setHeight(side);
    }
}