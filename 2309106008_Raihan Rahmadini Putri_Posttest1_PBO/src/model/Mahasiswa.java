package model;

public class Mahasiswa {
    private final String nim, nama, email, noTelepon, password;

    public Mahasiswa(String nim, String nama, String email, String noTelepon, String password) {
        this.nim = nim;
        this.nama = nama;
        this.email = email;
        this.noTelepon = noTelepon;
        this.password = password;
    }

    public String getNim() {
        return nim;
    }

    public String getPassword() {
        return password; // ✅ Sekarang password dibaca
    }

    public void tampilkan() {
        System.out.println("NIM: " + nim + ", Nama: " + nama + ", Email: " + email + ", No Telepon: " + noTelepon);
    }
}
