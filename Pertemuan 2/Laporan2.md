# LAPORAN PRAKTIKUM II ALGORITMA DAN STRUKTUR DATA
### Nama : Saka Nabil
### NIM : 2341720108
### Kelas : TI-1B
### Absen : 26

#### 2. Praktikum
#### 2.1 Percobaan 1: Deklarasi Class, Atribut dan Method
``` java
public class Buku26 {
    String judul, pengarang;
    int halaman, stok, harga;

    void tampilInformasi() {
        System.out.println("Judul: " + judul);
        System.out.println("Pengarang: " + pengarang);
        System.out.println(" Jumlah halaman: " + halaman);
        System.out.println("Sisa stok: " + stok);
        System.out.println("Harga: Rp " + harga);
    }

    void terjual(int jml) {
        stok -= jml;
    }

    void restock(int jml) {
        stok += jml;
    }

    void gantiHarga(int hrg) {
        harga = hrg;
    }
}
```
#### 2.1.2 Verifikasi Hasil Percobaan
![Verivikasi](<../Screenshot (354).png>)

#### 2.2 Percobaan 2: Instansiasi Object, serta Mengakses Atribut dan Method
``` java
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
    }
}
```
#### 2.2.2 Verifikasi Hasil Percobaan
![verivikasi](<../Screenshot 2024-02-21 130700.png>)