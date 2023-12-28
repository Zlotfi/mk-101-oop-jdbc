package ir.maktabsharif101.oopjdbc.repository;

import ir.maktabsharif101.oopjdbc.base.repository.BaseEntityRepository;
import ir.maktabsharif101.oopjdbc.domain.User;

public interface UserRepository extends BaseEntityRepository {

    User findByUserName(String userName);
    boolean existsByUserName(String userName);
    boolean existsByMobileNumber(String mobileNumber);
}
