import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String username;
    private String email;
    private int reputation;
    private static int idx = 1;
    private List<Question> questions;
    private List<Answer> answers;
    private List<Comment> comments;
    private List<Vote> votes;

    public User(String username, String email) {
        this.id = idx++;
        this.username = username;
        this.email = email;
        this.reputation = 0;
        this.questions = new ArrayList<>();
        this.answers = new ArrayList<>();
        this.votes = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    public Question askQuestion(String title, String content, List<String> tags) {

        Question  q = new Question(title, content, this, tags);
        this.questions.add(q);
        return q;
    }

    public Answer answerQuestion(String content, Question q) {
        Answer ans = new Answer(content, this, q);
        this.answers.add(ans);
        return ans;
    }

    public Comment addComment(String content, Commentable commentable) {

        Comment cmt = new Comment(content, this);
        comments.add(cmt);
        commentable.addComment(cmt);
        return cmt;
    }


    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public int getReputation() {
        return reputation;
    }

    public int getId() {
        return id;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public List<Vote> getVotes() {
        return votes;
    }
}
