import java.util.Date;

public class Comment {

    private int Id;
    private String content;
    private User user;
    private Date creationDate;

    public Comment(int id, String content, User user, Date creationDate) {
        Id = generateId();
        this.content = content;
        this.user = user;
        this.creationDate = new Date();
    }

    private int generateId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    public int getId() {
        return Id;
    }

    public String getContent() {
        return content;
    }
    public User getUser() {
        return user;
    }
    public Date getCreationDate() {
        return creationDate;
    }
}
