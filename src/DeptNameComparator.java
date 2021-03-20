import java.util.Comparator;

public class DeptNameComparator implements Comparator<Department> {
    /*
    * if first dpt name less than second return integer < 0
    * if firrst more than second return integer > 0
    * if equal return 0 */

    @Override
    public int compare(Department first, Department second) {
        return  first.getDeptName().compareTo(second.getDeptName());

    }
}
