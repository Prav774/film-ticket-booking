package com.film.util;

/**
 * Oracle SQL*Plus Setup Script
 *
 * Run the following commands in Oracle SQL*Plus before starting the application:
 *
 * -- Connect as SYSTEM or DBA user:
 * CONNECT system/your_password@localhost:1521:xe
 *
 * -- Create the ticket table:
 * CREATE TABLE ticket (
 *     ticketid   NUMBER PRIMARY KEY,
 *     moviename  VARCHAR2(100) NOT NULL,
 *     showtime   VARCHAR2(50)  NOT NULL,
 *     seatnumber VARCHAR2(10)  NOT NULL,
 *     price      NUMBER        NOT NULL
 * );
 *
 * -- Create the sequence for auto-increment:
 * CREATE SEQUENCE ticket_seq
 *     START WITH 1
 *     INCREMENT BY 1
 *     NOCACHE
 *     NOCYCLE;
 *
 * -- Verify:
 * SELECT * FROM ticket;
 * SELECT sequence_name FROM user_sequences;
 *
 * Note: spring.jpa.hibernate.ddl-auto=update will manage the schema automatically
 *       if the table does not exist. However, Oracle sequences must be created manually
 *       or via a schema.sql file placed in src/main/resources/.
 */
public class DatabaseConfig {
    // Utility documentation class — no instantiation needed.
    private DatabaseConfig() {
    }
}
