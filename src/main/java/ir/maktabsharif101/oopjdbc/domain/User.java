package ir.maktabsharif101.oopjdbc.domain;

import ir.maktabsharif101.oopjdbc.base.domain.BaseEntity;
import ir.maktabsharif101.oopjdbc.domain.enumeration.UserType;

import java.time.ZonedDateTime;

@SuppressWarnings("unused")
//@Entity
//@Inheritance(strategy = SINGLE_TABLE)
//@Inheritance(strategy = JOIN)
//@Inheritance(strategy = TABLE_PRE_CLASS)
public class User extends BaseEntity {

    public static final String TABLE_NAME = "user3";
    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String USER_NAME = "userName";
    public static final String PASSWORD = "password";
    public static final String MOBILE_NUMBER = "mobileNumber";
    public static final String AGE = "age";

    private String firstName;
    private String lastName;
    //unique
    private String userName;
    private String password;
    private String mobileNumber;
    private int age;
    private Long createDateMillis;

    //transient
    private ZonedDateTime createDate;
    private UserType userType;

    //OneToOne -> split (To) -> One  -  One
    //ManyToOne -> split (To) -> Many  -  One
    //OneToMany -> split (To) -> One  -  Many
    //ManyToMany -> split (To) -> Many  -  Many

    //ManyToMany
    private Role[] roles;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getCreateDateMillis() {
        return createDateMillis;
    }

    public void setCreateDateMillis(Long createDateMillis) {
        this.createDateMillis = createDateMillis;
    }

    public ZonedDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(ZonedDateTime createDate) {
        this.createDate = createDate;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Role[] getRoles() {
        return roles;
    }

    public void setRoles(Role[] roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + getId() + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
