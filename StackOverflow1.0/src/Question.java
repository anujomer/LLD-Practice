import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Question implements Votable,Commentable {
    private int id;
    private String title;
    private String content;
    private User author;
    private Date creation_date;
    private List<Answer> answers;
    private List<Comment> comments;
    private List<Tag> tags;
    private List<Vote> votes;

    public Question(String title, String content, User author, List<String> tagNames) {
        this.id = generateId();
        this.title = title;
        this.content = content;
        this.author = author;
        this.creation_date = new Date();
        this.answers = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.votes = new ArrayList<>();
        for (String tagName : tagNames) {
            this.tags.add(new Tag(tagName));
        }

    }

    public void addAnswer(Answer answer) {
        if (!answers.contains(answer)) {
            answers.add(answer);
        }
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
        author.updateReputation(value * 5);
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
}
