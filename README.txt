CSCE-340-HW2
--------------

Microsoft has just hired you as a consultant to help them reduce costs in their customer service department. They digitally record customer service phone calls and store all the sound files on portable disks at the end of each week. Since your marginal cost is proportional to the total number of disks used, your task is to assign the sound files to disks using as few disks as possible. This problem is NP-hard; thus, it seems hopeless to find an efficient algorithm for finding the optimal packing. Instead, your goal is to design heuristics that run fast and produce high quality solutions.

We formulate the bin packing problem as follows: given a set of N file sizes between 0 and 1,000,000 KB (1 GB), find a way to assign them to a minimal number of disks, each of capacity 1 GB. 

The worst-fit heuristic is a simple rule that considers the file sizes in the order they are presented:  
if the sound file won't fit on any disk, create a new disk; otherwise place the file on a disk that has the most remaining space. 
o	For example, this algorithm would put the sizes 700,000, 800,000, 200,000, 150,000, 150,000 onto three disks: {700,000, 200,000}, {800,000, 150,000}, {150,000}. Note that this does not necessarily lead to the best solution since the five files could fit on two disks.  Your main task is to implement the worst-fit heuristic.

Priority queue ADT. 
--------------------------
You will need to develop an efficient data structure to support all of the basic operations to implement the heuristic. For the worst-fit heuristic, you will certainly need insert and delete the maximum. The priority queue MaxPQ.java (posted on Blackboard) is a judicious choice. 

Input and output. 
--------------------------
Your client program will read in the set of file sizes (guaranteed to be between zero and a million) from standard input. 
Your program should output the number of disks used by the heuristic and the sum of all file sizes divided by 1 million (a lower bound on the number of disks required). 
If the number of files is less than 100, you should also print out the disks in decreasing order of remaining space. For each disk, print out its remaining space and its contents (in the order the file sizes were inserted). Optionally, you may also print out a unique id associated with each disk (assigned in the order the disks were created) to aid in debugging.

Worst-fit decreasing. 
--------------------------
The worst-fit decreasing heuristic is to do worst-fit, but first preprocess the file sizes so that they are in descending order. 
A modular way to implement this heuristic is to write a separate program IntegerSorter.java that reads in a sequence of integers and prints them out in descending order. Then you can pipe the results through your worst-fit heuristic.
