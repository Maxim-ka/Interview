package geekbrains.task2;

public class FibonacciNumber {

    private boolean isNegative;
    private long sum = 1;

    public long getFibonacciNumber(int sequenceNumber){
        if (sequenceNumber == 0) return 0;
        isNegative = sequenceNumber < 0;
        if (isNegative) sequenceNumber = Math.abs(sequenceNumber);
        if (sequenceNumber == 1) {
            return output();
        }
        return calculate(sequenceNumber);
    }

    private long calculate(int sequenceNumber){
        long next = 0, previous;
        for (int i = 2; i <= sequenceNumber; i++) { // сложность О(n)
            previous = next;
            next = sum;
            sum = next + previous;
        }
        return output();

    }

    private long output(){
        if (isNegative) return -1 * sum;
        return sum;
    }
}
