# Лабораторна робота №15
# Колекції в Java

### Мета:
- Ознайомлення з бібліотекою колекцій Java SE.
- Використання колекцій для розміщення об'єктів розроблених класів.

## 1 ВИМОГИ
### 1.1 Розробник
- Бондар Артем Олексiйович
- КН-921В

### 1.2 Загальне завдання

1. Розробити консольну програму для реалізації завдання обробки даних згідно прикладної області.

2. Для розміщення та обробки даних використовувати контейнери (колекції) і алгоритми з Java Collections Framework.

3. Забезпечити обробку колекції об'єктів: додавання, видалення, пошук, сортування згідно розділу Прикладні задачі л.р. №10.

4. Передбачити можливість довготривалого зберігання даних: 1) за допомогою стандартної серіалізації; 2) не використовуючи протокол серіалізації.

5. Продемонструвати розроблену функціональність в діалоговому та автоматичному режимах за результатом обробки параметрів командного рядка.

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
public class Main {
    public static void main(String args[]) {
        RecruitmentAgencyContainer container = new RecruitmentAgencyContainer();
        RecruitmentAgency agency1 = new RecruitmentAgency(1, new Experience(), new Requirement());
        RecruitmentAgency agency2 = new RecruitmentAgency(2, new Experience(), new Requirement());
        RecruitmentAgency agency3 = new RecruitmentAgency(3, new Experience(), new Requirement());
        container.add(agency1);
        container.add(agency2);
        container.add(agency3);

        // get
        System.out.println(container.get(0).toString());

        // get all
        List<RecruitmentAgency> agencyList = container.getAll();
        for (RecruitmentAgency agency : agencyList) {
            System.out.println(agency.toString());
        }

        // remove
        container.remove(container.get(0));

        // clear
        container.clear();

        // isEmpty
        System.out.println(container.isEmpty());
    }
}
```

## 3 ВАРІАНТИ ВИКОРИСТАННЯ
Для кадрового агентства

## Висновки
Ми набули навичи у розробці параметризованих контейнерів.
