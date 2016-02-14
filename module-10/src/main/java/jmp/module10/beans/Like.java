package jmp.module10.beans;

import java.util.Date;

/**
 * The bean that contains all information about a like
 */
public class Like {

    private Long id;

    private Post post;

    private User user;

    private Date timestamp;

    public Like() {
    }

    public Like(Post post, User user, Date timestamp) {
        this.post = post;
        this.user = user;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Like {id=" + id + ", post=" + post + ", user=" + user + ", timestamp=" + timestamp + "}";
    }

}