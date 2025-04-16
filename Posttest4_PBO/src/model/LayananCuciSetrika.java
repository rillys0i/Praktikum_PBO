package model;

public class LayananCuciSetrika extends Layanan {

    public LayananCuciSetrika() {
        super("Cuci Setrika", "3 Jam");
    }

    @Override
    public int hitungHarga(String jenisBarang) {
        if ("sprei".equalsIgnoreCase(jenisBarang)) {
            return 25000;
        } else {
            return 15000;
        }
    }

    @Override
    public int getEstimasiHarga() {
        return 20000; // Estimasi harga rata-rata
    }

    @Override
    public void tampilkanDetail() {
        System.out.println("Layanan: Cuci Setrika");
        System.out.println("Perkiraan Waktu: " + getPerkiraanWaktu());
        System.out.println("Harga Pakaian: Rp 15.000");
        System.out.println("Harga Sprei: Rp 25.000");
    }

    @Override
    public String getNamaLayanan() {
        return "Cuci Setrika";
    }

    @Override
    public String getPerkiraanWaktu() {
        return "3 Jam";
    }
}
