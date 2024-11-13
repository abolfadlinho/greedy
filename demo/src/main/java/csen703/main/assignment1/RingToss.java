package csen703.main.assignment1;

public class RingToss {
    public static int RingTossGreedy(int[] pegs) {
        int tosses = 0;
        int n = pegs.length;
        
        int i = 0;
        
        while (i < n) {
            int start = i;
            while (i + 1 < n && pegs[i] < pegs[i + 1]) { //condition for checking if we are still increasing and the array hasn't ended
                i++;
            }

            if (i > start) { //making sure we have a segment to handle not a single peg
                tosses += handleSegment(pegs, start, i);
            }
            
            start = i;
            while (i + 1 < n && pegs[i] >= pegs[i + 1]) { //condition for checking if we are still decreasing and the array hasn't ended
                i++;
            }

            if (i > start) { //making sure we have a segment to handle not a single peg
                tosses += handleSegment(pegs, start, i);
            }
            
            i++;
        }
        
        return tosses;
        
    }

    private static int handleSegment(int[] pegs, int start, int end) {
        int tosses = 0;
        int currentHeight = 0; //this is a variable for the whole set so whenever we toss, the whole set increases in height

        for (int i = start; i <= end; i++) {
            int diff = pegs[i] - currentHeight; //if previous tosses is not enough
            if (diff > 0) {
                tosses++;
                currentHeight += diff;
            }
        }

        return tosses;
    }
}
