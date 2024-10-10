package M303_9;

public class Triangle extends Shape {

    private double base;
    private double height;

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double calculateArea() {
        getName();
        return 0.5 * base * height;
    }

    @Override
    public double calculatePerimeter() {
        return (2 * base) + (2 * height);
    }
}
