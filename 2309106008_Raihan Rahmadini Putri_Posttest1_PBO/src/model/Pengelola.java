package model;

public class Pengelola {
    private final String username;
    private final String password;

    public Pengelola(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
