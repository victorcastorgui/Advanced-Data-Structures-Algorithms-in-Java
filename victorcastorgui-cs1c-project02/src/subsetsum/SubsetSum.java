package subsetsum;

import java.util.ArrayList;

/**
 * This class enables the program to find the suitable items
 * depending on the budget that will be given by the user.
 *
 * @author Foothill College, Victor Castor
 */

public class SubsetSum
{
    /**
     * find ArrayList of closest or same input price to groceries' price
     * @param list ArrayList of prices
     * @param budget budget of the groceries.
     * @return ArrayList for the prices that matched with the budget and list.
     */
    public static ArrayList<Double> findSubset
    (ArrayList<Double> list, double budget)
    {
        Sublist sublist = new Sublist(list);

        if(sublist.getTotalObjects() < budget)
            return sublist.objects;
        subsetHelper(sublist, budget);

        return findSubsetHelper(sublist, subsetHelper(sublist, budget));
    }

    /**
     * method helper for findSubset
     * @param list
     * @param budget
     * @return sublist of prices
     */
    private static ArrayList<Sublist> subsetHelper(Sublist list, double budget)
    {
        ArrayList<Sublist> sublist = new ArrayList<Sublist>();
        sublist.add(list);
        double price;

        while (true)
        {
            for(int i = 0; i < list.objects.size(); i++)
            {
                for(int k = 0, val = sublist.size(); k < val; k++)
                {
                    price = sublist.get(k).getSum()
                            + list.objects.get(i);

                    if (price <= budget)
                        sublist.add(sublist.get(k).addItem(i));
                }
            }

            break;
        }

        return sublist;
    }

    /**
     * Using method helper to create list of prices.
     * @param list
     * @param sublist
     * @return Arraylist to enable closest match or exact match
     */
    private static ArrayList<Double> findSubsetHelper
    (Sublist list, ArrayList<Sublist> sublist)
    {
        // Making list in order.
        int last = 0;

        for(int i = 1; i < sublist.size(); i++)
            if(sublist.get(last).getSum() < sublist.get(i).getSum())
                last = i;

        ArrayList<Double> priceFound = new ArrayList<Double>();

        for(int k = 0; k < sublist.get(last).indices.size(); k++)
            priceFound.add
                    (list.objects.get(sublist.get(last).indices.get(k)));

        return priceFound;
    }
}

class Sublist implements Cloneable
{
    private double sum = 0.0;
    private double totalObjects = 0.0;
    protected ArrayList<Double> objects;
    protected ArrayList<Integer> indices;

    /**
     * print the sublist
     */
    void showSublist()
    {
        System.out.print("[");

        for(int i = 0; i < indices.size(); i++)
        {
            System.out.print(objects.get(indices.get(i)));

            if(i != (indices.size() - 1))
                System.out.print(", ");
        }

        System.out.println("]");
    }

    /**
     * Default constructor that creates list of prices.
     * @param original the input ArrayList of prices
     */
    public Sublist(ArrayList<Double> original)
    {
        sum = 0.0;
        objects = original;
        sumTotalObjects();
        indices = new ArrayList<Integer>();
    }

    /**
     * Calculate totalObjects
     */
    private void sumTotalObjects()
    {
        for(int i = 0; i < objects.size(); i++)
            totalObjects += objects.get(i);
    }

    /**
     * add index of item to add to the cloned sublist
     * @param indexOfItemToAdd
     * @return the cloned sublist with added index of item
     */
    Sublist addItem( int indexOfItemToAdd)
    {
        Sublist cloneObject = null;

        try
        {
            cloneObject = (Sublist)this.clone();
        }

        catch (CloneNotSupportedException e) {}

        cloneObject.indices.add(indexOfItemToAdd);

        cloneObject.sum += cloneObject.objects.get(indexOfItemToAdd);

        return cloneObject;
    }

    /**
     * accessor for sum of prices
     * @return sum of prices
     */
    double getSum()
    {
        return sum;
    }

    /**
     * accessor for totalObjects
     * @return totalObjects
     */
    double getTotalObjects()
    {
        return totalObjects;
    }

    /**
     * copy sublist object with deep copied indices
     * @return new cloned Sublist object
     * @throws CloneNotSupportedException
     */
    public Object clone() throws CloneNotSupportedException
    {
        // shallow copy
        Sublist newObject = (Sublist)super.clone();
        // deep copy
        newObject.indices = (ArrayList<Integer>)indices.clone();

        return newObject;
    }
}