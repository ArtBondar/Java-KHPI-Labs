package ua.khpi.oop.bondar08;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

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

    public void Save(String path){
        try {
            XMLEncoder x = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(path + "RecruitmentAgency.xml")));
            x.writeObject(this);
            x.close();
            System.out.println("Done");
        } catch (FileNotFoundException e) {

            e.printStackTrace();
            System.out.println("Error");
        }
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
