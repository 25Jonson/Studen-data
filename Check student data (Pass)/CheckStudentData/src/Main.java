
import Entities.*;
import Functions.*;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        CheckData check = new CheckData();
        ArrayList<Student> studentList = new ArrayList<>();

        System.out.println("====== Management Student Program ======");
        //get student info
        studentList = check.getStudentInfo(studentList);
        //print out the list
        check.printStudentList(studentList);
        //print out classification Info
        check.classification(studentList);
    }

}
