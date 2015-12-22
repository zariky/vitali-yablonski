package jmp.module05.beans;

/**
 * The bean that contains all information about a user
 */
public class User {

    /**
     * The info
     */
    private String info;

    public User() {
    }

    public User(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "User { info = '" + info + "' }";
    }

}