package ir.maktabsharif101.oopjdbc.domain;

public class Admin extends User {
    private boolean isSuperAdmin;

    public boolean isSuperAdmin() {
        return isSuperAdmin;
    }

    public void setSuperAdmin(boolean superAdmin) {
        isSuperAdmin = superAdmin;
    }
}
