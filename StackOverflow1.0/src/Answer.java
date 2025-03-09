import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Answer implements Votable,Commentable {
    private int Id;
    private String content;
    private Question question;
    private User author;
    private Date creationDate;
    private boolean isAccepted;
    private List<Comment> comments;
    private List<Vote> votes;


    public Answer(User author, Question question, String content) {
        this.Id = generateId();
        this.author = author;
        this.question = question;
        this.content = content;
        this.creationDate = new Date();
        this.isAccepted = false;
        this.comments = new ArrayList<>();
        this.votes = new ArrayList<>();

    }

    private int generateId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }



    @Override
    public void vote(User user, int value) {
        if (value != 1 && value != -1) {
            throw new IllegalArgumentException("Vote value must be either 1 or -1");
        }
        votes.removeIf(v -> v.getUser().equals(user));
        votes.add(new Vote(user, value));
        author.updateReputation(value * 10);
    }

    @Override
    public int getVoteCount() {
        return votes.stream().mapToInt(Vote::getValue).sum();
    }

    @Override
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    @Override
    public List<Comment> getcomments() {
        return new ArrayList<>(comments);
    }

    public void markAsAccepted() {
        if (isAccepted) {
            throw new IllegalStateException("This answer is already accepted");
        }
        isAccepted = true;
        author.updateReputation(15);  // +15 reputation for accepted answer
    }
}
