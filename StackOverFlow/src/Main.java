import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StackOverFlow st = new StackOverFlow();
        User anuj = st.createUser("anomer","omer@gmail.com");
        User ravi = st.createUser("ravi","ravi@gmail.com");
        User kenil = st.createUser("kenil","kenil@gmail.com");

        Question anujques = st.askQuestion(anuj, "Java","is java object oriented?", Arrays.asList("Java","OOPS"));

        Answer ravians = st.answerQuestion(ravi, anujques, "yes it is");

        st.addComment(kenil,"good one", anujques);

        st.addComment(anuj,"good two", ravians);

        st.voteQuestion(kenil, anujques, 1);
        st.voteAnswer(kenil, ravians, 1);

        st.acceptAnswer(ravians);


        // Bob asks another question
        Question pythonQuestion = st.askQuestion(ravi, "How to use list comprehensions in Python?",
                "I'm new to Python and I've heard about list comprehensions. Can someone explain how to use them?",
                Arrays.asList("python", "list-comprehension"));

        // Alice answers Bob's question
        Answer kenilAnswer = st.answerQuestion(kenil, pythonQuestion,
                "List comprehensions in Python provide a concise way to create lists...");

        // Charlie votes on Bob's question and Alice's answer
        st.voteQuestion(anuj, pythonQuestion, 1);  // Upvote
        st.voteAnswer(anuj, kenilAnswer, 1);  // Upvote

        // Print out the current state
        System.out.println("Question: " + anujques.getTitle());
        System.out.println("Asked by: " + anujques.getAuthor().getUsername());
        System.out.println("Tags: " + anujques.getTagList().stream().map(Tag::getTagName).reduce((a, b) -> a + ", " + b).orElse(""));
        System.out.println("Votes: " + anujques.getVoteCount());
        System.out.println("Comments: " + anujques.getComments().size());
        System.out.println("\nAnswer by " + ravians.getAuthor().getUsername() + ":");
        System.out.println(ravians.getContent());
        System.out.println("Votes: " + ravians.getVoteCount());
        System.out.println("Accepted: " + ravians.isAccepted());
        System.out.println("Comments: " + ravians.getComments().size());

//        System.out.println("\nUser Reputations:");
//        System.out.println("Alice: " + alice.getReputation());
//        System.out.println("Bob: " + bob.getReputation());
//        System.out.println("Charlie: " + charlie.getReputation());

        // Demonstrate search functionality
        System.out.println("\nSearch Results for 'java':");
        List<Question> searchResults = st.searchQuestions("java");
        for (Question q : searchResults) {
            System.out.println(q.getTitle());
        }

        System.out.println("\nSearch Results for 'python':");
        searchResults = st.searchQuestions("python");
        for (Question q : searchResults) {
            System.out.println(q.getTitle());
        }

        // Demonstrate getting questions by user
        System.out.println("\nBob's Questions:");
        List<Question> bobQuestions = st.getQuestionByUser(anuj);
        for (Question q : bobQuestions) {
            System.out.println(q.getTitle());
        }



    }
}