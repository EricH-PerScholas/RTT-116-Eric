package M303_8;

public class Runner {

    public static void main (String[] args) {
        Rectangle r1 = new Rectangle();
        System.out.println(r1.toString());
        System.out.println("The area is " + r1.calculateArea());
        System.out.println("The perimeter is " + r1.calculatePerimeter());

        r1.setHeight(30);
        r1.setWidth(15);
        System.out.println(r1.toString());
        System.out.println("The area is " + r1.calculateArea());
        System.out.println("The perimeter is " + r1.calculatePerimeter());

        // this is an error because the function is set to private
        //r1.notAvailable();

        // this is okay because Runner and Rectangle are in the same package
        r1.partlyAvailable();


        Rectangle s2 = new Rectangle(10,20);
        System.out.println(s2.toString());
        System.out.println("The area is " + s2.calculateArea());
        System.out.println("The perimeter is " + s2.calculatePerimeter());


        String s1 = "abc";
        s1.substring(1);
        s1.substring(0,1);

    }

}
