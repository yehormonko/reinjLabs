/**
* Mimics functional empty list.
* @author Vyacheslav Moskalenko
* @since JDK1.4
*/
public class Empty extends FunList{

private static Empty EMPTY = new Empty();

/**
* @return single instance of class
 */
public static Empty uniqueInstanse(){
    return EMPTY;
}

private Empty(){}

/**
* @return nothing now
 */
public int car(){
throw new java.util.NoSuchElementException("car requires a non Empty Funlist");
}

/**
* @return nothing now
 */
public FunList cdr(){
throw new java.util.NoSuchElementException("cdr requires a non Empty Funlist");
}

    public FunList append(FunList other) {
        return new Cons(this.car(), other);
    }


    public FunList insertInOrder(int i) {
        return new Cons(i);
    }


    public FunList sort() {
        return this;
    }



    /**
* @return empty string
 */
String toStringHelp(){
return "";
}


}