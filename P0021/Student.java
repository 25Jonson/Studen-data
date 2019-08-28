/**
 *
 * @author PC
 */
public class Student implements Comparable<Student>{
 
    private int id;
    private String name;
    private String semester;
    private String courseName;

    public Student() {
    }

    public Student(int id, String name, String semester, String courseName) {
        this.id = id;
        this.name = name;
        this.semester = semester;
        this.courseName = courseName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public int compareTo(Student otherStudent) {
        return this.name.compareTo(otherStudent.getName());
    }

    @Override
    public String toString() {
        return String.format("%-30s%-15s%-5s", this.name,this.semester,this.courseName);
    }
    
    
}
