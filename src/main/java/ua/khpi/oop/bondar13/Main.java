package ua.khpi.oop.bondar13;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int timeout = 5000; // максимальний час виконання в мілісекундах
        int numThreads = 3; // кількість потоків для паралельної обробки

        // створення великого списку з випадковими числами
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10000000; i++) {
            numbers.add(random.nextInt(100));
        }

        // створення та запуск потоків
        List<Thread> threads = new ArrayList<>();
        List<AverageCalculator> calculators = new ArrayList<>();
        int chunkSize = numbers.size() / numThreads;
        for (int i = 0; i < numThreads; i++) {
            int start = i * chunkSize;
            int end = (i == numThreads - 1) ? numbers.size() : (i + 1) * chunkSize;
            List<Integer> chunk = numbers.subList(start, end);
            AverageCalculator calculator = new AverageCalculator(chunk);
            Thread thread = new Thread(calculator);
            threads.add(thread);
            calculators.add(calculator);
            thread.start();
        }

        // очікування на завершення відведеного часу
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            // ігнорувати
        }

        // зупинка потоків
        for (Thread thread : threads) {
            thread.interrupt();
        }

        // обчислення середнього значення з результатів кожного потоку
        int count = 0;
        double sum = 0;
        for (AverageCalculator calculator : calculators) {
            count += calculator.getCount();
            sum += calculator.getSum();
        }
        double average = sum / count;

        // виведення результату
        System.out.println("Average: " + average);
    }
}
