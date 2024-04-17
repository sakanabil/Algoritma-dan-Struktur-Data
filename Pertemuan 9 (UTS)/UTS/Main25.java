public class Main25 {
    public static void main(String[] args) {
        PencarianNomor25 data = new PencarianNomor25();
        int angka[] = {46, 4, 18, 27, 44, 30, 26, 16, 21, 34, 9, 10, 44, 34, 31, 11, 45};

        for (int i = 0; i < angka.length; i++) {
            if (i < data.data.length) {
                data.data[i] = new Nomor25(angka[i]);
            } else {
                break;
            }
        }

        int posisi = data.BinarySearch(21,0, angka.length - 1); 
        System.out.println("Data awal: ");
        data.tampil();
        data.TampilPosisi(21, posisi);
        System.out.println();
        
        int posisiasc = data.BinarySearchAsc(21, 0, angka.length - 1); 
        data.urutAsc();
        System.out.println("Setelah diurutkan ascending: ");
        data.tampil();
        data.TampilPosisi(21, posisiasc);
        System.out.println();

        int posisidesc = data.BinarySearchDesc(21, 0, angka.length - 1);
        data.urutDesc();
        System.out.println("Setelah diurutkan descending: ");
        data.tampil();
        data.TampilPosisi(21, posisidesc);
        System.out.println();

        int posisix = data.BinarySearch(1,0, angka.length - 1); 
        System.out.println("Data: ");
        data.tampil();
        data.TampilPosisi(1, posisix);

    }
}