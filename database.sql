CREATE SCHEMA IF NOT EXISTS `university`;

USE `university`;

CREATE TABLE IF NOT EXISTS 'university'.'degree'(
    'id' INT PRIMARY KEY NOT NULL AUTO_INCREMENT UNIQUE,
    'name' VARCHAR(45) NOT NULL
);

CREATE TABLE IF NOT EXISTS 'university'.'department'(
    'id' INT PRIMARY KEY NOT NULL AUTO_INCREMENT UNIQUE,
    'name' VARCHAR(70) NOT NULL,
    'head' VARCHAR(70) NOT NULL,
    'average_salary' DECIMAL(7,2) NOT NULL
);

CREATE TABLE IF NOT EXISTS 'university'.'lector'(
    'id' INT PRIMARY KEY NOT NULL AUTO_INCREMENT UNIQUE,
    'name' VARCHAR(70) NOT NULL,
    'degree_id' INT NOT NULL,
    FOREIGN KEY ('degree_id') REFERENCES 'university'.'degree' ('id')
);

CREATE TABLE IF NOT EXISTS 'university'.'department_lectors'(
    'lector_id' INT NOT NULL,
    'department_id' INT NOT NULL,
    FOREIGN KEY ('department_id') REFERENCES 'university'.'department' ('id'),
    FOREIGN KEY ('lector_id') REFERENCES 'university'.'lector' ('id')
    ON DELETE CASCADE ON UPDATE CASCADE
);

#Example entries

INSERT INTO degree VALUES (1, 'Assistant');
INSERT INTO degree VALUES (2, 'Associate professor');
INSERT INTO degree VALUES (3, 'Professor');

INSERT INTO department VALUES (1, 'Chemistry', 'John Snow', 17000.00);
INSERT INTO department VALUES (2, 'Computer Science', 'Ivan Ivanov', 25000.00);
INSERT INTO department VALUES (3, 'History', 'Julia Roberts', 12500.00);
INSERT INTO department VALUES (4, 'Environmental Systems and Societies', 'Max Nilson', 9875.75);
INSERT INTO department VALUES (5, 'Arts of Old Age', 'Hannah Baker', 11020.50);

INSERT INTO lector VALUES(1, 'John Johnson', 1);
INSERT INTO lector VALUES(2, 'Mei Meison', 1);
INSERT INTO lector VALUES(3, 'Alex Alexon', 3);
INSERT INTO lector VALUES(4, 'Robert Perry', 2);
INSERT INTO lector VALUES(5, 'Rick Anderson', 1);
INSERT INTO lector VALUES(6, 'James Goth', 3);
INSERT INTO lector VALUES(7, 'Meg Stone', 3);
INSERT INTO lector VALUES(8, 'Katheryne Simons', 2);
INSERT INTO lector VALUES(9, 'Alex Olson', 3);
INSERT INTO lector VALUES(10, 'Marina Diamond', 2);

INSERT INTO department_lectors VALUES (4, 1);
INSERT INTO department_lectors VALUES (1, 1);
INSERT INTO department_lectors VALUES (9, 1);
INSERT INTO department_lectors VALUES (4, 2);
INSERT INTO department_lectors VALUES (3, 2);
INSERT INTO department_lectors VALUES (5, 3);
INSERT INTO department_lectors VALUES (6, 3);
INSERT INTO department_lectors VALUES (10, 3);
INSERT INTO department_lectors VALUES (2, 3);
INSERT INTO department_lectors VALUES (7, 4);
INSERT INTO department_lectors VALUES (8, 5);
