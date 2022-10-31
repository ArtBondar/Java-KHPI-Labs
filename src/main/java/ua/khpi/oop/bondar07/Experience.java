package ua.khpi.oop.bondar07;

import java.util.Date;

public class Experience {
    private String job;
    private Date time;

    public Experience(){
        job = "job";
        time = new Date();
    }

    public Experience(String job, Date time) {
        this.job = job;
        this.time = time;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "job='" + job + '\'' +
                ", time=" + time +
                '}';
    }
}
