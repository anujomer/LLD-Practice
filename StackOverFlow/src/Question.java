import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Question implements Commentable,votable {
    private final int id;
    private final String title;
    private final String description;
    private final User author;

    public Date getCreateDate() {
        return createDate;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public User getAuthor() {
        return author;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public List<Vote> getVoteList() {
        return voteList;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    private final Date createDate;
    private final List<Answer> answerList;
    private final List<Comment> commentList;
    private final List<Vote> voteList;
    private final List<Tag> tagList;
    private static int tagId = 0;
    private static int questionId = 0;
    public Question(String title, String description, User author, List<String> tagList) {
        this.id = questionId++;
        this.title = title;
        this.description = description;
        this.author = author;
        this.createDate = new Date();
        this.answerList = new ArrayList<>();
        this.commentList = new ArrayList<>();
        this.voteList = new ArrayList<>();
        this.tagList = new ArrayList<>();
        for(String tag : tagList) {
            this.tagList.add(new Tag(tagId, tag));
            tagId++;
        }

    }

    @Override
    public void addComment(Comment comment) {
        commentList.add(comment);
    }

    @Override
    public List<Comment> getComments() {
        return commentList;
    }

    @Override
    public void vote(User user, int value) {
        if (value != 1 && value != -1) {
            throw new IllegalArgumentException("Vote value must be either 1 or -1");
        }
        voteList.removeIf(v -> v.getUser().equals(user));
        voteList.add(new Vote(user, value));
    }

    @Override
    public int getVoteCount() {
        return  voteList.stream().mapToInt(Vote::getValue).sum();
    }

    public void addAnwer(Answer answer) {
        if (!answerList.contains(answer)) {
            answerList.add(answer);
        }
    }
}
