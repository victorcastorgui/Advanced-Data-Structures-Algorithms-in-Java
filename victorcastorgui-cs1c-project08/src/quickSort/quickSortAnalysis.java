package quickSort;

import cs1c.FHSort;
import cs1c.TimeConverter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Time;


/**
 * This class is a test program. A quickSort algorithm with recursion limit.
 * The recursion limit varies from 2 to 300 by 2 steps, the array sized 20000 to 20480000.
 * The result will be imported to Excel using Apache POI.
 *
 * @author CS1C, Foothill College, [VICTOR CASTOR]
 */
public class quickSortAnalysis
{
    //spreadsheet
    private static XSSFWorkbook workbook = new XSSFWorkbook();
    private static final String FILE_NAME = "resources/Project08_sortAnalysis.xlsx";
    private static final int UPPER_LIMIT_RECURSION = 300;
    private static final int LOWER_LIMIT_RECURSION = 2;
    private static final int UPPER_ARRAY_SIZE = 20480000;
    private static final int LOWER_ARRAY_SIZE = 20000;

    /**
     * This is the main method that takes in one parameter which int testSize
     * to test the runtime of recursion limit with different array size.
     * The result will be imported to excel spreadsheet.
     *
     * @param testSize array size
     */
    private static void compareRecLimQuickSort(int testSize)
    {
        int randomInt, rowDex, cellDex;
        long start, estimateTime;

        //Start from 0
        XSSFSheet sortAnalysisSheet = workbook.createSheet("Array Size " + testSize);
        rowDex = 0;
        cellDex = 0;

        // generate data to excel
        Row row = sortAnalysisSheet.createRow(rowDex++);
        row.createCell(cellDex++).setCellValue("Recursion Limit");
        row.createCell(cellDex++).setCellValue("Runtime in ms");

        Integer[] arrayOfInts = new Integer[testSize];
        Integer[] arrayCopy = new Integer[testSize];

        // build arrays for comparing recursion limit of quick sort
        generateRandomArray(arrayOfInts, arrayCopy, testSize);

        // sorting with different recursion limit
        for (int limit = LOWER_LIMIT_RECURSION; limit <= UPPER_LIMIT_RECURSION; limit += 2)
        {
            FHSort.setRecursionLimit(limit);

            start = System.nanoTime();
            FHSort.quickSort(arrayOfInts);
            estimateTime = System.nanoTime() - start;

            displaySortDetails(limit, estimateTime, testSize);

            row = sortAnalysisSheet.createRow(rowDex++);
            cellDex = 0;
            row.createCell(cellDex++).setCellValue(limit);

            // The class that is added in TimeConverter.java is added here.
            long milliseconds = TimeConverter.getMilliseconds(estimateTime);
            row.createCell(cellDex++).setCellValue(milliseconds);

            // reset sorted arrays to unsorted arrays
            resetSortedArray(arrayOfInts, arrayCopy, testSize);
        }
    }

    /**
     * This method takes in three parameters which is arrayOfInts,
     * arrayCopy and testSize. It generates random integer that
     * depends on array size.
     *
     * @param arrayOfInts to be filled with random ints
     * @param arrayCopy of the random ints array
     * @param testSize size of array
     */
    private static void generateRandomArray(Integer[] arrayOfInts, Integer[] arrayCopy, int testSize)
    {
        int randomInt;

        for (int k = 0; k < testSize; k++)
        {
            randomInt = (int) (Math.random() * testSize);
            arrayOfInts[k] = randomInt;
            arrayCopy[k] = randomInt;
        }
    }

    /**
     * THis method also takes in three parameters.
     * The already sorted array will be renewed to the original random ints array.
     *
     * @param arrayOfInts sorted ints array
     * @param arrayCopy original unsorted array
     * @param testSize size of array
     */
    private static void resetSortedArray(Integer[] arrayOfInts, Integer[] arrayCopy, int testSize)
    {
        for (int j = 0; j < testSize; j++)
            arrayOfInts[j] = arrayCopy[j];
    }

    /**
     * This method outputs the runtime, recursion limit and array size.
     *
     * @param limit recursion limit
     * @param estimatedTime runtime
     * @param testSize size of array
     */
    private static void displaySortDetails(int limit, long estimatedTime, int testSize)
    {
        System.out.println("Quick sort Elapsed Time: "
                + " recursion limit: " + limit
                + ", size: " + testSize + ", "
                + TimeConverter.convertTimeToString(estimatedTime)
                + " = " + estimatedTime + "ns");
    }

    /**
     * This method enables the program to write the output to the spreadsheet.
     */
    private static void outputToExcel()
    {
        try
        {
            FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
            workbook.write(outputStream);
            workbook.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Testing runtime of QuickSort algorithm with array sized from 20000 to 512000
     * and import the data to Excel Spreadsheet
     *
     * @throws Exception error handling of writing Excel Spreadsheet
     */
    public static void main(String[] args) throws Exception
    {
        for (int arraySize = LOWER_ARRAY_SIZE; arraySize <= UPPER_ARRAY_SIZE; arraySize *= 4)
        {
            compareRecLimQuickSort(arraySize);
            System.out.println();
        }

        outputToExcel();
    }
}