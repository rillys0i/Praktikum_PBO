package model;

public final class LayananCuciSetrika extends Layanan {
    public LayananCuciSetrika() {
        super("Cuci Setrika", 15000, "3 Jam");
    }

    @Override
    public int hitungHarga(String jenisBarang) {
        if ("pakaian".equals(jenisBarang)) {
            return estimasiHarga;
        } else if ("sprei".equals(jenisBarang)) {
            return estimasiHarga + 7000; // Harga lebih mahal untuk sprei
        }
        return 0;
    }
}