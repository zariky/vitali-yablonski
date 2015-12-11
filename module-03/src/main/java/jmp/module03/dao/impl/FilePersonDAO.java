package jmp.module03.dao.impl;

import jmp.module03.beans.Person;
import jmp.module03.dao.PersonDAO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * The DAO of {@link Person} that implements a {@link PersonDAO} to stores a {@link Person} to file
 */
public class FilePersonDAO implements PersonDAO {

    /**
     * The logger
     */
    private static final Logger logger = LoggerFactory.getLogger(FilePersonDAO.class);

    /**
     * The name of file
     */
    private static final String FILE_NAME = "temporary/file.txt";

    /**
     * Constructor of the {@link FilePersonDAO} that initializes file
     */
    public FilePersonDAO() {
        initializeFile();
    }

    /**
     * Save {@link Person} to file
     * @param person a {@link Person} that saves to file
     */
    @Override
    public void save(Person person) {
        Map<String, Person> persons = readFromFile();
        persons.put(person.getName(), person);
        writeToFile(persons);
    }

    /**
     * Find {@link Person} by name in file
     * @param name a attribute of {@link Person}
     * @return a {@link Person} from file by name or a {@code null} if {@link Person} is not exist
     */
    @Override
    public Person findByName(String name) {
        return readFromFile().get(name);
    }

    /**
     * Find all {@link Person} from file
     * @return a {@link List} of {@link Person} (possibly empty)
     */
    @Override
    public List<Person> findAll() {
        return new ArrayList<Person>(readFromFile().values());
    }

    /**
     * Free resources of {@link FilePersonDAO}
     */
    @Override
    public void close() {
    }

    /**
     * Initialize a file
     */
    private void initializeFile() {
        try {
            Path pathToFile = Paths.get(FILE_NAME);
            File file = pathToFile.toFile();

            if( ! file.exists()) {
                Files.createDirectories(pathToFile.getParent());
                file.createNewFile();
            }

            writeToFile(new LinkedHashMap<String, Person>());
        } catch (IOException e) {
            logger.error("File was not initialized.", e);
        }
    }

    /**
     * Write to file
     * @param persons a {@link Map} of {@link Person} that writes to file
     */
    private void writeToFile(Map<String, Person> persons) {
        try ( FileOutputStream fileOS = new FileOutputStream(FILE_NAME);
              ObjectOutputStream objectOS = new ObjectOutputStream(fileOS); ) {
            objectOS.writeObject(persons);
        } catch (IOException e) {
            logger.error("Persons was not written.", e);
        }
    }

    /**
     * Read all {@link Person} from file
     * @return a persons (possibly empty)
     */
    private Map<String, Person> readFromFile() {
        Map<String, Person> persons = new LinkedHashMap<String, Person>();

        try ( FileInputStream fileIS = new FileInputStream(FILE_NAME);
              ObjectInputStream objectIS = new ObjectInputStream(fileIS); ) {
            persons = (Map<String, Person>) objectIS.readObject();
        } catch (IOException e) {
            logger.error("Persons cannot be read.", e);
        } catch (ClassNotFoundException e) {
            logger.error("Result is not valid.", e);
        }

        return persons;
    }

}