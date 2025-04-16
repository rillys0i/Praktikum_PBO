package model;

// Kelas LayananCuciKering
public class LayananCuciKering extends Layanan {
    public LayananCuciKering() {
        super("Cuci Kering", "2 Jam");
    }

    @Override
    public int hitungHarga(String jenisBarang) {
        if ("sprei".equalsIgnoreCase(jenisBarang)) {
            return 20000; // Harga untuk sprei
        } else {
            return 10000; // Harga untuk pakaian
        }
    }

    @Override
    public int getEstimasiHarga() {
        // Estimasi harga bisa berbeda-beda tergantung jenis layanan
        return 15000; // Misalnya estimasi harga untuk Cuci Kering
    }

    @Override
    public void tampilkanDetail() {
        System.out.println("Layanan: Cuci Kering");
        System.out.println("Perkiraan Waktu: " + getPerkiraanWaktu());
        System.out.println("Harga Pakaian: Rp 10.000");
        System.out.println("Harga Sprei: Rp 20.000");
    }

    @Override
    public String getNamaLayanan() {
        return "Cuci Kering";
    }

    @Override
    public String getPerkiraanWaktu() {
        return "2 Jam";
    }
}
