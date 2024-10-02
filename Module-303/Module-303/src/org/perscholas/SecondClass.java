package org.perscholas;

public class SecondClass {

    int variableName = 5;

    int thisVariableHasLongName = 5;

    double area = 0.0;

    boolean question = true;
    boolean answer = false;

    boolean thisIsALongVariableName3 = false;

    boolean publicVariable = false;

    public static final void main(String[] args) {
        boolean oneTime = false;

        oneTime = true;

        char a = 'A';
        String s = "String uses double quotes";




        // this way is depreciated and no longer the best way of creating a new Integer (non primitive)
        Integer i = new Integer(45);

        // it has been replaced with
        Integer ii = Integer.valueOf(45);

        // Integer class is an actual class and has methods on it
        String iiString = ii.toString();
    }
}
