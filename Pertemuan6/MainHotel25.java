package Pertemuan6;

public class MainHotel25 {
    public static void main(String[] args) {
        HotelService25 list = new HotelService25();
        Hotel25 h1 = new Hotel25("Hotel A", "Malang", 350000, (byte) 4);
        Hotel25 h2 = new Hotel25("Hotel B", "Surabaya", 200000, (byte) 2);
        Hotel25 h3 = new Hotel25("Hotel C", "Mataram", 150000, (byte) 1);
        Hotel25 h4 = new Hotel25("Hotel D", "Jakarta", 400000, (byte) 5);
        Hotel25 h5 = new Hotel25("Hotel E", "Bogor", 125000, (byte) 3);

        list.tambah(h1);
        list.tambah(h2);
        list.tambah(h3);
        list.tambah(h4);
        list.tambah(h5);

        System.out.println("Data Hotel sebelum sorting : ");
        list.tampil();
        System.out.println("");

        System.out.println("Data Hotel setelah disorting berdasarkan Harga (Ascending)");
        list.bubbleSort();
        list.tampil();
        System.out.println("");

        System.out.println("Data Hotel setelah disorting berdasarkan Bintang (Descending)");
        list.selectionSort();
        list.tampil();
    }
}