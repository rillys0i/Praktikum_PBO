package service;

public class NotifikasiConsole implements Notifikasi {
    @Override
    public void kirimNotifikasi(String pesan) {
        System.out.println("[NOTIFIKASI] " + pesan);
    }
}