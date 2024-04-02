public class PencarianBuku25 {
    Buku25 listBk[] = new Buku25[5];
    int idx;

    void tambah(Buku25 m) {
        if (idx < listBk.length) {
            listBk[idx] = m;
            idx++;
        } else {
            System.out.println("Data sudah penuh!");
        }
    }

    void tampil() {
        for (Buku25 m : listBk) {
            m.tampilDataBuku();
        }
    }

    public int FindSeqSearch(String cari) {
        int posisi = -1;
        for (int j = 0; j < listBk.length; j++) {
            if (listBk[j].kodeBuku.equals(cari)) {
                posisi = j; 
                break;
            }
        }
        return posisi;
    }

    public void TampilPosisi(int x, int pos) {
        if (pos != -1) {
            System.out.println("data " + x + " ditemukan pada index-" + pos);
        } else {
            System.out.println("data " + x + " tidak ditemukan");
        }
    }

    public void TampilData(int x, int pos) {
        if (pos != -1) {
            System.out.println("Kode Buku\t: " + x);
            System.out.println("Judul\t\t: " + listBk[pos].judulBuku);
            System.out.println("Tahun Terbit\t: " + listBk[pos].tahunTerbit);
            System.out.println("Pengarang\t: " + listBk[pos].pengarang);
            System.out.println("Stock\t\t: " + listBk[pos].stock);
        } else {
            System.out.println("data " + x + " tidak ditemukan");
        }
    }

    void bubbleSort(String cari){
        for(int i=0; i<listBk.length-1; i++){
            for(int j=1; j<listBk.length-i; j++){
                if(listBk[j-1].kodeBuku.compareTo(cari) > listBk[j].kodeBuku.compareTo(cari)){
                    Buku25 tmp = listBk[j];
                    listBk[j] = listBk[j-1];
                    listBk[j-1] = tmp;
                }
            }
        }
    }

    public int FindBinarySearch(String cari) {
        bubbleSort(cari);
        int left = 0;
        int right = listBk.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (listBk[mid].kodeBuku.equals(cari)) {
                return mid;
            } else if (listBk[mid].kodeBuku.equals(cari)) {
                left = mid + 1;
            } else {
                right = mid - 1; 
            }
        }
        return -1;
    }

    public Buku25 FindBuku(String cari) {
        for (int j = 0; j < listBk.length; j++){
            if (listBk[j].kodeBuku.equals(cari)){
                return listBk[j];
            }
        }    
        return null;
    }

    public int FindJudulBukuSeq(String judulBuku) {
        int posisi = -1;
        for (int j = 0; j < listBk.length; j++) {
            if (listBk[j].judulBuku.equals(judulBuku)) {
                posisi = j;
                break;
            }
        }
        return posisi;
    }

    private void BubbleSortJudulBuku() {
        for (int i = 0; i < listBk.length - 1; i++) {
            for (int j = 0; j < listBk.length - i - 1; j++) {
                if (listBk[j].judulBuku.compareTo(listBk[j + 1].judulBuku) > 0) {
                    Buku25 temp = listBk[j];
                    listBk[j] = listBk[j + 1];
                    listBk[j + 1] = temp;
                }
            }
        }
    }

    public int findJudulBinary(String judulBuku) {
        BubbleSortJudulBuku(); 
        int left = 0;
        int right = listBk.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int compareResult = listBk[mid].judulBuku.compareTo(judulBuku);
            if (compareResult == 0) {
                return mid;
            } else if (compareResult < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;    
    }

    public void TampilPosisi(String cariJudul, int posisiJudul) {
        if (posisiJudul == -1) {
            System.out.println("Buku dengan judul '" + cariJudul + "' tidak ditemukan!");
        } else {
            System.out.println("Kode Buku " + cariJudul + " ditemukan pada posisi " + (posisiJudul + 1));
        }
    }

    public void TampilData(String cariJudul, int posisiJudul) {
        if (posisiJudul == -1) {
            System.out.println("Buku dengan judul '" + cariJudul + "' tidak ditemukan!");
        } else {
            System.out.println("Data buku dengan judul '" + cariJudul + "':");
        }
    }
}
