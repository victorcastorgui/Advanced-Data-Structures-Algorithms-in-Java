project folder:
victorcastorgui-cs1c-project06/

Brief description of submitted files:

resources/inventory_log.txt
    - Testing the garbage collection in SuperMarket Class.
      Observing the difference between hard and soft traversal.
      The garbage collection threshold is 4.

resources/inventory_short.txt
    - Testing the garbage collection in SuperMarket
      Class. Showing an Item where user requests to buy a
      few items. The garbage collection threshold is 4.

resources/inventory_invalid_removal.txt
    - Testing the garbage collection in SuperMarket
      Class. Showing an Item with a count of 1 in the
      inventory and the user's request to buy the item
      twice. The garbage collection threshold is 4.

resources/inventory_threshold.txt
    - Testing the garbage collection in SuperMarket
      Class. The garbage collection threshold is 2.

resources/inventory_threshold2.txt
    - Testing the garbage collection in SuperMarket
      Class. The garbage collection threshold is 3.

resources/inventory_remove_all.txt
    - Testing the garbage collection in SuperMarket
      Class. Removing all items in inventory. The garbage
      collection threshold is 4.

resources/RUN.txt
    - Output of tests.
        - inventory_log.txt
        - inventory_short.txt
        - inventory_invalid_removal.txt
        - inventory_threshold.txt
        - inventory_remove_all.txt
        - inventory_remove_all.txt

src/lazyTrees/SuperMarket.java
    - This is the main class where resources will be tested.
    - This class simulates the collect garbage by removing items.
    - Tests file are changed in line 218 - 233.

src/lazyTrees/LazySearchTree.java
    - This class is mostly given by the instructor. It has a outer class and inner class.
    - This class implements soft and hard deletion in BST.
    - findMaxHard and findMinHard is added from the previous code.
    - collectGarbage is also added to enable the threshold.

src/lazyTrees/Item.java
    - One object of Item class represents one item in the inventory, with two class members.
    - Which is count and number.

src/lazyTrees/PrintObject.java
    - This class is given by the instructor it is a function object that implements visit() method from an interface

src/lazyTrees/Traverser.java
    - This class is given by the instructor it is an interface containing visit() method.

README.txt
    - description of submitted files