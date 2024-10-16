package M303_11;

public class GenericValueObject<T,K extends Number> {

    private T typeT;
    private K typeK;

    public T getT() {
        return typeT;
    }

    public void setT(T typeT) {
        this.typeT = typeT;
    }

    public static void main(String[] args) {
        // creating your own generic classes is something that is very rare for an engineer and primarily is
        // used when creating a library that many other engineers and projects will use in diffent ways
        GenericValueObject<String, Integer> str = new GenericValueObject<>();
        str.setT("String");
        String s1 = str.getT();

        GenericValueObject<Integer, Double> value = new GenericValueObject<>();
        value.setT(10);
        Integer i = value.getT();

    }

}
