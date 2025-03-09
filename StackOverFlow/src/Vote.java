public class Vote {
    private User user;
    private int vote;
    public Vote(User user, int vote) {
        this.user = user;
        this.vote = 0;
    }

    public User getUser() {
        return user;
    }

    public int getValue() {
        return vote;
    }


}
