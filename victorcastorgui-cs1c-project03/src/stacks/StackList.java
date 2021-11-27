package stacks;
import java.util.Iterator;

/**
 * Singly linked list StackList class
 * Generic object type of singly linked list data structure
 * which implements Iterable
 * In a stack we process items in LIFO (Last-In-First-Out) order.
 *
 * @param <E> generic type class
 * @author Foothill College, VICTOR CASTOR
 */
public class StackList<E> implements Iterable<E>
{
    //stack name
    private String name;
    //data
    protected Node top;
    //stack
    private int mSize;

    /**
     * default constructor that takes in two parameters which is name and top
     * to put new data to the top of the stack. This constructor uses if and else method to check if there is a data
     * to be passed to the top.
     *
     * @param name stack name.
     * @param top generic object passed to the top.
     */
    public StackList(String name, E top)
    {
        this.name = name;

        if (top == null)
        {
            this.top = null;
            mSize = 0;
        }
        else
        {
            this.top = new Node(top);
            mSize = 1;
        }
    }

    /**
     * This constructor takes in one parameter. If there is no data, it will just return.
     * If there is data, it will push new data to the top and the array will increases.
     *
     * @param x generic object to push.
     */
    public void push(E x)
    {
        if (x.toString()=="" || x == null)
            return;

        Node topNode = new Node(x);
        topNode.next = top;
        top = topNode;
        mSize++;
    }

    /**
     * This constructor does not take any parameter. This constructor is made
     * just to see the top data and return the data. If there is no data then it will return null. This is needed
     * for the public E remove().
     *
     * @return the generic object of the data at the top of the stack.
     */
    public E peek()
    {
        if (isEmpty())
            return null;

        return top.getData();
    }

    /**
     * This constructor does not take in any parameter. This constructor is made to remove the
     * top data in the stack. Just like stack of cards if we were to put one card back on top,
     * the top card will be taken first.
     *
     * @return the generic object of the data at the top of the stack.
     */
    public E pop()
    {
        if (isEmpty())
            return null;

        E topData = top.getData();
        top = top.next;
        mSize--;

        return topData;
    }

    /**
     * If stack has no data them it will return 0. This constructor is boolean because it needs to
     * test if it is empty or not.
     *
     * @return whether the test is true or false.
     */
    public boolean isEmpty()
    {
        return size() == 0;
    }

    /**
     * This constructor does not take in any parameter and it is very simple. It only check how
     * many data in the stack and return the size of the stack.
     *
     * @return the size of the stack based on the amount of data.
     */
    public int size()
    {
        return mSize;
    }

    /**
     * This constructor's job is only to print the format of the stack. It uses for loop to put comma
     * to separate every time there is a new data. It will look like this [......,......,.....].
     *
     * @return the output of the stack when running.
     */
    public String toString()
    {
        //traverses the elements stored in the data structure.
        String stackFormat = name + " with " + mSize + " link(s): \n[";
        StackIterator iter = new StackIterator();

        //To put comma everytime there is a new link
        while (iter.hasNext())
        {
            stackFormat += iter.next();

            if (iter.hasNext())
                stackFormat += ", ";
        }

        stackFormat += "]";

        return stackFormat;
    }

    /**
     * adding iterator to traverse the stack
     *
     * @return object StackIterator
     */
    public Iterator<E> iterator()
    {
        return new StackIterator();
    }

    /**
     * inner class to store generic data in this linked list stack
     */
    private class Node
    {
        private Node next;
        private E data;

        /**
         * default constructor that takes in one parameter to create new node.
         *
         * @param data generic object to store in node
         */
        private Node(E data)
        {
            this.next = null;
            this.data = data;
        }

        /**
         * private accessor for data in node. This is simple it only get data and return it.
         *
         * @return generic object in node
         */
        private E getData()
        {
            return data;
        }
    }

    /**
     * inner class iterator which implements Iterator for the stack
     */
    private class StackIterator implements Iterator<E>
    {
        private Node mCurrentNode;
        private Node mLastNodeReturned = null;
        private int mCurrentIndex;

        /**
         * default constructor takes no parameter for iterator. It instantiate the currenNode to top
         * and currentIndex to 0.
         */
        private StackIterator()
        {
            mCurrentNode = top;
            mCurrentIndex = 0;
        }

        /**
         * This boolean method constructor test if there is data in stack
         *
         * @return true or false
         */
        public boolean hasNext()
        {
            return mCurrentIndex < mSize;
        }

        /**
         * get the data at the top of the stack
         *
         * @return the generic object at the top of the stack
         */
        public E next()
        {
            if (!hasNext())
                throw new java.util.NoSuchElementException();

            E returnNext = mCurrentNode.getData();
            mLastNodeReturned = mCurrentNode;
            mCurrentNode = mCurrentNode.next;
            mCurrentIndex++;

            return returnNext;
        }
    }
}
