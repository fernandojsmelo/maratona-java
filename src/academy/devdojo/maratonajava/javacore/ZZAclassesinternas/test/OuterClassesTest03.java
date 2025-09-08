package academy.devdojo.maratonajava.javacore.ZZAclassesinternas.test;

public class OuterClassesTest03 {
    private String name = "Willian";
    static class Nested{
        private String lastName = "Suane";
        void print(){
            System.out.printf(new OuterClassesTest03().name + " " + lastName);
        }
    }

    public static void main(String[] args) {
        Nested nestd = new Nested();
        nestd.print();
    }
}
