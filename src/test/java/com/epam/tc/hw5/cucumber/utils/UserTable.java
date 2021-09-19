package com.epam.tc.hw5.cucumber.utils;

public class UserTable {
    private Integer number = null;
    private String user = null;
    private String description = null;

    public UserTable(Integer number, String user, String description) {
        this.number = number;
        this.user = user;
        this.description = description;
    }

    public int getNumber() {
        return number;
    }

    public String getUser() {
        return user;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UserTable userTable = (UserTable) o;

        if (number != null ? !number.equals(userTable.number) : userTable.number != null) {
            return false;
        }
        if (user != null ? !user.equals(userTable.user) : userTable.user != null) {
            return false;
        }
        return description != null ? description.equals(userTable.description) : userTable.description == null;
    }

    @Override
    public int hashCode() {
        int result = number != null ? number.hashCode() : 0;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
