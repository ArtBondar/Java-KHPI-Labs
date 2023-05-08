package ua.khpi.oop.bondar15;

import java.util.List;

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
