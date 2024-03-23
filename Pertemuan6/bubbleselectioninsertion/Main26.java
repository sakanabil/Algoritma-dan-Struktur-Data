package Pertemuan6.bubbleselectioninsertion;

public class Main26 {
    public static void main(String[] args) {
        DaftarMahasiswaBerprestasi26 list = new DaftarMahasiswaBerprestasi26();
            Mahasiswa26 m1 = new Mahasiswa26("Nusa", 2017, 25, 3);
            Mahasiswa26 m2 = new Mahasiswa26("Rara", 2012, 19, 4);
            Mahasiswa26 m3 = new Mahasiswa26("Dopu", 2018, 19, 3.5);
            Mahasiswa26 m4 = new Mahasiswa26("Abdul", 2017, 23, 2);
            Mahasiswa26 m5 = new Mahasiswa26("Umi", 2019, 21, 3.75);

            list.tambah(m1);
            list.tambah(m2);
            list.tambah(m3);
            list.tambah(m4);
            list.tambah(m5);

            System.out.println("Data mahasiswa sebelum sorting = ");
            list.tampil();

            System.out.println("Data mahasiswa setelah sorting desc berdasarkan ipk");
            list.bubbleSort();
            list.tampil();

            System.out.println("Data mahasiswa setelah sorting asc berdasarkan ipk");
            list.selectionSort();
            list.tampil();

            System.out.println("Data mahasiswa setelah sorting desc berdasarkan ipk (menggunakan insertion sort)");
            list.insertionSort();
            list.tampil();
    }
}
