CREATE DATABASE campus_event;
USE campus_event;

CREATE TABLE events (
    event_id INT PRIMARY KEY AUTO_INCREMENT,
    event_name VARCHAR(100) NOT NULL
);

CREATE TABLE registrations (
    registration_id INT PRIMARY KEY AUTO_INCREMENT,
    student_id VARCHAR(30) NOT NULL,
    student_name VARCHAR(100) NOT NULL,
    event_id INT NOT NULL,
    FOREIGN KEY (event_id) REFERENCES events(event_id),
    UNIQUE(student_id, event_id)
);

INSERT INTO events(event_name)
VALUES
('Dance Competition'),
('Singing Competition'),
('Technical Quiz');
