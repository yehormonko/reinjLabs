public class AppendTest {
    public static void main(String[] args) {
        Cons cons = new Cons(1);
        cons = (Cons) cons.append(new Cons(2));
        System.out.println(cons.toStringHelp());
    }
}
