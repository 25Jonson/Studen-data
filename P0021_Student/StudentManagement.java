
import com.sun.xml.internal.ws.api.ha.StickyFeature;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class StudentManagement {

    Validator v = new Validator();
    private final List<Student> listStudent;
    private final List<StudentReport> listStudentReport;

    public StudentManagement() {
        listStudent = new ArrayList<>();
        listStudentReport = new ArrayList<>();
    }

    public void add(Student s) {
        listStudent.add(s);
    }

    public void add(StudentReport sr) {
        listStudentReport.add(sr);
    }

    //add information of stundet
    public void add() {
        Scanner in = new Scanner(System.in);
        boolean addMore = false;
        do {
            do {
                System.out.println("Enter ID:");
                String id = v.checkString("");
                System.out.println("Enter name: ");
                String name = v.checkString("");
//                do {
//                    if (!(listStudent.get(checkDupplicate(id)).getName().equalsIgnoreCase(name))) {
//                        System.out.printf("ID [%s] had existed with name [%s], enter again:",
//                                 listStudent.get(checkDupplicate(id)).getId(), listStudent.get(checkDupplicate(id)).getName());
//                        name = v.checkString("");
//                    }
//                } while (!listStudent.get(checkDupplicate(id)).getName().equalsIgnoreCase(name));
                System.out.println("Enter course: ");
                String course = v.checkString("");
                do {
                    if (!course.equalsIgnoreCase("java") && !course.equalsIgnoreCase(".net") && !course.equalsIgnoreCase("C/C++")) {
                        System.out.println("There are only three courses: Java, .Net, C/C++). ");
                        course = v.checkString("");
                    }
                } while (!course.equalsIgnoreCase("java") && !course.equalsIgnoreCase(".net") && !course.equalsIgnoreCase("C/C++"));

                System.out.println("Enter semester: ");
                int semester = v.checkInt("");
                if (checkSameInfo(id, semester, course) == false) {
                    listStudent.add(new Student(id, name, course, semester));
                } else {
                    System.out.println("Student had existed in data, please enter again:\n");
                }
            } while (listStudent.size() <= 4);

            System.out.println("Do you want to continue (Y/N)? Choose Y to continue, N to return main screen");
            String number = in.next();
            if (number.equalsIgnoreCase("y")) {
                addMore = true;
            }
        } while (addMore == true);
    }

    public boolean checkSameInfo(String checkId, int checkSemester, String checkCourse) {
        boolean sameInfor = false;
        for (int i = 0; i < listStudent.size(); i++) {
            if (listStudent.get(i).getId().equalsIgnoreCase(checkId) && listStudent.get(i).getSemester() == checkSemester && listStudent.get(i).getCourse().equalsIgnoreCase(checkCourse)) { //if same id, semester and course
                sameInfor = true;
                break;
            } else {
                sameInfor = false;
            }
        }
        return sameInfor;
    }

    public int checkDupplicate(String check) {
        int n = listStudent.size();
        int Ret = -1;
        boolean find = false;
        for (int i = 0; i < n; i++) {
            Student s = listStudent.get(i);
            if (s.getId().equalsIgnoreCase(check)) {
                find = true;
                Ret = i;
                break;
            }
        }
        return Ret;
    }

    public void displayStudent() {
        int n = listStudent.size();
        System.out.printf("%-20s%-20s%-10s%-10s\n", "ID", "Name", "Course", "Semester");
        for (int i = 0; i < n; i++) {
            Student s = listStudent.get(i);
            toString();
        }
    }

    public void search(String name) {
        int n = listStudent.size();
        boolean find = false;

        for (int i = 0; i < n; i++) {
            Student s = listStudent.get(i);
            if (s.getName().equalsIgnoreCase(name)) {
                find = true;
                System.out.printf("%-20s%-20s%-10s%-10s\n", "ID", "Name", "Course", "Semester");
                System.out.printf("%-10s%-20s%-10s%-10d\n", s.getId(), s.getName(), s.getCourse(), s.getSemester());;
                Comparator<Student> nameSort = new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        return s.getName().compareToIgnoreCase(o1.getName());
                    }
                };
            }
        }
        if (find == false) {
            System.out.println("Name is not exists in data");
        }
    }

    public void delete(String removeById) {
        boolean find = false;
        if (checkDupplicate(removeById) != -1) {
            find = true;
            listStudent.remove(checkDupplicate(removeById));
        }
        if (find == false) {
            System.out.println("Data is not exists so it is not delete");
        }
    }

    public void update(String updateById) {
        Scanner sc = new Scanner(System.in);
        boolean find = false;
        for (int i = 0; i < listStudent.size(); i++) {
            if (listStudent.get(i).getId().equals(updateById)) {
                find = true;
                System.out.println("Enter new name: ");
                String newName = v.checkString2("");
                if (!newName.equals("")) {
                    listStudent.get(i).setName(newName);
                }
                System.out.println("Enter new course: ");
                String newCourse = v.checkString2("");
                if (!newName.equals("")) {
                    listStudent.get(i).setCourse(newCourse);
                } else {
                    do {
                        if (!newCourse.equalsIgnoreCase("java") && !newCourse.equalsIgnoreCase(".net") && !newCourse.equalsIgnoreCase("C/C++")) {
                            System.out.println("There are only three courses: Java, .Net, C/C++). ");
                            newCourse = v.checkString("");
                        }
                    } while (!newCourse.equalsIgnoreCase("java") && !newCourse.equalsIgnoreCase(".net") && !newCourse.equalsIgnoreCase("C/C++"));
                }
                System.out.println("Enter new semester - Press 0 to skip:  ");
                int newSemester = v.checkInt("");
                if (newSemester != 0) {
                    listStudent.get(i).setSemester(newSemester);
                }
            }
        }
    }

    public void report() {
        for (int i = 0; i < listStudent.size(); i++) {
            StudentReport sr = new StudentReport();
            sr.setId(listStudent.get(i).getId());
            if (sr.getCourse().equalsIgnoreCase("Java") == true) {
                sr.setTotalJava(sr.getTotalJava() + 1);
            } else if (sr.getCourse().equalsIgnoreCase(".Net") == true) {
                sr.setTotalNet(sr.getTotalNet() + 1);
            } else {
                sr.setTotalC(sr.getTotalC() + 1);
            }
            listStudentReport.add(sr);
        }
        //print out result
        for (int i = 0; i < listStudentReport.size(); i++) {
            System.out.println("Student: " + listStudentReport.get(i).getName());
            System.out.println("Java: " + listStudentReport.get(i).getTotalJava());
            System.out.println(".Net: " + listStudentReport.get(i).getTotalNet());
            System.out.println("C/C++: " + listStudentReport.get(i).getTotalC());
            System.out.println();
        }
    }

}
