package ua.khpi.oop.bondar16.Test;

import org.junit.jupiter.api.Test;
import ua.khpi.oop.bondar11.Experience;
import ua.khpi.oop.bondar11.RecruitmentAgency;
import ua.khpi.oop.bondar11.Requirement;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

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
