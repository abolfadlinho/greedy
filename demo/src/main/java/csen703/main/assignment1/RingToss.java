package csen703.main.assignment1;

import java.util.Arrays;

public class RingToss {
    public static int RingTossGreedy(int[] pegs) {
        int n = pegs.length;
        int[] current = new int[n];
        int tosses = 0;
        int i = 0;


        while(i < n && current[i]<=pegs[i]) {
            if(current[i]==pegs[i]) {
                //System.out.println(Arrays.toString(current));
                i++;
                continue;
            }
            int diff = pegs[i] - current[i];
            for(int j = i; j < n && ((pegs[j]-current[j])>=diff);j++) {
                //System.out.println(Arrays.toString(current));
                //System.out.println("New j");
                current[j]++;
            }
            tosses++;
        }

        return tosses;
    }


    public static void main(String[] args) {
        int[] pegs = {2,3,4,2,1};

        //heuristic is that we can divide the array into segments wether increasing or decreasing
        int result = RingToss.RingTossGreedy(pegs);

        System.out.println(result);
    }
}
