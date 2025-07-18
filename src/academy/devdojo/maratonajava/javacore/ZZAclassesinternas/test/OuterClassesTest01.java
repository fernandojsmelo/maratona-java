package academy.devdojo.maratonajava.javacore.ZZAclassesinternas.test;

public class OuterClassesTest01 {
    private String name = "Monkey D. Luffy";

    class Inner{
        public void printOuterClasseAttribute(){
            System.out.println(name);
            System.out.println(this); // Referencia ao objeto mais interno
            System.out.println(OuterClassesTest01.this); // referencia ao objeto mais Interno
        }
    }
    public static void main(String[] args) {
        OuterClassesTest01 outerClass = new OuterClassesTest01();
        Inner inner = outerClass.new Inner();
        Inner inner2 = new OuterClassesTest01().new Inner();

        inner.printOuterClasseAttribute();
        inner2.printOuterClasseAttribute();
    }
}
