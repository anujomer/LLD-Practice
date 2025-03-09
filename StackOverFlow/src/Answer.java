import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Answer implements votable,Commentable {
    private final int id;

    public int getId() {
        return id;
    }

    public User getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Question getQuestion() {
        return question;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public boolean isAccepted() { return isAnswered; }

    private final String content;
    private final User author;
    private final Date createDate;
    private final Question question;
    private final List<Vote> votes;
    private final List<Comment> comments;
    private boolean isAnswered;
    private static int idx = 1;

    public Answer(String content, User author, Question question) {
        this.id = idx++;
        this.content = content;
        this.author = author;
        this.createDate = new Date();
        this.question = question;
        this.votes = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.isAnswered = false;
    }


    @Override
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    @Override
    public List<Comment> getComments() {
        return comments;
    }


    @Override
    public void vote(User user, int value) {
        if (value != 1 && value != -1) {
            throw new IllegalArgumentException("Vote value must be either 1 or -1");
        }
        votes.removeIf(v -> v.getUser().equals(user));
        votes.add(new Vote(user, value));

    }

    @Override
    public int getVoteCount() {
        return votes.stream().mapToInt(Vote::getValue).sum();
    }

    public void isAnswered() {
        if(isAnswered){
            throw new IllegalStateException("Answer is already answered");
        }

        isAnswered = true;
    }

}
