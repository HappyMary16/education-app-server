-- CREATE TABLE users (
-- 	id INT(11) NOT NULL AUTO_INCREMENT,
-- 	first_name VARCHAR(50),
-- 	last_name VARCHAR(50),
-- 	username VARCHAR(50) NOT NULL,
-- 	password BLOB NOT NULL,
-- 	phone VARCHAR(50),
-- 	email VARCHAR(50),
--
-- 	PRIMARY KEY (id),
-- 	UNIQUE INDEX id (id)
-- );
--
CREATE TABLE users
(
    id         SERIAL,
    first_name VARCHAR(50),
    last_name  VARCHAR(50),
    username   VARCHAR(50) NOT NULL,
    password   VARCHAR(50) NOT NULL,
    phone      VARCHAR(50),
    email      VARCHAR(50),

    PRIMARY KEY (id)
);

