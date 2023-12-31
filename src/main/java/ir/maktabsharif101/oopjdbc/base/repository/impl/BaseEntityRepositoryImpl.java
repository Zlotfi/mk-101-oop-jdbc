package ir.maktabsharif101.oopjdbc.base.repository.impl;

import ir.maktabsharif101.oopjdbc.base.domain.BaseEntity;
import ir.maktabsharif101.oopjdbc.base.repository.BaseEntityRepository;

import java.sql.*;

@SuppressWarnings("unused")
public abstract class BaseEntityRepositoryImpl
        implements BaseEntityRepository {

    protected final Connection connection;
    public static final String FIND_BY_ID_QUERY_TEMPLATE = "SELECT * FROM %s WHERE id = ?";
    public static final String FIND_ALL_QUERY_TEMPLATE = "SELECT * FROM %s";
//    public static final String EXISTS_BY_ID_QUERY_TEMPLATE = "SELECT COUNT(id) FROM %s WHERE id = ?";
    public static final String INSERT_QUERY_TEMPLATE = "INSERT INTO %s(%s) VALUES(%s)";
    public static final String UPDATE_QUERY_TEMPLATE = "UPDATE %s SET %s WHERE id = ?";
    public static final String DELETE_BY_ID_QUERY_TEMPLATE = "DELETE FROM %s WHERE id = ?";
    protected BaseEntityRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public BaseEntity[] findAll() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                String.format(
                        FIND_ALL_QUERY_TEMPLATE,
                        getEntityTableName()
                )
        );
        ResultSet resultSet = preparedStatement.executeQuery();
        BaseEntity[] entities = getBaseEntityArrayForFindAll();
//        BaseEntity[] entities = new BaseEntity[(int) count()];
        int index = 0;
        while (resultSet.next()){
            entities[index] = mapResultSetToEntity(resultSet);
            index++;
        }
        return entities;
    }

    @Override
    public BaseEntity findById(Long id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                String.format(
                        FIND_BY_ID_QUERY_TEMPLATE,
                        getEntityTableName()
                )
        );
        preparedStatement.setLong(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            return mapResultSetToEntity(resultSet);
        }
        return null;
    }
    @Override
    public void deleteById(Long id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                String.format(
                        DELETE_BY_ID_QUERY_TEMPLATE,
                        getEntityTableName()
                )
        );
        preparedStatement.setLong(1, id);
        preparedStatement.executeUpdate();
    }

    @Override
    public long count() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT COUNT(*) FROM " + getEntityTableName()
        );

        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getLong(1);
    }

    @Override
    public BaseEntity sava(BaseEntity entity) throws SQLException {
//        return saveFirstApproach(entity);
        return saveSecondApproach(entity);
    }

    @Override
    public BaseEntity update(BaseEntity entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                generateUpdateQuery()
        );
        fillPreparedStatementParamsForUpdate(preparedStatement, entity);
        preparedStatement.executeUpdate();
        return entity;
    }

    @Override
    public boolean existsById(Long id) throws SQLException {
//        return existsByIdWithCount(id);
        return existsByIdWithIdSelection(id);
    }

    protected boolean existsByIdWithCount(Long id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT COUNT(*) FROM " + getEntityTableName() + " WHERE id = ?"
        );
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getLong(1) > 0;
    }

    protected boolean existsByIdWithIdSelection(Long id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT id FROM " + getEntityTableName() + " WHERE id = ?"
        );
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }

    protected BaseEntity saveFirstApproach(BaseEntity entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                String.format(
                        INSERT_QUERY_TEMPLATE,
                        getEntityTableName(),
                        getInsertColumnsForFirstApproach(),
                        getInsertValuesForFirstApproach(entity)
                ),
                Statement.RETURN_GENERATED_KEYS
        );
        return setGenerateKeyAndReturnEntity(entity, preparedStatement);
    }

    protected BaseEntity saveSecondApproach(BaseEntity entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                generateSaveSecondApproachQuery(),
                Statement.RETURN_GENERATED_KEYS
        );
        fillPreparedStatementParamsForSave(preparedStatement, entity);

        return setGenerateKeyAndReturnEntity(entity, preparedStatement);
    }

    private static BaseEntity setGenerateKeyAndReturnEntity(BaseEntity entity, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.executeUpdate();
        ResultSet generatedKeysResultSet = preparedStatement.getGeneratedKeys();
        generatedKeysResultSet.next();
        entity.setId(
                generatedKeysResultSet.getLong(1)
        );
        return entity;
    }

    protected String generateSaveSecondApproachQuery() {
        String[] insertColumns = getInsertColumnsForSecondApproach();

        return String.format(
                INSERT_QUERY_TEMPLATE,
                getEntityTableName(),
                String.join(",", insertColumns),
                generateQuestionMarkForInsertQuery(insertColumns.length)
        );
    }

    private String generateQuestionMarkForInsertQuery(int length) {
        String questionMarks = "";
        for (int i = 0; i < length; i++) {
            if (i == length - 1){
                questionMarks = questionMarks.concat("?");
            } else {
                questionMarks = questionMarks.concat("?, ");
            }
//            questionMarks = questionMarks.concat("?,");
        }
        return questionMarks;
//        ?,?,?,?,
//        return questionMarks.substring(0, questionMarks.length() - 1);
    }

    protected String generateUpdateQuery() {
        String[] updateColumns = getInsertColumnsForSecondApproach();
//        firstName = ?,
//        lastName = ?,
        String setClause = "";
        for (String updateColumn : updateColumns) {
            setClause = setClause.concat(updateColumn).concat(" = ?,");
        }
//        firstName = ?, lastName = ?,
        setClause = setClause.substring(0, setClause.length() - 1);
//        firstName = ?, lastName = ?
        return String.format(
                UPDATE_QUERY_TEMPLATE,
                getEntityTableName(),
                setClause
        );
    }

    protected abstract String[] getInsertColumnsForSecondApproach();

    protected abstract String getEntityTableName();

    protected abstract BaseEntity mapResultSetToEntity(ResultSet resultSet) throws SQLException;

    protected abstract BaseEntity[] getBaseEntityArrayForFindAll() throws SQLException;

    protected abstract String getInsertColumnsForFirstApproach();

    protected abstract  String getInsertValuesForFirstApproach(BaseEntity entity);

    protected abstract void fillPreparedStatementParamsForSave(PreparedStatement preparedStatement,
                                                               BaseEntity entity) throws SQLException;

    protected abstract void fillPreparedStatementParamsForUpdate(PreparedStatement preparedStatement,
                                                                 BaseEntity entity) throws SQLException;
}
