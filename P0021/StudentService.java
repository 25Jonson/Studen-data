
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author PC
 */
public class StudentService {

    private StudentStorage studentStorage;
    private Scanner scanner = new Scanner(System.in);
    public StudentService() {
        studentStorage = new StudentStorage();
    }
    
    public void addNewStudent(){
        Student st = inputStudent(true);
        boolean addSuccess = studentStorage.addNew(st);
        if(addSuccess) System.out.println("Add student successfully");
        else System.out.println("Add fail!");
    }
    
    
    public void findAndSort(){
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        List<Student> findResult = studentStorage.findByName(name);
        for(int i=0;i<findResult.size();i++){
            Student st = findResult.get(i);
            System.out.println((i+1)+" "+st);
        }
    }
    
    public Student inputStudent(boolean isNew){
        int ID = 0;
        if(isNew){
            System.out.print("Enter student ID: ");
            ID = Integer.parseInt(scanner.nextLine());
        }
        
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Semester: ");
        String semester = scanner.nextLine();
        System.out.print("Course:\n 1. Java \n 2. .Net \n 3. C/C++");
        int choice = Integer.parseInt(scanner.nextLine());
        String course = null;
        switch(choice){
            case 1: 
                course = Courses.JAVA.toString();
                break;
            case 2: 
                course = Courses.DotNET.toString();
                break;
            case 3: 
                course = Courses.CCplus.toString();
                break;
        }
        Student st = new Student(ID, name, semester, course);
        return st;
    }
    
    public void updateAndDelete(){
        System.out.print("Enter ID: ");
        int ID = Integer.parseInt(scanner.nextLine());
        System.out.print("Do you want to Delete (D) or Update (U): ");
        String choice = scanner.nextLine();
        if(choice.equals("D")){
            boolean delSuccess = studentStorage.deleteByID(ID);
            if(delSuccess) System.out.println("Delete student is successfully");
            else System.out.println("Delete fail because student ID not found");
        }
        else {
            if(choice.equals("U")){
                Student st = inputStudent(false);
                st.setId(ID);
                boolean updateSuccess = studentStorage.updateByID(ID, st);
                
                if(updateSuccess) System.out.println("Update student is succesfully");
                else System.out.println("Update fail because student ID not found");
            }
            else System.out.println("Wrong selection!");
        }
    }
    
    public void studentReport(){
        System.out.println("========== Student Report ==========");
        studentStorage.report();
    }
}
