CREATE TYPE UserType AS ENUM('ADMIN','CUSTOMER');

CREATE TABLE IF NOT EXISTS user3 (
    id SERIAL PRIMARY KEY,
    firstName VARCHAR(50) NOT NULL,
    lastName VARCHAR(50) NOT NULL,
    userName VARCHAR(50) NOT NULl UNIQUE,
    password VARCHAR(50) NOT NULL,
    mobileNumber VARCHAR(50),
    age INT,
    createDateMillis BIGINT,
    createDate timestamp with time zone,
    userType UserType,
    dType VARCHAR(50),
    email VARCHAR(50),
    national_code VARCHAR(50),
    address VARCHAR(500),
    is_super_admin BOOLEAN
);

CREATE TABLE IF NOT EXISTS role (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS users_roles(
    user_id INTEGER,
    role_id INTEGER,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES user3(id),
    FOREIGN KEY (role_id) REFERENCES role(id)
);

CREATE TABLE IF NOT EXISTS permission(
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS roles_permissions(
    role_id INTEGER,
    permission_id INTEGER,
    PRIMARY KEY (role_id, permission_id),
    FOREIGN KEY (role_id) REFERENCES role(id),
    FOREIGN KEY (permission_id) REFERENCES permission(id)
);

CREATE TABLE IF NOT EXISTS customer_join(
    id INTEGER,
    PRIMARY KEY (id),
    FOREIGN KEY (id) REFERENCES user3(id),
    email VARCHAR(50) NOT NULL,
    nationalCode VARCHAR(50) NOT NULL,
    address VARCHAR(500) NOT NULL
);

CREATE TABLE IF NOT EXISTS city (
    id SERIAL PRIMARY KEY ,
    name VARCHAR(50) NOT NULL
);