package coffee_shop;

import java.util.ArrayList;
import java.util.List;

public class CoffeeShop {

    // this is a class level variable that will contain our list of products for sale
    // best practice is to define these at the top of the class
    private List<Product> products = new ArrayList<>();

    private void initProducts() {
        Product p1 = new Product("Small Coffee", 4.57, 0);
        products.add(p1);

        Product p2 = new Product("Large Coffee", 7.99, 0);
        products.add(p2);

        Product p3 = new Product("Sugar Cookie", 5.89, 0);
        products.add(p3);

        Product p4 = new Product("Egg Sandwich", 6.49, 0);
        products.add(p4);
    }

    private void printProductMenu() {
        for ( int count = 0 ; count < products.size() ; count++ ) {
            Product p = products.get(count);
            // count + 1 the complier will recognize the math and increment the value of count
            // before using it to create the string that is printed
            System.out.println((count+1) + ") " + p.getName() + " \t " + p.getPrice());
        }
    }



    public void start() {
        // this becomes similar to the main method in that it will be where our project starts and runs
        // 1) initialize the products for sale
        initProducts();

        // 2) print the list of products for sale
        printProductMenu();
    }

    public static void main(String[] args) {
        CoffeeShop cs = new CoffeeShop();
        cs.start();
    }
}
