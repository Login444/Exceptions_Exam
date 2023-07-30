package org.example;

public class User {
    public String lastName;
    public String name;
    public String surname;
    public String dateOfBirth;
    public Long phoneNumber;
    public Character sex;

    public User(String lastName, String name, String surname, String dateOfBirth, Long phoneNumber, Character sex) {
        this.lastName = lastName;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
    }

    public User() {
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "<" + lastName + ">" +
                "<" + name + ">" +
                "<" + surname + ">" +
                "<" + dateOfBirth + ">" +
                "<" + phoneNumber + ">" +
                "<" + sex + ">";
    }
}
