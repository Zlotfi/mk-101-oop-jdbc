package ir.maktabsharif101.oopjdbc.service;

import ir.maktabsharif101.oopjdbc.base.service.BaseEntityService;
import ir.maktabsharif101.oopjdbc.domain.User;

public interface UserService extends BaseEntityService {

    User findByUserName(String userName);
    boolean existsByUserName(String userName);
    boolean existsByMobileNumber(String mobileNumber);
}
