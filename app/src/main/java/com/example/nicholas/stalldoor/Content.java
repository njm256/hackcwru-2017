package com.example.nicholas.stalldoor;

public class Content {
    private String body;
    private int upvotes;
    private int downvotes;

    public Content(String str) {
        body = str;
        upvotes = 0;
        downvotes = 0;
    }
    public Content(String str, int ups, int downs) {
        body = str;
        upvotes = ups;
        downvotes = downs;
    }

    public String getBody() {
        return body;
    }

    public int getUpvotes() {
        return upvotes;
    }
    public void setUpvotes(int votes) {
        upvotes = votes;
    }
    public void setDownvotes(int votes) {
        downvotes = votes;
    }
    public int getDownvotes() {
        return downvotes;
    }
    public void upvote() {
        upvotes++;
    }
    public void downvote() {
        downvotes++;
    }
    public int getScore() {
        return upvotes - downvotes;
    }
}
