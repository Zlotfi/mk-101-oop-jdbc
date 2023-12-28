package ir.maktabsharif101.oopjdbc.service.impl;

import ir.maktabsharif101.oopjdbc.base.repository.BaseEntityRepository;
import ir.maktabsharif101.oopjdbc.base.service.impl.BaseEntityServiceImpl;
import ir.maktabsharif101.oopjdbc.repository.RoleRepository;
import ir.maktabsharif101.oopjdbc.service.RoleService;

public class RoleServiceImpl extends BaseEntityServiceImpl
        implements RoleService {
    public RoleServiceImpl(RoleRepository baseRepository) {
        super(baseRepository);
    }
}
