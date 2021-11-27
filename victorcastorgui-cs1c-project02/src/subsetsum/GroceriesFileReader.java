package subsetsum;

import java.io.*;
import java.util.ArrayList;
/**
 * This class is able to read the groceries text file that is given
 * by the professor and it finds the prices of the item.
 *
 * @author Foothill College, Victor Castor
 */
public class GroceriesFileReader
{
    /**
     * @param filePath path in the computer.
     * @return ArrayList of the price of groceries.
     */
    public ArrayList<Double> readFile(String filePath)
    {
        ArrayList<Double> listOfGroceries = new ArrayList<Double>();
        String input= "";
        String[] price; //Array to put the price.

        try
        {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            input = br.readLine();

            // Separatation between each price by putting comma.
            while ((line = br.readLine()) != null)
            {
                input += "," + line;
            }

            price = input.split (",");

            for(int i = 1; i < price.length; i += 2)
                listOfGroceries.add(Double.parseDouble(price[i]));

            br.close();
        }

        catch (IOException e)
        {
        }

        return listOfGroceries;
    }
}
