# Carnival Ring Toss Challenge - CSEN 703 Assignment 1

## Overview
This is the solution to the Carnival Ring Toss Challenge for the **Analysis and Design of Algorithms** course at the **German University in Cairo**. The task is to develop a solution for the carnival ring toss game using a **greedy algorithm** to minimize the number of tosses needed to match the target heights of the pegs.

## Problem Description
The game involves a row of pegs, each with a target number of rings. Your goal is to toss rings onto the pegs in such a way that the number of rings on each peg matches the target heights, using the minimum number of tosses.

### Key Features:
- **Pegs**: A row of pegs with target heights.
- **Rings**: Unlimited number of rings.
- **Contiguous Tosses**: Each toss can cover multiple pegs as long as they form a contiguous group.
- **Objective**: Minimize the number of tosses to match the target heights on each peg.

## Example Walkthrough
Given the initial state `[0, 0, 0, 0, 0]` and the target heights `[2, 3, 4, 2, 1]`, the optimal solution can be achieved with 4 tosses:
1. Toss 3 rings on the first 3 pegs to make `[2, 3, 4, 2, 1]`.

### Optimal Tosses:
1. Toss 3 rings on the first 3 pegs → `[2, 2, 2, 0, 0]`
2. Toss 3 rings on the first 3 pegs again → `[2, 2, 2, 0, 0]`
3. Toss 4 rings on the last 4 pegs → `[2, 3, 3, 1, 1]`
4. Toss 2 rings on the last 2 pegs → `[2, 3, 4, 2, 1]`

## Requirements
You are required to implement a **greedy algorithm** in **Java** that solves the problem in **O(n)** time complexity.

### Deliverables
1. **Class Name**: `RingToss`
2. **Package Name**: `csen703.main.assignment1`
3. **Methods**:
   - `public static int RingTossGreedy(int [] pegs)` — This method implements the greedy approach to calculate the minimum number of tosses needed to match the scoreboard.

## Instructions

### Problem Constraints:
- The number of pegs is not fixed.
- Heights of the pegs are nonnegative integers and can vary independently.
  
### Solution Approach
The solution uses a greedy approach to minimize the number of tosses. The algorithm involves:
1. Iterating through the pegs array.
2. For each contiguous group of pegs, determining the optimal number of tosses required to bring the pegs to their target height.

### Java Code Implementation

```java
package csen703.main.assignment1;

public class RingToss {

    public static int RingTossGreedy(int[] pegs) {
        int tosses = 0;
        // Implement greedy algorithm to minimize tosses
        // Your code here

        return tosses;
    }

    public static void main(String[] args) {
        // Test the solution
        int[] pegs = {0, 0, 0, 0, 0};
        System.out.println("Minimum tosses: " + RingTossGreedy(pegs));
    }
}
