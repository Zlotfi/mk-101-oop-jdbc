CREATE TYPE UserType AS ENUM('ADMIN','CUSTOMER');

CREATE TABLE IF NOT EXISTS user3 (
    id SERIAL PRIMARY KEY,
    firstName VARCHAR(50) NOT NULL,
    lastName VARCHAR(50) NOT NULL,
    userName VARCHAR(50) NOT NULl UNIQUE,
    password VARCHAR(50) NOT NULL,
    mobileNumber VARCHAR(50) NOT NULL,
    age INTEGER NOT NULL,
    createDateMillis BIGINT,
    createDate timestamp with time zone,
    userType UserType
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