# Лабораторна робота №16
# Модульне тестування

### Мета:
- Розробка модульних тестів з використанням JUnit 5.

## 1 ВИМОГИ
### 1.1 Розробник
- Бондар Артем Олексiйович
- КН-921В

### 1.2 Загальне завдання

1. Розробити та додати модульні тести до програм попередніх лабораторних робіт. Забезпечити розділення на рівні початкового коду, тести розташовувати в директоріях з назвою test.

2. Перевірити всі public-методи власного контейнера та його ітератора, які були створені при віконанні завдання лабораторної роботи "9. Параметризація в Java". Забезпечити покриття коду не менше 80%.

3. Перевірити методи, що забезпечують валідацію даних в програмі рішення завдання лабораторної роботи "11. Регулярні вирази. Перевірка даних".

4. Перевірити вирішення прикладної задачі лабораторної роботи "12. Регулярні вирази. Обробка тексту".

5. Перевірити методи обробки контейнера лабораторної роботи "13. Паралельне виконання. Multithreading". Перевіряти тільки обробку даних, виключаючи multithreading (див. п.4).

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
public class AverageCalculatorTest {
    @Test
    public void testCalculateAverage() {
        List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10);
        AverageCalculator calculator = new AverageCalculator(numbers);
        Thread thread = new Thread(calculator);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            fail("Thread was interrupted.");
        }
        assertEquals(5, calculator.getCount());
        assertEquals(30.0, calculator.getSum(), 0.0001);
        assertEquals(6.0, calculator.getSum() / calculator.getCount(), 0.0001);
    }

    @Test
    public void testEmptyList() {
        List<Integer> numbers = Collections.emptyList();
        AverageCalculator calculator = new AverageCalculator(numbers);
        Thread thread = new Thread(calculator);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            fail("Thread was interrupted.");
        }
        assertEquals(0, calculator.getCount());
        assertEquals(0.0, calculator.getSum(), 0.0001);
        assertTrue(Double.isNaN(calculator.getSum() / calculator.getCount()));
    }

    @Test
    public void testInterruptedThread() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        AverageCalculator calculator = new AverageCalculator(numbers);
        Thread thread = new Thread(calculator);
        thread.start();
        thread.interrupt();
        try {
            thread.join();
        } catch (InterruptedException e) {
            fail("Thread was interrupted.");
        }
        assertTrue(calculator.getCount() < numbers.size());
        assertTrue(calculator.getSum() < numbers.stream().mapToInt(Integer::intValue).sum());
    }
}

public class RecruitmentAgencyContainerTest {
    private RecruitmentAgencyContainer container;

    @BeforeEach
    void setUp() {
        container = new RecruitmentAgencyContainer();
    }

    @Test
    public void testAdd() {
        RecruitmentAgency agency = new RecruitmentAgency();
        container.add(agency);
        assertEquals(1, container.size());
        assertTrue(container.getAll().contains(agency));
    }

    @Test
    public void testRemove() {
        RecruitmentAgency agency = new RecruitmentAgency();
        container.add(agency);
        container.remove(agency);
        assertEquals(0, container.size());
        assertFalse(container.getAll().contains(agency));
    }

    @Test
    public void testGet() {
        RecruitmentAgency agency = new RecruitmentAgency();
        container.add(agency);
        assertEquals(agency, container.get(0));
    }

    @Test
    public void testGetAll() {
        RecruitmentAgency agency1 = new RecruitmentAgency();
        RecruitmentAgency agency2 = new RecruitmentAgency();
        container.add(agency1);
        container.add(agency2);
        List<RecruitmentAgency> allAgencies = container.getAll();
        assertEquals(2, allAgencies.size());
        assertTrue(allAgencies.contains(agency1));
        assertTrue(allAgencies.contains(agency2));
    }

