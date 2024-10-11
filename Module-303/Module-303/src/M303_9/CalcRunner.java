package M303_9;

import java.util.ArrayList;
import java.util.List;

public class CalcRunner {

    public static void main(String[] args) {
        Circle c = new Circle();
        c.setRadius(10.0);
        c.setName("Circle");

        Circle c1 = new Circle();
        c1.setRadius(15.0);
        c1.setName("Circle 1");

        Triangle t = new Triangle();
        t.setHeight(10.0);
        t.setBase(10.0);
        t.setName("Triangle");

        // this is no longer possible because shape is abstract and thus incomplete
        //Shape s = new Shape();

        // make a list of shapes but notice that we are using the parent shape
        // in an indrect way, when we add individual shapes to this list, they are
        // automatically being typecasted to a shape
        List<Shape> shapes = new ArrayList<>();
        shapes.add(c);
        shapes.add(c1);
        shapes.add(t);

        // lets loop over all the shapes and calculate the area
        for ( Shape s : shapes ) {
            double area = s.calculateArea();
            double perimeter = s.calculatePerimeter();

            // when something has been typcasted to its parent we can still check to
            // see if it is a Triangle by using instanceof
            if ( s instanceof Triangle ) {
                System.out.println("s is of type Triangle");
            }

            System.out.println("The area for shape " + s.getName() + " is " + area + " and perimeter is " + perimeter);
        }

        // the child can become the parent
        //Shape s = new Circle();

        // the parent can not become the child
        //Circle c3 = new Shape();

    }


}
