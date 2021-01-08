package com.w2p.model.dto;

public class OrganizationDto {
    private String name;
    private String Description;
    private String orgUserName;

    public OrganizationDto(String name, String description, String orgUserName) {
        this.name = name;
        Description = description;
        this.orgUserName = orgUserName;
    }

    public String getOrgUserName() {
        return orgUserName;
    }

    public void setOrgUserName(String orgUserName) {
        this.orgUserName = orgUserName;
    }

    public OrganizationDto() {
    }

    public OrganizationDto(String name, String description) {
        this.name = name;
        Description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
