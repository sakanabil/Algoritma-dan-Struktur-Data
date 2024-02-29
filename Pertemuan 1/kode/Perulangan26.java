package kode;
import java.util.Scanner;

public class Perulangan26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan NIM: ");
        String nim = sc.nextLine();

        int n = Integer.parseInt(nim.substring(nim.length() - 2));

        if (n < 10) {
            n += 10;
        }

        System.out.println("=====================");
        System.out.println("n : " + n);
        System.out.print("");

        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0) {
                System.out.print("* ");
            } else if (i == 6 || i == 10) {
                continue;
            } else {
                System.out.print(i + " ");
            }
        }
    }
}