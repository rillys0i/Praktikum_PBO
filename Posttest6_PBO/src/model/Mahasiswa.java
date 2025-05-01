package model;

public class Mahasiswa {
    private final String nim;
    private String nama;
    private String email;
    private String noTelepon;
    private String password;

    // Constructor
    public Mahasiswa(String nim, String nama, String email, String noTelepon, String password) {
        this.nim = nim;
        this.nama = nama;
        this.email = email;
        this.noTelepon = noTelepon;
        this.password = password;
    }

    // Getter
    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public String getEmail() {
        return email;
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public String getPassword() {
        return password;
    }

    public void setNama(String nama) {
        if (!nama.trim().isEmpty()) {
            this.nama = nama;
        } else {
            System.out.println("⚠️ Nama tidak boleh kosong!");
        }
    }

    public void setEmail(String email) {
        if (email.contains("@")) {
            this.email = email;
        } else {
            System.out.println("⚠️ Email tidak valid!");
        }
    }

    public void setNoTelepon(String noTelepon) {
        if (noTelepon.matches("\\d{10,13}")) { 
            this.noTelepon = noTelepon;
        } else {
            System.out.println("⚠️ No telepon tidak valid!");
        }
    }

    public void setPassword(String password) {
        if (password.length() >= 6) { 
            this.password = password;
        } else {
            System.out.println("⚠️ Password harus minimal 6 karakter!");
        }
    }

    public void tampilkan() {
        System.out.println("NIM: " + nim + ", Nama: " + nama + ", Email: " + email + ", No Telepon: " + noTelepon);
    }
}
