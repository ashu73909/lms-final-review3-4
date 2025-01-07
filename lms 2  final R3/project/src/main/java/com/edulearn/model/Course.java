package com.edulearn.model;

public class Course {
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

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }
    public String getInstructor() { return instructor; }
    public void setInstructor(String instructor) { this.instructor = instructor; }
}