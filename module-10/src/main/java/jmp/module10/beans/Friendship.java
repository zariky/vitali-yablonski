package jmp.module10.beans;

import java.util.Date;

/**
 * The bean that contains all information about a friendship
 */
public class Friendship {

    private Long id;

    private User user1;

    private User user2;

    private Date timestamp;

    public Friendship() {
    }

    public Friendship(User user1, User user2, Date timestamp) {
        this.user1 = user1;
        this.user2 = user2;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Friendship {id=" + id + ", user1=" + user1 + ", user2=" + user2 + ", timestamp=" + timestamp + "}";
    }

}