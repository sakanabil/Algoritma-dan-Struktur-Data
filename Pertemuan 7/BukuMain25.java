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

            Buku25 m = new Buku25(Integer.toString(kodeBuku), judulBuku, tahunTerbit, pengarang, stock);
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
        int posisi = data.FindSeqSearch(Integer.toString(cari));
        data.TampilPosisi(cari, posisi);
        data.TampilData(cari, posisi);
        Buku25 dataBuku = data.FindBuku(Integer.toString(cari));
        dataBuku.tampilDataBuku();

        System.out.println("---------------------------------------------------");
        System.out.println("Mengguanakn Binary Search");
        posisi = data.FindBinarySearch(Integer.toString(cari));
        data.TampilPosisi(cari, posisi);
        data.TampilData(cari, posisi);

        System.out.println("Masukan Judul Buku yang dicari : ");
        System.out.print("Judul Buku : ");
        String cariJudul = s1.next();
        System.out.println("Menggunakan Sequential Search");
        int posisiJudulBukuSequential = data.FindJudulBukuSeq(cariJudul);
        data.TampilPosisi(cariJudul, posisiJudulBukuSequential);
        data.TampilData(cariJudul, posisiJudulBukuSequential);
        int jumlahJudulSequential = 0;
        for (Buku25 buku : data.listBk) {
            if (buku != null && buku.judulBuku.equals(cariJudul)) {
                jumlahJudulSequential++;
            }
        }
        if (jumlahJudulSequential > 1) {
            System.out.println("Peringatan: Terdapat lebih dari satu hasil dengan judul buku '" + cariJudul + "'!");
        }
        System.out.println("---------------------------------------");
        System.out.println("Menggunakan Binary Search");
        int posisiJudulBinary = data.findJudulBinary(cariJudul);
        data.TampilPosisi(cariJudul, posisiJudulBinary);
        data.TampilData(cariJudul, posisiJudulBinary);
        int jumlahJudulBinary = 0;
        for (Buku25 buku : data.listBk) {
            if (buku != null && buku.judulBuku.equals(cariJudul)) {
                jumlahJudulBinary++;
            }
        }
        if (jumlahJudulBinary > 1) {
            System.out.println("Peringatan: Terdapat lebih dari satu hasil dengan judul buku '" + cariJudul + "'!");
        }
    }
}