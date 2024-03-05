package Latihan2;

public class Mahasiswa26 {
    public String nama, nim, jenisKelamin;
    public double ipk;

    public Mahasiswa26(String nama, String nim, String jenisKelamin, double ipk) {
        this.nama = nama;
        this.nim = nim;
        this.jenisKelamin = jenisKelamin;
        this.ipk = ipk;
    }

    public static double hitungRataIPK(Mahasiswa26[] mhs) {
        double totalIPK = 0;
        for (Mahasiswa26 mahasiswa : mhs) {
            totalIPK += mahasiswa.ipk;
        }
        return totalIPK / mhs.length;
    }

    public static Mahasiswa26 mhsIPKTerbesar(Mahasiswa26[] mhs) {
        Mahasiswa26 IPKTerbesar = mhs[0];
        for (Mahasiswa26 mahasiswa : mhs) {
            if (mahasiswa.ipk > IPKTerbesar.ipk) {
                IPKTerbesar = mahasiswa;
            }
        }
        return IPKTerbesar;
    }
}