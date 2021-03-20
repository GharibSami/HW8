//   Assignment: ASU CSE205 Spring 2021 #8
//         Name:
//    StudentID:
//      Lecture:
//  Description: The Assignment 8 class displays a menu of choices to a user
//               and performs the chosen task. It will keep asking a user to
//               enter the next choice until the choice of 'Q' (Quit) is
//               entered. //---- is where you should add your own code

import java.io.*;
import java.util.Scanner;

public class Assignment8 {
    public static void main(String[] args) {
        char input1;
        String deptName, numOfFacultyStr, nameOfUniversity;
        String firstName, lastName, academicLevel;
        String university;
        int numOfFaculty;

        boolean operation = false;
        int operation2 = 0;
        String line;
        String filename;

        // create a DeptManagement object. This is used throughout this class.
        DeptManagement deptManage1 = new DeptManagement();

        File file;

        try {
            // print out the menu
            printMenu();

            // create a BufferedReader object to read input from a keyboard
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader stdin = new BufferedReader(isr);

            do {
                System.out.print("\nWhat action would you like to perform?\n");
                line = stdin.readLine().trim(); //read a line
                input1 = line.charAt(0);
                input1 = Character.toUpperCase(input1);

                if (line.length() == 1) //check if a user entered only one character
                {
                    switch (input1) {
                        case 'A':
                            //Add Department
                            System.out.print("Please enter the department information:\n");
                            System.out.print("Enter department name:\n");
                            deptName = stdin.readLine().trim();
                            System.out.print("Enter number of faculty:\n");
                            numOfFacultyStr = stdin.readLine().trim();
                            numOfFaculty = Integer.parseInt(numOfFacultyStr);
                            System.out.print("Enter university name:\n");
                            nameOfUniversity = stdin.readLine().trim();
                            System.out.print("Enter faculty first name:\n");
                            firstName = stdin.readLine().trim();
                            System.out.print("Enter faculty last name:\n");
                            lastName = stdin.readLine().trim();
                            System.out.print("Enter faculty academic level:\n");
                            academicLevel = stdin.readLine().trim();
/************************************************************************************
 ***  Complete the follwing statement, if the department is added successfully, show
 "Department added\n" on screen, otherwise show "Department NOT added\n"
 ***********************************************************************************/
                            if (deptManage1.addDepartment(deptName, nameOfUniversity, numOfFaculty,
                                    firstName, lastName, academicLevel)) {

                                System.out.print("Department added\n");
                            } else
                                System.out.print("Department NOT added\n");
                            break;
                        case 'C':
                            //Create a new department management
                            deptManage1 = new DeptManagement();
                            break;
                        //*****
                        case 'D':
                            //Search by department's name and the university
                            System.out.print("Please enter the department name to search:\n");
                            deptName = stdin.readLine().trim();
                            System.out.print("Please enter the university name to search:\n");
                            university = stdin.readLine().trim();
/************************************************************************************
 ***  Complete the follwing statement, if the department with above name and university is found
 show deptName + " at " + university + " is found\n"; otherwise show
 deptName + " at " + university + " is NOT found\n"
 ***********************************************************************************/
                            int i = deptManage1.deptExists(deptName,
                                    university);
                            if (i >= 0) {
                                Department department = deptManage1.deptList.get(i);
                                System.out.print(department.getDeptName() + " at " + department.getUniversity() + " is found\n");
                            } else
                                System.out.print(deptName + " at " + university + " NOT found\n");
                            break;
                        case 'E':
                            //Search faculty
                            System.out.print("Please enter the faculty first name to search:\n");
                            firstName = stdin.readLine().trim();
                            System.out.print("Please enter the faculty last name to search:\n");
                            lastName = stdin.readLine().trim();
                            System.out.print("Please enter the faculty academic level to search:\n");
                            academicLevel = stdin.readLine().trim();
/************************************************************************************
 ***  Complete the follwing statement, if the department with its currentFaculty has above
 first, last and academic info. is found, show "Faculty: " + firstName + " " + lastName + ", " + academicLevel + " is found\n"; otherwise show
 "Faculty: " + firstName + " " + lastName + ", " + academicLevel + " is NOT found\n"
 ***********************************************************************************/
                            int g = deptManage1.facultyExists(firstName, lastName, academicLevel);
                            if (g >= 0) {
                                Department department = deptManage1.deptList.get(g);
                                System.out.print("Faculty: " + department.getFaculty().getFirstName() +
                                        " " + department.getFaculty().getLastName() + ", " + department.getFaculty().getAcademicLevel() + " is found\n");
                            } else
                                System.out.print("Faculty: " + firstName + " " + lastName + ", " + academicLevel + " is NOT found\n");
                            break;
                        case 'L':
                            //List departments
                            System.out.print(deptManage1.listDepartments());
                            break;

                        case 'N':
/************************************************************************************
 ***  Complete the follwing statement. Sort by department names in alphabetical order
 ***********************************************************************************/
                            deptManage1.sortByDepartmentName();
                            System.out.print("sorted by department names\n");
                            break;

                        case 'O':
/************************************************************************************
 ***  Complete the follwing statement. Sort by faculty numbers in increasing order
 ***********************************************************************************/
                            deptManage1.sortByFacultyNumbers();
                            System.out.print("sorted by faculty numbers\n");
                            break;
                        case 'P':
/************************************************************************************
 ***  Complete the follwing statement. Sort the current faculty in alphabetical order
 ***********************************************************************************/
                            deptManage1.sortByDeptFaculty();
                            System.out.print("sorted by current faculty name\n");
                            break;
                        case 'Q':
                            return;

                        case 'R':
                            //Remove a department
                            System.out.print("Please enter the department name to remove:\n");
                            deptName = stdin.readLine().trim();
                            System.out.print("Please enter the university name to remove:\n");
                            university = stdin.readLine().trim();
/************************************************************************************
 ***  Complete the follwing statement, if the department with above name and university is found
 remove it. Show the relevant info. accordingly.
 ***********************************************************************************/
                            boolean dep = deptManage1.removeDepartment(deptName, university);
                            if (dep)
                                System.out.print(deptName + " at " + university + " is removed\n");
                            else
                                System.out.print(deptName + " at " + university + " is NOT removed\n");
                            break;
                        case 'T':
                            //Close DeptManagement
                            deptManage1.closeDeptManagement();
                            System.out.print("Department management system closed\n");
                            break;
                        case 'U':
                            //Write Text to a File
                            System.out.print("Please enter a file name that we will write to:\n");
                            filename = stdin.readLine().trim();
                            try {
/************************************************************************************
 ***  Complete the follwing statement, write above string inside the relevant file
 ***********************************************************************************/

                                File f = new File(filename);
                                FileWriter fr = new FileWriter(f);
                                System.out.print("Please enter a string to write inside the file:\n");
                                String text = stdin.readLine().trim();
                                fr.write(text + "\n");
                                fr.close();
                                System.out.print(filename + " is written\n");
                            } catch (Exception e) {
                                System.out.print("Write string inside the file error\n");
                            }
                            break;
                        case 'V':
                            //Read Text from a File
                            System.out.print("Please enter a file name which we will read from:\n");
                            filename = stdin.readLine().trim();
                            try {
                                FileReader fileReader = new FileReader(filename);
                                int fline = fileReader.read();
                                if (fline != -1) {
                                    System.out.print(filename + " was read\n");
                                }
                                int ch;
                                String content = "";
                                System.out.print("the first line of the file is\n");
                                while ((ch = fileReader.read()) != 10) {
                                    content += (((char) ch) + "");
                                }
                                content += "\n";
                                System.out.print(content);
                                fileReader.close();

/************************************************************************************
 ***  Complete the follwing statement, read from above text file
 ***********************************************************************************/

                            } catch (FileNotFoundException e) {
                                System.out.print(filename + " not found error\n");
                            } catch (IOException e1) {
                                System.out.print("Read string from the file error\n");
                            }
                            break;
                        case 'W':
                            //Serialize DeptManagement to a File
                            System.out.print("Please enter a file name which we will write to:\n");
                            filename = stdin.readLine().trim();
                            try {
/************************************************************************************
 ***  Complete the follwing statement, write object deptManage1 inside the data file
 ***********************************************************************************/
                                File f = new File(filename);
                                FileOutputStream fileOutputStream = new FileOutputStream(f);
                                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                                objectOutputStream.writeObject(deptManage1);
                                objectOutputStream.flush();
                                fileOutputStream.flush();
                            } catch (NotSerializableException e) {
                                System.out.print("Not serializable exception\n");
                            } catch (IOException e1) {
                                System.out.print("Data file written exception\n");
                            }
                            break;
                        case 'X':
                            //Deserialize DeptManagement from a File
                            System.out.print("Please enter a file name which we will read from:\n");
                            filename = stdin.readLine().trim();
                            try {
/************************************************************************************
 ***  Complete the follwing statement, read object from the data file and save the object
 as deptManage1
 ***********************************************************************************/

                                FileInputStream fileInputStream = new FileInputStream(filename);
                                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                                DeptManagement management = (DeptManagement) objectInputStream.readObject();
                                System.out.print(filename + " was read\n");
                            } catch (NotSerializableException e1) {
                                System.out.print("Not serializable exception\n");
                            } catch (ClassNotFoundException e) {
                                System.out.print("Class not found exception\n");
                            } catch (IOException e3) {
                                System.out.print("Data file read exception\n");
                            }
                            break;
                        case '?':
                            //Display Menu
                            printMenu();
                            break;
                        default:
                            System.out.print("Unknown action\n");
                            break;
                    }
                } else {
                    System.out.print("Unknown action\n");
                }
            } while (input1 != 'Q' || line.length() != 1);
        } catch (IOException exception) {
            System.out.print("IO Exception\n");
        }
    }

    /**
     * The method printMenu displays the menu to a user
     **/
    public static void printMenu() {
        System.out.print("Choice\t\tAction\n" +
                "------\t\t------\n" +
                "A\t\tAdd a department\n" +
                "C\t\tCreate a DeptManagement\n" +
                "D\t\tSearch a department\n" +
                "E\t\tSearch a faculty\n" +
                "L\t\tList departments\n" +
                "N\t\tSort by department names\n" +
                "O\t\tSort by department faculty numbers\n" +
                "P\t\tSort by current faculty name\n" +
                "Q\t\tQuit\n" +
                "R\t\tRemove a department\n" +
                "T\t\tClose DeptManagement\n" +
                "U\t\tWrite strings to a text file\n" +
                "V\t\tRead strings from a text file\n" +
                "W\t\tSerialize DeptManagement to a data file\n" +
                "X\t\tDeserialize DeptManagement from a data file\n" +
                "?\t\tDisplay Help\n");
    }
}