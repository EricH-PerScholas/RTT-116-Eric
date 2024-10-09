package M303_8;

public class Rectangle {

    // these are considered class members or class variables
    // we are not directly exposing these to the outside world .. thus they are private class members
    // the best practice is for class level variables to be private
    private int height;
    private int width;

    // this is the constructor and this one takes no arguements
    public Rectangle() {
        // this is run when ever the code contains new Rectangle()
    }

    // this is also a constructor that takes in 2 arguements
    public Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    // we use what are called getters and setters to change the values of height and width
    // very very very common practice in java and will see it all over the palce
    public int getHeight() {
        return height;
    }

    // the word method and function both mean the same thing
    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    // this method is on all java objects and is used to return a string representation of this object
    public String toString() {
        return "Rectangle [width = " + width + " height = " + height + "]";
    }

    public int calculateArea() {
        int p = height * width;
        notAvailable();
        return p;
    }

    public int calculatePerimeter() {
        int p = (height * 2) + (width * 2);
        notAvailable();
        return p;
        //return height + height + width + width;
    }

    private void notAvailable() {
        // this is only available within the rectangle class itself
        // not available outside the class
    }


    protected void partlyAvailable() {
        // proitected is available to everything in the same package
    }


}
