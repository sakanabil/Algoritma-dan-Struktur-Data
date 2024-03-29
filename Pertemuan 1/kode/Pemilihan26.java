package kode;
import java.util.Scanner;

public class Pemilihan26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Program Menghitung Nilai Akhir");

        System.out.println("============================");
        System.out.print("Masukkan nilai Tugas: ");
        double tugas = sc.nextDouble();

        System.out.print("Masukkan nilai Kuis: ");
        double kuis = sc.nextDouble();

        System.out.print("Masukkan nilai UTS: ");
        double uts = sc.nextDouble();

        System.out.print("Masukkan nilai UAS: ");
        double uas = sc.nextDouble();
        System.out.println("============================");

        if (!isValid(tugas) || !isValid(kuis) || !isValid(uts) || !isValid(uas)) {
            System.out.println("============================");
            System.out.println("Nilai tidak valid");
            System.out.println("============================");
            System.out.println("============================");
        } else {
            double nilaiAkhir = 0.2 * tugas + 0.2 * kuis + 0.3 * uts + 0.3 * uas;
            String nilaiHuruf;
            if (nilaiAkhir >= 80) {
                nilaiHuruf = "A";
            } else if (nilaiAkhir >= 73) {
                nilaiHuruf = "B+";
            } else if (nilaiAkhir >= 65) {
                nilaiHuruf = "B";
            } else if (nilaiAkhir >= 60) {
                nilaiHuruf = "C+";
            } else if (nilaiAkhir >= 50) {
                nilaiHuruf = "C";
            } else if (nilaiAkhir >= 39) {
                nilaiHuruf = "D";
            } else {
                nilaiHuruf = "E";
            }

            String keterangan = nilaiHuruf.equals("D") || nilaiHuruf.equals("E") ? "ANDA TIDAK LULUS"
                    : "SELAMAT ANDA LULUS";

            System.out.println("============================");
            System.out.println("Nilai Akhir: " + nilaiAkhir);
            System.out.println("Nilai Huruf: " + nilaiHuruf);
            System.out.println("============================");
            System.out.println("============================");
            System.out.println(keterangan);
        }
    }

    public static boolean isValid(double nilai) {
        return nilai >= 0 && nilai <= 100;
    }
}