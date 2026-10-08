# 💼 JobNest AI – AI-Powered Job Portal

### 🚀 Find Jobs. Match Skills. Build Your Career.

JobNest AI is a modern **AI-powered job portal and recruitment management platform** built using **Java Full Stack technologies**.

The platform connects **job seekers and recruiters** in one system, allowing candidates to search and apply for jobs while recruiters can post vacancies, manage applications, and discover suitable candidates using AI-powered resume and job matching.

---

## 📌 Project Overview

JobNest AI provides a complete recruitment workflow:

**Candidate → Resume → AI Analysis → Job Matching → Application → Recruiter Review → Hiring**

The project demonstrates real-world implementation of:

* Java
* Spring Boot
* Spring Security
* REST APIs
* React.js
* MySQL
* JWT Authentication
* AI integration
* File upload
* Role-based authorization
* Search and filtering
* Recruitment dashboards

---

# ✨ Features

## 👤 Job Seeker

* Register and login
* JWT-based authentication
* Manage profile
* Upload resume
* Update skills and experience
* Search jobs
* Filter jobs by:

  * Location
  * Experience
  * Salary
  * Job type
  * Skills
* View job details
* Apply for jobs
* Track applications
* Save/bookmark jobs
* View application status
* Receive notifications

---

## 🏢 Recruiter

* Recruiter registration/login
* Company profile management
* Post job vacancies
* Update and delete jobs
* View applicants
* Search candidates
* Review resumes
* Shortlist candidates
* Reject applications
* Update application status
* Recruiter dashboard

---

# 🤖 AI Features

JobNest AI includes intelligent recruitment features.

### 📄 AI Resume Analysis

The system analyzes a candidate's resume and extracts information such as:

* Skills
* Education
* Experience
* Technologies
* Job-related keywords

### 🎯 AI Job Recommendation

The system recommends jobs based on:

```text
Candidate Skills
       +
Experience
       +
Education
       +
Job Requirements
       ↓
AI Matching Engine
       ↓
Recommended Jobs
```

### 📊 Resume–Job Matching

Candidates can receive a matching score based on their resume and the job requirements.

Example:

```text
Java              ✓
Spring Boot       ✓
React             ✓
MySQL             ✓
Docker            ✗

Match Score: 82%
```

---

# 🛠️ Technology Stack

## Frontend

* React.js
* JavaScript
* HTML5
* CSS3
* Vite
* Axios
* React Router
* Context API / Redux Toolkit

## Backend

* Java 21+
* Spring Boot
* Spring MVC
* Spring Data JPA
* Hibernate
* Spring Security
* JWT
* Bean Validation
* Maven

## Database

* MySQL

## AI

* AI/LLM API integration
* Resume analysis
* Job recommendation
* Skill matching

## Tools

* IntelliJ IDEA / VS Code
* MySQL Workbench
* Postman
* Git
* GitHub

---

# 🏗️ System Architecture

```text
                  ┌─────────────────────┐
                  │      React UI       │
                  │     Frontend        │
                  └──────────┬──────────┘
                             │
                             │ REST API
                             ▼
                  ┌─────────────────────┐
                  │    Spring Boot      │
                  │      Backend        │
                  └──────────┬──────────┘
                             │
             ┌───────────────┼────────────────┐
             │               │                │
             ▼               ▼                ▼
        ┌─────────┐    ┌────────────┐   ┌────────────┐
        │  MySQL  │    │ JWT/Spring │   │ AI Engine  │
        │ Database│    │  Security  │   │            │
        └─────────┘    └────────────┘   └────────────┘
```

---

# 📂 Project Structure

## Backend

```text
jobnest-ai-backend/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── com.jobnest/
│       │       ├── config/
│       │       ├── controller/
│       │       ├── dto/
│       │       ├── entity/
│       │       ├── enums/
│       │       ├── exception/
│       │       ├── repository/
│       │       ├── security/
│       │       ├── service/
│       │       └── JobNestApplication.java
│       │
│       └── resources/
│           ├── application.properties
│           └── static/
│
└── pom.xml
```

## Frontend

```text
jobnest-ai-frontend/
│
├── src/
│   ├── components/
│   ├── pages/
│   ├── services/
│   ├── context/
│   ├── hooks/
│   ├── assets/
│   ├── App.jsx
│   └── main.jsx
│
├── public/
├── package.json
└── vite.config.js
```

---

# 🗄️ Database Design

Main entities include:

```text
User
 │
 ├── JobSeeker
 │
 └── Recruiter

JobSeeker
 │
 ├── Resume
 ├── Skill
 └── Application

Recruiter
 │
 ├── Company
 └── Job

Job
 │
 └── Application

Application
 │
 └── ApplicationStatus
```

### Main Tables

* users
* job_seekers
* recruiters
* companies
* jobs
* skills
* resumes
* applications
* saved_jobs
* notifications
* interviews

---

# 🔐 Security

JobNest AI uses Spring Security and JWT authentication.

### Security Features

* JWT authentication
* Password hashing using BCrypt
* Role-based authorization
* Protected REST APIs
* Input validation
* Secure file upload
* Environment variables for API secrets
* No sensitive credentials stored in GitHub

### User Roles

```text
ROLE_JOB_SEEKER
ROLE_RECRUITER
ROLE_ADMIN
```

---

# 🔗 REST API Examples

### Authentication

```http
POST /api/auth/register
POST /api/auth/login
```

### Jobs

```http
GET    /api/jobs
GET    /api/jobs/{id}
POST   /api/jobs
PUT    /api/jobs/{id}
DELETE /api/jobs/{id}
```

