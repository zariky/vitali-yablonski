package jmp.module03;

import static jmp.module03.utils.Constants.*;
import jmp.module03.factories.PersonFactory;
import jmp.module03.factories.PersonServiceFactory;
import jmp.module03.services.PersonService;
import jmp.module03.utils.VmArgumentsUtils;

/**
 * The main class
 */
public class Main {

    /**
     * The main method
     * @param vmArguments a array of programm arguments
     */
    public static void main(String[] vmArguments) {
        final String appMode = VmArgumentsUtils.findArgumentByKey(SOURCE_MODE, vmArguments);
        PersonService personService = PersonServiceFactory.create(appMode);

        if (FILE_MODE.equals(appMode)) {
            System.out.println("App was started in File mode.");
        } else if (DATABASE_MODE.equals(appMode)) {
            System.out.println("App was started in Database mode.");
        } else {
            System.out.println("Type of Source mode is absent.");
        }

        if (personService != null) {
            try {
                System.out.println("All persons: " + personService.findAll());

                personService.save(PersonFactory.create());
                personService.save(PersonFactory.create());
                personService.save(PersonFactory.create());

                System.out.println("All persons: " + personService.findAll());
                System.out.println("Find person by name 'Patrick': " +personService.findByName("Patrick"));
            } finally {
                personService.close();
            }
        }
    }

}