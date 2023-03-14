// This projects was to help with understanding java's formatting when trying to learn it after python

import java.util.Scanner;

public class LearningJava {
    // This method checks the array to see if all the numbers are 8 and 9, returns false otherwise
    public static boolean just8and9 ( int[] numbers ) {
        boolean all8and9 = true;
        for (int number : numbers) {
            if (number != 8 && number != 9) {
                all8and9 = false;
                break;
            }
        }
        return all8and9;
    }
    // This methods counts how many "runs" there are. Runs are a series of number that repeat.
    public static int countRuns ( int[] numbers ) {
        boolean currentlyInRun = false;
        int previousValue = 10000;
        int runCount = 0;
        for (int number : numbers) {
            if (number == previousValue && !currentlyInRun) {
                runCount += 1;
                currentlyInRun = true;
            } else if (number != previousValue) {
                currentlyInRun = false;
                previousValue = number;
            }
        }
        return runCount;
    }
    // This method takes in an array and adds all the numbers except for 6 and 7 and those inbetween the two
    public static int sum67 ( int[] numbers ) {
        boolean exclusionMode = false;
        int previousValue = 0;
        int totalSum = 0;
        for (int number : numbers) {
            if (number == 6) {
                exclusionMode = true;
            }
            if (previousValue == 7) {
                exclusionMode = false;
            }
            if (!exclusionMode) {
                totalSum += number;
                previousValue = number;
            } else {
                previousValue = number;
            }
        }
        return totalSum;
    }
    // This method simply returns the number that appears the most in the array
    public static int mode ( int[] numbers ) {
        int finalMode = 0;
        int finalAmount = 0;
        int amount;
        for (int i: numbers){
            amount = 0;
            for (int j : numbers) {
                if (i == j) {
                    amount += 1;
                }
            }
            if (amount > finalAmount) {
                finalAmount = amount;
                finalMode = i;
            }
        }
        return finalMode;
    }
    // This method was used for testing out different arrays and methods
    public static void main (String[] args){
        int[] test = {1,2,2,2,3};
        System.out.println(mode(test));
    }
}

