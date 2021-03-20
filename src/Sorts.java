//   Assignment: ASU CSE205 Spring 2021 #8
//         Name:
//    StudentID:
//      Lecture:
//  Description:

import java.util.Comparator;
import java.util.ArrayList;

public class Sorts {
    // if return of compare postive number replace
    public static void sort(ArrayList<Department> deptList, Comparator<Department> xComparator) {
        for (int i = 0; i < deptList.size(); i++) {
            Department department = deptList.get(i);
            for (int g = 0; g < deptList.size(); g++) {
                int compare = xComparator.compare(department ,deptList.get(g));
                if (compare < 0){
                    Department depRep = deptList.get(g);
                    deptList.set(i ,depRep);
                    deptList.set(g ,department);
                    department =depRep;
                }
            }
        }

    } //end sort
} //end class Sorts
