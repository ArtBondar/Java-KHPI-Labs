package ua.khpi.oop.bondar15;

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
}

