package ua.khpi.oop.bondar15;

public class Requirement {
    private String job;
    private String terms;
    private int minWage;

    public Requirement(){
        job = "job";
        terms = "terms";
        minWage = 0;
    }

    public Requirement(String job, String terms, int minWage) {
        this.job = job;
        this.terms = terms;
        this.minWage = minWage;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public int getMinWage() {
        return minWage;
    }

    public void setMinWage(int minWage) {
        this.minWage = minWage;
    }

    @Override
    public String toString() {
        return "Requirement{" +
                "job='" + job + '\'' +
                ", terms='" + terms + '\'' +
                ", minWage=" + minWage +
                '}';
    }
}
