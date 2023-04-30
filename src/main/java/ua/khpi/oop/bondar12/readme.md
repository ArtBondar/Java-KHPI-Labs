# Лабораторна робота №12
# Регулярні вирази. Обробка тексту

### Мета:
- Ознайомлення з принципами використання регулярних виразів для обробки тексту.

## 1 ВИМОГИ
### 1.1 Розробник
- Бондар Артем Олексiйович
- КН-921В

### 1.2 Загальне завдання

Вимоги
1. Використовуючи програми рішень попередніх задач, продемонструвати ефективне (оптимальне) використання регулярних виразів при вирішенні прикладної задачі.
2. Передбачити можливість незначної зміни умов пошуку.
3. Продемонструвати розроблену функціональність в діалоговому та автоматичному режимах.

### 1.3 Задача

Кадрове агентство. Знайти всіх претендентів з досвідом роботи в сфері менеджменту, які не бажають їздити у відрядження.

## 2 ОПИС ПРОГРАМИ

### 2.1 Засоби ООП
...

### 2.2 Ієрархія та структура класів
...

### 2.3 Важливі фрагменти програми
```java
public class Main {

    public static void main(String args[]) {
        RecruitmentAgency agency1 = new RecruitmentAgency(1, new Experience(), new Requirement());
        RecruitmentAgency agency2 = new RecruitmentAgency(2, new Experience(), new Requirement());
        RecruitmentAgency agency3 = new RecruitmentAgency(3, new Experience(), new Requirement());

        List<RecruitmentAgency> list = new ArrayList<RecruitmentAgency>();
        list.add(agency1);
        list.add(agency2);
        list.add(agency3);

        // Задання умов пошуку
        Pattern reg_RegisterNumber = Pattern.compile("^0-9\\+");

        for (RecruitmentAgency agency: list) {
            if(reg_RegisterNumber.matcher(Integer.toString(agency.getRegisterNumber())).matches()) {
                System.out.println("Agency: " + agency.toString());
            }
        }
    }
}
```

## 3 ВАРІАНТИ ВИКОРИСТАННЯ
Для кадрового агентства

## Висновки
Ми набули навичи у розробці параметризованих контейнерів.