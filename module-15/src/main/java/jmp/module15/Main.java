package jmp.module15;

import jmp.module15.services.SportGameService;

/**
 * The main class
 */
public class Main {

    /**
     * The main method
     * @param vmArguments a array of programm arguments
     */
    public static void main(String[] vmArguments) {
        SportGameService sportGameService = new SportGameService();

        System.out.println("Weathers:");
        println(sportGameService.weathers());

        System.out.println("FIFA teams:");
        println(sportGameService.teams());

        final String TEAM = "Uruguay";
        System.out.println("Players(" + TEAM + "):");
        println(sportGameService.players(TEAM));
    }

    private static void println(String[] array) {
        for (String entity : array) {
            System.out.println(entity);
        }
    }

}