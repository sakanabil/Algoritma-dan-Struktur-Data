import java.util.Scanner;
public class ArrayObjects {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Masukkan panjang array: ");
        int array = sc.nextInt();
        PersegiPanjang26[] ppArray = new PersegiPanjang26[array];

        for (int i = 0; i < array; i++) 
        {
            ppArray[i] = new PersegiPanjang26();
            System.out.println("Persegi Panjang ke-" + i);
            System.out.println("Masukkan panjang: ");
            ppArray[i].panjang = sc.nextInt();
            System.out.println("Masukkan lebar: ");
            ppArray[i].lebar = sc.nextInt();
        }

        for (int i = 0; i < array; i++)
        {
            System.out.println("Persegi Panjang ke-" + i);
            System.out.println("Panjang: " + ppArray[i].panjang + " Lebar: " + ppArray[i].lebar);
        }
    }
}