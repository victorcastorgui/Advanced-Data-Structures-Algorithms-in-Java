project folder:
victorcastorgui-cs1c-project05/

Brief description of submitted files:

resources/inventory_log.txt
    - Input file to test BST soft deletion implementation in
      SuperMarket class, the difference between the output
      when traversing the hard tree vs the soft tree.

resources/inventory_short.txt
    - Input file to test BST soft deletion implementation in
      SuperMarket class by showing removal of an item where
      tree root has both left and right children.

resources/inventory_invalid_removal.txt
    - Input file to test BST soft deletion implementation in
      SuperMarket class showing removal of an Item which
      was previously lazily removed from our LazySearchTree.

resources/inventory_owntest_1.txt
    - Input file to test BST soft deletion
      implementation in SuperMarket class showing removing
      an item from the first and last node and test
      findMin() and findMax() methods.

resources/inventory_owntest_2.txt
    - Long version of input file to test BST soft deletion
      implementation in SuperMarket class showing removing
      an item from the first and last node and test
      findMin() and findMax() methods.

resources/RUN.txt
    - Output of tests.
        - inventory_log.txt
        - inventory_short.txt
        - inventory_invalid_removal.txt
        - inventory_owntest_1.txt
        - inventory_owntest_2.txt

src/lazyTrees/SuperMarket.java
    - This is the main class where resources will be tested.
    - This class simulates soft deletion BST by adding and removing items to the tree.
    - Tests file are changed in line 184.

src/lazyTrees/LazySearchTree.java
    - This class is mostly given by the instructor. It has a outer class and inner class.
    - This class implements soft deletion in BST.
    - FHsearch_tree.java is renamed to LazySearchTree
    - FHs_treeNode.java is renamed to LazySTNode

src/lazyTrees/Item.java
    - One object of Item class represents one item in the inventory, with two class members.
    - Which is count and number.

src/lazyTrees/PrintObject.java
    - This class is given by the instructor it is a function object that implements visit() method from an interface

src/lazyTrees/Traverser.java
    - This class is given by the instructor it is an interface containing visit() method.

README.txt
    - description of submitted files