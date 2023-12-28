package ir.maktabsharif101.oopjdbc.domain;

import ir.maktabsharif101.oopjdbc.base.domain.Entity;
import ir.maktabsharif101.oopjdbc.domain.enumeration.UserType;

import java.time.ZonedDateTime;

@SuppressWarnings("unused")
//@Entity
public class User extends Entity {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String mobileNumber;
    private Integer age;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
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
}
