package model;

public class LayananCuciKering extends Layanan {
    public LayananCuciKering() {
        super("Cuci Kering", 10000, "2 Jam");
    }

    @Override
    public int hitungHarga(String jenisBarang) {
        if ("pakaian".equals(jenisBarang)) {
            return estimasiHarga;
        } else if ("sprei".equals(jenisBarang)) {
            return estimasiHarga + 5000; // Harga lebih mahal untuk sprei
        }
        return 0;
    }
}