package jmp.module10.dao.jdbc.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The mapper
 */
public interface Mapper<Type> {

    /**
     * Convert {@link ResultSet} to bean
     * @param rs a {@link ResultSet}
     * @return a bean
     * @throws SQLException
     */
    public Type create(ResultSet rs) throws SQLException;

}