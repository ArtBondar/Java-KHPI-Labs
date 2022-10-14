package ua.khpi.oop.bondar02;

import java.util.Random;

public class Main {
    private static int GetRandomNumber() {
        return new Random().nextInt(999999);
    }
    private static int GetSumInNumber(int number){
        int res = 0;
        while(number > 0){
            res += number % 10;
            number /= 10;
        }
        return res;
    }
    public static void main(String args[]) {
        int randomNumber = GetRandomNumber();
        System.out.println("Random number: " + randomNumber);
        System.out.println("Result: "+ GetSumInNumber(randomNumber));
    }
}
