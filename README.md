# SocialMediaPlatform

A simple Java-based social media platform that interacts with a MySQL database using phpMyAdmin for database management.

## Features
- **User Management**: Users can sign up, log in, and manage their profiles.
- **Post Creation**: Users can create posts, like, comment, and share posts.
- **Comment System**: Users can leave comments on posts.
- **Likes System**: Users can like and view posts they have liked.

## Prerequisites
Before you start, make sure you have the following installed:
- **Java JDK**: Version 8 or later.
- **MySQL**: For database storage.
- **phpMyAdmin (MyPHP)**: For managing your MySQL database.
- **Git**: For version control.

## Getting Started

### 1. Clone the Repository
```bash
git clone git@github.com:lazarous18/SocialmediaPlatform.git
cd SocialmediaPlatform
```
### 2. Database Setup
- Create a MySQL database (socialmedia_db).
- Use phpMyAdmin (MyPHP) or another MySQL client to set up the tables as required by the project.
- Update the database connection credentials in the Database.java file:
```bash
  public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/socialmedia_db";
    private static final String USER = "your_username";
    private static final String PASS = "your_password";
  }
```
### 3. Import the Project
- Open the project in your favorite Java IDE (VS Code, IntelliJ, Eclipse).
- Ensure that the necessary MySQL connector jar (mysql-connector-j-9.0.0.jar) is added to your project's classpath.
### 4. Run the Application
- Compile and run the Main.java file, which serves as the entry point.
- The application will connect to the MySQL database and launch the social media platform interface.
### 5. MySQL Configuration
- Make sure MySQL is running locally and that the database tables are properly set up with the necessary schema for user management, posts, comments, and likes.
### Usage
- **Login/Signup**: Create a new user or log in with an existing account.
- **Posts**: Create and view posts.
- **Likes**: Like and unlike posts.
- **Comments**: Leave comments on posts and view comments.
## Project Structure
```bash
├── bin
├── src
│   ├── Controller
│   ├── Model
│   │   ├── Comment.java
│   │   ├── Database.java
│   │   ├── Post.java
│   │   ├── User.java
│   ├── View
│   ├── Main.java
└── README.md
```
- **Controller**: Handles the logic for interacting with the data.
- **Model**: Contains data structure classes like User, Post, Comment, and database connectivity (Database.java).
- **View**: Manages the user interface (e.g., Welcome.java).
- **Main.java**: Entry point of the application.
## Technologies Used
- **Java**: Core language for the application.
- **MySQL**: For database storage and queries.
- **phpMyAdmin**: To manage the MySQL database with MyPHP integration.
## Contributing
- **Contributions are welcome! Please fork the repository and submit a pull request with your updates**.


