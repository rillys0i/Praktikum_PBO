package model;

public class LayananCuciKilat extends Layanan {

    public LayananCuciKilat() {
        super("Cuci Kilat", "1 Jam");
    }

    @Override
    public int hitungHarga(String jenisBarang) {
        if ("sprei".equalsIgnoreCase(jenisBarang)) {
            return 30000;
        } else {
            return 20000;
        }
    }

    @Override
    public int getEstimasiHarga() {
        return 25000; // Estimasi harga rata-rata
    }

    @Override
    public void tampilkanDetail() {
        System.out.println("Layanan: Cuci Kilat");
        System.out.println("Perkiraan Waktu: " + getPerkiraanWaktu());
        System.out.println("Harga Pakaian: Rp 20.000");
        System.out.println("Harga Sprei: Rp 30.000");
    }

    @Override
    public String getNamaLayanan() {
        return "Cuci Kilat";
    }

    @Override
    public String getPerkiraanWaktu() {
        return "1 Jam";
    }
}
