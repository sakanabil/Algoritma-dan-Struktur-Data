class Buku26 {
    String judul, pengarang;
    int halaman, stok, harga, terjual;

    public Buku26() {   
    }

    public Buku26(String jud, String pg, int hal, int stok, int har) {
        judul = jud;
        pengarang = pg;
        halaman = hal;
        this.stok = stok;
        harga = har;
    }

    void tampilInformasi() {
        System.out.println("Judul: " + judul);
        System.out.println("Pengarang: " + pengarang);
        System.out.println("Jumlah halaman: " + halaman);
        System.out.println("Sisa stok: " + stok);
        System.out.println("Harga: Rp " + harga);
    }

    //modifikasi pertanyaan 4
    void terjual(int jml) {
        if (stok > 0 && jml <= stok) {
            stok -= jml;
            terjual += jml;
        } else {
            System.out.println("Stok habis!");
        }
    }

    void restock(int jml) {
        stok += jml;
    }

    void gantiHarga(int hrg) {
        harga = hrg;
    }

    int hitungHargaTotal() {
        int totalHarga = harga * terjual;
        return totalHarga;
    }

    int hitungDiskon() {
        int totalHarga = hitungHargaTotal();
        double diskon = 0;

        if (totalHarga > 150000) {
            diskon = 0.12;
        } else if (totalHarga >= 75000) {
            diskon = 0.05;
        }
        return (int) (totalHarga * diskon);
    }

    int hitungHargaBayar() {
        int totalHarga = hitungHargaTotal();
        int diskon = hitungDiskon();
        return totalHarga - diskon;
    }
}

