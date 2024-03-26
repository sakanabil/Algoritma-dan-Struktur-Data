package Pertemuan6;

public class Hotel25 {
    String nama, kota;
    int harga;
    Byte rating;

    Hotel25(String n, String k, int h, Byte r) {
        nama = n;
        kota = k;
        harga = h;
        rating = r;
    }

    void tampil() {
        System.out.println("Nama : " + nama);
        System.out.println("Kota : " + kota);
        System.out.println("Harga : Rp." + harga);
        System.out.println("Bintang : " + rating);
    }
}
