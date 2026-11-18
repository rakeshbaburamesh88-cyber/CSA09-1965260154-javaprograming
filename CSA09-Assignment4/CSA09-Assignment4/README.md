# CSA0916 - Java Assignment 4: Event-Driven GUI Design

Tasks 1 to 6 are in the folders Task01 to Task06.

## Requirements
- JDK 11 or later (check with `java -version`)
- Task 6 only: MySQL Server and the MySQL Connector/J JAR

## Run (from inside each TaskXX folder)
    javac *.java
    java FeeWindow          # Task01
    java HospitalAppointment # Task02
    java LibrarySearch      # Task03
    java DrawPad            # Task04
    java Converter          # Task05 (also: java EventStylesDemo)

## Task 6
1. Run `schema.sql` in MySQL.
2. Edit the PASSWORD in `RegistrationDAO.java`.
3. Compile and run with the connector on the classpath:
       javac *.java
       java -cp ".;mysql-connector-j-X.X.X.jar" EventRegistration    (Windows)
       java -cp ".:mysql-connector-j-X.X.X.jar" EventRegistration    (Mac/Linux)
