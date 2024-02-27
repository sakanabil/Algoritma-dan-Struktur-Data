public class BukuMain26 {
    public static void main(String[] args) {
        Buku26 bk1 = new Buku26();
        bk1.judul = "Today Ends Tomorrow Comes";
        bk1.pengarang = "Denanda Pratiwi";
        bk1.halaman = 198;
        bk1.stok = 13;
        bk1.harga = 71000;

        bk1.tampilInformasi();
        bk1.terjual(5);
        bk1.gantiHarga(60000);
        bk1.tampilInformasi();

        Buku26 bk2 = new Buku26("Self Reward", "Maheera Ayesha", 160, 29, 59000);
        bk2.terjual(11);
        bk2.tampilInformasi();

        Buku26 bukuSakaNabil = new Buku26("Bumi", "Tere Liye", 516, 11, 96000);
        bukuSakaNabil.terjual(10);
        bukuSakaNabil.tampilInformasi();

        int totalHarga = bukuSakaNabil.hitungHargaTotal();
        System.out.println("Total harga: Rp " + totalHarga);
        
        int diskon = bukuSakaNabil.hitungDiskon();
        System.out.println("Diskon: " + diskon);
        
        int hitungHargaBayar = bukuSakaNabil.hitungHargaBayar();
        System.out.println("Total bayar: Rp " + hitungHargaBayar);
    }
}