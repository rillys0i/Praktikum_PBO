package model;

public abstract class Layanan {
    private final String namaLayanan;
    private final String perkiraanWaktu;

    public Layanan(String namaLayanan, String perkiraanWaktu) {
        this.namaLayanan = namaLayanan;
        this.perkiraanWaktu = perkiraanWaktu;
    }

    public String getNamaLayanan() {
        return namaLayanan;
    }

    public String getPerkiraanWaktu() {
        return perkiraanWaktu;
    }

    @Override
    public String toString() {
        return "Nama Layanan: " + namaLayanan + ", Perkiraan Waktu: " + perkiraanWaktu;
    }

    // Method Abstrak untuk menghitung harga
    public abstract int hitungHarga(String jenisBarang);  // Menghitung harga berdasarkan jenis barang

    public abstract int getEstimasiHarga();

    // Method Abstrak untuk menampilkan detail layanan
    public abstract void tampilkanDetail();
}
