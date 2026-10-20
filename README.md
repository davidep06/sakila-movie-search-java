# Sakila Movie Search (Java)

A small Java console application that looks up a movie by its title in the **Sakila** sample database. This is my first project using Java, JDBC, and SQL, built to learn how an application talks to a database.

## What It Does

The program asks for a movie title, searches for it in the `film` table, and prints the result:

```text
Enter the title of the film you are looking for: ACADEMY DINOSAUR
Movie found:
Movie{movieID=1, title='ACADEMY DINOSAUR', releaseYear=2006, length=86}
```

If the movie is not in the database, it shows an error message instead:

```text
Error: The movie does not exist: SOME TITLE
```

The search is an exact match on the title. In Sakila, titles are stored in uppercase.

## Project Structure

```text
src/
├── Main.java            # Reads the title from the user and prints the result
├── dao/
│   └── MovieDAO.java    # Database access: connects and runs the query
└── entity/
    └── Movie.java       # The Movie class (id, title, release year, length)
```

The project follows a simple DAO (Data Access Object) pattern: `Main` only handles input and output, `MovieDAO` handles everything related to the database, and `Movie` represents one row from the `film` table.

## Technologies

* Java
* JDBC
* MariaDB (MySQL-compatible) with the Sakila sample database
* IntelliJ IDEA

## Requirements

1. **Java JDK** installed.
2. **MariaDB or MySQL** running locally on port 3306.
3. The **Sakila database** installed. It can be downloaded from the official MySQL documentation: https://dev.mysql.com/doc/sakila/en/
4. The **MariaDB JDBC driver** (`mariadb-java-client`, version 3.0.8 was used). It is not included in this repository, so it needs to be added to the project as a library.

## How to Run

1. Clone the repository and open it in IntelliJ IDEA.
2. Add the MariaDB JDBC driver as a library (`File -> Project Structure -> Libraries -> + -> Java`, then select the `.jar` file).
3. Open `src/dao/MovieDAO.java` and set your own database credentials:
   ```java
   private static final String URL = "jdbc:mariadb://localhost:3306/sakila";
   private static final String USER = "root";
   private static final String PASS = "your-password";
   ```
4. Run the `Main` class and type a movie title.

## What I Learned

* How to connect a Java application to a database with JDBC.
* How to organize code using the DAO pattern and separate classes for entities.
* Why queries should use `PreparedStatement` instead of string concatenation (it prevents SQL injection).
* How to close database resources safely with `try-with-resources`.

## Possible Improvements

* Search by release year or by actor.
* Allow partial matches (for example, titles that contain a word).
* Read the database credentials from a config file instead of hardcoding them.
* Let the user search multiple times without restarting the program.
