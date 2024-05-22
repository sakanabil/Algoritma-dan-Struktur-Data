package Kuis2;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        Scanner scanner = new Scanner(System.in);

        // Menambahkan klub ke dalam list
        String[] clubNames = {
            "Prawira Harum Bandung", "Satria Muda Pertamina Jakarta", "Pelita Jaya Jakarta",
            "Dewa United Banten", "RANS PIK Basketball Club", "Bima Perkasa Jogja",
            "Bali United Basketball", "Bumi Borneo Basketball Pontianak", "Tangerang Hawks Basketball",
            "Indonesia Patriots", "Amartha Hangtuah Jakarta", "Evos Thunder Bogor",
            "West Bandits Solo", "Mountain Gold Timika", "Elang Pacific Caesar Surabaya",
            "Satya Wacana Salatiga"
        };

        for (String name : clubNames) {
            list.addClub(new Club(name));
        }

        // Menu utama
        boolean exit = false;
        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Input Hasil Pertandingan");
            System.out.println("2. Lihat Klasemen");
            System.out.println("3. Keluar");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();
            scanner.nextLine();


            switch (choice) {
                case 1:
                    // Input hasil pertandingan
                    String club1, club2, result;
                    System.out.println("\nMasukkan Club A (atau ketik 'exit' untuk keluar): ");
                    club1 = scanner.nextLine();
                    if (club1.equalsIgnoreCase("exit")) {
                        exit = true;
                        break;
                    }
                    System.out.println("Masukkan Club B: ");
                    club2 = scanner.nextLine();
                    System.out.println("Hasil Pertandingan (W untuk Club A menang, L untuk Club A kalah): ");
                    result = scanner.nextLine();
                    System.out.println("=====================\n");

                    Club clubA = list.findClub(club1);
                    Club clubB = list.findClub(club2);

                    if (clubA != null && clubB != null) {
                        if (result.equalsIgnoreCase("W")) {
                            clubA.recordMatch(true);
                            clubB.recordMatch(false);
                            System.out.println("Hasil Pertandingan: " + club1 + " vs " + club2 + ", " + club1 + " Menang!");
                        } else if (result.equalsIgnoreCase("L")) {
                            clubA.recordMatch(false);
                            clubB.recordMatch(true);
                            System.out.println("Hasil Pertandingan: " + club1 + " vs " + club2 + ", " + club2 + " Menang!");
                        } else {
                            System.out.println("Hasil tidak valid. Gunakan 'W' untuk menang atau 'L' untuk kalah.");
                        }
                    } else {
                        System.out.println("Nama klub tidak ditemukan. Pastikan memasukkan nama klub dengan benar.");
                    }
                    break;
                case 2:
                    list.sortClubs();
                    System.out.println("\n\t\t\tKLASEMEN IBL 2024\n");
                    list.printList();
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }
}