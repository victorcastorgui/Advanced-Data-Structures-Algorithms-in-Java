package lazyTrees;

/**
 * This class is given by the instructor it is a function object that
 * implements visit() method from an interface.
 * @param <E> any object
 */
class PrintObject<E> implements Traverser<E>
{
    public void visit(E x)
    {
        System.out.print( x + " ");
    }
};
