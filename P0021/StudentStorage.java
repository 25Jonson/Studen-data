
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author PC
 */
public class StudentStorage {
    
    private List<Student> listStudents;

    public StudentStorage() {
        listStudents = new ArrayList<>();
    }
    
    public boolean addNew(Student st){
        // find the student will be add that is registed
        for(Student stItem : listStudents){
            // check for duplicate id
            if(stItem.getId() == st.getId()) return false;
            
//            if(checkRule(stItem, st)) break;
//            else return false;
            
        }
        this.listStudents.add(st);
        return true;
    }
    
    public boolean checkRule(Student st1, Student st2)
    {
        if(st1.getName().compareTo(st2.getName())==0){
            // check for the duplicate semester
            if(st1.getSemester().compareTo(st2.getSemester())==0){
                // if duplicate semeseter
                // new student must register deffence course
                if(st1.getCourseName().compareTo(st2.getCourseName())==0){
                    return false;
                }
                else {
                    return true;
                }
            }
        }
        return true;
    }    
    public boolean deleteByID(int id){
        Student st = findByID(id);
        if(st!=null){
            this.listStudents.remove(st);
            return true;
        }
        else return false;
    }
    
    public Student findByID(int id){
        for(Student stItem : listStudents){
            if(stItem.getId() == id){
                return stItem;
            }
        }
        return null;
    }
    
    public boolean updateByID(int id, Student studentModified){
        Student st = findByID(id);
        if(st!=null && checkRule(st, studentModified)){
            listStudents.set(listStudents.indexOf(st), studentModified);
            return true;
        }
        return false;
    }
    
    public List<Student> findByName(String name){
        List<Student> result = new ArrayList<>();
        for(Student stItem : listStudents){
            if(stItem.getName().contains(name)){
                result.add(stItem);
            }
        }
        
        // sort by name
        Collections.sort(result);
        return result;
    }
    
    public void report(){
        
        Collections.sort(listStudents);
        Student studentIsCounted = listStudents.get(0);
        int n = listStudents.size();
        int i = 0;
        while(i < n){
            int javaCount = 0;
            int dotNetCount = 0;
            int ccplusCount = 0;
            
            // count course 
            while(listStudents.get(i).getName().compareTo(studentIsCounted.getName())==0){
                // count course
                switch(listStudents.get(i).getCourseName()){
                    case "Java" : javaCount++; break;
                    case ".Net" : dotNetCount++; break;
                    case "C/C++" : ccplusCount++; break;
                }
                i++;
                if(i >= n-1) break;
            }
            
            // print out to screen
            if(javaCount!=0)
                System.out.println(studentIsCounted.getName()+ "| JAVA | " + javaCount);
            
            if(dotNetCount!=0)
                System.out.println(studentIsCounted.getName()+ "| .NET | " + dotNetCount);
            
            if(ccplusCount!=0)
                System.out.println(studentIsCounted.getName()+ "| C/C++ | " + ccplusCount);
        
            if(i< n) studentIsCounted = listStudents.get(i);
        }
    }
}
