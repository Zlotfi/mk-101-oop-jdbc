package ir.maktabsharif101.oopjdbc.repository.impl;

import ir.maktabsharif101.oopjdbc.base.domain.BaseEntity;
import ir.maktabsharif101.oopjdbc.base.repository.impl.BaseEntityRepositoryImpl;
import ir.maktabsharif101.oopjdbc.domain.City;
import ir.maktabsharif101.oopjdbc.repository.CityRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CityRepositoryImpl extends BaseEntityRepositoryImpl
        implements CityRepository {
    public CityRepositoryImpl(Connection connection) {
        super(connection);
        String createTableQuery = "CREATE TABLE IF NOT EXISTS city (" +
                "    id SERIAL PRIMARY KEY ," +
                "    name VARCHAR(50) NOT NULL" +
                ");";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(createTableQuery);
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement(
                    "ALTER TABLE IF EXISTS public.city OWNER to postgres"
            );
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected String[] getInsertColumnsForSecondApproach() {
        return new String[]{
                City.NAME
        };
    }

    @Override
    protected String getEntityTableName() {
        return City.TABLE_NAME;
    }

    @Override
    protected BaseEntity mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return new City(
                resultSet.getLong(1),
                resultSet.getString(2)
        );
    }

    @Override
    protected BaseEntity[] getBaseEntityArrayForFindAll() throws SQLException {
        return new City[(int) count()];
    }

    @Override
    protected String getInsertColumnsForFirstApproach() {
        return City.NAME;
    }

    @Override
    protected String getInsertValuesForFirstApproach(BaseEntity entity) {
        return ((City) entity).getName();
    }

    @Override
    protected void fillPreparedStatementParamsForSave(PreparedStatement preparedStatement,
                                                      BaseEntity entity) throws SQLException {
        preparedStatement.setString(
                1, ((City) entity).getName()
        );
    }

    @Override
    protected void fillPreparedStatementParamsForUpdate(PreparedStatement preparedStatement, BaseEntity entity)
            throws SQLException {
        preparedStatement.setString(
                1, ((City) entity).getName()
        );

        preparedStatement.setLong(
                2, entity.getId()
        );
    }
}
