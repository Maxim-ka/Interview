package geekbrains.task1;

import java.util.Random;

public class InsertionSorting {

    public int[] sortByInsert(int[] array){
        for (int i = 0; i < array.length; i++) { // проход по массиву n
            int temp = array[i];
            int j = i;
            while (j > 0 && array[j - 1] > temp){ //определение места вставки,
                array[j] = array[j - 1];          // при худшем варианте n
                j--;
            }
            array[j] = temp;
        }
        //сложность О(n * n) = O(n^2)
        return array;
    }

    public int[] randomlyGenerateAnArray(int limit){
        Random random = new Random();
        int[] arr = new int[limit];
        for (int i = 0; i < arr.length ; i++) {
            if (random.nextInt(2) == 1) arr[i] = random.nextInt(limit) + random.nextInt(limit);
            else arr[i] = random.nextInt(limit) - random.nextInt(limit);
        }
        return arr;
    }

}
