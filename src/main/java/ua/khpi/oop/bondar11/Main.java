package ua.khpi.oop.bondar11;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
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

                System.out.println("Agency: " + agency + " is " + (valid ? "valid" : "invalid"));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }




    public static void main(String args[]) {
        try (Scanner scanner = new Scanner(System.in)) {

            RecruitmentAgency agency = new RecruitmentAgency(
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
}
