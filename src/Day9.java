public class Day9 {
    public int publicField;
    protected int protectedField;
    int defaultField;
    private int privateField;
    public void publicMethod() {
        System.out.println("m()");
    }
    protected void protectedMethod() {
        System.out.println("protectedMethod");
    }

    void defaultMethod() {
        System.out.println("defaultMethod");
    }

    private void privateMethod() {
        System.out.println("privateMethod");
    }
    public static void main(String[] args) {
        Day9 day9 = new Day9();
        day9.defaultField
        int privateField1 = day9.privateField;
        int protectedField1 = day9.protectedField;
        int publicField1 = day9.publicField;
    }
}
