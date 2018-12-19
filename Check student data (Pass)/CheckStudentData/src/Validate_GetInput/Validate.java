package Validate_GetInput;

import Entities.*;
import java.io.*;
import java.util.*;

public class Validate {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    //VALIDATE NAME
    public boolean nameVal(String name) {
        boolean invalidName;
        name = name.trim();
        if (name == null || name.equals("")) {  //check for blank input
            System.out.println("Blank input. Please enter name");
            System.out.println();
            invalidName = true;
        } else if (!name.matches("[a-zA-Z0-9\\s]*")) {  //check for name to be character only
            System.out.println("No number or special character allowed");
            System.out.println();
            invalidName = true;
        } else {
            invalidName = false;
        }
        return invalidName;
    }

    //VALIDATE CLASS
    public boolean classVal(String className) {
        boolean invalidClass;
        className = className.trim();
        if (className == null || className.equals("")) {      //check for blank input
            System.out.println("Blank input. Please enter again");
            System.out.println();
            invalidClass = true;
        } else if (!className.matches("[a-zA-Z0-9]*")) {      //check if ID having special characters
            System.out.println("No special character allowed");
            System.out.println();
            invalidClass = true;
        } else {
            invalidClass = false;
        }
        return invalidClass;
    }

    //VALIDATE MARK
    public boolean markVal(double mark) {
        boolean invalidMark;
        if (mark < 0) {
            System.out.println("Mark is greater than equal zero"); //check for mark inside range of 0-10
            System.out.println();
            invalidMark = true;
        } else if (mark > 10) {
            System.out.println("Mark is less than equal ten");    //check for mark inside range of 0-10
            System.out.println();
            invalidMark = true;
        } else {
            invalidMark = false;
        }
        return invalidMark;
    }

    //VALIDATE Y/N QUESTION
    public boolean ynVal() throws IOException {
        boolean ynCheck;
        boolean addMore = false;
        do {
            System.out.print("Do you want to continue (Y/N) ? ");
            String check = in.readLine().trim();
            if (check.equalsIgnoreCase("y")) {        //if y then return to adding student
                ynCheck = true;
                addMore = true;
            } else if (check.equalsIgnoreCase("n")) {   //if n then end the function
                ynCheck = true;
                addMore = false;
                System.out.println();
            } else {
                System.out.println("Wrong input. Please enter Y or N only");
                ynCheck = false;
            }
        } while (ynCheck == false);
        return addMore;
    }

    //CHECK FOR DUPLICATE NAME
    public boolean checkDupName(String name, ArrayList<Student> StudentList) {
        boolean dupName = false;
        for (int i = 0; i < StudentList.size(); i++) {
            if (StudentList.get(i).getName().equalsIgnoreCase(name.trim()) == true) {   //check if the new name is the same as another name
                dupName = true;
                System.out.println("This name has already been entered. Please enter different name");
                break;
            } else {
                dupName = false;
            }
        }
        return dupName;
    }
}
