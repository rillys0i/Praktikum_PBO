package model;

public class Pesanan {
    private final String idPesanan;
    private final String nimMahasiswa;
    private final String layanan;
    private final int estimasiHarga;
    private final String perkiraanWaktu;
    private String status; // Status bisa berubah

    public Pesanan(String idPesanan, String nimMahasiswa, String layanan, int estimasiHarga, String perkiraanWaktu) {
        this.idPesanan = idPesanan;
        this.nimMahasiswa = nimMahasiswa;
        this.layanan = layanan;
        this.estimasiHarga = estimasiHarga;
        this.perkiraanWaktu = perkiraanWaktu;
        this.status = "Menunggu"; // Status default
    }

    public String getIdPesanan() {
        return idPesanan;
    }

    public String getNimMahasiswa() {
        return nimMahasiswa;
    }

    public String getLayanan() {
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
}
