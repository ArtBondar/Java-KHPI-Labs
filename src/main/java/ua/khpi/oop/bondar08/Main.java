package ua.khpi.oop.bondar08;

public class Main {
    public static void main(String args[]) {
        RecruitmentAgency myagency = new RecruitmentAgency();
        myagency.setRegisterNumber(123321);
        myagency.Save("D:\\");
        System.out.println(myagency.toString());
    }
}
