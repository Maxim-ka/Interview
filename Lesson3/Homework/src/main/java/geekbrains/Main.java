package geekbrains;

import geekbrains.task1.InsertionSorting;
import geekbrains.task2.FibonacciNumber;
import geekbrains.task4.SieveOfEratosthenes;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        InsertionSorting sorting = new InsertionSorting();
        int[] inputArray = sorting.randomlyGenerateAnArray(20);
        System.out.println(Arrays.toString(inputArray));
        System.out.println(Arrays.toString(sorting.sortByInsert(inputArray)));

        System.out.println(new FibonacciNumber().getFibonacciNumber(-10));

        System.out.println(SieveOfEratosthenes.findSimpleNumbers(100));
        System.out.println(new SieveOfEratosthenes().findPrimeNumbers(100));
    }
}
