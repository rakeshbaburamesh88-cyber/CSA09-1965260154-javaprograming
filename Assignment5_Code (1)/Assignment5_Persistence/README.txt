Assignment 5 - Data Persistence Engineering (Java)
Open this folder in VS Code (File > Open Folder). Each TaskNN folder is independent.

  cd TaskNN
  javac *.java
  java <MainClassName>

Task02  BufferedLineCounter, ReadAllLines  - need an attendance.txt in the folder you run from
Task03  Dao, Student, StudentDao           - library classes (no main); need a JDBC Connection
Task05  LoginCheck                         - needs MySQL 'college' database with a users table
Task06  PassStore                          - self-contained test (uses a temp file); run: java PassStore
Task07  SafeLogin                          - needs MySQL
Task08  PassLoader + create_table.sql      - run create_table.sql in MySQL first
Task09  PassMigration, DatabaseInfo        - need MySQL and a passes.csv for PassMigration
        (PassLoader.java is copied here so it compiles)

Database programs need the MySQL JDBC driver (mysql-connector-j .jar) on the classpath, e.g.
  javac *.java
  java -cp ".;path/to/mysql-connector-j.jar" DatabaseInfo      (Windows)
  java -cp ".:path/to/mysql-connector-j.jar" DatabaseInfo      (Mac/Linux)
and the DB user/password in the code ("root"/"password") must be changed to yours.
