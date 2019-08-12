package geekbrains.task4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SieveOfEratosthenes {

    public static List<Integer> findSimpleNumbers(int limit){
        List<Integer> integerList = new ArrayList<>();
        label:for (int i = 2; i <= limit; i++) {
            if (!integerList.isEmpty()){
                for (int j : integerList) {
                    if (i % j == 0) {
                        continue label;
                    }
                }
            }
            integerList.add(i);
        }
        return integerList;
    }

    public List<Integer> findPrimeNumbers(int limit){
        int min = 2;
        List<Integer> list = Stream.iterate(min, number -> ++number)
                .limit(limit - min)
                .filter(i -> i == min || i % min != 0)
                .collect(Collectors.toList());
        int next = getNextPrimeNumber(list, min);
        while (checkListForComplexNumbers(list, next)){
            list = passToList(list, next);
            next = getNextPrimeNumber(list, next);
        }
        return list;
    }

    private boolean checkListForComplexNumbers(List<Integer> list, int next){
        return list.stream().anyMatch(i -> i != next && i % next == 0);
    }

    private List<Integer> passToList(List<Integer> list, int next){
        return list.stream()
                .filter(i -> i <= next || i % next != 0)
                .collect(Collectors.toList());
    }

    private int getNextPrimeNumber(List<Integer> list, int next){
       return list.stream()
                .filter(i -> i > next)
                .findFirst()
                .orElse(next);
    }
}
