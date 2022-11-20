# Лабораторна робота №7
# Об'єктно-орієнтована декомпозиція

### Мета:
- Використання об'єктно-орієнтованого підходу для розробки об'єкта предметної (прикладної) галузі.

## 1 ВИМОГИ
### 1.1 Розробник
- Бондар Артем Олексiйович
- КН-921В

### 1.2 Загальне завдання
1. Використовуючи об'єктно-орієнтований аналіз, реалізувати класи для представлення сутностей відповідно прикладної задачі - domain-об'єктів.

2. Забезпечити та продемонструвати коректне введення та відображення кирилиці.

3. Продемонструвати можливість управління масивом domain-об'єктів.

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
public class RecruitmentAgency {
    private int registerNumber;
    private Experience experience;
    private Requirement requirement;

    public RecruitmentAgency(){
        registerNumber = 0;
        experience = new Experience();
        requirement = new Requirement();
    }

    public RecruitmentAgency(int registerNumber, Experience experience, Requirement requirement) {
        this.registerNumber = registerNumber;
        this.experience = experience;
        this.requirement = requirement;
    }

    public int getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(int registerNumber) {
        this.registerNumber = registerNumber;
    }

    public Experience getExperience() {
        return experience;
    }

    public void setExperience(Experience experience) {
        this.experience = experience;
    }

    public Requirement getRequirement() {
        return requirement;
    }

    public void setRequirement(Requirement requirement) {
        this.requirement = requirement;
    }

    @Override
    public String toString() {
        return "RrecruitmentAgency{" +
                "registerNumber=" + registerNumber +
                ", experience=" + experience +
                ", requirement=" + requirement +
                '}';
    }
}
```

## 3 ВАРІАНТИ ВИКОРИСТАННЯ
Для кадрового агентства

## Висновки
Ми набули навичи об'єктно-орієнтованого підходу для розробки об'єкта предметної.
