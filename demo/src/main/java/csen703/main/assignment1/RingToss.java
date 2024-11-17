package csen703.main.assignment1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unused")
public class RingToss {

    public static int RingTossGreedyX(int[] pegs) {
        int n = pegs.length;
        int[] current = new int[n];
        int tosses = 0;
        int i = 0;
        int iter = 0;

        do {
            if(current[i]==pegs[i]) {
                ++i;
                continue;
            }
            for(int j = i; j < n && ((pegs[j] - current[j])>0); ++j) {
                ++current[j];
                iter++;
            }
            ++tosses;
        } while(i < n);
        System.out.println("n: " + n);
        System.out.println("Iterations: " + iter);
        return tosses;
    }

    public static int RingTossGreedyY(int[] pegs) {
        if (pegs.length == 0) return 0;

        int tosses = 0;
        int currentMax = Math.max(pegs[1], pegs[0]);

        for (int i = 2; i < pegs.length; i++) {
            if ((pegs[i-2] > pegs[i-1] && pegs[i-1] < pegs[i])) {
                tosses += currentMax;
                currentMax = pegs[i];
            } else {
                currentMax = Math.max(currentMax, pegs[i]);
            }
        }

        tosses += currentMax;

        return tosses;
    }

    public static boolean[] findLocalMinimums(int[] arr) {
        boolean[] localMinimums = new boolean[arr.length];
        int counter = 0;

        if(arr[0] < arr[1]) {
            localMinimums[0] = true;
            counter++;
        }

        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] < arr[i - 1] && arr[i] < arr[i + 1]) {
                localMinimums[i] = true;
                counter++;
            }
        }

        if(arr[arr.length-1] < arr[arr.length-2]) {
            localMinimums[arr.length-1] = true;
            counter++;
        }
        System.out.println("Local Minimums: " + Arrays.toString(localMinimums));
        return localMinimums;
    }

    public static boolean[] detectLocalMinimums(int[] arr) {
        boolean[] localMinimums = new boolean[arr.length];
        for (int i = 1; i < arr.length-1; i++) {
            if (i > 0 && i < arr.length - 1 && ((arr[i] < arr[i - 1] && arr[i] <= arr[i + 1]) || (arr[i] == arr[i + 1] && arr[i] < arr[i - 1] && (i + 1 == arr.length - 1 || arr[i] < arr[i + 2])))) {
                localMinimums[i] = true;            
            }
        }
        return localMinimums;
    }

    public static boolean[] findLocalMaximums(int[] arr) {
        boolean[] localMaximums = new boolean[arr.length];
        int counter = 0;

        if(arr[0] > arr[1]) {
            localMaximums[0] = true;
            counter++;
        }

        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                localMaximums[i] = true;
                counter++;
            }
        }

        if(arr[arr.length-1] > arr[arr.length-2]) {
            localMaximums[arr.length-1] = true;
            counter++;
        }
        System.out.println("Local Maximums: " + counter);
        return localMaximums;
    }

    public static int RingTossGreedy(int[] pegs) {

        int tosses = 0;
        int currentMax = 0;
        boolean[] localMinimums = detectLocalMinimums(pegs);

        for (int i = 0; i < pegs.length; i++) {
            if(localMinimums[i]) { //[2,3,4,2,1]
                tosses += currentMax - pegs[i];
                currentMax = pegs[i];
            } else {
                currentMax = Math.max(pegs[i], currentMax);
            }
        }

        tosses += currentMax;

        return tosses;
    }

    public static int RingTossGreedyZ(int[] pegs) {
        if (pegs.length == 0) return 0;
        if (pegs.length == 1) return pegs[0];
        if (pegs.length == 2) return Math.max(pegs[0], pegs[1]);

        int tosses = 0;
        boolean[] localMaximums = findLocalMaximums(pegs);

        for (int i = 0; i < pegs.length; i++) {
            if(localMaximums[i]) {
                tosses += pegs[i];
                System.out.println("Added: " + pegs[i] + " when I saw: " + pegs[i] + " @ " + i);
            }
        }

        return tosses;
    }

    public static void main(String[] args) {
        //int[] pegs = {0, 7, 4, 5, 7, 7, 5, 2, 1, 7, 1, 4, 2, 3, 2, 3, 0,  1, 0, 5, 0, 2, 1, 0, 2, 3, 4, 4, 5, 0, 3, 0, 0, 0, 1, 2, 7, 1, 1, 2, 3, 6, 0, 7, 4, 1, 2, 2, 2, 1 };
        //int[] pegs= { 8, 8, 8, 9, 2, 8, 5, 8, 0, 8, 0,  1, 0, 1, 3, 0, 2, 8, 5, 5, 6, 9, 10, 1, 2, 1, 4, 7, 6, 4,  5, 2, 0,  2, 9, 5,  10, 8, 3, 3, 3, 1, 1,  8, 4, 2, 1, 10, 7, 7};
        //int[] pegs= {5, 0, 0, 5, 3, 0, 0, 4, 3, 0, 0, 4, 5, 4, 2, 2, 1, 3, 0, 4, 5, 5, 5, 0, 5, 1, 2, 0, 3, 2, 4, 5, 0, 0, 0, 2, 3, 4, 3, 4, 5, 2, 4, 2, 2, 5, 3, 2, 2, 3};
        int[] pegs={2,3,4,2,1};
        //heuristic is we loop from beginning and add1 to all consecutive indexes that have a diff greater than or equal to current diff and add 1
        //detectLocalMinimums(pegs);
        int result = RingToss.RingTossGreedy(pegs);
        System.out.println(result);
    }
}
