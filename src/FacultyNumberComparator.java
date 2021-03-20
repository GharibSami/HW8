import java.util.Comparator;

public class FacultyNumberComparator implements Comparator<Department> {
    @Override
    public int compare(Department o1, Department o2) {
        if(o1.getNumOfMembers() == o2.getNumOfMembers())
            return 0;
        return o1.getNumOfMembers() > o2.getNumOfMembers() ? 1 : -1 ;
    }
}
