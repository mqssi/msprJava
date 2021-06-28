
public class Object {

    private String name;
    private boolean hasObject;

    public Object(String name, boolean hasObject) {
        this.name = name;
        this.hasObject = hasObject;
    }

    public String getName() {
        return name;
    }

    public boolean isHasObject() {
        return hasObject;
    }

    public void setHasObject(boolean hasObject) {
        this.hasObject = hasObject;
    }

}