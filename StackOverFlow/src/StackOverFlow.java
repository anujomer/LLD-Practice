import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class StackOverFlow {
    private final Map<Integer,User> userMap;
    private final Map<Integer,Question> questions;
    private final Map<Integer,Answer> answers;
    private final Map<Integer,Tag> tags;


    public StackOverFlow() {
        this.userMap = new ConcurrentHashMap<>();
        this.questions = new ConcurrentHashMap<>();
        this.answers = new ConcurrentHashMap<>();
        this.tags = new ConcurrentHashMap<>();
    }

    public User createUser(String userName, String email){
        User usr = new User(userName,email);
        userMap.putIfAbsent(userMap.size()+1,usr);
        return usr;
    }

    public Question askQuestion(User usr,String title, String question, List<String> tagList){
        Question q = usr.askQuestion(title,question,tagList);
        questions.putIfAbsent(questions.size()+1,q);
        for(Tag tag: q.getTagList()){
            tags.putIfAbsent(tag.getId(),tag);
        }
        return q;
    }

    public Answer answerQuestion(User usr, Question question, String answer){
        Answer ans = usr.answerQuestion(answer,question);
        answers.putIfAbsent(ans.getId(),ans);
        return ans;
    }

    public Comment addComment(User usr, String comment, Commentable commentable){
        Comment cmt = usr.addComment(comment,commentable);
        return cmt;
    }

    public void voteQuestion(User usr, Question question, int vote){
        question.vote(usr, vote);

    }

    public void voteAnswer(User usr, Answer answer, int vote){
        answer.vote(usr, vote);
    }

    public void acceptAnswer(Answer answer){
        answer.isAnswered();
    }

    public List<Question> getQuestionByUser(User usr){
        return usr.getQuestions();
    }

    public List<Question> searchQuestions(String query) {
        return questions.values().stream()
                .filter(q -> q.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                        q.getDescription().toLowerCase().contains(query.toLowerCase()) ||
                        q.getTagList().stream().anyMatch(t -> t.getTagName().equalsIgnoreCase(query)))
                .collect(Collectors.toList());
    }



}
