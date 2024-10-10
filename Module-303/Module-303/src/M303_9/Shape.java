package M303_9;

public abstract class Shape implements AreaCalculation {


    private String name;

    // this is another way of declaring something that the children must implement
    // abstract methods must be implemented by the children
    public abstract double calculatePerimeter();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
