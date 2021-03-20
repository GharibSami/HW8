//Assignment: ASU CSE205 Spring 2021 #8
//Name:
//StudentID:
//Lecture:
//Description: //---- is where you should add your own code

import java.io.Serializable;
import java.util.ArrayList;
//import all other necessary classes

public class DeptManagement implements Serializable {
    ArrayList<Department> deptList;

    public DeptManagement() {
        this.deptList = new ArrayList<Department>();
    }

    public int deptExists(String deptName, String universityName) {
        int i = 0;
        for (Department d : deptList) {
            if (d.getDeptName().equals(deptName)) {
                if (d.getUniversity().equals(universityName)) {
                    return i;
                }
            }
            i++;
        }
        return -1;
    }

    public int facultyExists(String firstName, String lastName, String academicLevel) {
        int i = 0;
        for (Department d : deptList) {
            if (d.getFaculty().getFirstName().equals(firstName) &&
                    d.getFaculty().getLastName().equals(lastName) &&
                    d.getFaculty().getAcademicLevel().equals(academicLevel)) {
                return i;
            }
        }
        return -1;
    }

    public boolean addDepartment(String deptName, String university, int numOfMembers, String firstName, String lastName, String academicLevel) {
        int find = deptExists(deptName, university);

        if (find == -1) {
            deptList.add(new Department(deptName, university, numOfMembers, firstName, lastName, academicLevel));
            return true;
        }
        return false;
    }

    //***will remove all departments with the same name and university
    public boolean removeDepartment(String deptName, String universityName) {
        int find = deptExists(deptName, universityName);
        if (find > 0) {
            deptList.remove(find);
            return true;
        }
        return false;
    }

    public void sortByDepartmentName() {
        Sorts.sort(deptList, new DeptNameComparator());
    }

    public void sortByFacultyNumbers() {
        Sorts.sort(deptList, new FacultyNumberComparator());
    }

    public void sortByDeptFaculty() {
        Sorts.sort(deptList, new DeptFacultyComparator());
    }

    public String listDepartments() {
        String s = "";
        if (deptList.size() > 0) {
            for (Department d : deptList) {
                s += d.toString();
            }
            return s;
        }
        return "\nNo Department\n\n";
    }

    public void closeDeptManagement() {

        for (int i = 0; i < deptList.size(); i++) {
            deptList.remove(i);
        }
    }
}