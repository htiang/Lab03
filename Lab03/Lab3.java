import java.lang.Math;
import java.time.Duration;

public class Lab3 {
    public static int[] arrayGenerator(int datasetSize)  {
        if(datasetSize<1) {

            throw new IllegalArgumentException();
        }
        int[] arr = new int[datasetSize];
        for(int i= 0;i<datasetSize; i++) {
            int rand = (int)(Math.random() * datasetSize); //numbers between 0 and the dataset size will be randomized;
            arr[i] = rand;
        }
        return arr;
    }
    //bubble sort
    public static void sortAlgorithm1(int[] dataset) {
        int x;
        for(int i = 0; i< dataset.length; i++) {
            for(int j = 0; j<dataset.length; j++) {

                if(dataset[j]>dataset[i]) {
                    x = dataset[i];
                    dataset[i] = dataset[j];
                    dataset[j] = x;
                }
            }
        }
    }

    //merge sort
    public static void sortAlgorithm2(int[] arr, int n) {
        if(n<2) {
            return;
        }
        int mid = n/2;
        int[] x = new int[mid];
        int[] y = new int[n - mid];

        for(int i = 0; i<mid; i++) {
            x[i] = arr[i];
        }
        for(int i = mid; i< n; i++) {
            y[i-mid] = arr[i];
        }
        sortAlgorithm2(x,mid);
        sortAlgorithm2(y,n-mid);
        merge(arr,x,y,mid,n-mid);
    }

    public static void merge(int[] arr, int[] x, int[] y, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (x[i] <= y[j]) {
                arr[k++] = x[i++];
            }
            else {
                arr[k++] = y[j++];
            }
        }
        while (i < left) {
            arr[k++] = x[i++];
        }
        while (j < right) {
            arr[k++] = y[j++];
        }
    }

    public static void printArr(int[] arr) {
        for(int i = 0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static Performance algorithmsComparator(int[] dataset, int iterations){
        int[] arr = dataset;
        Performance perf = new Performance(dataset[0], iterations);
        perf.setFirstAlgoStartTime(System.currentTimeMillis());
        for(int i = 0; i<iterations; i++) {
            sortAlgorithm1(arr);
            arr = dataset;
        }
        perf.setFirstAlgoEndTime(System.currentTimeMillis());

        perf.setSecondAlgoStartTime(System.currentTimeMillis());
        for(int i = 0;i<iterations; i++) {
            sortAlgorithm2(arr,arr.length);
            arr = dataset;
        }
        perf.setSecondAlgoEndTime(System.currentTimeMillis());


        return perf;
    }

    public static String checkPerformanceForMultipleArraySizes(int[] arraySizes, int iterations){
        // TODO: Add code here
        Performance[] list = new Performance[arraySizes.length];
        for(int i = 0; i<arraySizes.length; i++) {
            int[] arr = arrayGenerator(arraySizes[i]);
            list[i] = algorithmsComparator(arr,iterations);
        }
        StringBuilder response = new StringBuilder();
        for (int i = 0; i < arraySizes.length; i++){
            // TODO: Add code here and replace <name> on the next line.
//            int[] arr = arrayGenerator(arraySizes[i]);
//            long[] times = new long[2];
//            Performance performance = new Performance(arraySizes[i],iterations);
//
//
//            response.append("For dataset of " + arraySizes[i] + " numbers firstAlgoPerformance="+ times[0] + ", secondAlgoPerformance="+ times[1]);
            response.append(list[i].toString());
            response.append(System.getProperty("line.separator"));
        }
        return response.toString();
    }

    public static void main(String[] args) {
//        int[] arr = arrayGenerator(9);
//        sortAlgorithm2(arr,arr.length);
//        printArr(arr);
        int[] arraySizes = new int[] {10000, 100000, 1000000};
        int iterations = 10;
        System.out.println(checkPerformanceForMultipleArraySizes(arraySizes,iterations));
    }
}
