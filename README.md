Film Ticket Booking System
Overview
The Film Ticket Booking System is a web-based application developed using Spring Boot, Thymeleaf, and Oracle Database. It allows users to manage cinema ticket bookings efficiently by performing CRUD operations such as adding, viewing, updating, and deleting ticket records.

The application follows the Model–View–Controller (MVC) architecture and demonstrates practical web development using Java technologies.

Features

Add new ticket details
View all tickets
Update ticket information
Delete ticket records
Search tickets by movie name or show time (optional)

Technologies Used

Backend: Spring Boot, Spring Data JPA, Hibernate
Frontend: Thymeleaf, HTML, CSS
Database: Oracle (SQL*Plus)
Server: Embedded Apache Tomcat
Build Tool: Maven
IDE: Eclipse

Project Structure

```
film-ticket-booking/
 ├── src/main/java/com/film/
 │    ├── controller/
 │    ├── model/
 │    ├── repository/
 │    ├── service/
 │    └── util/
 ├── src/main/resources/
 │    ├── templates/
 │    ├── static/css/
 │    └── application.properties
 ├── pom.xml
 ├── mvnw
 └── mvnw.cmd
```

Database Setup (Oracle SQL*Plus)
Run the following commands:
```sql
CREATE TABLE ticket (
    ticketid   NUMBER PRIMARY KEY,
    moviename  VARCHAR2(100) NOT NULL,
    showtime   VARCHAR2(50)  NOT NULL,
    seatnumber VARCHAR2(10)  NOT NULL,
    price      NUMBER        NOT NULL
);

CREATE SEQUENCE ticket_seq START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;
```

Configuration
Update application.properties:
```properties
spring.datasource.url=jdbc:oracle:thin:@localhost:1521:xe
spring.datasource.username=system
spring.datasource.password=your_password
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.OracleDialect

spring.thymeleaf.cache=false
```
How to Run
1. Import the project into Eclipse as a Maven project
2. Update Oracle database credentials in application.properties
3. Run FilmTicketBookingApplication.java
4. Open a browser and go to: http://localhost:8080

Key Concepts Demonstrated
MVC Architecture
CRUD Operations
Spring Data JPA and Hibernate
Oracle Database Integration
Thymeleaf Template Engine
Form Handling and Validation
is developed for academic purposes.
