package ua.khpi.oop.bondar16.Test;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AverageCalculatorTest {
    @Test
    public void testCalculateAverage() {
        List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10);
        AverageCalculator calculator = new AverageCalculator(numbers);
        Thread thread = new Thread(calculator);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            fail("Thread was interrupted.");
        }
        assertEquals(5, calculator.getCount());
        assertEquals(30.0, calculator.getSum(), 0.0001);
        assertEquals(6.0, calculator.getSum() / calculator.getCount(), 0.0001);
    }

    @Test
    public void testEmptyList() {
        List<Integer> numbers = Collections.emptyList();
        AverageCalculator calculator = new AverageCalculator(numbers);
        Thread thread = new Thread(calculator);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            fail("Thread was interrupted.");
        }
        assertEquals(0, calculator.getCount());
        assertEquals(0.0, calculator.getSum(), 0.0001);
        assertTrue(Double.isNaN(calculator.getSum() / calculator.getCount()));
    }

    @Test
    public void testInterruptedThread() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        AverageCalculator calculator = new AverageCalculator(numbers);
        Thread thread = new Thread(calculator);
        thread.start();
        thread.interrupt();
        try {
            thread.join();
        } catch (InterruptedException e) {
            fail("Thread was interrupted.");
        }
        assertTrue(calculator.getCount() < numbers.size());
        assertTrue(calculator.getSum() < numbers.stream().mapToInt(Integer::intValue).sum());
    }
}
