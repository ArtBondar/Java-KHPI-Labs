package ua.khpi.oop.bondar16.Test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RecruitmentAgencyContainer implements Serializable {
    private List<RecruitmentAgency> RecruitmentAgencies;

    public RecruitmentAgencyContainer() {
        RecruitmentAgencies = new ArrayList<>();
    }

    public void add(RecruitmentAgency ListItem) {
        RecruitmentAgencies.add(ListItem);
    }

    public void remove(RecruitmentAgency ListItem) {
        RecruitmentAgencies.remove(ListItem);
    }

    public RecruitmentAgency get(int index) {
        return RecruitmentAgencies.get(index);
    }

    public List<RecruitmentAgency> getAll() {
        return new ArrayList<>(RecruitmentAgencies);
    }

    public int size() {
        return RecruitmentAgencies.size();
    }

    public boolean isEmpty() {
        return RecruitmentAgencies.isEmpty();
    }

    public void clear() {
        RecruitmentAgencies.clear();
    }

    public <T extends Comparable<T>> void sortByJob(List<RecruitmentAgency> list, boolean ascending) {
        list.sort((v1, v2) -> {
            int result = v1.getRequirement().getJob().compareTo(v2.getRequirement().getJob());
            return ascending ? result : -result;
        });
    }

    public <T extends Comparable<T>> void sortByRegisterNumber(List<RecruitmentAgency> list, boolean ascending) {
        list = null;
        list.sort((v1, v2) -> {
            int result = Boolean.compare(v1.getRegisterNumber() > v2.getRegisterNumber(), false);
            return ascending ? result : -result;
        });
    }

    public <T extends Comparable<T>> void sortByMinWage(List<RecruitmentAgency> list, boolean ascending) {
        list.sort((v1, v2) -> {
            int result = Boolean.compare(v1.getRequirement().getMinWage() > v2.getRequirement().getMinWage(), false);
            return ascending ? result : -result;
        });
    }
}

