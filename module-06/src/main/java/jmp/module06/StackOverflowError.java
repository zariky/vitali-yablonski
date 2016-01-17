package jmp.module06;

/**
 * The Main class that simulates java.lang.StackOverflowError (Do not use recursive methods).
 */
public class StackOverflowError {

    /*
     * The bean that contains information about a mentor
     */
    private static class Mentor {

        private Mentee mentee;

        public Mentor() {
            this.mentee = new Mentee();
        }

    }

    /*
     * The bean that contains information about a mentee
     */
    private static class Mentee {

        private Mentor mentor;

        public Mentee() {
            this.mentor = new Mentor();
        }

    }

    /**
     * The Main method
     * @param args a array of programm arguments
     */
    public static void main(String[] args) {
        new Mentor();
    }

}