# Лабораторна робота №9
# Параметризація в Java

### Мета:
- Вивчення принципів параметризації в Java.
- Розробка параметризованих класів та методів.

## 1 ВИМОГИ
### 1.1 Розробник
- Бондар Артем Олексiйович
- КН-921В

### 1.2 Загальне завдання
1. Створити власний клас-контейнер, що параметризується (Generic Type), на основі зв'язних списків для реалізації колекції domain-об’єктів лабораторної роботи №7.

2. Для розроблених класів-контейнерів забезпечити можливість використання їх об'єктів у циклі foreach в якості джерела даних.

3. Забезпечити можливість збереження та відновлення колекції об'єктів: 1) за допомогою стандартної серіалізації; 2) не використовуючи протокол серіалізації.

4. Продемонструвати розроблену функціональність: створення контейнера, додавання елементів, видалення елементів, очищення контейнера, перетворення у масив, перетворення у рядок, перевірку на наявність елементів.

5. Забороняється використання контейнерів (колекцій) з Java Collections Framework.

### 1.3 Задача
Кадрове агентство

Дані про претендента: реєстраційний номер; досвід роботи - набір значень "спеціальність, стаж"; освіта; дата звільнення; вимоги до майбутньої роботи - набір необов'язкових властивостей у вигляді "спеціальність, умови праці, мінімальна зарплата".

## 2 ОПИС ПРОГРАМИ

### 2.1 Засоби ООП
...

### 2.2 Ієрархія та структура класів
...

### 2.3 Важливі фрагменти програми
```java
public class RecruitmentAgencyContainer implements Serializable {
    private List<RecruitmentAgency> RecruitmentAgencies;

    public RecruitmentAgencyContainer() {
        RecruitmentAgencies = new ArrayList<>();
    }

    public void add(RecruitmentAgency ListItem) {
        RecruitmentAgencies.add(ListItem);
    }

    public void remove(RecruitmentAgency ListItem) {
        RecruitmentAgencies.remove(ListItem);
    }

    public RecruitmentAgency get(int index) {
        return RecruitmentAgencies.get(index);
    }

    public List<RecruitmentAgency> getAll() {
        return new ArrayList<>(RecruitmentAgencies);
    }

    public int size() {
        return RecruitmentAgencies.size();
    }

    public boolean isEmpty() {
        return RecruitmentAgencies.isEmpty();
    }

    public void clear() {
        RecruitmentAgencies.clear();
    }
}
```

## 3 ВАРІАНТИ ВИКОРИСТАННЯ
Для кадрового агентства

## Висновки
Ми набули навичи у принципі параметризації в Java, параметризованих класів та методів.