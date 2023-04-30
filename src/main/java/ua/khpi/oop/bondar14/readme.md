# Лабораторна робота №13
# Multithreading. Ефективність використання
### Мета:
- Вимірювання часу паралельних та послідовних обчислень.
- Демонстрація ефективності паралельної обробки.

## 1 ВИМОГИ
### 1.1 Розробник
- Бондар Артем Олексiйович
- КН-921В

### 1.2 Загальне завдання
1. Забезпечити вимірювання часу паралельної обробки елементів контейнера за допомогою розроблених раніше методів.

2. Додати до алгоритмів штучну затримку виконання для кожної ітерації циклів поелементної обробки контейнерів, щоб загальний час обробки був декілька секунд.

3. Реалізувати послідовну обробку контейнера за допомогою методів, що використовувались для паралельної обробки та забезпечити вимірювання часу їх роботи.

4. Порівняти час паралельної і послідовної обробки та зробити висновки про ефективність розпаралелювання:

- результати вимірювання часу звести в таблицю;
- обчислити та продемонструвати у скільки разів паралельне виконання швидше послідовного.
### 1.3 Задача
Порівняти час паралельної і послідовної обробки та зробити висновки про ефективність розпаралелювання

## 2 ОПИС ПРОГРАМИ

### 2.1 Засоби ООП
...

### 2.2 Ієрархія та структура класів
...

### 2.3 Важливі фрагменти програми
```java
public class Main {
    public static void main(String[] args) {
        // Створення контейнера з елементами
        List<Integer> container = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            container.add(i);
        }

        // Паралельна обробка контейнера
        long startParallel = System.currentTimeMillis();
        container.parallelStream().forEach(element -> {
            // Додавання штучної затримки виконання
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long endParallel = System.currentTimeMillis();
        System.out.println("Parallel processing time: " + (endParallel - startParallel) + " ms");

        // Послідовна обробка контейнера
        long startSequential = System.currentTimeMillis();
        for (Integer element : container) {
            // Додавання штучної затримки виконання
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long endSequential = System.currentTimeMillis();
        System.out.println("Parallel processing time: " + (endSequential - startSequential) + " ms");

        // Виведення висновків про ефективність розпаралелювання
        if ((endSequential - startSequential) == 0) {
            System.out.println("Sequential processing took less than 1ms, so parallelization efficiency cannot be calculated.");
        } else {
            double efficiency = (double) (endParallel - startParallel) / (double) (endSequential - startSequential);
            System.out.println("Efficiency of parallelization: " + efficiency + " times faster than sequential processing.");
        }
    }
}
```

## 3 ВАРІАНТИ ВИКОРИСТАННЯ


## Висновки
Ми набули навичи у розробці програм з моделлю потоків Java.