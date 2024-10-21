package coffee_shop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CoffeeShop {


    // we will use this is a couple functions to read input from the user
    private Scanner scanner = new Scanner(System.in);

    // this is a class level variable that will contain our list of products for sale
    // best practice is to define these at the top of the class
    private List<Product> products = new ArrayList<>();

    // this will hold the products that we are going to purchase
    private List<Product> cart = new ArrayList<>();

    private void initProducts() {
        Product p1 = new Product("Small Coffee", 4.57, 0);
        products.add(p1);

        Product p2 = new Product("Large Coffee", 7.99, 0);
        products.add(p2);

        Product p3 = new Product("Sugar Cookie", 5.89, 0);
        products.add(p3);

        Product p5 = new Product("Ginger Cookie", 5.89, 0);
        products.add(p5);

        Product p4 = new Product("Egg Sandwich", 6.49, 0);
        products.add(p4);


        // lets sort the list by the price
        // https://stackoverflow.com/questions/40517977/sorting-a-list-with-stream-sorted-in-java
        // stream will not modify the original list that you streamed
        // TODO - Homework #1 - write this function using a for loop
        // use a bubble sort algorithm - look this up on google
        // sort the list of products by price using 2 nested for loops to implement a bubble sort in a function
        // should create a function that will tke in a List<Product> to be sorted and return a sorted List<Product>

        // TODO - Homework #2 - create a new main menu option that allows you to search the list of products for a user entered name
        // 1) Ask the user to enter a search phrase "coffee"
        // 2) filter the list of products to show only the products that the match the phrase entered
        // 2b - do not alter the original list of products which means use the .stream()
        // 2c - use a lambda to print out the sorted list using a product.toString() method
        // 2c p1 - create a toString method on your product object
        // 3) Add the search capability to the main menu when you start the coffee shop as a new option
        List<Product> sorted = products.stream().sorted(Comparator.comparing(Product::getPrice)).toList();

        // this just prints the products and when we run this we will have to make a fix
        //sorted.forEach(p -> System.out.println(p));

        // this will modify the origial list ... using stream will not modify the original list
        products.sort(Comparator.comparing(Product::getPrice).thenComparing(Product::getName));
        // this line uses a lambda expression
        products.forEach(p -> System.out.println(p));
    }

    private List<Product> sortByPrice(List<Product> source) {
        return null;
    }

    private void printProductMenu() {
        for (int count = 0; count < products.size(); count++) {
            Product p = products.get(count);
            // count + 1 the complier will recognize the math and increment the value of count
            // before using it to create the string that is printed
            System.out.println((count + 1) + ") " + p.getName() + " \t " + p.getPrice());
        }

        // give some white space after print
        System.out.println("");
    }

    private int printMainMenu() throws InvalidInputException {
        System.out.println("1) See product menu");
        System.out.println("2) Purchase product");
        System.out.println("3) Checkout");
        System.out.println("4) Exit");

        return readNumberFromUser("\nEnter Selection :");
    }

    // by adding the throws clause here, I am specifically saying this fuction can (but may not) throw an exception called InvalidInputException
    // this is what is called throwing a checked exception which means that all places in the code that are calling this method now have to deal with it
    private int readNumberFromUser(String question) throws InvalidInputException {
        System.out.print(question);
        try {
            int selection = scanner.nextInt();
            // normally a return stops execution of code at that point and executes the function
            // ****** !!!!!!  in this case it will still call the finally block
            return selection;
        } catch (Exception e) {
            // this is logic we are adding as an engineer so we know there was a problem
            // this is not always the best of handeling things
            System.out.println("Invalid input: " + e.getMessage());
            throw new InvalidInputException("Invalid input: " + e.getMessage());
        } finally {
            // this is a good example of usage for a finally block is to clear the Scanner so it is ready for the
            // next time this function is called.
            scanner.nextLine();
        }
    }

    public void addProductToCart() {
        // 1 display the items for sale
        printProductMenu();

        // 2 prompt the user to enter an item # to buy
        try {
            int selection = readNumberFromUser("Enter product number:");

            // we want to check that the user has entered a valid product number
            if (isProductSelectionValid(selection)) {

                // if the user does not enter a valid item from the menu then there is no reason to ask how many
                // prompt the user to enter how many they would like to buy
                int quantity = readNumberFromUser("Enter quantity to buy:");

                // error checking can happen here to make sure the user enters a positive number
                if (quantity <= 0) {
                    System.out.println("Must buy at least one item");

                } else {
                    // 3 add to the cart array
                    // we are subtracting 1 from the user input to get the real position in the array
                    // because most people do not have a concept of the 0th item in a list
                    Product p = products.get(selection - 1);
                    p.setQuantity(p.getQuantity() + quantity);

                    // if the product does not already exist in the cart then we can add the product to the cart
                    if (!doesSelectedProductExistInCart(p)) {
                        cart.add(p);
                    }
                    System.out.println("Added " + p.getName() + " to your cart.\n");
                }
            } else {
                System.out.println("Invalid item selection");
            }
        } catch (InvalidInputException iie) {
            // maybe we dont care to do anything here ...
            System.out.println("===== HERE =====");
        }
    }

    private boolean isProductSelectionValid(int selectedProduct) {
        if (selectedProduct >= 1 && selectedProduct <= products.size()) {
            return true;
        }

        return false;
    }

    private boolean doesSelectedProductExistInCart(Product purchase) {
        boolean found = false;

        // start looping over all the items in the cart and if the name of the purchased item is the same
        // name as one of the products in the cart then we know it is already in the cart
        for (Product item : cart) {
            if (item.getName().equals(purchase.getName())) {
                found = true;
                break;
            }
        }

        return found;
    }

    public void checkout() {
        System.out.println("==== Items in your cart ====");

        // list the items in the cart
        double subtotal = 0.0;
        for (Product item : cart) {
            System.out.println(item.getName() + " \t " + item.getQuantity() + " \t $" + item.getPrice() + " \t Total $" + (item.getPrice() * item.getQuantity()));
            subtotal = subtotal + item.getPrice();
        }
        System.out.println("");
        System.out.println("Subtotal\t\t $" + subtotal);

        // assume there is a 9% sales tax to be applied to the order
        // calculate tax
        double tax = subtotal * 0.09;
        System.out.println("Tax\t\t\t\t $" + tax);

        // calculate total amount
        // adding an addtional () will cause it to do the math
        double total = (subtotal + tax);
        System.out.println("Total\t\t\t $" + total + "\n");
    }

    public void start() throws InvalidInputException {
        // this becomes similar to the main method in that it will be where our project starts and runs
        // 1) initialize the products for sale
        initProducts();

        // repeat forever until the user enters selection 4 which will exit the program
        while (true) {
            // print the menu and get back the user selected input
            // add a try catch block here and reshow the menu asking for another input
            int selection = printMainMenu();

            if (selection == 1) {
                // print the product menu
                printProductMenu();
            } else if (selection == 2) {
                // purchase product / add to cart
                addProductToCart();
            } else if (selection == 3) {
                // checkout
                checkout();
            } else if (selection == 4) {
                System.out.println("Good bye");

                // we are exiting with a value of 0 means successful exit
                // this ends the program
                System.exit(0);
            } else {
                System.out.println("Invalid command entered " + selection + "\n");
            }
        }

    }

    // a main method can not be private
    public static void main(String[] args) {
        CoffeeShop cs = new CoffeeShop();
        try {
            cs.start();
        } catch (InvalidInputException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Ending program");
    }
}
