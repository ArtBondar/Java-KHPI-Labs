# Лабораторна робота №3
# Утилітарні класи. Обробка масивів і рядків

### Мета:
- Розробка власних утилітарних класів.
- Набуття навичок вирішення прикладних задач з використанням масивів і рядків.

## 1 ВИМОГИ
### 1.1 Розробник
- Бондар Артем Олексiйович
- КН-921В
- 2 варiант

### 1.2 Загальне завдання
1. Розробити та продемонструвати консольну програму мовою Java в середовищі Eclipse для вирішення прикладної задачі за номером, що відповідає збільшеному на одиницю залишку від ділення на 15 зменшеного на одиницю номера студента в журналі групи.
2. При вирішенні прикладних задач використовувати латинку.
3. Продемонструвати використання об'єктів класу StringBuilder або StringBuffer.
4. Застосувати функціональну (процедурну) декомпозицію - розробити власні утилітарні класи (особливий випадок допоміжного класу, див. Helper Class) та для обробки даних використовувати відповідні статичні методи.
5. Забороняється використовувати засоби обробки регулярних виразів: класи пакету java.util.regex (Pattern, Matcher та ін.), а також відповідні методи класу String (matches, replace, replaceFirst, replaceAll, split).

### 1.3 Задача
Ввести декілька рядків. Упорядкувати, а потім вивести рядки за алфавітом (перший пріоритет) та в порядку зростання їх довжини (другий пріоритет).

## 2 ОПИС ПРОГРАМИ

### 2.1 Засоби ООП
...

### 2.2 Ієрархія та структура класів
...

### 2.3 Важливі фрагменти програми
```java
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
```

## 3 ВАРІАНТИ ВИКОРИСТАННЯ
Для сортування будь якого тексту

## Висновки
Ми набули навичи вирішення прикладних задач з використанням масивів і рядків.