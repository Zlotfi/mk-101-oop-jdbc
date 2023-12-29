package ir.maktabsharif101.oopjdbc.repository.impl;

import ir.maktabsharif101.oopjdbc.base.repository.impl.BaseEntityRepositoryImpl;
import ir.maktabsharif101.oopjdbc.domain.User;
import ir.maktabsharif101.oopjdbc.repository.UserRepository;

import java.sql.Connection;

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
