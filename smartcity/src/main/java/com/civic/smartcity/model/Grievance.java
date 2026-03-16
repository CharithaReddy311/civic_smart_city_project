package com.civic.smartcity.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "grievances")
public class Grievance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String category;

    private String status;

    private LocalDateTime createdAt;

    // Relationship with User (Citizen)
    @ManyToOne
    @JoinColumn(name = "citizen_id")
    private User citizen;

    // Relationship with User (Officer)
    @ManyToOne
    @JoinColumn(name = "officer_id")
    private User officer;

    public Grievance() {
        this.createdAt = LocalDateTime.now();
        this.status = "PENDING";
    }

    // Getters and Setters

    public Long getId() { return id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getCategory() { return category; }

    public void setCategory(String category) { this.category = category; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public User getCitizen() { return citizen; }

    public void setCitizen(User citizen) { this.citizen = citizen; }

    public User getOfficer() { return officer; }

    public void setOfficer(User officer) { this.officer = officer; }
}