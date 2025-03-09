import java.util.ArrayList;
import java.util.List;

public class User {
    private int Id;
    private String name;
    private String mailAddress;
    private int reputation;
    private List<Question> questions;
    private List<Answer> answers;
    private List<Comment> comments;

    private static final int QUESTION_REPUTATION = 5;
    private static final int ANSWER_REPUTATION = 10;
    private static final int COMMENT_REPUTATION = 2;

    public User(int Id, String name, String mailAddress) {
        this.Id = Id;
        this.name = name;
        this.mailAddress = mailAddress;
        this.reputation = 0;
        this.questions = new ArrayList<>();
        this.answers = new ArrayList<>();
        this.comments = new ArrayList<>();

    }

    public synchronized void updateReputation(int value) {
        this.reputation += value;
        if (this.reputation < 0) {
            this.reputation = 0;
        }
    }
}
