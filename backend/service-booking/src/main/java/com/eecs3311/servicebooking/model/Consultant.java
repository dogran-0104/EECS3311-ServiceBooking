package com.eecs3311.servicebooking.model;

public class Consultant {
    private Long id;
    private String name;
    private boolean approved; // UC11: admin approve/reject consultant

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