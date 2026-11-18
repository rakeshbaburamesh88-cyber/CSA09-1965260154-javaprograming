CREATE DATABASE college;

USE college;

CREATE TABLE bus_pass (
    pass_id VARCHAR(20) PRIMARY KEY,
    reg_no VARCHAR(20),
    name VARCHAR(100),
    route_no INT,
    amount DOUBLE
);

INSERT INTO bus_pass VALUES
('P1001','192311001','Arun',12,4500),
('P1002','192311002','Bala',7,3800),
('P1003','192311003','Divya',5,4200);

SELECT * FROM bus_pass;
