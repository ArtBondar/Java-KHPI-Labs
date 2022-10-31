# Лабораторна робота №5
# Розробка власних контейнерів. Ітератори

### Мета:
- Набуття навичок розробки власних контейнерів.
- Використання ітераторів.

## 1 ВИМОГИ
### 1.1 Розробник
- Бондар Артем Олексiйович
- КН-921В

### 1.2 Загальне завдання
1. Розробити клас-контейнер, що ітерується для збереження початкових даних завдання л.р. №3 у вигляді масиву рядків з можливістю додавання, видалення і зміни елементів.

2. В контейнері реалізувати та продемонструвати наступні методи:
- String toString() повертає вміст контейнера у вигляді рядка;
- void add(String string) додає вказаний елемент до кінця контейнеру;
- void clear() видаляє всі елементи з контейнеру;
- boolean remove(String string) видаляє перший випадок вказаного елемента з контейнера;
- Object[] toArray() повертає масив, що містить всі елементи у контейнері;
- int size() повертає кількість елементів у контейнері;
- boolean contains(String string) повертає true, якщо контейнер містить вказаний елемент;
- boolean containsAll(Container container) повертає true, якщо контейнер містить всі елементи з зазначеного у параметрах;
- public Iterator<String> iterator() повертає ітератор відповідно до Interface Iterable.
3. В класі ітератора відповідно до Interface Iterator реалізувати методи:
- public boolean hasNext();
- public String next();
- public void remove()
4. Продемонструвати роботу ітератора за допомогою циклів while и for each.
5. Забороняється використання контейнерів (колекцій) і алгоритмів з Java Collections Framework.

### 1.3 Задача
Розробити клас-контейнер, що ітерується для збереження початкових даних завдання л.р. №3 у вигляді масиву рядків з можливістю додавання, видалення і зміни елементів.

## 2 ОПИС ПРОГРАМИ

### 2.1 Засоби ООП
...

### 2.2 Ієрархія та структура класів
...

### 2.3 Важливі фрагменти програми
```java
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
```

## 3 ВАРІАНТИ ВИКОРИСТАННЯ
Для обробки будь якого тексту

## Висновки
Ми набули навичи реалізація озробка власних контейнерів.