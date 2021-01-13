package com.w2p.model.dto;

public class InvitationDto {
    private int id;
    private String memberEmail;
    private String status;
    private int organizationId;
    private String username;

    public InvitationDto() {
    }

    public InvitationDto(String memberEmail, String status, int organizationId, String username) {
        this.memberEmail = memberEmail;
        this.status = status;
        this.organizationId = organizationId;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
