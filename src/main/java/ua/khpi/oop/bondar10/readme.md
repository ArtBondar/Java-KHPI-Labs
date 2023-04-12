# Лабораторна робота №10
# Обробка параметризованих контейнерів

### Мета:
- Розширення функціональності параметризованих класів.

## 1 ВИМОГИ
### 1.1 Розробник
- Бондар Артем Олексiйович
- КН-921В

### 1.2 Загальне завдання
Використовуючи програму рішення завдання лабораторної роботи №9:

1. Розробити параметризовані методи (Generic Methods) для обробки колекцій об'єктів згідно прикладної задачі.
2. Продемонструвати розроблену функціональність (створення, управління та обробку власних контейнерів) в діалоговому та автоматичному режимах.
3. Автоматичний режим виконання програми задається параметром командного рядка -auto. Наприклад, java ClassName -auto.
4. В автоматичному режимі діалог з користувачем відсутній, необхідні данні генеруються, або зчитуються з файлу.
5. Забороняється використання алгоритмів з Java Collections Framework.

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

    public <T extends Comparable<T>> void sortByJob(List<RecruitmentAgency> list, boolean ascending) {
        list.sort((v1, v2) -> {
            int result = v1.getRequirement().getJob().compareTo(v2.getRequirement().getJob());
            return ascending ? result : -result;
        });
    }

    public <T extends Comparable<T>> void sortByRegisterNumber(List<RecruitmentAgency> list, boolean ascending) {
        list = null;
        list.sort((v1, v2) -> {
            int result = Boolean.compare(v1.getRegisterNumber() > v2.getRegisterNumber(), false);
            return ascending ? result : -result;
        });
    }

    public <T extends Comparable<T>> void sortByMinWage(List<RecruitmentAgency> list, boolean ascending) {
        list.sort((v1, v2) -> {
            int result = Boolean.compare(v1.getRequirement().getMinWage() > v2.getRequirement().getMinWage(), false);
            return ascending ? result : -result;
        });
    }
}
```

## 3 ВАРІАНТИ ВИКОРИСТАННЯ
Для кадрового агентства

## Висновки
Ми набули навичи у розробці параметризованих контейнерів.
