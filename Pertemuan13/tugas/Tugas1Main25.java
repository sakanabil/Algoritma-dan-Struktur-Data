package Pertemuan13.tugas;

import java.util.Scanner;

public class Tugas1Main25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Queue25 vaksin = new Queue25();
        vaksin.menu();
        int pilih = sc.nextInt();
        while (pilih != 4) {
            if (pilih == 1) {
                System.out.println("-------------------------------");
                System.out.println("Masukkan data penerima Vaksin");
                System.out.println("-------------------------------");
                System.out.print("Nomor Antrian anda : ");
                int nomorAntrian = sc.nextInt();
                System.out.print("Masukkan nama anda : ");
                String nama = sc.next();
                vaksin.enqueue(nomorAntrian, nama);
            } else if (pilih == 2) {
                vaksin.dequeue();
            } else if (pilih == 3) {
                vaksin.printQueue();
            }
            vaksin.menu();
            pilih = sc.nextInt();
        }

    }
}