import java.util.Collections;
import java.util.LinkedList;

/**
 * Mimics fundamental function cons for constructs
 * memory objects which hold two values or pointers to values
 *
 * @author Vyacheslav Moskalenko
 * @since JDK1.4
 */
public class Cons extends FunList {
    private int _dat;
    private FunList _cdr;

    public Cons(int carDat, FunList cdr) {
        _dat = carDat;
        _cdr = cdr;
    }

    /**
     * @param i a left side (head) of the list.
     */
    public Cons(int i) {
        _dat = i;
        _cdr = Empty.uniqueInstanse();
    }

    /**
     * @return the first int in the list object
     */
    public int car() {
        return _dat;
    }

    /**
     * @return the tail (all but the first element) of the list object
     */
    public FunList cdr() {
        return _cdr;
    }

    @Override
    public FunList append(FunList other) {
        if(this._cdr instanceof Empty){
            return new Cons(this._dat, other);
        }
        return  new Cons(this._dat, this._cdr.append(other));
    }

    @Override
    public FunList insertInOrder(int i) {
        if(_dat<=i) {
            return new Cons(i, this);
        }else{
            return new Cons(_dat, _cdr.insertInOrder(i));
        }

    }

    @Override
    public FunList sort() {
        return _cdr.sort()
                .insertInOrder(_dat);
    }

    /**
     * @return a String description of the list object
     */
    String toStringHelp() {
        return " " + _dat + _cdr.toStringHelp();
    }
}