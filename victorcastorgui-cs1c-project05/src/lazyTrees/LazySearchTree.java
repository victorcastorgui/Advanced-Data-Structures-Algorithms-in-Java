package lazyTrees;

import java.util.*;

/**
 * This class is given by the instructure and I add and change codes that follows the assignment.
 * This class is a implementation of soft deletion in Binary Search Tree
 *
 * @author Foothill College, [VICTOR CASTOR]
 * @param <E> objects for the tree
 */
public class LazySearchTree<E extends Comparable< ? super E > >
        implements Cloneable
{
    protected int mSize;
    protected int mSizeHard;
    protected LazySTNode mRoot;

    /**
     * This is a default constructor that takes in no parameter,
     * its job is just to clear the tree
     */
    public LazySearchTree()
    {
        clear();
    }

    /**
     * Boolean method that checks if there's nodes in the tree.
     * @return true/false
     */
    public boolean empty()
    {
        return (mSize == 0);
    }

    /**
     * This is an accessor for the size of tree only for undeleted nodes
     * @return the number of undeleted nodes inside the tree
     */
    public int size()
    {
        return mSize;
    }

    /**
     * This is an accessor for the size of tree including both deleted and undeleted nodes
     * @return the number of all nodes inside the tree
     */
    public int sizeHard()
    {
        return mSizeHard;
    }

    /**
     * This is a void method that takes in no parameter.
     * This is used to clear nodes in the tree.
     */
    public void clear()
    {
        mSize = 0;
        mSizeHard = 0;
        mRoot = null;
    }

    /**
     * Find the height of the tree
     * @return int of height of the tree
     */
    public int showHeight()
    {
        return findHeight(mRoot, -1);
    }

    /**
     * If mRoot is null, it will throw exception. Otherwise, it will find
     * the lowest value of undeleted node in the tree.
     * @return the data node
     */
    public E findMin()
    {
        if (mRoot == null)
            throw new NoSuchElementException();
        return findMin(mRoot).data;
    }

    /**
     * This is similar to above, it will throw exception if mRoot is null
     * Otherwise, it will find the highest value of undeleted node in the tree
     * @return the data node
     */
    public E findMax()
    {
        if (mRoot == null)
            throw new NoSuchElementException();
        return findMax(mRoot).data;
    }

    /**
     * This particular code is used to search a data in the tree
     * @param x any object to be searched
     * @return the data of the found node
     */
    public E find( E x )
    {
        LazySTNode resultNode;
        resultNode = find(mRoot, x);
        if (resultNode == null)
            throw new NoSuchElementException();
        return resultNode.data;
    }

    /**
     * This boolean method, is used to check if there is data in the tree that
     * is identical to find(), but instead of returning the data of the found node, it will return
     * true or false.
     * @param x any object to be searched
     * @return true/false base on test
     */
    public boolean contains(E x)
    {
        return find(mRoot, x) != null;
    }

    /**
     * This is a boolean method, it takes in one parameter.
     * It checks if a data is inserted
     * @param x any object to be inserted
     * @return true/false based on the test
     */
    public boolean insert( E x )
    {
        int oldSize = mSize;
        mRoot = insert(mRoot, x);
        return (mSize != oldSize);
    }

    /**
     * This is a boolean method, it takes in one parameter.
     * It check if a data is removed from the tree
     * @param x any object to be removed
     * @return true/false based on the test
     */
    public boolean remove( E x )
    {
        int oldSize = mSize;
        remove(mRoot, x);
        return (mSize != oldSize);
    }

    /**
     * This is a void method that extends the class Traverser. Takes in one parameter. It visits
     * undeleted nodes in the tree.
     * @param func function object that implements a visit method
     * @param <F> any objects implements Traverser
     */
    public < F extends Traverser<? super E > >
    void traverseSoft(F func)
    {
        traverseSoft(func, mRoot);
    }

    /**
     * This is also a void method that takes in one parameter. But instead of visiting all
     * undeleted node, it visits all nodes in the tree.
     * @param func function object that implements a visit method
     * @param <F> any objects implements Traverser
     */
    public < F extends Traverser<? super E > >
    void traverseHard(F func)
    {
        traverseHard(func, mRoot);
    }

    /**
     * This is a clone the tree
     * @return the cloned tree
     * @throws CloneNotSupportedException will throw error when cloning happens
     */
    public Object clone() throws CloneNotSupportedException
    {
        LazySearchTree<E> newObject = (LazySearchTree<E>)super.clone();
        newObject.clear();  // can't point to other's data

        newObject.mRoot = cloneSubtree(mRoot);
        newObject.mSize = mSize;
        newObject.mSizeHard = mSizeHard;

        return newObject;
    }

    /**
     * This is a constructor that takes in one parameter.
     * It finds the lowest value of undeleted node in the tree.
     * @param root the node to be searched
     * @return the found node
     */
    protected LazySTNode findMin(LazySTNode root )
    {
        if (root == null)
            return null;

        LazySTNode temp = findMin(root.lftChild);
        if (temp != null)
            return temp;

        if (!root.deleted)
            return root;

        temp = findMin(root.rtChild);
        if (temp != null)
            return temp;

        return null;
    }

    /**
     * This is a constructor that takes in one parameter.
     * But instead of finfing the lowes value of the undelted node, It finds
     * the lowest value of all nodes in the tree
     * @param root the node to be searched
     * @return the found node
     */
    protected LazySTNode findMinHard(LazySTNode root )
    {
        if (root == null)
            return null;
        if (root.lftChild == null)
            return root;
        return findMinHard(root.lftChild);
    }

    /**
     * This is a constructor that takes in one parameter.
     * It finds the highest value of undeleted node in the tree
     * @param root the node to be searched
     * @return the found node
     */
    protected LazySTNode findMax(LazySTNode root )
    {
        if (root == null)
            return null;

        LazySTNode temp = findMax(root.rtChild);
        if (temp != null)
            return temp;

        if (!root.deleted)
            return root;

        temp = findMax(root.lftChild);
        if (temp != null)
            return temp;

        return null;
    }

    /**
     * This is a constructor that takes in one parameter.
     * It finds the highest value of all nodes in the tree
     * @param root the node to be searched
     * @return the found node
     */
    protected LazySTNode findMaxHard(LazySTNode root )
    {
        if (root == null)
            return null;
        if (root.rtChild == null)
            return root;
        return findMaxHard(root.rtChild);
    }


    /**
     * This is a constructor that takes in two parameter.
     * It inserts a data inside a root node
     * @param root the node where a data will be inserted
     * @param x object to be inserted
     * @return the node inserted.
     */
    protected LazySTNode insert(LazySTNode root, E x )
    {
        int compareResult;  // avoid multiple calls to compareTo()

        if (root == null)
        {
            mSize++;
            mSizeHard++;
            return new LazySTNode(x, null, null, false);
        }

        compareResult = x.compareTo(root.data);
        if ( compareResult < 0 )
            root.lftChild = insert(root.lftChild, x);
        else if ( compareResult > 0 )
            root.rtChild = insert(root.rtChild, x);
        else
        {
            if (root.deleted)
            {
                root.deleted = false;
                mSize++;
            }
        }
        return root;
    }

    /**
     * This is a protected void method that takes in two parameter. It changes deleted
     * value of a data to be true
     * @param root node where the data will be removed
     * @param x any object to be removed
     */
    protected void remove(LazySTNode root, E x)
    {
        int compareResult;  // avoid multiple calls to compareTo()

        if (root == null)
            return;

        compareResult = x.compareTo(root.data);
        if ( compareResult < 0 )
            remove(root.lftChild, x);
        else if ( compareResult > 0 )
            remove(root.rtChild, x);

        else
        {
            root.deleted = true;
            mSize--;
        }
    }

    /**
     * This is a constructor that takes in two parameter. It removes a data inside a root node
     * @param root node where the data will be removed
     * @param x any object to be removed
     * @return the new root after removal
     */
    protected LazySTNode removeHard(LazySTNode root, E x  )
    {
        int compareResult;  // avoid multiple calls to compareTo()

        if (root == null)
            return null;

        compareResult = x.compareTo(root.data);
        if ( compareResult < 0 )
            root.lftChild = removeHard(root.lftChild, x);
        else if ( compareResult > 0 )
            root.rtChild = removeHard(root.rtChild, x);

            // found the node
        else if (root.lftChild != null && root.rtChild != null)
        {
            root.data = findMinHard(root.rtChild).data;
            root.rtChild = removeHard(root.rtChild, root.data);
        }
        else
        {
            root =
                    (root.lftChild != null)? root.lftChild : root.rtChild;
            mSize--;
        }
        return root;
    }

    /**
     * This is a protected void method that takes in two parameter. It
     * visits every undeleted nodes in the tree
     * @param func function object that implements a visit method
     * @param treeNode the node to be traversed down
     * @param <F> object that implements Traverser
     */
    protected <F extends Traverser<? super E>>
    void traverseSoft(F func, LazySTNode treeNode)
    {
        if (treeNode == null)
            return;

        traverseSoft(func, treeNode.lftChild);
        if (!treeNode.deleted)
            func.visit(treeNode.data);
        traverseSoft(func, treeNode.rtChild);
    }

    /**
     * This is a protected void method that takes in two parameter. It
     * visits all nodes in the tree.
     * @param func function object that implements a visit method
     * @param treeNode the node to be traversed down
     * @param <F> any object that implements Traverser
     */
    protected <F extends Traverser<? super E>>
    void traverseHard(F func, LazySTNode treeNode)
    {
        if (treeNode == null)
            return;

        traverseHard(func, treeNode.lftChild);
        func.visit(treeNode.data);
        traverseHard(func, treeNode.rtChild);
    }

    /**
     * This takes in two parameters. It finds the undeleted data inside a root node.
     * @param root the root node for the data
     * @param x any object to be searched
     * @return the found node
     */
    protected LazySTNode find(LazySTNode root, E x )
    {
        int compareResult;  // avoid multiple calls to compareTo()

        if (root == null)
            return null;

        compareResult = x.compareTo(root.data);
        if (compareResult < 0)
            return find(root.lftChild, x);
        if (compareResult > 0)
            return find(root.rtChild, x);

        return root.deleted? null : root;
    }

    /**
     * This is a helper to clone the subtree
     * @param root node to be cloned
     * @return the cloned node
     */
    protected LazySTNode cloneSubtree(LazySTNode root)
    {
        LazySTNode newNode;
        if (root == null)
            return null;

        // does not set myRoot which must be done by caller
        newNode = new LazySTNode
                (
                        root.data,
                        cloneSubtree(root.lftChild),
                        cloneSubtree(root.rtChild),
                        root.deleted
                );
        return newNode;
    }

    /**
     * This takes in two parameters. It finds the height of the tree
     * @param treeNode root node to be analyzed
     * @param height height of current tree
     * @return int of height of the tree
     */
    protected int findHeight(LazySTNode treeNode, int height )
    {
        int leftHeight, rightHeight;
        if (treeNode == null)
            return height;
        height++;
        leftHeight = findHeight(treeNode.lftChild, height);
        rightHeight = findHeight(treeNode.rtChild, height);
        return (leftHeight > rightHeight)? leftHeight : rightHeight;
    }

    // This class is rename from FHTreeNode and is added some codes,
    /**
     * This is a inner class inside Binary Search Tree
     * the node containing an object and referencing to left and right child
     */
    private class LazySTNode
    {
        private LazySTNode lftChild, rtChild;
        private E data;
        private LazySTNode myRoot;
        private boolean deleted;

        /**
         * This constructor takes in four parameters to set the data and the other references
         * @param d any object to be stored in the node
         * @param lft reference to the left child of the node
         * @param rt reference to the right child of the node
         * @param deleted reference to signal if the node is *softly* deleted
         */
        public LazySTNode(E d, LazySTNode lft, LazySTNode rt, boolean deleted)
        {
            lftChild = lft;
            rtChild = rt;
            data = d;
            this.deleted = deleted;
        }

        /**
         * This is a default constructor to set default value.
         */
        public LazySTNode()
        {
            this(null, null, null, true);
        }
    }
}