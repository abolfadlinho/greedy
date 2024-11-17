package csen703.main.assignment1;

import java.util.Arrays;

@SuppressWarnings("unused")
public class RingToss {
    public static int RingTossGreedy(int[] pegs) {
        int n = pegs.length;
        int[] current = new int[n];
        int tosses = 0;
        int i = 0;
        
        do {
            if(current[i]==pegs[i]) {
                ++i;
                continue;
            }
            int diff = pegs[i] - current[i];
            for(int j = i; j < n && ((pegs[j]-current[j])>=diff);++j) {
                ++current[j];
            }
            ++tosses;
        } while(i < n && current[i]<=pegs[i]);

        return tosses;
    }

    public static void main(String[] args) {
        int[] pegs = {2,3,4,2,1};

        //heuristic is we loop from beginning and add1 to all consecutive indexes that have a diff greater than or equal to current diff and add 1
        int result = RingToss.RingTossGreedy(pegs);

        System.out.println(result);
    }
}
