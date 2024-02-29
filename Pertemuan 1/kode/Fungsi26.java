package kode;
public class Fungsi26 {
    
    static int stokBunga[][] = {
            { 10, 5, 15, 7 },
            { 6, 11, 9, 12 },
            { 2, 10, 10, 5 },
            { 5, 7, 12, 9 }
    };
    
    static int hargaBunga[] = { 75000, 50000, 60000, 10000 };
    
    static void pendapatanCabang() {
        System.out.println("Pendapatan cabang Royal Garden");
        System.out.println("===============================");
        for (int i = 0; i < stokBunga.length; i++) {
            int totalPendapatan = 0;
            for (int j = 0; j < stokBunga[i].length; j++) {
                totalPendapatan += stokBunga[i][j] * hargaBunga[j];
            }
            System.out.println("Pendapatan cabang Royal Garden " + (i + 1) + ": Rp " + totalPendapatan);
        }
    }
    
    static String NamaBunga(int index) {
        switch (index) {
            case 0:
                return "Aglonema";
            case 1:
                return "Keladi";
            case 2:
                return "Alocasia";
            case 3:
                return "Mawar";
            default:
                return "Bunga Tidak Ada";
        }
    }
    static void jumlahStockPerJenisBunga() {
        System.out.println("=================================================");
        System.out.println("Sisa stok bunga pada cabang Royal Garden 4: ");
        System.out.println("=================================================");
        System.out.println("Stok " + NamaBunga(0) + ": " + (stokBunga[3][0] - 1));
        System.out.println("Stok " + NamaBunga(1) + ": " + (stokBunga[3][1] - 2));
        System.out.println("Stok " + NamaBunga(2) + ": " + stokBunga[3][2]);
        System.out.println("Stok " + NamaBunga(3) + ": " + (stokBunga[3][3] - 5));
    }
    
    public static void main(String[] args) {
        pendapatanCabang();
        jumlahStockPerJenisBunga();
    }
}