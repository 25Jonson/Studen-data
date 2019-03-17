
public class Main {

    public static void main(String[] args) {
        IProject ip = new MyProject();

        //add some projects
        ip.add(new Project("fap", 5000));
        ip.add(new Project("cms", 7000));
        ip.add(new Project("Airbus", 20000));
        ip.add(new Project("uniap", 3000));
        
        //output project
        ip.list();
        //
        String name = "cmsm";
        Project p = ip.search(name);
        if(p == null) System.out.println("Given project does not exists");
        else{
            System.out.println(p.getName() + "\t" + p.getInvest());
        }
        System.out.println("\nSort ascending by invest :");
        ip.sortAscendingByInvest();
        System.out.println("\nSort descending by invest :");
        ip.sortDescendingByInvest();
    }
}
