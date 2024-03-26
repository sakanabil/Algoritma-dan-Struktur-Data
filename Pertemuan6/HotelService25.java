package Pertemuan6;

public class HotelService25 {
    Hotel25 hotel[] = new Hotel25[5];
    int idx;

    void tambah(Hotel25 h) {
        if (idx < hotel.length) {
            hotel[idx] = h;
            idx++;
        } else {
            System.out.println("Hotel sudah penuh!");
        }
    }

    void tampil() {
        for (Hotel25 h : hotel) {
            h.tampil();
        }
    }

    public void bubbleSort() {
        for (int i = 0; i < idx - 1; i++) {
            for (int j = 0; j < idx - i - 1; j++) {
                if (hotel[j].harga > hotel[j + 1].harga) {
                    Hotel25 tmp = hotel[j];
                    hotel[j] = hotel[j + 1];
                    hotel[j + 1] = tmp;
                }
            }
        }
    }

    public void selectionSort() {
        for (int i = 0; i < idx - 1; i++) {
            int idxMax = i;
            for (int j = i + 1; j < idx; j++) {
                if (hotel[j].rating > hotel[idxMax].rating) {
                    idxMax = j;
                }
            }
            Hotel25 tmp = hotel[idxMax];
            hotel[idxMax] = hotel[i];
            hotel[i] = tmp;
        }
    }
}