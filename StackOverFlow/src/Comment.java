import java.util.Date;

public class Comment {
    private int id;
    private String comment;
    private User user;
    private static int commentId = 0;
    private Date creationdate;
    public Date getCreationdate() {
        return creationdate;
    }

    public User getUser() {
        return user;
    }

    public String getComment() {
        return comment;
    }

    public int getId() {
        return id;
    }



    public Comment(String comment, User user) {
        this.id = commentId++;
        this.comment = comment;
        this.user = user;
        this.creationdate = new Date();
    }
}