### Applications

```http
POST /api/applications
GET  /api/applications/my
GET  /api/applications/job/{jobId}
PUT  /api/applications/{id}/status
```

### Resume

```http
POST /api/resumes/upload
GET  /api/resumes/{id}
POST /api/resumes/analyze
```

### AI

```http
POST /api/ai/resume-analysis
POST /api/ai/job-recommendations
POST /api/ai/match-score
```

---

# 🔄 Job Application Flow

```text
Candidate Login
       ↓
Search Jobs
       ↓
View Job Details
       ↓
AI Match Score
       ↓
Apply
       ↓
Recruiter Receives Application
       ↓
Resume Review
       ↓
Shortlist / Reject
       ↓
Interview
       ↓
Hiring
```

---

# 🧮 AI Matching Logic

The initial matching engine can consider:

```text
Skill Match
     +
Experience Match
     +
Education Match
     +
Job Keyword Match
     ↓
Final Match Score
```

Example:

```text
Skill Match       = 40%
Experience        = 20%
Education         = 15%
Keywords          = 15%
Other Factors     = 10%

Final Score       = 100%
```

The exact weighting can be configured as the project evolves.

---

# ⚙️ Installation & Setup

## 1️⃣ Clone the Repository

```bash
git clone <YOUR_GITHUB_REPOSITORY_URL>
```

```bash
cd jobnest-ai
```

---

# ☕ Backend Setup

Navigate to the backend:

```bash
cd jobnest-ai-backend
```

Configure MySQL in:

```text
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/jobnest
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

server.port=8080
```

Run the Spring Boot application:

```bash
mvn spring-boot:run
```

Backend:

```text
http://localhost:8080
```

---

# ⚛️ Frontend Setup

Open another terminal:

```bash
cd jobnest-ai-frontend
```

Install dependencies:

```bash
npm install
```

Start React:

```bash
npm run dev
```

Frontend:

```text
http://localhost:5173
```

---

# 🧪 API Testing

APIs can be tested using:

* Postman
* Browser
* React frontend

Example login request:

```json
{
  "email": "candidate@example.com",
  "password": "password123"
}
```

Example job:

```json
{
  "title": "Java Full Stack Developer",
  "location": "Bengaluru",
  "experience": "0-2 years",
  "skills": [
    "Java",
    "Spring Boot",
    "React",
    "MySQL"
  ]
}
```

---

# 🖥️ Application Screens

Planned screens:

### Public

* Home
* Login
* Registration
* Job Search
* Job Details

### Job Seeker

* Dashboard
* My Profile
* Resume
* AI Resume Analysis
* Recommended Jobs
* Applications
* Saved Jobs
* Notifications

### Recruiter

* Recruiter Dashboard
* Company Profile
* Post Job
* Manage Jobs
* Applicants
* Candidate Details
* Application Management

### Admin

* Admin Dashboard
* User Management
* Recruiter Management
* Job Management
* Application Monitoring
* Reports

---

# 🚀 Future Enhancements

* AI interview preparation
* AI-generated interview questions
* AI resume improvement suggestions
* Skill-gap analysis
* Personalized career roadmap
* Email notifications
* Real-time notifications
* Online interview scheduling
* Video interview integration
* Advanced recruiter analytics
* Elasticsearch-based job search
* Cloud deployment
* Docker support
* AWS deployment
* Mobile application

---

# 📈 Development Roadmap

```text
Phase 1  → Project Setup
Phase 2  → MySQL Database
Phase 3  → User Registration/Login
Phase 4  → JWT Authentication
Phase 5  → Job Seeker Module
Phase 6  → Recruiter Module
Phase 7  → Job Management
Phase 8  → Job Application
Phase 9  → Resume Upload
Phase 10 → AI Resume Analysis
Phase 11 → AI Job Recommendation
Phase 12 → Match Score
Phase 13 → Notifications
Phase 14 → Admin Dashboard
Phase 15 → Testing
Phase 16 → Deployment
```

---

# 🧪 Testing

Backend testing:

* JUnit
* Mockito
* Spring Boot Test

API testing:

* Postman

Frontend testing can be added using:

* Jest
* React Testing Library

---

# 📊 Learning Objectives

This project demonstrates practical knowledge of:

* Core Java
* OOP
* Collections
* Exception Handling
* Java 21+
* Spring Boot
* REST API development
* Spring Data JPA
* Hibernate
* MySQL
* Spring Security
* JWT
* React.js
* API integration
* Git & GitHub
* AI integration
* Full Stack application architecture

---

# 💡 Why JobNest AI?

JobNest AI is designed as a **real-world portfolio project**, rather than a simple CRUD application.

It combines:

```text
Java
   +
Spring Boot
   +
React
   +
MySQL
   +
REST APIs
   +
Spring Security
   +
JWT
   +
AI
```

This makes it suitable for demonstrating **Java Full Stack Developer** skills during interviews and portfolio reviews.

---

# 👨‍💻 Developer

**Cheerla Rakesh**

B.Tech – Electrical & Electronics Engineering

Interested in:

* Java Full Stack Development
* React.js
* Spring Boot
* AI Applications
* Software Development

---

# 📌 Project Status

🚧 **Currently Under Development**

The project is being developed incrementally, starting with the backend architecture, database, authentication, and core job-management features.

---

# ⭐ Support

If you find this project useful, consider giving the repository a ⭐ on GitHub.

---

## 📄 License

This project is developed for **educational, portfolio, and learning purposes**.
