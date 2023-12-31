package ir.maktabsharif101.oopjdbc.base.service;

import ir.maktabsharif101.oopjdbc.base.domain.BaseEntity;

import java.sql.SQLException;

public interface BaseEntityService {

    BaseEntity[] findAll() throws SQLException;
    BaseEntity findById(Long id) throws SQLException;
    void deleteById(Long id) throws SQLException;
    long count() throws SQLException;
    BaseEntity sava(BaseEntity entity) throws SQLException;
    BaseEntity update(BaseEntity entity) throws SQLException;
    boolean existsById(Long id) throws SQLException;
}
