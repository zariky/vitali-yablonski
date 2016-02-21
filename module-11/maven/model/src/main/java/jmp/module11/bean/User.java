package jmp.module11.bean;

import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * The bean that contains all information about a user
 */
public class User {

    private String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 31).append(name).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        boolean isEquals = false;

        if (obj instanceof User) {
            if (obj == this) {
                isEquals = true;
            } else {
                User user =  (User) obj;
                isEquals = user.getName() != null && user.getName().equals(this.getName());
            }
        }

        return isEquals;
    }

    @Override
    public String toString() {
        return "User {name=" + name + "}";
    }

}