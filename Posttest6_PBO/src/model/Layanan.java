package model;

public abstract class Layanan {

    public final String namaLayanan;
    public final int estimasiHarga;
    public final String perkiraanWaktu;

    public Layanan(String namaLayanan, int estimasiHarga, String perkiraanWaktu) {
        this.namaLayanan = namaLayanan;
        this.estimasiHarga = estimasiHarga;
        this.perkiraanWaktu = perkiraanWaktu;
    }

    public abstract int hitungHarga(String jenisBarang);

    public final String getNamaLayanan() {
        return namaLayanan;
    }

    public String getPerkiraanWaktu() {
        return perkiraanWaktu;
    }

    public int getEstimasiHarga() {
        return estimasiHarga;
    }
}
