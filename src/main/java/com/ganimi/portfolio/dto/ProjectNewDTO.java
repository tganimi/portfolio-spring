package com.ganimi.portfolio.dto;

import java.io.Serializable;

public class ProjectNewDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String title;
    private String description;
    private Integer personalInfoId;

    public ProjectNewDTO() {}

    public ProjectNewDTO(String title, String description, Integer personalInfoId) {
        this.title = title;
        this.description = description;
        this.personalInfoId = personalInfoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPersonalInfoId() {
        return personalInfoId;
    }

    public void setPersonalInfoId(Integer personalInfoId) {
        this.personalInfoId = personalInfoId;
    }
}
