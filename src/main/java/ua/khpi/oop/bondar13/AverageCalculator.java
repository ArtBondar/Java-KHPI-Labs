package ua.khpi.oop.bondar13;

import java.util.List;

public class AverageCalculator implements Runnable {
    private final List<Integer> numbers;
    private int count;
    private double sum;

    public AverageCalculator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int getCount() {
        return count;
    }

    public double getSum() {
        return sum;
    }

    @Override
    public void run() {
        for (Integer number : numbers) {
            if (Thread.interrupted()) {
                return; // завершити потік, якщо він був перерваний
            }
            count++;
            sum += number;
        }
    }
}
