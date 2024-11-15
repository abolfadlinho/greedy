
package csen703.main.assignment1;


import csen703.main.assignment1.RingToss;

@SuppressWarnings("unused")
public class Main {
    public static void main(String[] args) {
        int[] pegs = {2,3,4,2,1};

        //heuristic is that we can divide the array into segments wether increasing or decreasing
        int result = RingToss.RingTossGreedy(pegs);

        System.out.println(result);
    }
}