package com.example.androiddemo.model;

public class UserModel {

  private int id;
  private String name;
  private String email;
  private String mobile;
  private String avatar;
  private int mainDepartmentId;
  private String position;
  private int gender;
  private int isDeparture;
  private int isDisable;
  private String joinDate;
  private String mainDepartmentName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getMainDepartmentId() {
        return mainDepartmentId;
    }

    public void setMainDepartmentId(int mainDepartmentId) {
        this.mainDepartmentId = mainDepartmentId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getIsDeparture() {
        return isDeparture;
    }

    public void setIsDeparture(int isDeparture) {
        this.isDeparture = isDeparture;
    }

    public int getIsDisable() {
        return isDisable;
    }

    public void setIsDisable(int isDisable) {
        this.isDisable = isDisable;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public String getMainDepartmentName() {
        return mainDepartmentName;
    }

    public void setMainDepartmentName(String mainDepartmentName) {
        this.mainDepartmentName = mainDepartmentName;
    }
}
