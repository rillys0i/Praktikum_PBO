package model;

public class LayananCuciKilat extends Layanan {
    public LayananCuciKilat() {
        super("Cuci Kilat", 20000, "1 Jam");
    }

    @Override
    public int hitungHarga(String jenisBarang) {
        if ("pakaian".equals(jenisBarang)) {
            return estimasiHarga;
        } else if ("sprei".equals(jenisBarang)) {
            return estimasiHarga + 10000; // Harga lebih mahal untuk sprei
        }
        return 0;
    }
}