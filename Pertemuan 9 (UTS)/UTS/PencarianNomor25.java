public class PencarianNomor25 {
    Nomor25 data[] = new Nomor25[17];
    int idx;

    void tampil() {
        for (int i = 0; i < data.length; i++) 
            data[i].tampil();
    }

    void urutAsc() {
        for(int i=1; i<data.length; i++) {
            Nomor25 tmp = data[i];
            while((i>=1) && (data[i-1].nomor > tmp.nomor)) {
                data[i] = data[i-1];
                i--;
            }
            data[i] = tmp;
        }
    }
    
    void urutDesc() {
        for(int i=1; i<data.length; i++) {
            Nomor25 tmp = data[i];
            while((i>=1) && (data[i-1].nomor < tmp.nomor)) {
                data[i] = data[i-1];
                i--;
            }
            data[i] = tmp;
        }
    }

    public int BinarySearch(int cari, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (cari == data[mid].nomor) {
                return mid;
            }   
            if (cari > data[mid].nomor) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public int BinarySearchAsc(int cari, int left, int right) {
        urutAsc();
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (cari == data[mid].nomor) {
                return mid;
            }   
            if (cari > data[mid].nomor) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public int BinarySearchDesc(int cari, int left, int right) {
        urutDesc();
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (cari == data[mid].nomor) {
                return mid;
            } 
            if (cari < data[mid].nomor) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public void TampilPosisi(int x, int pos) { 
        if (pos != -1) {
            System.out.println("Data: "+ x +" ditemukan pada indeks "+ pos);
        } else {
            System.out.println("Data: "+ x + " tidak ditemukan!");
        }
    }
}

            

    
