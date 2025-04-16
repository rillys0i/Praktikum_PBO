package model;

public class Pesanan {
    private final String idPesanan;
    private final String nimMahasiswa;
    private final Layanan layanan;
    private final String jenisBarang; // Menambahkan jenisBarang untuk menentukan harga
    private final int estimasiHarga;
    private final String perkiraanWaktu;
    private String status; // Status bisa berubah

    public Pesanan(String idPesanan, String nimMahasiswa, Layanan layanan, String perkiraanWaktu, String jenisBarang) {
        this.idPesanan = idPesanan;
        this.nimMahasiswa = nimMahasiswa;
        this.layanan = layanan;
        this.jenisBarang = jenisBarang; // Menyimpan jenis barang
        this.estimasiHarga = layanan.hitungHarga(jenisBarang); // Menggunakan hitungHarga() dari layanan
        this.perkiraanWaktu = perkiraanWaktu;
        this.status = "Menunggu"; // Status default
    }

    public String getIdPesanan() {
        return idPesanan;
    }

    public String getNimMahasiswa() {
        return nimMahasiswa;
    }

    public Layanan getLayanan() {
        return layanan;
    }

    public int getEstimasiHarga() {
        return estimasiHarga;
    }

    public String getPerkiraanWaktu() {
        return perkiraanWaktu;
    }

    public String getStatus() {
        return status;
    }

    // Setter dengan validasi status
    public void setStatus(String status) {
        if (status.equalsIgnoreCase("Menunggu") || 
            status.equalsIgnoreCase("Diproses") || 
            status.equalsIgnoreCase("Selesai") || 
            status.equalsIgnoreCase("Dibatalkan")) {
            this.status = status;
        } else {
            System.out.println("⚠️ Status tidak valid! Gunakan: Menunggu, Diproses, Selesai, atau Dibatalkan.");
        }
    }

    public String getJenisBarang() {
        return jenisBarang;
    }
}
