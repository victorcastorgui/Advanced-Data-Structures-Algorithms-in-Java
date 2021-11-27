package hashTables;

/**
 * This class is a extend of FHhashQP to a new class called FHhashQPwFind.
 * It is derived from quadratic probing hash table, this class enables to working on
 * specific generic key type for example ID field of SongEntry object
 * or genre field.
 *
 * @author Foothill College, [VICTOR CASTOR]
 */

public class FHhashQPwFind<KeyType, E extends Comparable<KeyType> > extends FHhashQP<E>
{
    /**
     * This constructor uses the method find() and it takes in one parameter.
     * It finds an object by key.
     *
     * @param key of object to look.
     * @return the error or object.
     */

    public E find(KeyType key)
    {
        int index = findPosKey(key);

        if(mArray[index].state == ACTIVE)
            return mArray[index].data;

        throw new java.util.NoSuchElementException();
    }

    /**
     * This is a hash function that is used to find index position.
     * It takes in one parameter.
     *
     * @param key of object to find.
     * @return index position.
     */

    public int myHashKey(KeyType key)
    {
        int hashValue = key.hashCode() % mTableSize;
        //HashValue must be smaller than 0
        if(hashValue < 0) hashValue += mTableSize;

        return hashValue;
    }

    /**
     * Find index position with quadratic probing
     *
     * @param key of object to find.
     * @return index position.
     */

    private int findPosKey(KeyType key)
    {
        int index = myHashKey(key);
        int odd = 1;

        while(mArray[index].state != EMPTY && mArray[index].data.compareTo(key) != 0)
        {
            index += odd;
            odd += 2;
            if(index >= mTableSize) index -= mTableSize;
        }

        return index;
    }
}
