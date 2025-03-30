package model;

public class Mahasiswa extends Pengguna {
    private final String nim;
    private final String email;

    public Mahasiswa(String nim, String username, String email, String noTelepon, String password) {
        super(username, password, noTelepon); // Memanggil constructor dari Pengguna
        this.nim = nim;
        this.email = email;
    }

    public String getNim() { return nim; }
    public String getEmail() { return email; }

    @Override
    public void tampilkanInfo() {
        System.out.println("NIM: " + nim + " | Nama: " + username + " | Email: " + email + " | No Telepon: " + noTelepon);
    }
}