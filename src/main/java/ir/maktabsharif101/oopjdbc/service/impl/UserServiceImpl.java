package ir.maktabsharif101.oopjdbc.service.impl;

import ir.maktabsharif101.oopjdbc.base.domain.BaseEntity;
import ir.maktabsharif101.oopjdbc.base.service.impl.BaseEntityServiceImpl;
import ir.maktabsharif101.oopjdbc.domain.User;
import ir.maktabsharif101.oopjdbc.repository.UserRepository;
import ir.maktabsharif101.oopjdbc.service.RoleService;
import ir.maktabsharif101.oopjdbc.service.UserService;
@SuppressWarnings("unused")
public class UserServiceImpl extends BaseEntityServiceImpl implements UserService {

    private final RoleService roleService;
    public UserServiceImpl(UserRepository baseRepository, RoleService roleService) {
        super(baseRepository);
        this.roleService = roleService;
    }

    @Override
    public BaseEntity sava(BaseEntity entity) {
        // TODO use role service
        return super.sava(entity);
    }

    @Override
    public User findByUserName(String userName) {
        return ((UserRepository)baseRepository).findByUserName(userName);
    }

    @Override
    public boolean existsByUserName(String userName) {
        return ((UserRepository)baseRepository).existsByUserName(userName);
    }

    @Override
    public boolean existsByMobileNumber(String mobileNumber) {
        return ((UserRepository)baseRepository).existsByMobileNumber(mobileNumber);
    }
}
