public class Tag {

    private int Id;
    private String Name;

    public Tag(String name) {
        Id = generateId();
        Name = name;
    }

    private int generateId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    public int getId() {
        return Id;
    }
    public String getName() {
        return Name;
    }
}
