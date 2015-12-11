package jmp.module03;

import static jmp.module03.utils.Constants.*;
import jmp.module03.beans.Person;
import jmp.module03.factories.PersonServiceFactory;
import jmp.module03.factories.impl.DatabasePersonServiceFactory;
import jmp.module03.factories.impl.FilePersonServiceFactory;
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
        final String John = "John";
        final String Patrick = "Patrick";
        final String Vasya = "Vasya";

        final String appMode = VmArgumentsUtils.findArgumentByKey(SOURCE_MODE, vmArguments);

        PersonServiceFactory personServiceFactory = null;
        PersonService personService = null;

        if (FILE_MODE.equals(appMode)) {
            System.out.println("App was started in File mode.");
            personServiceFactory = new FilePersonServiceFactory();
        } else if (DATABASE_MODE.equals(appMode)) {
            System.out.println("App was started in Database mode.");
            personServiceFactory = new DatabasePersonServiceFactory();
        } else {
            System.out.println("Type of Source mode is absent.");
        }

        if (personServiceFactory != null) {
            try {
                personService = personServiceFactory.create();

                System.out.println("All persons: " + personService.findAll());

                personService.save(new Person(John));
                personService.save(new Person(Patrick));
                personService.save(new Person(Vasya));

                System.out.println("All persons: " + personService.findAll());
                System.out.println("Find person by name '" + Patrick + "': " +personService.findByName(Patrick));
            } finally {
                if (personService != null) {
                    personService.close();
                }
            }
        }
    }

}