    @Test
    public void testSize() {
        RecruitmentAgency agency = new RecruitmentAgency();
        container.add(agency);
        assertEquals(1, container.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(container.isEmpty());
        RecruitmentAgency agency = new RecruitmentAgency();
        container.add(agency);
        assertFalse(container.isEmpty());
    }

    @Test
    public void testClear() {
        RecruitmentAgency agency = new RecruitmentAgency();
        container.add(agency);
        container.clear();
        assertEquals(0, container.size());
        assertTrue(container.isEmpty());
        assertFalse(container.getAll().contains(agency));
    }
}

public class RegularTest {
    private static final Pattern registerNumber_Pattern = Pattern.compile("^0-9\\+");
    private static final Pattern experience_job_Pattern = Pattern.compile("^[a-zA-Z]+$");
    private static final Pattern experience_time_Pattern = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$");
    private static final Pattern requirement_job_Pattern = Pattern.compile( "^[a-zA-Z]+$");
    private static final Pattern requirement_terms_Pattern = Pattern.compile("^[a-zA-Z0-9\s]+$");
    private static final Pattern requirement_minWage_Pattern = Pattern.compile("^0-9\\+");

    // Метод для перевірки registerNumber
    public static boolean validate_RegisterNumber(String registerNumber) {
        Matcher matcher = registerNumber_Pattern.matcher(registerNumber);
        return matcher.matches();
    }

    // Метод для перевірки experience_job
    public static boolean validate_Experience_job_Pattern(String experience_job) {
        Matcher matcher = experience_job_Pattern.matcher(experience_job);
        return matcher.matches();
    }

    // Метод для перевірки experience_time
    public static boolean validate_Experience_time_Pattern(String experience_time) {
        Matcher matcher = experience_time_Pattern.matcher(experience_time);
        return matcher.matches();
    }

    // Метод для перевірки requirement_job
    public static boolean validate_Requirement_job_Pattern(String requirement_job) {
        Matcher matcher = requirement_job_Pattern.matcher(requirement_job);
        return matcher.matches();
    }

    // Метод для перевірки requirement_terms
    public static boolean validate_Requirement_terms_Pattern(String requirement_terms) {
        Matcher matcher = requirement_terms_Pattern.matcher(requirement_terms);
        return matcher.matches();
    }

    // Метод для перевірки minWage_Pattern
    public static boolean validate_Requirement_minWage_Pattern(String minWage_Pattern) {
        Matcher matcher = requirement_minWage_Pattern.matcher(minWage_Pattern);
        return matcher.matches();
    }

