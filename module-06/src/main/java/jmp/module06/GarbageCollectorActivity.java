package jmp.module06;

import java.util.ArrayList;
import java.util.List;

/**
 * The Main class that simulates frequent peaks in GC activity.
 */
public class GarbageCollectorActivity {

    /*
     * The bean that contains information about a mentor
     */
    private static class Mentor {

        private List<String> mentees;

        public Mentor() {
            this.mentees = new ArrayList<String>();
            for (int index = 0; index < 1000; index++) {
                mentees.add("Mentee" + index);
            }
        }

    }

    /**
     * The Main method
     * @param args a array of programm arguments
     */
    public static void main(String[] args) {
        List<Object> list = new ArrayList<Object>();

        while (true) {
            list.add(new Mentor());
        }
    }

}