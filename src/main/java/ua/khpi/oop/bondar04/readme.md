# Лабораторна робота №4
# Інтерактивні консольні програми для платформи Java SE

### Мета:
- Реалізація діалогового режиму роботи з користувачем в консольних програмах мовою Java.

## 1 ВИМОГИ
### 1.1 Розробник
- Бондар Артем Олексiйович
- КН-921В

### 1.2 Загальне завдання
1. Використовуючи програму рішення завдання лабораторної роботи №3, відповідно до прикладної задачі забезпечити обробку команд користувача у вигляді текстового меню:
- введення даних;
- перегляд даних;
- виконання обчислень;
- відображення результату;
- завершення програми і т.д.

2. Забезпечити обробку параметрів командного рядка для визначення режиму роботи програми:
- параметр "-h" чи "-help": відображається інформація про автора програми, призначення (індивідуальне завдання), детальний опис режимів роботи (пунктів меню та параметрів командного рядка);
- параметр "-d" чи "-debug": в процесі роботи програми відображаються додаткові дані, що полегшують налагодження та перевірку працездатності програми: діагностичні повідомлення, проміжні значення змінних, значення тимчасових змінних та ін.

### 1.3 Задача
Використовуючи програму рішення завдання лабораторної роботи №3, відповідно до прикладної задачі забезпечити обробку команд користувача у вигляді текстового меню.

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

```

## 3 ВАРІАНТИ ВИКОРИСТАННЯ
Для сортування будь якого тексту

## Висновки
Ми набули навичи реалізація діалогового режиму роботи з користувачем в консольних програмах