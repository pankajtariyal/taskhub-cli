# TaskHub CLI (v0.1)

A Java console-based task manager built to practice OOP, `Scanner` input handling, and `ArrayList` operations.

## Features
- Add Task
- List All Tasks
- Search Task by ID
- Update Task by ID (status)
- Delete Task by ID

## Tech Stack
- Java
- Maven

## Project Structure
src/main/java/com/taskhub_cli/
Main.java
Task.java
TaskStatus.java



## How to Run

### Option A: Run in IntelliJ
1. Open project in IntelliJ
2. Run `Main.java`

### Option B: Run using Maven (recommended)
```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="com.taskhub_cli.Main"


Notes

Tasks are stored in memory (no database yet).

Status values: TODO, DONE.

Future Improvements

 Persist tasks to file (JSON)

 Better input validation (non-numeric IDs)

 Unit tests (JUnit)

 Convert to backend API (Spring Boot)