import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Pengguna {
    protected String nama;
    protected String noTelepon;

    public Pengguna(String nama, String noTelepon) {
        this.nama = nama;
        this.noTelepon = noTelepon;
    }

    public void tampilkanData() {
        System.out.println("Nama: " + nama + " | No Telepon: " + noTelepon);
    }
}

class Mahasiswa extends Pengguna {
    private final String nim;
    private final String email;
    private final List<Pesanan> pesananList = new ArrayList<>();

    public Mahasiswa(String nama, String noTelepon, String nim, String email) {
        super(nama, noTelepon);
        this.nim = nim;
        this.email = email;
    }

    public void buatPesanan(String layanan, int jumlah) {
        pesananList.add(new Pesanan(layanan, jumlah, "Diproses"));
        System.out.println("Pesanan berhasil dibuat!");
    }

    public List<Pesanan> getPesananList() {
        return pesananList;
    }

    @Override
    public void tampilkanData() {
        System.out.println("NIM: " + nim + " | Nama: " + nama + " | Email: " + email + " | No Telepon: " + noTelepon);
    }
}

class Pengelola extends Pengguna {
    private final String username;

    public Pengelola(String nama, String noTelepon, String username) {
        super(nama, noTelepon);
        this.username = username;
    }

    public void perbaruiStatusPesanan(Pesanan pesanan, String statusBaru) {
        pesanan.setStatus(statusBaru);
        System.out.println("Status pesanan diperbarui menjadi: " + statusBaru);
    }

    @Override
    public void tampilkanData() {
        System.out.println("Pengelola: " + username + " | No Telepon: " + noTelepon);
    }
}

class Pesanan {
    private final String layanan;
    private final int jumlah;
    private String status;

    public Pesanan(String layanan, int jumlah, String status) {
        this.layanan = layanan;
        this.jumlah = jumlah;
        this.status = status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLayanan() {
        return layanan;
    }

    public int getJumlah() {
        return jumlah;
    }

    public String getStatus() {
        return status;
    }
}

public class App {
    private static final List<Pengguna> penggunaList = new ArrayList<>();
    private static final List<Pesanan> pesananList = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("=== Program Data Pengguna ===");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Tambah Pengelola");
            System.out.println("3. Lihat Semua Pengguna");
            System.out.println("4. Edit Pengguna");
            System.out.println("5. Hapus Pengguna");
            System.out.println("6. Buat Pesanan (Mahasiswa)");
            System.out.println("7. Perbarui Status Pesanan (Pengelola)");
            System.out.println("8. Lihat Semua Pesanan");
            System.out.println("9. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1 -> tambahMahasiswa();
                case 2 -> tambahPengelola();
                case 3 -> tampilkanSemuaPengguna();
                case 4 -> editPengguna();
                case 5 -> hapusPengguna();
                case 6 -> buatPesanan();
                case 7 -> perbaruiStatusPesanan();
                case 8 -> tampilkanSemuaPesanan();
                case 9 -> {
                    System.out.println("Program selesai.");
                    System.exit(0);
                }
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void tambahMahasiswa() {
        System.out.print("Masukkan Nama: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan No Telepon: ");
        String noTelepon = scanner.nextLine();
        System.out.print("Masukkan NIM: ");
        String nim = scanner.nextLine();
        System.out.print("Masukkan Email: ");
        String email = scanner.nextLine();

        penggunaList.add(new Mahasiswa(nama, noTelepon, nim, email));
        System.out.println("Mahasiswa berhasil ditambahkan!");
    }

    private static void tambahPengelola() {
        System.out.print("Masukkan Nama: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan No Telepon: ");
        String noTelepon = scanner.nextLine();
        System.out.print("Masukkan Username: ");
        String username = scanner.nextLine();

        penggunaList.add(new Pengelola(nama, noTelepon, username));
        System.out.println("Pengelola berhasil ditambahkan!");
    }

    private static void tampilkanSemuaPengguna() {
        if (penggunaList.isEmpty()) {
            System.out.println("Belum ada pengguna.");
        } else {
            for (Pengguna pengguna : penggunaList) {
                pengguna.tampilkanData();
            }
        }
    }

    private static void editPengguna() {
        System.out.print("Masukkan Nama Pengguna yang Ingin Diedit: ");
        String nama = scanner.nextLine();

        for (Pengguna pengguna : penggunaList) {
            if (pengguna.nama.equals(nama)) {
                System.out.print("Masukkan Nama Baru: ");
                pengguna.nama = scanner.nextLine();
                System.out.print("Masukkan No Telepon Baru: ");
                pengguna.noTelepon = scanner.nextLine();
                System.out.println("Data pengguna berhasil diperbarui!");
                return;
            }
        }
        System.out.println("Pengguna tidak ditemukan.");
    }

    private static void hapusPengguna() {
        System.out.print("Masukkan Nama Pengguna yang Ingin Dihapus: ");
        String nama = scanner.nextLine();

        for (int i = 0; i < penggunaList.size(); i++) {
            if (penggunaList.get(i).nama.equals(nama)) {
                penggunaList.remove(i);
                System.out.println("Pengguna berhasil dihapus!");
                return;
            }
        }
        System.out.println("Pengguna tidak ditemukan.");
    }

    private static void buatPesanan() {
        System.out.print("Masukkan Nama Mahasiswa: ");
        String nama = scanner.nextLine();

        for (Pengguna pengguna : penggunaList) {
            if (pengguna instanceof Mahasiswa mahasiswa && mahasiswa.nama.equals(nama)) {
                System.out.print("Masukkan Layanan: ");
                String layanan = scanner.nextLine();
                System.out.print("Masukkan Jumlah: ");
                int jumlah = scanner.nextInt();
                scanner.nextLine();

                Pesanan pesanan = new Pesanan(layanan, jumlah, "Diproses");
                pesananList.add(pesanan);
                System.out.println("Pesanan berhasil dibuat!");
                return;
            }
        }
        System.out.println("Mahasiswa tidak ditemukan.");
    }

    private static void perbaruiStatusPesanan() {
        System.out.print("Masukkan index pesanan yang ingin diperbarui: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index >= 0 && index < pesananList.size()) {
            System.out.print("Masukkan Status Baru: ");
            String statusBaru = scanner.nextLine();
            pesananList.get(index).setStatus(statusBaru);
            System.out.println("Status pesanan diperbarui.");
        } else {
            System.out.println("Index pesanan tidak valid.");
        }
    }

    private static void tampilkanSemuaPesanan() {
        if (pesananList.isEmpty()) {
            System.out.println("Belum ada pesanan.");
        } else {
            for (int i = 0; i < pesananList.size(); i++) {
                Pesanan p = pesananList.get(i);
                System.out.println(i + ". Layanan: " + p.getLayanan() + ", Jumlah: " + p.getJumlah() + ", Status: " + p.getStatus());
            }
        }
    }
}
