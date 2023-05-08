package ua.khpi.oop.bondar16.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RecruitmentAgencyContainerTest {
    private RecruitmentAgencyContainer container;

    @BeforeEach
    void setUp() {
        container = new RecruitmentAgencyContainer();
    }

    @Test
    public void testAdd() {
        RecruitmentAgency agency = new RecruitmentAgency();
        container.add(agency);
        assertEquals(1, container.size());
        assertTrue(container.getAll().contains(agency));
    }

    @Test
    public void testRemove() {
        RecruitmentAgency agency = new RecruitmentAgency();
        container.add(agency);
        container.remove(agency);
        assertEquals(0, container.size());
        assertFalse(container.getAll().contains(agency));
    }

    @Test
    public void testGet() {
        RecruitmentAgency agency = new RecruitmentAgency();
        container.add(agency);
        assertEquals(agency, container.get(0));
    }

    @Test
    public void testGetAll() {
        RecruitmentAgency agency1 = new RecruitmentAgency();
        RecruitmentAgency agency2 = new RecruitmentAgency();
        container.add(agency1);
        container.add(agency2);
        List<RecruitmentAgency> allAgencies = container.getAll();
        assertEquals(2, allAgencies.size());
        assertTrue(allAgencies.contains(agency1));
        assertTrue(allAgencies.contains(agency2));
    }

    @Test
    public void testSize() {
        RecruitmentAgency agency = new RecruitmentAgency();
        container.add(agency);
        assertEquals(1, container.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(container.isEmpty());
        RecruitmentAgency agency = new RecruitmentAgency();
        container.add(agency);
        assertFalse(container.isEmpty());
    }

    @Test
    public void testClear() {
        RecruitmentAgency agency = new RecruitmentAgency();
        container.add(agency);
        container.clear();
        assertEquals(0, container.size());
        assertTrue(container.isEmpty());
        assertFalse(container.getAll().contains(agency));
    }
}