    public static void Try_From_File(){
        try {
            File inputFile = new File("date.txt");
            Scanner scanner = new Scanner(inputFile);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");

                ua.khpi.oop.bondar11.RecruitmentAgency agency = new ua.khpi.oop.bondar11.RecruitmentAgency(
                        Integer.parseInt(parts[0]),
                        new ua.khpi.oop.bondar11.Experience(parts[1], new Date(parts[2])),
                        new ua.khpi.oop.bondar11.Requirement(parts[3], parts[4], Integer.parseInt(parts[5])));

                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

                boolean valid = validate_RegisterNumber(Integer.toString(agency.getRegisterNumber())) &&
                        validate_Experience_job_Pattern(agency.getExperience().getJob()) &&
                        validate_Experience_time_Pattern(formatter.format(agency.getExperience().getTime()).toString()) &&
                        validate_Requirement_job_Pattern(agency.getRequirement().getJob()) &&
                        validate_Requirement_terms_Pattern(agency.getRequirement().getTerms()) &&
                        validate_Requirement_minWage_Pattern(Integer.toString(agency.getRequirement().getMinWage()));

                System.out.println("Agency: " + agency + " is " + (valid ? "valid" : "invalid"));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }


    public static void main(String args[]) {
        try (Scanner scanner = new Scanner(System.in)) {

            ua.khpi.oop.bondar11.RecruitmentAgency agency = new RecruitmentAgency(
                    Integer.parseInt(scanner.nextLine()),
                    new Experience(scanner.nextLine(), new Date(scanner.nextLine())),
                    new Requirement(scanner.nextLine(), scanner.nextLine(), Integer.parseInt(scanner.nextLine())));

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

            boolean valid = validate_RegisterNumber(Integer.toString(agency.getRegisterNumber())) &&
                    validate_Experience_job_Pattern(agency.getExperience().getJob()) &&
                    validate_Experience_time_Pattern(formatter.format(agency.getExperience().getTime()).toString()) &&
                    validate_Requirement_job_Pattern(agency.getRequirement().getJob()) &&
                    validate_Requirement_terms_Pattern(agency.getRequirement().getTerms()) &&
                    validate_Requirement_minWage_Pattern(Integer.toString(agency.getRequirement().getMinWage()));

            System.out.println("Agency: " + agency + " is " + (valid ? "valid" : "invalid"));
        }
    }

    @Test
    public void test_validate_RegisterNumber_validInput() {
        boolean result = validate_RegisterNumber("1234");
        assertTrue(result);
    }

    @Test
    public void test_validate_RegisterNumber_invalidInput() {
        boolean result = validate_RegisterNumber("abc");
        assertFalse(result);
    }

    @Test
    public void test_validate_Experience_job_validInput() {
        boolean result = validate_Experience_job_Pattern("Engineer");
        assertTrue(result);
    }

    @Test
    public void test_validate_Experience_job_invalidInput() {
        boolean result = validate_Experience_job_Pattern("1");
        assertFalse(result);
    }

    @Test
    public void test_validate_Experience_time_validInput() {
        boolean result = validate_Experience_time_Pattern("2021-05-08");
        assertTrue(result);
    }

    @Test
    public void test_validate_Experience_time_invalidInput() {
        boolean result = validate_Experience_time_Pattern("05-08-2021");
        assertFalse(result);
    }

    @Test
    public void test_validate_Requirement_job_validInput() {
        boolean result = validate_Requirement_job_Pattern("Manager");
        assertTrue(result);
    }

    @Test
    public void test_validate_Requirement_job_invalidInput() {
        boolean result = validate_Requirement_job_Pattern("123");
        assertFalse(result);
    }

    @Test
    public void test_validate_Requirement_terms_validInput() {
        boolean result = validate_Requirement_terms_Pattern("Full-time position");
        assertTrue(result);
    }

    @Test
    public void test_validate_Requirement_terms_invalidInput() {
        boolean result = validate_Requirement_terms_Pattern("Full-time position@");
        assertFalse(result);
    }

    @Test
    public void test_validate_Requirement_minWage_validInput() {
        boolean result = validate_Requirement_minWage_Pattern("15000");
        assertTrue(result);
    }

    @Test
    public void test_validate_Requirement_minWage_invalidInput() {
        boolean result = validate_Requirement_minWage_Pattern("abc");
        assertFalse(result);
    }

    @Test
    public void test_Try_From_File_validInput() {
        File inputFile = new File("valid_agencies.txt");
        try {
            Scanner scanner = new Scanner(inputFile);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                RecruitmentAgency agency = new RecruitmentAgency(
                        Integer.parseInt(parts[0]),
                        new Experience(parts[1], new Date(parts[2])),
                        new Requirement(parts[3], parts[4], Integer.parseInt(parts[5])));

                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

                boolean valid = validate_RegisterNumber(Integer.toString(agency.getRegisterNumber())) &&
                        validate_Experience_job_Pattern(agency.getExperience().getJob()) &&
                        validate_Experience_time_Pattern(formatter.format(agency.getExperience().getTime()).toString()) &&
                        validate_Requirement_job_Pattern(agency.getRequirement().getJob()) &&
                        validate_Requirement_terms_Pattern(agency.getRequirement().getTerms()) &&
                        validate_Requirement_minWage_Pattern(Integer.toString(agency.getRequirement().getMinWage()));

                assertTrue(valid);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            fail("File not found");
        }
    }
}
```

## 3 ВАРІАНТИ ВИКОРИСТАННЯ
Для кадрового агентства

## Висновки
Ми набули навичи у розробцi модульних тестів з використанням JUnit 5.
