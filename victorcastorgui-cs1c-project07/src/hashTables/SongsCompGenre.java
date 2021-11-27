package hashTables;

import cs1c.SongEntry;
import java.util.*;

/**
 * Wrapper class for SongEntry.
 *
 * @author Foothill College, [VICTOR CASTOR]
 */
public class SongsCompGenre implements Comparable<String>
{
    //name of genre
    private String genre;
    private ArrayList<SongEntry> data;

    /**
     * This is a default constructor it does not take in any parameter.
     *
     * @param genre name
     */
    public SongsCompGenre(String genre)
    {
        this.genre = genre;
        data = new ArrayList<>();
    }

    /**
     * String representation of the data.
     *
     * @return string representation of ArrayList of SongEntry object
     */
    public String toString()
    {
        return data.toString();
    }

    /**
     * Add SongEntry object to ArrayList. It checks first where the data and the genre
     * is the same. If it is the same it will add the data to the ArrayList.
     *
     * @param E SongEntry object to add
     */
    public void addSong(SongEntry E)
    {
        if (!data.contains(E) && genre.equals(E.getGenre()))
            data.add(E);
    }

    /**
     * This takes in one parameter.
     * It compares key input with SongEntry genre
     *
     * @param key to compare to the genre
     * @return int compare the result
     */
    public int compareTo(String key)
    {
        return getName().compareToIgnoreCase(key);
    }

    /**
     * This is a boolean method that takes in one parameter.
     * It checks if two SongsCompGenre are object the same. If it is the same then it returns
     * the result. If it is not the same that it does not return anything.
     *
     * @param A the other SongsCompGenre object to test
     * @return true/false according to the test
     */
    public boolean equals(SongsCompGenre A)
    {
        return genre.equals(A.genre);
    }

    /**
     * This is simple. It only get the hashcode of genre
     * @return hashcode of genre name
     */
    public int hashCode()
    {
        return genre.hashCode();
    }

    /**
     * This is a accessor for genre name. It only get the name of the genre and return it.
     *
     * @return genre name
     */
    public String getName()
    {
        return genre;
    }

    /**
     * This is also an accessor for list of SongEntry object. It only get the data and return it.
     *
     * @return ArrayList of SongEntry object
     */
    public ArrayList<SongEntry> getData()
    {
        return data;
    }
}
