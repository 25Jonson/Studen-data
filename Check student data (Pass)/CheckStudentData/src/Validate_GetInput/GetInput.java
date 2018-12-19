package Validate_GetInput;

import Entities.Student;
import java.io.*;
import java.util.ArrayList;

public class GetInput {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    Validate va = new Validate();

    //GET STUDENT NAME
    public String getStudentName(ArrayList<Student> StudentList) throws IOException {
        boolean dupName;
        boolean invalidName;
        String name;
        do {
            System.out.print("Enter name: ");
            name = in.readLine();
            invalidName = va.nameVal(name); //validate name (char only)
            dupName = va.checkDupName(name, StudentList); //check for duplicate name
        } while (invalidName == true || dupName == true);
        return name.trim();
    }

    //GET STUDENT CLASS
    public String getStudentClass() throws IOException {
        boolean invalidClass;
        String className;
        do {
            System.out.print("Enter class: ");
            className = in.readLine();
            invalidClass = va.classVal(className); //check for special char
        } while (invalidClass == true);
        return className.trim();
    }

    //GET MATH MARK
    public double getMath() throws IOException {
        boolean invalidMark;
        double math = 0;
        do {
            try {
                System.out.print("Enter math mark: ");
                math = Double.parseDouble(in.readLine().trim());
                invalidMark = va.markVal(math);
            } catch (NumberFormatException e) {         //check if input is not number
                System.out.println("Maths is digit");
                System.out.println();
                invalidMark = true;
            }
        } while (invalidMark == true);
        return math;
    }

    //GET PHYSICAL MARK
    public double getPhysic() throws IOException {
        boolean invalidMark;
        double physics = 0;
        do {
            try {
                System.out.print("Enter physical mark: ");
                physics = Double.parseDouble(in.readLine().trim());
                invalidMark = va.markVal(physics);
            } catch (NumberFormatException e) {         //check if input is not number
                System.out.println("Physics is digit");
                System.out.println();
                invalidMark = true;
            }
        } while (invalidMark == true);
        return physics;
    }

    //GET CHEMISTRY MARK
    public double getChemistry() throws IOException {
        boolean invalidMark;
        double chemistry = 0;
        do {
            try {
                System.out.print("Enter chemistry mark: ");
                chemistry = Double.parseDouble(in.readLine().trim());
                invalidMark = va.markVal(chemistry);
            } catch (NumberFormatException e) {         //check if input is not number
                System.out.println("Chemistry is digit");
                System.out.println();
                invalidMark = true;
            }
        } while (invalidMark == true);
        return chemistry;
    }

    //GET STUDENT TYPE
    public String getType(double avg) {
        String type;
        if (avg > 7.5) {
            type = "A";
        } else if (6 <= avg && avg <= 7.5) {
            type = "B";
        } else if (4 <= avg && avg < 6) {
            type = "C";
        } else {
            type = "D";
        }
        return type;
    }
}
