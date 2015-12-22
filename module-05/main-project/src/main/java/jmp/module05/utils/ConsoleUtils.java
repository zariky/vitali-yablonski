package jmp.module05.utils;

import org.apache.log4j.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 *  The Utility methods that helps to works with console
 */
public final class ConsoleUtils {

    /**
     * The logger
     */
    private static final Logger logger = Logger.getLogger(ConsoleUtils.class);

    /**
     * The {@link ConsoleUtils} instances should NOT be constructed because it is utility class
     */
    private ConsoleUtils() {
    }

    /**
     * Gives opportunity to select a option from list of option by console
     * @param options a list of option
     * @return a selected option
     */
    public static String chooseOption(List<String> options) {
        Integer optionId = null;
        boolean choice = false;

        logger.info("Choose a id of option from list:");
        printOptions(options);

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
            while ( !choice) {
                logger.info(">");
                String option = br.readLine();
                optionId = convertStringToInteger(option) - 1;
                choice = 0 <= optionId && optionId < options.size();
            }
        } catch (IOException e) {
            logger.error(e);
        }

        return options.get(optionId);
    }

    /**
     * Print list of option
     * @param options a list of option
     */
    private static void printOptions(List<String> options) {
        for(int id = 0; id < options.size(); id++) {
            logger.info((id + 1) + " - " + options.get(id));
        }
    }

    /**
     * Convert a {@link String} to a {@link Integer}
     * @param str a string that converts to {@link Integer}
     * @return the integer represented by the string or Integer.MIN_VALUE if a string is not valid
     */
    private static Integer convertStringToInteger(String str) {
        Integer result = Integer.MIN_VALUE;
        try {
            result = Integer.parseInt(str, 10);
        } catch (NumberFormatException e) {
            logger.error("String('" + str + "') cannot be converted to integer");
        }
        return result;
    }

}