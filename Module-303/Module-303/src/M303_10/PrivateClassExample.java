package M303_10;

public class PrivateClassExample {

    public void thisCanHaveAnyName() {
        InnerPrivateClass ipc = new InnerPrivateClass();
    }

    public static void main( String [] args ) {
        // we want to get outside this static method so that we can code like normal
        // otherwise everything would have to be static which we really dont want
        // we are just making a new instance of the class and it just so happens its the same class
        PrivateClassExample pce = new PrivateClassExample();
        // execute a non static method on the class we just created
        pce.thisCanHaveAnyName();


        // this notation does work and creates 2 new objects inside a static method
        InnerPrivateClass ipc = new PrivateClassExample().new InnerPrivateClass();
    }

    // this just to show that the java language will allow an internal private class
    private class InnerPrivateClass {

        private String a;
        private String b;

        // getters and setters
    }

}
