package M303_9;

public class Circle extends Shape {

    // when we use the static keyword .. there is only variable PI for all instances of circle
    // and the same memory location is shared amongst all circles
    // for the general rule of thumb we do not use static variables especially in a multithreaded environment
    // it you create 10 cirecles in memeory you will have 10 instances of the circle class and 1 instance of PI
    private static double PI = 3.14159;

    // each instance of the class ciricle in memory gets its own radius variable
    // unles we have a very specific need that requires us to use a static variable we will always deailer as non static
    private double radius;

    public double getRadius() {
        return radius;
    }

    public static double getPI() {
        return PI;
    }

    public static void setPI(double PI) {
        Circle.PI = PI;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }


    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return (2 * Math.PI) * radius;
    }
}
