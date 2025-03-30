package model;

public class Pengelola extends Pengguna {
    public Pengelola(String username, String password, String noTelepon) {
        super(username, password, noTelepon); // Memanggil constructor dari Pengguna
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Pengelola: " + username + " | No Telepon: " + noTelepon);
    }
}
