package cs1c;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


/**
 * One object of class MillionSongDataSubset parses a JSON data set and stores each entry in an array.
 * @author CS1C, Foothill College, Bita Mazloom
 * @version 1.0
 */
public class MillionSongDataSubset {

	private static final String jsonFilePath = "resources/music_genre_subset.json";
	private static final boolean ENABLE_DATA_OUTPUT = false;

	private SongEntry[] arrayOfSongs;

	public MillionSongDataSubset(JSONArray allSongs)
	{
		// --------------------
		// create an array of all the JSON objects
		arrayOfSongs = new SongEntry[allSongs.size()];

		Iterator<?> iterator = allSongs.iterator();
		int counter = 0;
		while (iterator.hasNext() && counter < arrayOfSongs.length) 
		{
			JSONObject currentJson = (JSONObject)iterator.next();
			String title = currentJson.get("title").toString();
			int duration = (int)Double.parseDouble(currentJson.get("duration").toString());
			String artist = currentJson.get("artist_name").toString();
			String genre = currentJson.get("genre").toString();

			SongEntry currentSong = new SongEntry(title, duration, artist, genre);
			arrayOfSongs[counter++] = currentSong;
		}			

	}

	/**
	 * returns the array of song entries
	 */
	public SongEntry[] getArrayOfSongs()
	{	return arrayOfSongs; }

	/**
	 * displays the array of song entries
	 */
	public void printAllSongs()
	{
		for (SongEntry song : arrayOfSongs)
			System.out.println(song);
	}

	/**
	 * Calls a JSONParse part of the "org.json.simple" package to parse the input file.
	 * Stores each song entry in an array of SongEntry.
	 * Demonstrates measuring elapsed time of an example algorithm.
	 */
	public static void main(String[] args) {

		JSONParser jsonParser = new JSONParser();

		try {

			// --------------------
			// parse the JSON file
			FileReader fileReader = new FileReader(jsonFilePath);

			JSONObject jsonObject = (JSONObject) jsonParser.parse(fileReader);

			JSONArray allSongs = (JSONArray) jsonObject.get("songs");

			System.out.println("Parsing JSON file...");
			MillionSongDataSubset dataSet = new MillionSongDataSubset(allSongs);

			// display unsorted array of songs
			System.out.println("Completed parsing JSON file.");
			if (ENABLE_DATA_OUTPUT)
				dataSet.printAllSongs();

			// --------------------
			// use to measure the run time
			long startTime, estimatedTime;

			System.out.println("Sorting array of " + dataSet.getArrayOfSongs().length + " songs via BubbleSort...");

			// measuring run time of an example algorithm
			startTime = System.nanoTime();    

			// sort
			SongEntry.setSortType(SongEntry.SORT_BY_DURATION);
			BubbleSort.sortArray(dataSet.getArrayOfSongs());

			estimatedTime = System.nanoTime() - startTime;

			// display the sorted list
			if (ENABLE_DATA_OUTPUT)
				dataSet.printAllSongs();

			// report algorithm time
			System.out.println("\nAlgorithm Elapsed Time: "
					+ TimeConverter.convertTimeToString(estimatedTime) + ", "
					+ " seconds.\n");

		} 
		catch (FileNotFoundException e) 
		{	e.printStackTrace(); } 
		catch (IOException e) 
		{	e.printStackTrace(); } 
		catch (ParseException e) 
		{	e.printStackTrace(); }
	}
}
