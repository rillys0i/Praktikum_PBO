package model;

public class Pesanan {
    private final String idPesanan;
    private final String nimMahasiswa;
    private final Layanan layanan;
    private String status;
    private final String jenisBarang;

    // Static field dan method
    private static int totalPesanan = 0;

    public static int getTotalPesanan() {
        return totalPesanan;
    }

    public Pesanan(String idPesanan, String nimMahasiswa, Layanan layanan, String status, String jenisBarang) {
        this.idPesanan = idPesanan;
        this.nimMahasiswa = nimMahasiswa;
        this.layanan = layanan;
        this.status = status;
        this.jenisBarang = jenisBarang;

        // Setiap kali ada pesanan dibuat, counter bertambah
        totalPesanan++;
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
