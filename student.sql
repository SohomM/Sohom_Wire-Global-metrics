CREATE DATABASE IF NOT EXISTS smartstudent;
USE smartstudent;

CREATE TABLE IF NOT EXISTS students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    roll_no VARCHAR(50) UNIQUE,
    department VARCHAR(50),
    email VARCHAR(100),
    phone VARCHAR(15),
    marks INT
);