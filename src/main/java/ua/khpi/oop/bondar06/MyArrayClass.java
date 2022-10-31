package ua.khpi.oop.bondar06;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class MyArrayClass implements Serializable {
    private ArrayList<String> arrayList;

    public ArrayList<String> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<String> arrayList) {
        this.arrayList = arrayList;
    }

    public MyArrayClass(){
        arrayList = new ArrayList<>();
    }
    public MyArrayClass(String[] strings) {
        this.arrayList = new ArrayList<>();
        for (String elem :
                strings) {
            arrayList.add(elem);
        }
    }

    public void add(String string){
        arrayList.add(string);
    }

    public void clear(){
        arrayList.clear();
    }

    public boolean remove(String string){
        return arrayList.remove(string);
    }

    public Object[] toArray(){
        return arrayList.toArray();
    }

    public int size(){
        return arrayList.size();
    }

    public boolean contains(String string){
        return arrayList.contains(string);
    }

    public boolean containsAll(ArrayList<String> container){
        return arrayList.containsAll(container);
    }

    public Iterator<String> iterator(){
        return arrayList.iterator();
    }

    @Override
    public String toString() {
        return arrayList.toString();
    }

    public static void Demonstration(){
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
