public class SortTest {
    public static void main(String[] args) {
        FunList cons = new Cons(2);
        cons = new Cons(1, cons);
        cons = new Cons(3,cons);
        System.out.println(cons.toStringHelp());
        System.out.println("________");
        System.out.println(cons.sort().toStringHelp());
    }
}
