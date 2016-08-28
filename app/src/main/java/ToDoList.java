
public class ToDoList {
    private int id;
    private String lists;
    private String tasks;
    public ToDoList() {
    }
    public ToDoList(int id, String lists, String tasks){
        this.id=id;
        this.lists=lists;
        this.tasks=tasks;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setLists(String lists){
        this.lists = lists;
    }
    public void setTasks(String tasks){
        this.tasks = tasks;
    }

    public int getId() {
        return id;
    }

    public String getLists() {
        return lists;
    }

    public String getTasks() {
        return tasks;
    }
}
