package hashTables;

import cs1c.SongEntry;

/**
 * Wrapper class for SongEntry.
 * Using the key of ID of SongEntry.
 *
 * @author Foothill College, [VICTOR CASTOR]
 */
public class SongCompInt implements Comparable<Integer>
{
    private SongEntry data;

    /**
     * This is a default constructor that takes in one parameter.
     * It only states that the data is e.
     *
     * @param E SongEntry Object
     */
    public SongCompInt(SongEntry E)
    {
        data = E;
    }

    /**
     * String representation of data.
     *
     * @return string representation of SongEntry object data
     */
    public String toString()
    {
        return data.toString();
    }

    /**
     * This constructor uses int and compareTo to compare the key input with SongEntry ID.
     * It takes in one parameter which is key.
     *
     * @param key int to compare to the ID
     * @return int comparing result
     */
    public int compareTo(Integer key)
    {
        return data.getID() - key;
    }

    /**
     * This is a boolean method to check two SongCompInt the same or not.
     * It takes in one parameter.
     *
     * @param A the other SongCompInt object to test
     * @return true/false according to the test
     */
    public boolean equals(SongCompInt A)
    {
        return data.equals(A.data);
    }

    /**
     * This is made just to get the hashcode of SongEntry object.
     * It takes in no parameter.
     *
     * @return ID field of SongEntry object
     */
    public int hashCode()
    {
        return data.getID();
    }
}
