import java.util.HashMap;

public class Agent {

    private String name;
    private HashMap<Integer, Object> listObject;

    public Agent(String name, HashMap<Integer, Object> listObject) {
        this.name = name;
        this.listObject = listObject;
    }

    public HashMap<Integer, Object> getListObject() {
        return listObject;
    }

    public void setListObject(HashMap<Integer, Object> listObject) {
        this.listObject = listObject;
    }

    public String getName() {
        return name;
    }



}