// Name: Ali Khan
// pnv4bs
// HW1-4Functions
// w3schools - Java

import java.util.Scanner;

public class FourFunctions {
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
    public static void main (String[] args){
        int[] test = {1,2,2,2,3};
        System.out.println(mode(test));
    }
}

