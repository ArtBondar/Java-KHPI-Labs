package ua.khpi.oop.bondar03;

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
    public static void main(String args[]) {
        StringBuilder ArrayStrings[] = new StringBuilder[]{
                new StringBuilder("Bondar"),
                new StringBuilder("Artem"),
                new StringBuilder("Alexeyevich"),
                new StringBuilder("Ar")
        };
        System.out.println("-- We have: ");
        PrintArrayString(ArrayStrings);
        System.out.println("-- After sort: ");
        SortArrayStrings(ArrayStrings);
        PrintArrayString(ArrayStrings);
    }
}
