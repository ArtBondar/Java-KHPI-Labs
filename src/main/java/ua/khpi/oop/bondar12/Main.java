package ua.khpi.oop.bondar12;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

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
