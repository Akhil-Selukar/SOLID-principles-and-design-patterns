package com.solid.principles;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(5,6);
        Square square = new Square(6);

        System.out.println("Area of rectangle : "+rectangle.calculateArea());
        System.out.println("Area of square : "+square.calculateArea());

        useRectangle(rectangle);
        System.out.println("Another method for square as now user knows that square is not a special type of rectangle," +
                " but it's a shape");
        useSquare(square);
    }

    private static void useSquare(Square square) {
        square.setSide(20);

        if(square.getSide() == 20)
            System.out.println("Side of square is 20.");
        else
            System.out.println("Side is not 20.");
    }

    private static void useRectangle(Rectangle rectangle) {
        rectangle.setWidth(10);
        rectangle.setHeight(20);

        if(rectangle.getHeight() == 20)
            System.out.println("Height of rectangle is 20.");
        else
            System.out.println("Height is not 20.");
        if(rectangle.getWidth() == 10)
            System.out.println("Width of rectangle is 10.");
        else
            System.out.println("Width is not 10.");
    }

}