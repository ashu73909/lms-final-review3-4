package com.edulearn.ui;
import com.edulearn.model.Test;
import com.edulearn.model.User;
import com.edulearn.model.Course;
import com.edulearn.model.Test;
import com.edulearn.service.UserService;
import com.edulearn.dao.UserDAO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

// Main Application Window
public class EduLearnGUI extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private User currentUser;
    
    public EduLearnGUI() {
        setTitle("EduLearn System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        
        mainPanel.add(new LoginPanel(this), "login");
        mainPanel.add(new RegisterPanel(this), "register");
        mainPanel.add(new CoursePanel(this), "courses");
        mainPanel.add(new TestPanel(this), "tests");
        
        add(mainPanel);
        cardLayout.show(mainPanel, "login");
    }
    
    public void switchPanel(String panelName) {
        cardLayout.show(mainPanel, panelName);
    }
    
    public void setCurrentUser(User user) {
        this.currentUser = user;
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                new EduLearnGUI().setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}

class LoginPanel extends JPanel {
    private EduLearnGUI mainFrame;
    private JTextField emailField;
    private JPasswordField passwordField;
    
    public LoginPanel(EduLearnGUI frame) {
        mainFrame = frame;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        JLabel titleLabel = new JLabel("Login", SwingConstants.CENTER);
        emailField = new JTextField(20);
        passwordField = new JPasswordField(20);
        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");
        
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(titleLabel, gbc);
        
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(new JLabel("Email:"), gbc);
        
        gbc.gridx = 1;
        add(emailField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2;
        add(new JLabel("Password:"), gbc);
        
        gbc.gridx = 1;
        add(passwordField, gbc);
        
        loginButton.addActionListener(e -> {
            try {
                UserService userService = new UserService(new UserDAO(DatabaseConnection.getConnection()));
                User user = userService.authenticate(emailField.getText(), new String(passwordField.getPassword()));
                if (user != null) {
                    mainFrame.setCurrentUser(user);
                    mainFrame.switchPanel("courses");
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid credentials");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage());
            }
        });
        
        registerButton.addActionListener(e -> mainFrame.switchPanel("register"));
        
        gbc.gridx = 0; gbc.gridy = 3;
        add(loginButton, gbc);
        
        gbc.gridx = 1;
        add(registerButton, gbc);
    }
}

class RegisterPanel extends JPanel {
    private EduLearnGUI mainFrame;
    private JTextField nameField;
    private JTextField emailField;
    private JPasswordField passwordField;
    
    public RegisterPanel(EduLearnGUI frame) {
        mainFrame = frame;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        nameField = new JTextField(20);
        emailField = new JTextField(20);
        passwordField = new JPasswordField(20);
        JButton registerButton = new JButton("Register");
        JButton backButton = new JButton("Back to Login");
        
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0; gbc.gridy = 0;
        add(new JLabel("Name:"), gbc);
        gbc.gridx = 1;
        add(nameField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        add(new JLabel("Email:"), gbc);
        gbc.gridx = 1;
        add(emailField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2;
        add(new JLabel("Password:"), gbc);
        gbc.gridx = 1;
        add(passwordField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 3;
        add(registerButton, gbc);
        gbc.gridx = 1;
        add(backButton, gbc);
        
        registerButton.addActionListener(e -> {
            if (validateInputs()) {
                try {
                    UserService userService = new UserService(new UserDAO(DatabaseConnection.getConnection()));
                    User user = userService.register(
                        nameField.getText(),
                        emailField.getText(),
                        new String(passwordField.getPassword())
                    );
                    JOptionPane.showMessageDialog(this, "Registration successful!");
                    mainFrame.switchPanel("login");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Registration error: " + ex.getMessage());
                }
            }
        });
        
        backButton.addActionListener(e -> mainFrame.switchPanel("login"));
    }
    
    private boolean validateInputs() {
        if (nameField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Name is required");
            return false;
        }
        if (!emailField.getText().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            JOptionPane.showMessageDialog(this, "Invalid email format");
            return false;
        }
        if (passwordField.getPassword().length < 6) {
            JOptionPane.showMessageDialog(this, "Password must be at least 6 characters");
            return false;
        }
        return true;
    }
}

class CoursePanel extends JPanel {
    private EduLearnGUI mainFrame;
    private JList<Course> courseList;
    private DefaultListModel<Course> listModel;
    
    public CoursePanel(EduLearnGUI frame) {
        mainFrame = frame;
        setLayout(new BorderLayout());
        
        listModel = new DefaultListModel<>();
        courseList = new JList<>(listModel);
        JButton enrollButton = new JButton("Enroll");
        JButton viewTestsButton = new JButton("View Tests");
        
        add(new JScrollPane(courseList), BorderLayout.CENTER);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(enrollButton);
        buttonPanel.add(viewTestsButton);
        add(buttonPanel, BorderLayout.SOUTH);
        
        enrollButton.addActionListener(e -> {
            Course selectedCourse = courseList.getSelectedValue();
            if (selectedCourse != null) {
                try {
                    // Add enrollment logic here
                    JOptionPane.showMessageDialog(this, "Successfully enrolled in " + selectedCourse.getTitle());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Error enrolling: " + ex.getMessage());
                }
            }
        });
        
        viewTestsButton.addActionListener(e -> mainFrame.switchPanel("tests"));
        
        loadCourses();
    }
    
    private void loadCourses() {
        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM courses");
            
            listModel.clear();
            while (rs.next()) {
                Course course = new Course(
                    rs.getLong("id"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getString("duration"),
                    rs.getString("instructor")
                );
                listModel.addElement(course);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading courses: " + e.getMessage());
        }
    }
}

class TestPanel extends JPanel {
    private EduLearnGUI mainFrame;
    private JList<Test> testList;
    private DefaultListModel<Test> listModel;
    private Timer testTimer;
    
    public TestPanel(EduLearnGUI frame) {
        mainFrame = frame;
        setLayout(new BorderLayout());
        
        listModel = new DefaultListModel<>();
        testList = new JList<>(listModel);
        JButton startTestButton = new JButton("Start Test");
        JLabel timerLabel = new JLabel("Time: 00:00");
        
        add(new JScrollPane(testList), BorderLayout.CENTER);
        
        JPanel controlPanel = new JPanel();
        controlPanel.add(timerLabel);
        controlPanel.add(startTestButton);
        add(controlPanel, BorderLayout.SOUTH);
        
        startTestButton.addActionListener(e -> {
            Test selectedTest = testList.getSelectedValue();
            if (selectedTest != null) {
                startTest(selectedTest, timerLabel);
            }
        });
        
        loadTests();
    }
    
    private void loadTests() {
        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM tests");
            
            listModel.clear();
            while (rs.next()) {
                Test test = new Test(
                    rs.getLong("id"),
                    rs.getString("title"),
                    rs.getInt("duration"),
                    rs.getInt("total_questions")
                );
                listModel.addElement(test);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading tests: " + e.getMessage());
        }
    }
    
    private void startTest(Test test, JLabel timerLabel) {
        int[] timeLeft = {test.getDuration() * 60};
        
        testTimer = new Timer(1000, e -> {
            timeLeft[0]--;
            if (timeLeft[0] <= 0) {
                testTimer.stop();
                JOptionPane.showMessageDialog(this, "Time's up!");
                submitTest();
            }
            updateTimerLabel(timerLabel, timeLeft[0]);
        });
        testTimer.start();
    }
    
    private void updateTimerLabel(JLabel label, int seconds) {
        int minutes = seconds / 60;
        int secs = seconds % 60;
        label.setText(String.format("Time: %02d:%02d", minutes, secs));
    }
    
    private void submitTest() {
        try {
            // Add test submission logic here
            JOptionPane.showMessageDialog(this, "Test submitted successfully!");
            mainFrame.switchPanel("courses");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error submitting test: " + e.getMessage());
        }
    }
}

class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/edulearn";
    private static final String USER = "root";
    private static final String PASSWORD = "password";
    
    public static Connection getConnection() throws SQLException {
        int retries = 3;
        while (retries > 0) {
            try {
                return DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                retries--;
                if (retries == 0) throw e;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    throw e;
                }
            }
        }
        throw new SQLException("Failed to connect to database after 3 attempts");
    }
}

class User {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String role;

    public User(Long id, String name, String email, String password, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getRole() { return role; }
}

class Course {
    private Long id;
    private String title;
    private String description;
    private String duration;
    private String instructor;

    public Course(Long id, String title, String description, String duration, String instructor) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.instructor = instructor;
    }

    // Getters
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getDuration() { return duration; }
    public String getInstructor() { return instructor; }
    
    @Override
    public String toString() {
        return title + " (" + duration + ") - " + instructor;
    }
}


