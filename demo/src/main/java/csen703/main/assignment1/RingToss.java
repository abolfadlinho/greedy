package csen703.main.assignment1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unused")
public class RingToss {

    public static boolean[] detectLocalMinimums(int[] arr) {
        boolean[] localMinimums = new boolean[arr.length];
        for (int i = 1; i < arr.length-1; i++) {
            if (i > 0 && i < arr.length - 1 && ((arr[i] < arr[i - 1] && arr[i] <= arr[i + 1]) || (arr[i] == arr[i + 1] && arr[i] < arr[i - 1] && (i + 1 == arr.length - 1 || arr[i] < arr[i + 2])))) {
                localMinimums[i] = true;            
            }
        }
        return localMinimums;
    }

    public static int RingTossGreedy(int[] pegs) {

        int tosses = 0;
        int currentMax = pegs[0];
        boolean[] localMinimums = detectLocalMinimums(pegs);

        for (int i = 1; i < pegs.length; i++) {
            if(localMinimums[i]) {
                tosses += currentMax - pegs[i];
                currentMax = pegs[i];
            } else {
                currentMax = Math.max(pegs[i], currentMax);
            }
        }

        tosses += currentMax;

        return tosses;
    }

    public static void main(String[] args) {
        //int[] pegs = {0, 7, 4, 5, 7, 7, 5, 2, 1, 7, 1, 4, 2, 3, 2, 3, 0,  1, 0, 5, 0, 2, 1, 0, 2, 3, 4, 4, 5, 0, 3, 0, 0, 0, 1, 2, 7, 1, 1, 2, 3, 6, 0, 7, 4, 1, 2, 2, 2, 1 };
        //int[] pegs= { 8, 8, 8, 9, 2, 8, 5, 8, 0, 8, 0,  1, 0, 1, 3, 0, 2, 8, 5, 5, 6, 9, 10, 1, 2, 1, 4, 7, 6, 4,  5, 2, 0,  2, 9, 5,  10, 8, 3, 3, 3, 1, 1,  8, 4, 2, 1, 10, 7, 7};
        //int[] pegs= {5, 0, 0, 5, 3, 0, 0, 4, 3, 0, 0, 4, 5, 4, 2, 2, 1, 3, 0, 4, 5, 5, 5, 0, 5, 1, 2, 0, 3, 2, 4, 5, 0, 0, 0, 2, 3, 4, 3, 4, 5, 2, 4, 2, 2, 5, 3, 2, 2, 3};
        int[] pegs={2,3,4,2,1};
        //detectLocalMinimums(pegs);
        int result = RingToss.RingTossGreedy(pegs);
        System.out.println(result);
    }
}
