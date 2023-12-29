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