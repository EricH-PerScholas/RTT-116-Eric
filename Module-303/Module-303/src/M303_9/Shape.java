package M303_9;

public abstract class Shape implements AreaCalculation {

    // this is also called the superclass

    // you have 2 different technique for acomplishing polymorphic behavior
    // 1) is by using an interface and allowing the child classes to provide the implentation
    // 2) is by using an abract method that allows child classes to provide the implementation


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
