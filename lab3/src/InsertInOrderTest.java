public class InsertInOrderTest {
    public static void main(String[] args) {
        Cons cons = new Cons(8);
        cons = (Cons) cons.insertInOrder(2).insertInOrder(7);
        System.out.println(cons.toStringHelp());
        System.out.println("___________");
    }
}
