package jmp.module10.dao.jdbc.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import jmp.module10.dao.jdbc.mappers.Mapper;

/**
 * The jdbc helper
 */
public abstract class JdbcHelper {

    private static final Logger logger = LoggerFactory.getLogger(JdbcHelper.class);

    private static final int GENERATED_KEY = 1;

    protected <Type> List<Type> find(String query, Mapper<Type> mapper) {
        return find(query, null, mapper);
    }

    protected <Type> List<Type> find(String query, Object[] parameters, Mapper<Type> mapper){
        List<Type> list = new ArrayList<Type>();

        try (Connection connection = DataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);) {

            if (parameters != null) {
                setParameters(preparedStatement, parameters);
            }

            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                list.add(mapper.create(result));
            }
        } catch (SQLException ex) {
            logger.error("SELECT : ", ex.getMessage());
        }

        return list;    
    }

    protected Long save(String query, Object[] parameters){
        long id = -1;

        try (Connection connection = DataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);) {

            setParameters(preparedStatement, parameters);
            
            preparedStatement.executeUpdate();
            ResultSet result = preparedStatement.getGeneratedKeys();
            
            if (result.next()) {
                id = result.getLong(GENERATED_KEY);
            }
        } catch (SQLException ex) {
            logger.error("SAVE : ", ex.getMessage());
        }

        return id;
    }

    protected void execute(String query){
        try (Connection connection = DataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            logger.error("execute : ", ex.getMessage());
        }
    }

    private void setParameters(PreparedStatement preparedStatement, Object[] parameters) throws SQLException {
        for (int index = 0; index < parameters.length; index++) {
            if (parameters[index] != null) {
                setRequireParameter(preparedStatement, index + 1, parameters[index]);
            } else {
                setOptionalParameter(preparedStatement, index + 1, parameters[index]);
            } 
        }
    }

    private void setRequireParameter(PreparedStatement preparedStatement, int index, Object parameter) throws SQLException {
        Class classParameter = parameter.getClass();
        
        if (classParameter.equals(String.class)) {
            preparedStatement.setString(index, String.valueOf(parameter));
        } else if (classParameter.equals(Long.class)) {
            preparedStatement.setLong(index, (Long)parameter);
        } else if (classParameter.equals(Timestamp.class)) {
            preparedStatement.setTimestamp(index, (Timestamp)parameter);
        }       
    }

    private void setOptionalParameter(PreparedStatement preparedStatement, int index, Object parameter) throws SQLException {
        preparedStatement.setNull(index, java.sql.Types.INTEGER);
    }

}