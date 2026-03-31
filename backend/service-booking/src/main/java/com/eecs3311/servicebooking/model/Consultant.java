package com.eecs3311.servicebooking.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "consultants")
public class Consultant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private boolean approved;

    public Consultant() {}

    public Consultant(Long id, String name, boolean approved) {
        this.id = id;
        this.name = name;
        this.approved = approved;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public boolean isApproved() { return approved; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setApproved(boolean approved) { this.approved = approved; }
}