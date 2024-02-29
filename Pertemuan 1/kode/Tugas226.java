package kode;
import java.util.Scanner;

public class Tugas226 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int menu;
        do {
            System.out.println("Pilih Menu:");
            System.out.println("1. Hitung Kecepatan");
            System.out.println("2. Hitung Jarak");
            System.out.println("3. Hitung Waktu");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1-4): ");
            menu = sc.nextInt();

            switch (menu) {
                case 1:
                    hitungKecepatan();
                    break;
                case 2:
                    hitungJarak();
                    break;
                case 3:
                    hitungWaktu();
                    break;
                case 4:
                    System.out.println("Keluar Program.");
                    break;
                default:
                    System.out.println("Menu tidak ada.");
            }
        } while (menu != 4);
    }

    static void hitungKecepatan() {
        System.out.print("Masukkan jarak (km): ");
        double jarak = sc.nextDouble();
        System.out.print("Masukkan waktu (jam): ");
        double waktu = sc.nextDouble();

        double kecepatan = jarak / waktu;
        System.out.println("Kecepatan = " + kecepatan + " km/jam");
    }

    static void hitungJarak() {
        System.out.print("Masukkan kecepatan (km/jam): ");
        double kecepatan = sc.nextDouble();
        System.out.print("Masukkan waktu (jam): ");
        double waktu = sc.nextDouble();

        double jarak = kecepatan * waktu;
        System.out.println("Jarak = " + jarak + " km");
    }

    static void hitungWaktu() {
        System.out.print("Masukkan jarak (km): ");
        double jarak = sc.nextDouble();
        System.out.print("Masukkan kecepatan (km/jam): ");
        double kecepatan = sc.nextDouble();

        double waktu = jarak / kecepatan;
        System.out.println("Waktu = " + waktu + " jam");
    }
}