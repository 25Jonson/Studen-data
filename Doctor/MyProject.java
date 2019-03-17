
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyProject implements IProject, A, B {

    //a list of project
    private List<Project> project;

    public MyProject() {
        project = new ArrayList();
    }

    @Override
    public void add(Project p) {
        project.add(p);
    }

    @Override
    public void list() {
        int n = project.size();
        for (int i = 0; i < n; i++) {
            Project p = project.get(i);
            System.out.println(String.format("%-20s%-10.2f\n", p.getName(), p.getInvest()));
        }
    }

    @Override
    public Project search(String name) {
        int n = project.size();
        for (int i = 0; i < n; i++) {
            Project x = project.get(i);
            if (x.getName().equalsIgnoreCase(name)) {
                return x;
            }
        }
        return null;
    }

    @Override
    public void sortAscendingByInvest() {
        Collections.sort(project, new Comparator<Project>() {
            @Override
            public int compare(Project o1, Project o2) {
                return Double.compare(o1.getInvest(), o2.getInvest());
            }
        });

        int n = project.size();
        for (int i = 0; i < n; i++) {
            Project x = project.get(i);
            System.out.println(x.getName() + "\t" + x.getInvest());
        }

    }

    @Override
    public void sortDescendingByInvest() {
        Collections.sort(project, new Comparator<Project>() {
            @Override
            public int compare(Project o1, Project o2) {
                return Double.compare(-o1.getInvest(), o2.getInvest());
            }
        });

        int n = project.size();
        for (int i = 0; i < n; i++) {
            Project x = project.get(i);
            System.out.println(x.getName() + "\t" + x.getInvest());
        }
    }

}
