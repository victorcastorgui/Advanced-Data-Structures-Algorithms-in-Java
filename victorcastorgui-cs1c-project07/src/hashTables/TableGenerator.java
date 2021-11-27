package hashTables;

import cs1c.SongEntry;
import java.util.*;

/**
 * This class will create and populate two hash tables of type FHhashQPwFind class,
 * one for each wrapper class. TableOfSongIDs a hash table based on SongCompInt
 * tableOfSongGenres a hash table based on SongsCompGenre. Hash table generator for
 * Integer key of ID and String key of Genres from SongEntry object.
 *
 * @author CS1C, Foothill College, [VICTOR CASTOR]
 */
public class TableGenerator
{
    protected FHhashQPwFind<Integer, SongCompInt> tableOfSongIDs;
    protected FHhashQPwFind<String, SongsCompGenre> tableOfSongGenres;
    protected ArrayList<String> genreNames;

    /**
     * Default constructor. Does not take in any parameter.
     * It initializes tables and list of genre names
     */
    public TableGenerator()
    {
        tableOfSongIDs = new FHhashQPwFind<>();
        tableOfSongGenres = new FHhashQPwFind<>();
        genreNames = new ArrayList<>();
    }

    /**
     * Fill hashtable with array of SongEntry objects set by ID
     *
     * @param songs SongEntry objects from song subset
     * @return array of SongEntry filled.
     */
    public FHhashQPwFind<Integer, SongCompInt>
    populateIDTable(SongEntry[] songs)
    {
        SongCompInt songInts;

        for (int i = 0; i < songs.length; i++)
        {
            songInts = new SongCompInt(songs[i]);
            tableOfSongIDs.insert(songInts);
        }

        return tableOfSongIDs;
    }

    /**
     * Fill hash table with array of SongEntry objects set by genres.
     *
     * @param songs SongEntry objects from song subset.
     * @return array of SongEntry filled.
     */
    public FHhashQPwFind<String, SongsCompGenre>
    populateGenreTable(SongEntry[] songs)
    {
        SongsCompGenre songGenres;

        for (int i = 0; i < songs.length; i++)
        {
            songGenres = new SongsCompGenre(songs[i].getGenre());

            try
            {
                tableOfSongGenres.find(songGenres.getName()).addSong(songs[i]);
            }

            catch (NoSuchElementException e)
            {
                genreNames.add(songGenres.getName());
                tableOfSongGenres.insert(songGenres);
                tableOfSongGenres.find(songGenres.getName()).addSong(songs[i]);
            }
        }

        return tableOfSongGenres;
    }

    /**
     * This is an accessor for genre names
     * @return genre names
     */
    public ArrayList<String> getGenreNames()
    {
        return genreNames;
    }
}
