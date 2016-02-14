package jmp.module10.beans;

import java.util.Date;

/**
 * The bean that contains all information about a post
 */
public class Post {

    private Long id;

    private User user;

    private String text;

    private Date timestamp;

    public Post() {
    }

    public Post(User user, String text, Date timestamp) {
        this.user = user;
        this.text = text;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Post {id=" + id +", user=" + user + ", text=" + text + ", timestamp=" + timestamp + "}";
    }

}