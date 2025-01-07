# lms-final-review3-4
EduLearn GUI

EduLearn GUI is a Java-based educational learning system that provides a graphical user interface for students to access courses and take tests.

Features:
- User authentication (login) and registration
- Course listing and enrollment
- Test listing and taking
- Timer-based test sessions

Prerequisites:
Before you begin, ensure you have met the following requirements:
- Java Development Kit (JDK) 8 or higher
- MySQL database server
- JDBC driver for MySQL

Installation:
1. Clone the repository:
   git clone https://github.com/yourusername/edulearn-gui.git

2. Navigate to the project directory:
   cd edulearn-gui

3. Compile the Java files:
   javac -cp .:path/to/mysql-connector-java.jar com/edulearn/ui/*.java com/edulearn/model/*.java com/edulearn/service/*.java com/edulearn/dao/*.java

4. Set up the database:
   - Create a new MySQL database named 'edulearn'
   - Run the SQL script in 'schema.sql' to create the necessary tables

5. Update the database connection details in DatabaseConnection.java:
   private static final String URL = "jdbc:mysql://localhost:3306/edulearn";
   private static final String USER = "your_username";
   private static final String PASSWORD = "your_password";

Usage:
To run the EduLearn GUI application:
java -cp .:path/to/mysql-connector-java.jar com.edulearn.ui.EduLearnGUI

Project Structure:
- com.edulearn.ui: Contains the GUI components
  - EduLearnGUI.java: Main application window
  - LoginPanel.java: Login interface
  - RegisterPanel.java: User registration interface
  - CoursePanel.java: Course listing and enrollment
  - TestPanel.java: Test listing and taking
- com.edulearn.model: Data models
  - User.java: Represents a user in the system
  - Course.java: Represents a course
  - Test.java: Represents a test
- com.edulearn.service: Business logic
  - UserService.java: Handles user authentication and registration
- com.edulearn.dao: Data Access Objects
  - UserDAO.java: Handles database operations for users

Contributing:
Contributions to the EduLearn GUI project are welcome. Please follow these steps:
1. Fork the repository
2. Create a new branch: 'git checkout -b feature-name'
3. Make your changes and commit them: 'git commit -m 'Add some feature''
4. Push to the branch: 'git push origin feature-name'
5. Submit a pull request

License:
This project is licensed under the MIT License - see the LICENSE.md file for details.

Contact:
If you have any questions or feedback, please contact [Your Name] at [your.email@example.com].

Acknowledgements:
- Java Swing for the GUI components
- MySQL for the database management system
