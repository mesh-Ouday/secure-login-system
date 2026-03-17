# Secure Login System

A simple backend application built with Java and Spring Boot that handles user registration and login with basic security measures.

The goal of this project is to practice building real-world backend features such as authentication, password handling, and protecting against common attack patterns like brute-force attempts.

---

## Features

* User registration and login
* Password hashing using BCrypt
* Tracking failed login attempts
* Account lock after multiple failed attempts
* REST endpoints for authentication
* Basic frontend (HTML, CSS, JavaScript) for interaction

---

## Tech Stack

* Java
* Spring Boot
* Spring Data JPA
* PostgreSQL
* BCrypt
* HTML / CSS / JavaScript

---

## How it works

When a user registers, the password is hashed using BCrypt before being stored in the database.

During login:

* The system checks if the user exists
* Verifies if the account is locked
* Compares the entered password with the stored hash
* Increments failed attempts on incorrect login
* Locks the account after 5 failed attempts

---

## Project Structure

* `controller` – handles incoming HTTP requests
* `service` – contains the core authentication logic
* `repository` – communicates with the database
* `model` – defines the User entity
* `config` – contains configuration (e.g., password encoder)
* `resources/static` – simple frontend pages

---

## Running the project

1. Clone the repository

2. Configure your database in `application.properties`

3. Run the application from:

   SecureLoginSystemApplication.java

4. Open in browser:

   http://localhost:8080

---

## Notes

This project is mainly for learning purposes and focuses on understanding backend fundamentals and basic security practices.

---

## Author

Ouday Tawashi
