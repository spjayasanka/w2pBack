package com.w2p.model.dto;

public class UserOrganizationsDto {

    private int organizationId;
    private String username;


    public UserOrganizationsDto(int organizationId, String username) {
        this.organizationId = organizationId;
        this.username = username;
    }

    public UserOrganizationsDto() {
    }

    public int getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(int organizationId) {
        this.organizationId = organizationId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
