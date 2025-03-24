package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import model.Mahasiswa;
import model.Pengelola;
import model.Pesanan;

public class LaundryService {
    private final  List<Mahasiswa> mahasiswaList = new ArrayList<>();
    private final List<Pengelola> pengelolaList = new ArrayList<>();
    private final List<Pesanan> pesananList = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);
    private Mahasiswa loggedInMahasiswa = null;
    private Pengelola loggedInPengelola = null;

    public void mulai() {
        pengelolaList.add(new Pengelola("admin", "admin123"));

        while (true) {
            System.out.println("\n1. Daftar Mahasiswa\n2. Login Mahasiswa\n3. Login Pengelola\n4. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1 -> daftarMahasiswa();
                case 2 -> loginMahasiswa();
                case 3 -> loginPengelola();
                case 4 -> { return; }
                default -> System.out.println("Pilihan tidak valid!");
            }
        }
    }

    private void daftarMahasiswa() {
        System.out.print("NIM: ");
        String nim = scanner.nextLine();
        System.out.print("Nama: ");
        String nama = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("No Telepon: ");
        String noTelepon = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        mahasiswaList.add(new Mahasiswa(nim, nama, email, noTelepon, password));
        System.out.println("Mahasiswa berhasil terdaftar!");
    }

    private void loginMahasiswa() {
        System.out.print("NIM: ");
        String nim = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        for (Mahasiswa m : mahasiswaList) {
            if (m.getNim().equals(nim) && m.getPassword().equals(password)) {
                loggedInMahasiswa = m;
                menuMahasiswa();
                return;
            }
        }
        System.out.println("Login gagal! Periksa NIM dan password.");
    }

    private void loginPengelola() {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        for (Pengelola p : pengelolaList) {
            if (p.getUsername().equals(username) && p.getPassword().equals(password)) {
                loggedInPengelola = p;
                menuPengelola();
                return;
            }
        }
        System.out.println("Login gagal! Periksa username dan password.");
    }

    private void menuMahasiswa() {
        while (true) {
            System.out.println("\n1. Buat Pesanan\n2. Lihat Pesanan Saya\n3. Logout");
            System.out.print("Pilih menu: ");
    
            int pilihan;
            try {
                pilihan = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Input harus berupa angka! Silakan coba lagi.");
                continue;
            }
    
            switch (pilihan) {
                case 1 -> buatPesanan();
                case 2 -> lihatPesananMahasiswa();
                case 3 -> {
                    loggedInMahasiswa = null;
                    return;
                }
                default -> System.out.println("⚠️ Pilihan tidak valid! Silakan pilih 1-3.");
            }
        }
    }
    

    private void menuPengelola() {
        if (loggedInPengelola == null) {
            System.out.println("Anda belum login sebagai pengelola!");
            return;
        }
    
        while (true) {
            System.out.println("\n1. Perbarui Status Pesanan\n2. Hapus Pesanan\n3. Lihat Laporan Transaksi\n4. Logout");
            System.out.print("Pilih menu: ");
    
            int pilihan;
            try {
                pilihan = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Input harus berupa angka! Silakan coba lagi.");
                continue;
            }
    
            switch (pilihan) {
                case 1 -> perbaruiStatusPesanan();
                case 2 -> hapusPesanan();
                case 3 -> lihatLaporanTransaksi();
                case 4 -> {
                    System.out.println("Logout berhasil, " + loggedInPengelola.getUsername());
                    loggedInPengelola = null;
                    return;
                }
                default -> System.out.println("⚠️ Pilihan tidak valid! Silakan pilih 1-4.");
            }
        }
    }
    
    

    private void buatPesanan() {
        String idPesanan = "PSN-" + UUID.randomUUID().toString().substring(0, 8); // ID otomatis
        System.out.println("ID Pesanan: " + idPesanan);
    
        // Pilih layanan dengan validasi input
        int pilihan;
        while (true) {
            System.out.println("Pilih layanan:");
            System.out.println("1. Cuci Kering - Rp 10.000 - 2 Jam");
            System.out.println("2. Cuci Setrika - Rp 15.000 - 3 Jam");
            System.out.println("3. Cuci Kilat - Rp 20.000 - 1 Jam");
            System.out.print("Pilihan: ");
            
            try {
                pilihan = Integer.parseInt(scanner.nextLine()); // Gunakan nextLine() agar tidak ada bug newline
                if (pilihan >= 1 && pilihan <= 3) break; // Jika input valid, keluar dari loop
                System.out.println("⚠️ Pilihan tidak valid! Masukkan angka 1-3.");
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Input harus berupa angka! Silakan coba lagi.");
            }
        }
    
        // Menentukan layanan berdasarkan pilihan
        String layanan = "";
        int estimasiHarga = 0;
        String perkiraanWaktu = "";
    
        switch (pilihan) {
            case 1 -> {
                layanan = "Cuci Kering";
                estimasiHarga = 10000;
                perkiraanWaktu = "2 Jam";
            }
            case 2 -> {
                layanan = "Cuci Setrika";
                estimasiHarga = 15000;
                perkiraanWaktu = "3 Jam";
            }
            case 3 -> {
                layanan = "Cuci Kilat";
                estimasiHarga = 20000;
                perkiraanWaktu = "1 Jam";
            }
        }
    
        // Simpan pesanan ke daftar
        pesananList.add(new Pesanan(idPesanan, loggedInMahasiswa.getNim(), layanan, estimasiHarga, perkiraanWaktu));
        System.out.println("✅ Pesanan berhasil dibuat dengan ID: " + idPesanan);
        System.out.println("🔹 Layanan: " + layanan);
        System.out.println("💰 Estimasi Harga: Rp " + estimasiHarga);
        System.out.println("⏳ Perkiraan Waktu: " + perkiraanWaktu);
    }    
    

    private void lihatPesananMahasiswa() {
        boolean adaPesanan = false;
        for (Pesanan p : pesananList) {
            if (p.getNimMahasiswa().equals(loggedInMahasiswa.getNim())) {
                System.out.println("ID: " + p.getIdPesanan() + " | Layanan: " + p.getLayanan() +
                        " | Harga: Rp " + p.getEstimasiHarga() + " | Waktu: " + p.getPerkiraanWaktu() +
                        " | Status: " + p.getStatus());
                adaPesanan = true;
            }
        }
        if (!adaPesanan) {
            System.out.println("⚠️ Anda belum memiliki pesanan.");
        }
    }    

    public List<Mahasiswa> getMahasiswaList() {
        return new ArrayList<>(mahasiswaList);
    }

    public List<Pengelola> getPengelolaList() {
        return new ArrayList<>(pengelolaList);
    }

    public List<Pesanan> getPesananList() {
        return new ArrayList<>(pesananList);
    }
    

    private void perbaruiStatusPesanan() {
        while (true) {
            System.out.print("Masukkan ID pesanan yang ingin diperbarui: ");
            String id = scanner.nextLine();
    
            for (Pesanan p : pesananList) {
                if (p.getIdPesanan().equals(id)) {
                    System.out.print("Masukkan status baru: ");
                    p.setStatus(scanner.nextLine());
                    System.out.println("✅ Status pesanan diperbarui!");
                    return;
                }
            }
    
            System.out.println("⚠️ ID tidak ditemukan! Coba lagi.");
        }
    }
    

    private void hapusPesanan() {
        System.out.print("Masukkan ID pesanan yang ingin dihapus: ");
        String id = scanner.nextLine();
        pesananList.removeIf(p -> p.getIdPesanan().equals(id));
        System.out.println("Pesanan dihapus!");
    }

    private void lihatLaporanTransaksi() {
        System.out.println("Total pesanan: " + pesananList.size());
    }
}
