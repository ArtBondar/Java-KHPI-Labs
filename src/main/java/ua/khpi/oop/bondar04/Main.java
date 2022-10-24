package ua.khpi.oop.bondar04;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static void PrintArrayString(StringBuilder ArrayStrings[]){
        for (StringBuilder elem : ArrayStrings)
            System.out.println(elem);
    }
    private static void SortArrayStrings(StringBuilder ArrayStrings[]){
        for(int i = 0; i < ArrayStrings.length - 1; i++)
            for (int j = i + 1; j < ArrayStrings.length; j++)
                if(ArrayStrings[i].compareTo(ArrayStrings[j]) > 0){
                    StringBuilder temp = ArrayStrings[i];
                    ArrayStrings[i] = ArrayStrings[j];
                    ArrayStrings[j] = temp;
                }
    }

    public static boolean isNumeric(String s) {
        if(s.length() == 0)
            return false;
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static ArrayList<StringBuilder> InputData(){
        ArrayList<StringBuilder> list = new ArrayList<StringBuilder>();
        Scanner scanner = new Scanner(System.in);
        String input = "";
        System.out.println("----------------------");
        System.out.println("Input data");
        System.out.println("(0) Exit");
        System.out.println("----------------------");

        do{
            input = scanner.next();

            if(isNumeric(input))
                if(Integer.parseInt(input) == 0)
                    return list;

            if(input != "")
                list.add(new StringBuilder(input));
        }
        while (true);
    }

    private static void Menu(StringBuilder ArrayStrings[]){
        StringBuilder list[] = ArrayStrings;
        Scanner scanner = new Scanner(System.in);
        int input = 0;
        do {
            System.out.println("====================");
            System.out.println("(1) Show data");
            System.out.println("(2) Input data");
            System.out.println("(3) Sort data");
            System.out.println("(4) Exit");
            System.out.println("====================");
            System.out.print("Please enter a number: ");

            input = scanner.nextInt();

            switch (input) {
                case 1:
                    PrintArrayString(list);
                    break;
                case 2:
                    ArrayList<StringBuilder> tmp = InputData();
                    list = tmp.toArray(new StringBuilder[tmp.size()]);
                    break;
                case 3:
                    SortArrayStrings(list);
                    break;
                case 4:
                    System.out.println("Exit");
                    break;
                default:
                    break;
            }

        } while (input != 4);
        System.exit(1);
    }


    public static void main(String args[]) {
        StringBuilder ArrayStrings[] = new StringBuilder[]{
                new StringBuilder("Bondar"),
                new StringBuilder("Artem"),
                new StringBuilder("Alexeyevich"),
                new StringBuilder("Ar")
        };
        Menu(ArrayStrings);
    }
}