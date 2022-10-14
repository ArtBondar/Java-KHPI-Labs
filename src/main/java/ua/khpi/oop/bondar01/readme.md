# Лабораторна робота №1
# Структура програми мовою Java. Типи даних, літерали, операції і оператори

### Мета:
Ознайомлення з JDK платформи Java SE та середовищем розробки Eclipse IDE.

## 1 ВИМОГИ
### 1.1 Розробник
- Бондар Артем Олексiйович
- КН-921В
- 1 варiант

### 1.2 Загальне завдання
1. Вирішити три прикладні задачі на мові Java в середовищі Eclipse.
2. Продемонструвати покрокове виконання програми та результати роботи в режимі налагодження, не використовуючи виведення до консолі.
3. Виконати компіляцію і запуск програми в командному рядку за допомогою відповідних утиліт JDK.

### 1.3 Задача
1. Обрати тип змінних та встановити за допомогою констант та літералів початкові значення:
    - число, що відповідає номеру залікової книжки за допомогою шістнадцяткового літералу;
    - число, що відповідає номеру мобільного телефона (починаючи з 380...) за допомогою десяткового літералу;
    - число, яке складається з останніх двох ненульових цифр номера мобільного телефону за допомогою двійкового літералу;
    - число, яке складається з останніх чотирьох ненульових цифр номера мобільного телефону за допомогою вісімкового літералу;
    - визначити збільшене на одиницю значення залишку від ділення на 26 зменшеного на одиницю номера студента в журналі групи;
    - символ англійського алфавіту в верхньому регістрі, номер якого відповідає знайденому раніше значенню.
2. Використовуючи десятковий запис цілочисельного значення кожної змінної знайти і підрахувати кількість парних і непарних цифр.

3. Використовуючи двійковий запис цілочисельного значення кожної змінної підрахувати кількість одиниць.

## 2 ОПИС ПРОГРАМИ

### 2.1 Засоби ООП
...

### 2.2 Ієрархія та структура класів
...

### 2.3 Важливі фрагменти програми
```java
public class Main {
    // --- #1
    //число, що відповідає номеру залікової книжки за допомогою шістнадцяткового літералу;
    static long num1 = 0x1;
    //число, що відповідає номеру мобільного телефона (починаючи з 380...) за допомогою десяткового літералу;
    static long num2 = 380632017150L;
    //число, яке складається з останніх двох ненульових цифр номера мобільного телефону за допомогою двійкового літералу;
    static long num3 = 0b1111;
    //число, яке складається з останніх чотирьох ненульових цифр номера мобільного телефону за допомогою вісімкового літералу;
    static long num4 = 03263;
    //визначити збільшене на одиницю значення залишку від ділення на 26 зменшеного на одиницю номера студента в журналі групи;
    static long num5 = (1-1) % 26 + 1;
    //символ англійського алфавіту в верхньому регістрі, номер якого відповідає знайденому раніше значенню.
    static char num6 = (char)(num5+64);

    public static void main(String args[])
    {
        // --- #1
        System.out.println("#1");
        System.out.println(num1 + " | " + num2 + " | " + num3 + " | " + num4 + " | " + num5 + " | " + num6);

        // --- #2
        long arr[] = new long[6];
        arr[0] = num1;
        arr[1] = num2;
        arr[2] = num3;
        arr[3] = num4;
        arr[4] = num5;
        arr[5] = (long)num6;

        int counter = 0;
        for (int i = 0; i < arr.length; i ++)
            if (arr[i] % 2 == 0)
                counter++;

        System.out.println("#2");
        System.out.println("Count pairs number : " + counter);

        // --- #3
        counter = 0;
        for (int i = 0; i < arr.length; i ++)
            while (arr[i] != 0) {
                if (arr[i] % 2 != 0)
                    counter++;
                arr[i] /= 2;
            }

        System.out.println("#3");
        System.out.println("The number of units in the binary system of numbers : " + counter);
    }
}
```

## 3 ВАРІАНТИ ВИКОРИСТАННЯ
Люди яким треба працювати з двiйковою, вiсiмковою та десятковою системою.

## Висновки
Ми ознайомилися з JDK платформи Java SE та середовищем розробки Eclipse IDE.