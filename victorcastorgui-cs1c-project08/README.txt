project folder:
victorcastorgui-cs1c-project08/

Conclusion:
Based on looking at the graphs and data, the runtime gets slower as recursion limit increases. Furthermore,
there is a difference between the runtime when the array sizes is getting bigger. We can see that when
the array size getting bigger, the insertion sort works slower and slower. Finally, quick sort is a good choice
to sort the elements.

Comments:
After spending time to find the best way to import data to spreadsheet, I finally use Apache POI. It helps
to import data to excel. I also add public static long getMilliSeconds in timeConverter class. To get the
milliseconds of sorting time.

Brief description of submitted files:

.idea/libraries
    - poi_4_1_2.xml
    - Apache POI to import data to excel.

resources/Project08_sortAnalysis.xlsx
    - Imported result of runtime from quickSort.QuickSortAnalysis.java and analysis of graphs.
    - Array sizes:
        - 20000
        - 80000
        - 320000
        - 1280000
        - 5120000
        - 20480000

resources/Array_Size_20000_snap.PNG
    - Array sized 20000 runtime graph snapshot

resources/Array_Size_80000_snap.PNG
    - Array sized 80000 runtime graph snapshot

resources/Array_Size_320000_snap.PNG
    - Array sized 320000 runtime graph snapshot

resources/Array_Size_1280000_snap.PNG
    - Array sized 1280000 runtime graph snapshot

resources/Array_Size_5120000_snap.PNG
    - Array sized 5120000 runtime graph snapshot

resources/Array_Size_20480000_snap.PNG
    - Array sized 20480000 runtime graph snapshot

resources/RUN.txt
    - Output details of QuickSort runtime.
    - From 2 to 300 by 2 steps, the array sized 20000 to 20480000.

src/cs1c/FHSort.java
    - Sorting algorithm collection.

src/cs1c/TimeConverter.java
    - Converts duration into a string representation.

src/quickSort/QuickSortAnalysis.java
    - This is the main class.
    - The recursion limit varies from 2 to 300 by 2 steps, the array sized 20000 to 20480000.
    - Testing the effectiveness of QuickSort.
    - After a lot of testing, the maximum array size is 20480000. I tried more but my computer
      overheat.
    - The result will be imported directly to excel.

README.txt
    - description of submitted files