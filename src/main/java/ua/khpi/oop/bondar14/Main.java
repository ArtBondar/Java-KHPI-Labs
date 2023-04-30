package ua.khpi.oop.bondar14;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Створення контейнера з елементами
        List<Integer> container = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            container.add(i);
        }

        // Паралельна обробка контейнера
        long startParallel = System.currentTimeMillis();
        container.parallelStream().forEach(element -> {
            // Додавання штучної затримки виконання
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long endParallel = System.currentTimeMillis();
        System.out.println("Parallel processing time: " + (endParallel - startParallel) + " ms");

        // Послідовна обробка контейнера
        long startSequential = System.currentTimeMillis();
        for (Integer element : container) {
            // Додавання штучної затримки виконання
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long endSequential = System.currentTimeMillis();
        System.out.println("Parallel processing time: " + (endSequential - startSequential) + " ms");

        // Виведення висновків про ефективність розпаралелювання
        if ((endSequential - startSequential) == 0) {
            System.out.println("Sequential processing took less than 1ms, so parallelization efficiency cannot be calculated.");
        } else {
            double efficiency = (double) (endParallel - startParallel) / (double) (endSequential - startSequential);
            System.out.println("Efficiency of parallelization: " + efficiency + " times faster than sequential processing.");
        }
    }
}
