package com.edulearn.model;

public class Test {
    private Long id;
    private Long courseId;
    private String title;
    private Integer duration;
    private Integer totalQuestions;

    public Test(Long id, Long courseId, String title, Integer duration, Integer totalQuestions) {
        this.id = id;
        this.courseId = courseId;
        this.title = title;
        this.duration = duration;
        this.totalQuestions = totalQuestions;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getCourseId() { return courseId; }
    public void setCourseId(Long courseId) { this.courseId = courseId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public Integer getDuration() { return duration; }
    public void setDuration(Integer duration) { this.duration = duration; }
    public Integer getTotalQuestions() { return totalQuestions; }
    public void setTotalQuestions(Integer totalQuestions) { this.totalQuestions = totalQuestions; }

    @Override
    public String toString() {
        return title + " (" + duration + " minutes, " + totalQuestions + " questions)";
    }
}