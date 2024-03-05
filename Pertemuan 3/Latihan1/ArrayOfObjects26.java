package Latihan1;

import java.util.Scanner;

public class ArrayOfObjects26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan jumlah kerucut: ");
        int jumlahKerucut = sc.nextInt();
        Kerucut26[] kerucutArray = new Kerucut26[jumlahKerucut];

        System.out.print("Masukkan jumlah limas segi empat: ");
        int jumlahLimasSegiEmpat = sc.nextInt();
        Limas26[] limasSegiEmpatArray = new Limas26[jumlahLimasSegiEmpat];

        System.out.print("Masukkan jumlah bola: ");
        int jumlahBola = sc.nextInt();
        Bola26[] bolaArray = new Bola26[jumlahBola];

        // Input Atribut Kerucut
        for (int i = 0; i < jumlahKerucut; i++) {
            System.out.println("Atribut kerucut ke-" + (i + 1));
            System.out.print("Masukkan jari-jari: ");
            int jariJari = sc.nextInt();
            System.out.print("Masukkan sisi miring: ");
            int sisiMiring = sc.nextInt();
            kerucutArray[i] = new Kerucut26(jariJari, sisiMiring);
            System.out.println();
        }

        // Input Atribut Limas Segi Empat
        for (int i = 0; i < jumlahLimasSegiEmpat; i++) {
            System.out.println("Atribut limas segi empat ke-" + (i + 1));
            System.out.print("Masukkan panjang sisi alas: ");
            int panjangSisiAlas = sc.nextInt();
            System.out.print("Masukkan tinggi: ");
            int tinggi = sc.nextInt();
            limasSegiEmpatArray[i] = new Limas26(panjangSisiAlas, tinggi);
            System.out.println();
        }

        // Input Atribut Bola
        for (int i = 0; i < jumlahBola; i++) {
            System.out.println("Atribut bola ke-" + (i + 1));
            System.out.print("Masukkan jari-jari: ");
            int jariJariBola = sc.nextInt();
            bolaArray[i] = new Bola26(jariJariBola);
            System.out.println();
        }

        // Print Kerucut
        System.out.println("\nHasil Perhitungan Kerucut:");
        for (int i = 0; i < jumlahKerucut; i++) {
            System.out.println("Luas Permukaan kerucut ke-" + (i + 1) + ": " + kerucutArray[i].hitungLuas());
            System.out.println("Volume kerucut ke-" + (i + 1) + ": " + kerucutArray[i].hitungVolume());
            System.out.println();
        }

        // Print Limas Segi Empat
        System.out.println("\nHasil Perhitungan Limas Segi Empat:");
        for (int i = 0; i < jumlahLimasSegiEmpat; i++) {
            System.out.println(
                    "Luas Permukaan limas segi empat ke-" + (i + 1) + ": " + limasSegiEmpatArray[i].hitungLuasPermukaan());
            System.out.println("Volume limas segi empat ke-" + (i + 1) + ": " + limasSegiEmpatArray[i].hitungVolume());
            System.out.println();
        }

        // Print Bola
        System.out.println("\nHasil Perhitungan Bola:");
        for (int i = 0; i < jumlahBola; i++) {
            System.out.println("Luas Permukaan bola ke-" + (i + 1) + ": " + bolaArray[i].hitungLuasPermukaan());
            System.out.println("Volume bola ke-" + (i + 1) + ": " + bolaArray[i].hitungVolume());
            System.out.println();
        }
    }
}