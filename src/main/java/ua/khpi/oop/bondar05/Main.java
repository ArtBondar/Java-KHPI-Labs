package ua.khpi.oop.bondar05;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Main {
    public static void main(String args[]) {
        String[] arr = new String[]{
                "A", "B", "C", "D"
        };
        MyArrayClass myArray = new MyArrayClass(arr);

        //String toString()
        System.out.println("toString():" + myArray.toString());

        //void add(String string)
        myArray.add("ABCD");
        System.out.println("add(String string):" + myArray.toString());

        //boolean remove(String string)
        System.out.println("remove(String string):" + myArray.remove("ABCD") + myArray.toString());

        //Object[] toArray()
        // Create an array from the ArrayList
        Object arraylist2[] = myArray.toArray();
        for (Object item : arraylist2) {
            System.out.println("Item = " + item);
        }

        //int size()
        System.out.println("size():" + myArray.size());

        //boolean contains(String string)
        System.out.println("contains(String string):" + myArray.contains("A"));

        //boolean containsAll(Container container)
        ArrayList<String> listTemp = new ArrayList<String>();
        listTemp.add("B");
        listTemp.add("C");
        System.out.println("containsAll(Container container):" + myArray.containsAll(listTemp));

        Iterator<String> iterator = myArray.iterator();

        String tmp, StringA = "A";
        while(iterator.hasNext()) {
            tmp = iterator.next();
            System.out.println("Word is - " + tmp);
            if (StringA.equals(tmp))
                iterator.remove();
        }
        System.out.println("Delete has success : " + myArray.toString());

    }
}
