🚧 Current Project Status (MVP Skeleton): This repository currently contains the functional full-stack core engine (Java Spring Boot API + Vanilla JS UI) handling local CRUD data pipelines. This project is actively being developed in incremental phases as part of a long-term roadmap. 
# CS Internship Tracker 🚀

A Full-Stack CRUD (Create, Read, Update, Delete) application built to manage and track computer science internship targets. This project demonstrates a complete end-to-end software architecture, connecting a dynamic JavaScript user interface to a Java Spring Boot REST API and an underlying relational database.

## 💻 Tech Stack
**Frontend:**
* HTML5 & CSS3
* Vanilla JavaScript (ES6+)
* Fetch API (Asynchronous HTTP Requests)
* DOM Manipulation

**Backend:**
* Java
* Spring Boot (RESTful Web Services)
* Spring Data JPA / Hibernate

**Database & Tools:**
* H2 Database (In-Memory SQL)
* Maven
* Git & GitHub

## ✨ Core Features
* **Dynamic Data Rendering:** Fetches data from the database and dynamically builds HTML tables using JavaScript template literals.
* **RESTful API Integration:** Fully functional `GET`, `POST`, `PUT`, and `DELETE` HTTP endpoints.
* **Asynchronous State Management:** Updates, adds, and deletes user records without requiring page reloads (SPA behavior).
* **Data Binding:** Safely parses DOM inputs into JSON payloads, translates them into Java Objects via `@RequestBody`, and persists them to the database.
* **CORS Configuration:** Configured cross-origin resource sharing to securely connect the frontend client to the backend server.

## 🏗️ Architecture Overview
This application follows a standard Client-Server architecture:
1. **The Client (Frontend):** The user inputs data into the HTML form. An Event Listener triggers a JavaScript function that prevents default page refreshing, packages the DOM values into a JSON object, and sends it via the Fetch API.
2. **The Server (Backend):** A Spring Boot `@RestController` intercepts the HTTP request. Using `@Autowired` dependency injection, the controller hands the Java Object off to the Repository.
3. **The Data Store (Database):** The Spring Data JPA Repository executes the appropriate SQL commands to Create, Read, Update, or Delete the record in the H2 Database.

## 🚀 How to Run the Project
1. Clone this repository to your local machine.
2. Open the backend Java code in an IDE (like VS Code or IntelliJ) and run the Spring Boot application. The server will start on `http://localhost:8082`.
3. Open a web browser and navigate to `http://localhost:8082` to view the frontend dashboard and interact with the database.
4. ## 🗺️ Roadmap & Future Architecture
This MVP is Phase 1 of a larger "CS Career Navigator" platform. Future development phases include:

* **Data Persistence & Schema Expansion:** Migrating from the local H2 in-memory database to a relational **PostgreSQL** instance (hosted on Amazon RDS). Expanding the `Student` entity schema to track `skillsList` and `applicationStatus`.
* **Rule-Based Roadmap Engine:** Implementing backend logic to dynamically generate actionable, step-by-step skill preparation paths based on the user's `targetRole` (e.g., automatically generating a Linux/AWS learning path for aspiring Cloud Engineers).
* **Cloud Infrastructure Migration:** Decoupling the monolith by hosting frontend assets in an **AWS S3** bucket and deploying the Spring Boot API to **AWS Elastic Beanstalk / EC2**.
* **Target Scraping Engine:** Integrating **Python** scripts to automate background web scraping of active job postings, matching real-world corporate demands with student profiles.

---
*Developed by Ian Ndirangu Macharia*
