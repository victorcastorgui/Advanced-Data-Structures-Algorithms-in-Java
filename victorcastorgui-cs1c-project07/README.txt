project folder:
victorcastorgui-cs1c-project07/

Brief description of submitted files:

resources/AllGenres.txt
    - Test file containing all valid genres.

resources/findGenres.txt
    - Test file containing valid and invalid genres.

resources/findIDs.txt
    - Test file containing valid and invalid genres.

resources/invalidGenres.txt
    - Test file containing invalid genres.

resources/invalidIDs.txt
    - Test file containing invalid IDs.

resources/music_genre_subset.json
    - List of genre name, title, artist name, duration and song id.

resources/RUN.txt
    - Output of tests.
        - resources/findGenres.txt
          resources/findIDs.txt
        - resources/findIDs.txt
          resources/AllGenres.txt
        - resources/findIDs.txt
          resources/invalidGenres.txt
        - resources/invalidIDs.txt
          resources/AllGenres.txt
        - resources/invalidIDs.txt
          resources/invalidGenres.txt

src/cs1c/MillionSongDataSubset
    - Parses a JSON data set and stores each entry in an array.

src/cs1c/SongEntry.java
    - Stores a simplified version of the genre data set from the Million Song Dataset.

src/cs1c/TimeConverter.java
    - Converts duration into a string representation.

src/hashTables/FHhashQP.java
    - This class is given by the instructor. Contains Data structure,
      quadratic probing implementation of hash table.

src/hashTables/FHhashQPwFind.java
    - Derived from quadratic probing hash table, this class enables to working on
      specific generic key type for example ID field of SongEntry object
      or genre field.

src/hashTables/HashEntry.java
    - It is a generic class containing an object for hash table and availability.

src/hashTables/MyTunes.java
    - Tests the functionality of FHhashQPwFind.java.
      Specifically checks for implementation of find() function to return an object associated with a given key input.

src/hashTables/SongCompInt.java
    - Wrapper class for SongEntry.
    - Using the key of ID of SongEntry.

src/hashTables/SongsCompGenre.java
    - Wrapper class for SongEntry with key type of SongEntry String genres member.

src/hashTables/TableGenerator.java
    - This class will create and populate two hash tables of type FHhashQPwFind class,
      one for each wrapper class.

README.txt
    - description of submitted files