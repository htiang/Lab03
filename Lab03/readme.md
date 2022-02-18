My first algorithm had an average runtime of 31ms at 10000 elements; 2603ms at 100000; 27005ms at 1000000.

My second algorithm had an average runtime of 0ms at 10000 elements; 3ms at 100000; 32ms at 1000000.

The bubble sort algorithm is by far the worst sorting algorithm with a best and worst case scenario of O^n^2.
This can be observed with the 27005ms it took for my computer to sort a 1000000 element list.

The merge sort algorithm has a best and worst case of O(n*log n) and takes significantly less time than the bubble sort. 
An important thing to note is the recursive space it takes though. This issue could be solved by making a recursive function 
of merge sort.