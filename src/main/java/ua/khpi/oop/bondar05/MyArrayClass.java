package ua.khpi.oop.bondar05;

import java.util.ArrayList;
import java.util.Iterator;

public class MyArrayClass {
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
}
