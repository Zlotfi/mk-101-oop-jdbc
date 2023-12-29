package ir.maktabsharif101.oopjdbc;

import ir.maktabsharif101.oopjdbc.base.domain.BaseEntity;
import ir.maktabsharif101.oopjdbc.domain.Permission;
import ir.maktabsharif101.oopjdbc.domain.Role;
import ir.maktabsharif101.oopjdbc.domain.User;
import ir.maktabsharif101.oopjdbc.repository.RoleRepository;
import ir.maktabsharif101.oopjdbc.util.ApplicationContext;

import java.sql.SQLException;

public class OopJdbcApplication {
    public static void main(String[] args) throws SQLException {
//        RoleService roleService = ApplicationContext.getRoleService();
//
//        UserService userService = ApplicationContext.getUserService();
//
//        PermissionService permissionService = ApplicationContext.getPermissionService();


//        RoleService roleService = ApplicationContext.getInstance().getRoleService();
//        UserService userService = ApplicationContext.getInstance().getUserService();
//        ApplicationContext applicationContext = ApplicationContext.getInstance();
//        RoleService roleService = applicationContext.getRoleService();
//        RoleService roleService1 = applicationContext.getRoleService();

//        BaseEntity[] entities = new BaseEntity[3];
//        entities[0] = new Role();
//        entities[1] = new Permission();
//        entities[2] = new User();

//        System.out.println(
//                "count roles: " + ApplicationContext.getInstance().getRoleRepository().count()
//        );
//
//        System.out.println(
//                "count users: " + ApplicationContext.getInstance().getUserService().count()
//        );

        System.out.println(
                "role with id 1: " + ApplicationContext.getInstance().getRoleRepository().findById(1L)
        );

        System.out.println(
                "user with id 1: " + ApplicationContext.getInstance().getUserRepository().findById(1L)
        );

        System.out.println(
                "permission with id 1: " + ApplicationContext.getInstance().getPermissionRepository().findById(1L)
        );

        System.out.println(
                "user with id 2: " + ApplicationContext.getInstance().getUserRepository().findById(2L)
        );
    }
}
