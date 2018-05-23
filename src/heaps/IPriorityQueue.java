package heaps;

import java.util.Iterator;

/**
 * @author Toygan Sevim
 * @version 1.0
 * @param <T>
 */
public interface IPriorityQueue<T extends Comparable<T>> extends Iterable<T>
{

    //ADT METHODS FOR HEAPS

    public void insert(T element);

    public T deleteMin();

    public T peek();

    //other

    public boolean contains(T element);

    public int size();

    public boolean isEmpty();

    public void clear();

    @Override
    public Iterator<T> iterator();
}
