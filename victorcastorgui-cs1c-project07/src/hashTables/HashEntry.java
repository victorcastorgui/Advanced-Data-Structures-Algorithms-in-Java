package hashTables;

/**
 * This class is given by Professor Bita. It is a generic class containing an object
 * for hash table and availability.
 *
 * @author Foothill College, Bita M
 */

// HashEntry class for use by FHhashQP -----------------------
public class HashEntry<E>
{
    public E data;
    public int state;

    public HashEntry( E x, int st )
    {
        data = x;
        state = st;
    }

    public HashEntry()
    {
        this(null, FHhashQP.EMPTY);
    }
}