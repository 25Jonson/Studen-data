
interface A{
    
}
interface B extends A{
    
}


public interface IProject {
    
    final int MAX = 10;
    public void list();
    void add(Project p);
    Project search(String name);
    //homework
    void sortAscendingByInvest(); //ascending by invest
    
    void sortDescendingByInvest();  //descending by invest
}
