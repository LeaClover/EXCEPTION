package com.gb.java.data;

public class User {

    private String lastname;
    private String firstname;
    private String patronymic;
    private String birthday;
    private Long phone;
    private char gender;
    
    public User(String lastname, String firstname, String patronymic, String birthday, Long phone, char gender) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.phone = phone;
        this.gender = gender;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "lastname=" + lastname + ", firstname=" + firstname + ", patronymic=" + patronymic + ", birthday="
                + birthday + ", phone=" + phone + ", gender=" + gender;
    }
}
