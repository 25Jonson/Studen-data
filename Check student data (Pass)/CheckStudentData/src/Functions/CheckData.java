package Functions;

import Entities.*;
import Validate_GetInput.*;
import java.io.*;
import java.util.*;

public class CheckData {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    GetInput get = new GetInput();
    Validate va = new Validate();

    //GET STUDENT INFO
    public ArrayList getStudentInfo(ArrayList<Student> studentList) throws IOException {
        boolean addMore;
        do {
            Student x = new Student();
            x.setName(get.getStudentName(studentList));
            x.setClassName(get.getStudentClass());
            x.setMath(get.getMath());
            x.setPhysical(get.getPhysic());
            x.setChemistry(get.getChemistry());
            double xAvg = (x.getMath() + x.getPhysical() + x.getChemistry()) / 3;
            x.setAvg(xAvg);
            x.setType(get.getType(x.getAvg()));
            studentList.add(x);
            Collections.sort(studentList);
            addMore = va.ynVal();
        } while (addMore == true);
        return studentList;
    }

    //PRINT OUT STUDENT LIST
    public void printStudentList(ArrayList<Student> studentList) {
        for (int i = 0; i < studentList.size(); i++) {
            System.out.printf("------ Student%d Info ------\n", (i + 1));
            System.out.println("Name: " + studentList.get(i).getName());
            System.out.println("Classes: " + studentList.get(i).getClassName());
            System.out.printf("AVG: %.1f\n", studentList.get(i).getAvg());
            System.out.println("Type: " + studentList.get(i).getType());
        }
    }

    //PRINT OUT CLASSIFICATION INFO
    public void classification(ArrayList<Student> studentList) {
        double aPercent = 0, bPercent = 0, cPercent = 0, dPercent = 0;
        double cntA = 0, cntB = 0, cntC = 0, cntD = 0;
        //count the number of student in each classification
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getType().equalsIgnoreCase("A") == true) {
                cntA++;
            } else if (studentList.get(i).getType().equalsIgnoreCase("B") == true) {
                cntB++;
            } else if (studentList.get(i).getType().equalsIgnoreCase("C") == true) {
                cntC++;
            } else {
                cntD++;
            }
        }
        //calculate the percentage
        double sum = cntA + cntB + cntC + cntD;
        aPercent = (cntA / sum) * 100;
        bPercent = (cntB / sum) * 100;
        cPercent = (cntC / sum) * 100;
        dPercent = 100 - (aPercent + bPercent + cPercent);
        //print out the result
        System.out.println("-------- Classification Info --------");
        System.out.printf("A: %.1f%% \n", aPercent);
        System.out.printf("B: %.1f%% \n", bPercent);
        System.out.printf("C: %.1f%% \n", cPercent);
        System.out.printf("D: %.1f%% \n", dPercent);
    }
}
