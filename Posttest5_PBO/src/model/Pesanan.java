package model;

public class Pesanan {
    private final String idPesanan;
    private final String nimMahasiswa;
    private final Layanan layanan; // Tipe Layanan bisa berubah sesuai jenis layanan yang dipilih
    private String status;
    private final String jenisBarang;

    public Pesanan(String idPesanan, String nimMahasiswa, Layanan layanan, String status, String jenisBarang) {
        this.idPesanan = idPesanan;
        this.nimMahasiswa = nimMahasiswa;
        this.layanan = layanan;
        this.status = status;
        this.jenisBarang = jenisBarang;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getJenisBarang() {
        return jenisBarang;
    }

    public int getEstimasiHarga() {
        return layanan.hitungHarga(jenisBarang); 
    }

    public String getPerkiraanWaktu() {
        return layanan.getPerkiraanWaktu(); 
    }
}
