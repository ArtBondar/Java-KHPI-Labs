package ua.khpi.oop.bondar07;

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
