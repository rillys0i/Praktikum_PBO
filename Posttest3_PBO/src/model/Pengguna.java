package model;

public class Pengguna {
    protected String username;
    protected String password;
    protected String noTelepon;

    public Pengguna(String username, String password, String noTelepon) {
        this.username = username;
        this.password = password;
        this.noTelepon = noTelepon;
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getNoTelepon() { return noTelepon; }

    public void tampilkanInfo() {
        System.out.println("Username: " + username + " | No Telepon: " + noTelepon);
    }
}
