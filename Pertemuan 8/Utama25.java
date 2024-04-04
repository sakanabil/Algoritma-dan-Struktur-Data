import java.util.Scanner;
public class Utama25 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Masukkan kapasitas Gudang: ");
        int kapasitas = scanner.nextInt();
        Gudang25 gudang = new Gudang25(kapasitas);
        
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah barang");
            System.out.println("2. Ambil barang");
            System.out.println("3. Tampilkan tumpukan barang");
            System.out.println("4. Tampilkan barang teratas");
            System.out.println("5. Tampilkan barang terbawah");
            System.out.println("6. Cari barang berdasarkan kode");
            System.out.println("7. Cari barang berdasarkan nama");
            System.out.println("8. Keluar");
            System.out.print("Pilih operasi: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();
        
            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan kode barang: ");
                    int kode = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Masukkan nama barang: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan nama kategori: ");
                    String kategori = scanner.nextLine();
                    Barang25 barangBaru = new Barang25(kode, nama, kategori);
                    gudang.tambahBarang(barangBaru);
                    break;
                case 2:
                    gudang.ambilBarang();
                    break;
                case 3:
                    gudang.tampilkanBarang();
                    break;
                case 4:
                    gudang.lihatBarangTeratas();
                    break;
                case 5:
                    gudang.lihatBarangTerbawah();
                    break;
                case 6:
                    System.out.println("Masukkan kode barang yang ingin dicari: ");
                    int kodeCari = scanner.nextInt();
                    Barang25 barangDitemukanKode = gudang.cariBarangKode(kodeCari);
                    if (barangDitemukanKode != null) {
                        System.out.println("Barang ditemukan berdasarkan kode: " + barangDitemukanKode.nama);
                    } else {
                        System.out.println("Barang tidak ditemukan.");
                    }
                    break;
                case 7:
                    System.out.println("Masukkan nama barang yang ingin dicari: ");
                    String namaCari = scanner.nextLine();
                    Barang25 barangDitemukanNama = gudang.cariBarangNama(namaCari);
                    if (barangDitemukanNama != null) {
                        System.out.println("Barang ditemukan berdasarkan nama: " + barangDitemukanNama.nama);
                    } else {
                        System.out.println("Barang tidak ditemuka.");
                    }
                    break;
                case 8:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                
            }
        }
    }
}
