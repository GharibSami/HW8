//Assignment: ASU CSE205 Spring 2021 #8
//Name:
//StudentID:
//Lecture:
//Description:

import java.util.Comparator;

public class DeptFacultyComparator implements Comparator<Department>
{
	//First we compare the currentFaculty's last name, if they are same, we then compare
	//their first names. The departments should be listed in the alphabetical order of the
	//currentFaculty's last and first names
	public int compare(Department first, Department second)
	{
		return first.getFaculty().getLastName().compareTo(second.getFaculty().getLastName());

	}
}
