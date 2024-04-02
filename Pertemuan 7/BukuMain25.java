import java.util.Scanner;

public class BukuMain25 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);

        PencarianBuku25 data = new PencarianBuku25();
        int jumBuku = 5;

        System.out.println("----------------------------------------------------");
        System.out.println("Masukkan data Buku secara Urut dari KodeBuku Terkecil : ");
        for (int i = 0; i < jumBuku; i++) {
            System.out.print("Kode Buku \t: ");
            int kodeBuku = s.nextInt();
            System.out.print("Judul Buku \t: ");
            String judulBuku = s1.nextLine();
            System.out.print("Tahun Terbit \t: ");
            int tahunTerbit = s.nextInt();
            System.out.print("Pengarang \t: ");
            String pengarang = s1.nextLine();
            System.out.print("Stock \t\t: ");
            int stock = s.nextInt();
        System.out.println("-------------------------");

            Buku25 m = new Buku25(kodeBuku, judulBuku, tahunTerbit, pengarang, stock);
            data.tambah(m);
        }
        System.out.println("---------------------------------------------------");
        System.out.println("Data keseluruhan Buku : ");
        data.tampil();

        System.out.println("---------------------------------------------------");
        System.out.println("---------------------------------------------------");
        System.out.println("Pencarian Data : ");
        System.out.print("Masukkan kode buku yang dicari :");
        int cari = s.nextInt();
        System.out.println("Menggunakan sequential Search");
        int posisi = data.FindSeqSearch(cari);
        data.TampilPosisi(cari, posisi);
        data.TampilData(cari, posisi);

        System.out.println("---------------------------------------------------");
        System.out.println("Mengguanakn Binary Search");
        posisi = data.FindBinarySearch(cari);
        data.TampilPosisi(cari, posisi);
        data.TampilData(cari, posisi);
    }
}