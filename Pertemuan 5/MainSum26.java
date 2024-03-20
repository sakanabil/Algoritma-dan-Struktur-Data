import java.util.Scanner;
public class MainSum26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=======================================================");
        System.out.println("Program Menghitung Keuntungan Total (Satuan Juta. Misal 5.9)");
        System.out.print("Masukkan jumlah Bulan : ");
        int elm = sc.nextInt();

        Sum26 sm = new Sum26(elm);
        System.out.println("=======================================================");
        for (int i = 0; i < elm; i++){
            System.out.print("Masukkan untung Bulan ke-"+(i+1)+" = ");
            sm.keuntungan[i] = sc.nextDouble();
        }

        System.out.println("=======================================================");
        System.out.println("Algoritma Brute Force");
        System.out.println("Total keuntungan perusahaan = " + sm.elemen + " bulan adalah = "+sm.totalBF(sm.keuntungan));
        System.out.println("=======================================================");
        System.out.println("Algoritma Divide and Conquer");
        System.out.println("Total keuntungan perusahaan selama = " + sm.elemen + " bulan adalah = "+sm.totalDC(sm.keuntungan, 0, sm.elemen-1));
    }
}
