package stacks;

/**
 * Define the class Navigator that provides three navigation options where the user can, set the current
 * link via setCurrentLink(linkName) method, replace the current link by going back one link via goBack()
 * method, and replace the current link by going forward one link via goForward() method.
 *
 * @author Foothill College, VICTOR CASTOR
 */
public class Navigator
{
    private String currentLink;
    private StackList<String> backLinks;
    private StackList<String> forwardLinks;

    /**
     * simple accessor for getting current link
     *
     * @return the current link
     */
    public String getCurrentLink()
    {
        return currentLink;
    }

    /**
     * simple accessor for getting back links
     *
     * @return stack of back links
     */
    public StackList<String> getBackLinks()
    {
        return backLinks;
    }

    /**
     * simple accessor for getting forward links
     *
     * @return stack of back links
     */
    public StackList<String> getForwardLinks()
    {
        return forwardLinks;
    }

    /**
     * default constructor that takes no parameter. This constructor set everything into null
     * since there is no link yet to be collected. Nothing will be printed.
     */
    public Navigator()
    {
        this("",
                new StackList<>("Back", null),
                new StackList<>("Forward", null));
    }

    /**
     * This constructor takes in three parameter which is the currentLink, backLinks, and
     * forwardLinks. Then it sets the links for all three.
     *
     * @param currentLink set current link
     * @param backLinks set back links
     * @param forwardLinks set forward links
     */
    public Navigator(String currentLink, StackList<String> backLinks,
                     StackList<String> forwardLinks)
    {
        this.currentLink = currentLink;
        this.backLinks = backLinks;
        this.forwardLinks = forwardLinks;
    }

    /**
     * This constructor warns the user if there is no back links left. If there is back links
     * then it will remove the top link in the back links.
     */
    public void goBack()
    {
        if (backLinks.top == null)
        {
            System.out.print("\nNO BACK LINKS LEFT!!!");
            return;
        }

        forwardLinks.push(currentLink);
        currentLink = backLinks.pop();
    }

    /**
     * This is similar to the constructor above but the difference is that this one check the forward links.
     */
    public void goForward()
    {
        if (forwardLinks.top == null)
        {
            System.out.print("\nNO FORWARD LINKS LEFT!!!");
            return;
        }

        backLinks.push(currentLink);
        currentLink = forwardLinks.pop();
    }

    /**
     * This boolean method constructor sets the current link and push previous link to the back links
     * and clear stack forward links. If the currentLink does not have any link then it will return false
     * and nothing will be added. If there is something then the previous currentLink is pushed back.
     *
     * @param currentLink link to update
     * @return true or false
     */
    public boolean setCurrentLink(String currentLink)
    {
        if (currentLink == "" || currentLink == null)
            return false;

        if (this.currentLink != null)
            backLinks.push(this.currentLink);

        while (forwardLinks.pop() != null)
            ;

        this.currentLink = currentLink;

        return true;
    }
}