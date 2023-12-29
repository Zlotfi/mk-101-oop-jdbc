package ir.maktabsharif101.oopjdbc.base.repository.impl;

import ir.maktabsharif101.oopjdbc.base.domain.BaseEntity;
import ir.maktabsharif101.oopjdbc.base.repository.BaseEntityRepository;

import java.sql.Connection;

public abstract class BaseEntityRepositoryImpl
        implements BaseEntityRepository {

    protected final Connection connection;

    protected BaseEntityRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public BaseEntity[] findAll() {
        return new BaseEntity[0];
    }

    @Override
    public BaseEntity findById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        System.out.println("delete by id: " + id);
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public BaseEntity sava(BaseEntity entity) {
        return null;
    }

    @Override
    public BaseEntity update(BaseEntity entity) {
        return null;
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }
}
