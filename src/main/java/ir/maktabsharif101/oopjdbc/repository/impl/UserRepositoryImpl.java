package ir.maktabsharif101.oopjdbc.repository.impl;

import ir.maktabsharif101.oopjdbc.base.domain.BaseEntity;
import ir.maktabsharif101.oopjdbc.base.repository.impl.BaseEntityRepositoryImpl;
import ir.maktabsharif101.oopjdbc.domain.Permission;
import ir.maktabsharif101.oopjdbc.domain.User;
import ir.maktabsharif101.oopjdbc.repository.UserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@SuppressWarnings("unused")
public class UserRepositoryImpl extends BaseEntityRepositoryImpl implements UserRepository {
    public UserRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String getEntityTableName() {
        return User.TABLE_NAME;
    }

    @Override
    protected BaseEntity mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(
                resultSet.getLong(1)
        );
        user.setFirstName(
                resultSet.getString(2)
        );
        user.setLastName(
                resultSet.getString(3)
        );
        user.setUserName(
                resultSet.getString(4)
        );
        user.setPassword(
                resultSet.getString(5)
        );
//        TODO fill roles
        return user;
    }

    @Override
    protected BaseEntity[] getBaseEntityArrayForFindAll() throws SQLException {
        return new User[(int) count()];
    }

    @Override
    protected String getInsertColumnsForFirstApproach() {
        return User.FIRST_NAME.concat(", ").concat(User.LAST_NAME).concat(", ").concat(User.USER_NAME)
                .concat(", ").concat(User.PASSWORD).concat(", ").concat(User.MOBILE_NUMBER).concat(", ").concat(User.AGE);
//        return User.FIRST_NAME + ", " + User.LAST_NAME + ", " + User.USER_NAME + ", " + User.PASSWORD + ", " +
//                User.MOBILE_NUMBER + ", " + User.AGE;
    }

    @Override
    protected String getInsertValuesForFirstApproach(BaseEntity entity) {
        User user = (User) entity;
        return "'".concat(user.getFirstName()).concat("', ").
                concat("'").concat(user.getLastName()).concat("', ").
                concat("'").concat(user.getUserName()).concat("', ").
                concat("'").concat(user.getPassword()).concat("', ").
                concat("'").concat(user.getMobileNumber()).concat("', ").
                concat("'") + user.getAge() + "'"
                ;
    }

    @Override
    protected String[] getInsertColumnsForSecondApproach() {
        return new String[]{
                User.FIRST_NAME,
                User.LAST_NAME,
                User.USER_NAME,
                User.PASSWORD,
                User.MOBILE_NUMBER,
                User.AGE
        };
    }

    @Override
    protected void fillPreparedStatementParamsForSave(PreparedStatement preparedStatement,
                                                      BaseEntity entity) throws SQLException {
        //        insert into user3(firstName, lastName, userName, password, mobileNumber, age) values(?,?,?,?,?,?)
        User user = (User) entity;
        preparedStatement.setString(
                1,
                user.getFirstName()
        );

        preparedStatement.setString(
                2,
                user.getLastName()
        );

        preparedStatement.setString(
                3,
                user.getUserName()
        );

        preparedStatement.setString(
                4,
                user.getPassword()
        );

        preparedStatement.setString(
                5,
                user.getMobileNumber()
        );

        preparedStatement.setInt(
                6,
                user.getAge()
        );
    }

    @Override
    public User findByUserName(String userName) {
        return null;
    }

    @Override
    public boolean existsByUserName(String userName) {
        return false;
    }

    @Override
    public boolean existsByMobileNumber(String mobileNumber) {
        return false;
    }
}
