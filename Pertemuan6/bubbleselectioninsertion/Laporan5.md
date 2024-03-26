<p align ="center"> LAPORAN PRAKTIKUM ALGORITMA DAN STRUKTUR DATA </p>
<br><br><br><br>

<p align="center">
   <img src="https://static.wikia.nocookie.net/logopedia/images/8/8a/Politeknik_Negeri_Malang.png/revision/latest?cb=20190922202558" width="30%"> </p>

<br><br><br><br><br>

<p align = "center"> Nama  : Saka Nabil </p>
<p align = "center"> NIM   : 2341720108 </p>
<p align = "center"> Prodi : TEKNIK INFOMATIKA</p>
<p align = "center"> Kelas : 1B </p>
<p align = "center"> Absen : 26 </p>


## JOBSHEET - V
## SORTING BUBBLE, SELECTION, DAN INSERTION SORT

### 5.2.1 Langkah-langkah Percobaan
#### Class Mahasiswa
``` java
package Pertemuan6.bubbleselectioninsertion;

public class Mahasiswa26 {
    String nama;
    int thnMasuk, umur;
    double ipk;

    Mahasiswa26(String n, int t, int u, double i) {
        nama = n;
        thnMasuk = t;
        umur = u;
        ipk = i;
    }

    void tampil() {
        System.out.println("Nama = " + nama);
        System.out.println("Tahun Masuk = " + thnMasuk);
        System.out.println("Umur = " + umur);
        System.out.println("IPK = " + ipk);
    }
}
```

#### Class DaftarMahasiswaBerprestasi
``` java
package Pertemuan6.bubbleselectioninsertion;

public class DaftarMahasiswaBerprestasi26 {
    Mahasiswa26 listMhs[] = new Mahasiswa26 [5];
    int idx;

    void tambah(Mahasiswa26 m){
        if (idx<listMhs.length){
            listMhs[idx] = m;
            idx++;
        }else{
            System.out.println("Data sudah penuh!!");
        }
    }

    void tampil(){
        for(Mahasiswa26 m : listMhs){
            m.tampil();
            System.out.println("========================================");
        }
    }

    void bubbleSort(){
        for(int i=0; i<listMhs.length-1; i++){
            for(int j=1; j<listMhs.length-i; j++){
                if(listMhs[j-1].ipk < listMhs[j].ipk){
                    Mahasiswa26 tmp = listMhs[j];
                    listMhs[j] = listMhs[j-1];
                    listMhs[j-1] = tmp;
                }
            }
        }
    }    
}
```

#### Class Main
```java
package Pertemuan6.bubbleselectioninsertion;

public class Main26 {
    public static void main(String[] args) {
        DaftarMahasiswaBerprestasi26 list = new DaftarMahasiswaBerprestasi26();
            Mahasiswa26 m1 = new Mahasiswa26("Nusa", 2017, 25, 3);
            Mahasiswa26 m2 = new Mahasiswa26("Rara", 2012, 19, 4);
            Mahasiswa26 m3 = new Mahasiswa26("Dopu", 2018, 19, 3.5);
            Mahasiswa26 m4 = new Mahasiswa26("Abdul", 2017, 23, 2);
            Mahasiswa26 m5 = new Mahasiswa26("Umi", 2019, 21, 3.75);

            list.tambah(m1);
            list.tambah(m2);
            list.tambah(m3);
            list.tambah(m4);
            list.tambah(m5);

            System.out.println("Data mahasiswa sebelum sorting = ");
            list.tampil();

            System.out.println("Data mahasiswa setelah sorting desc berdasarkan ipk");
            list.bubbleSort();
            list.tampil();
    }
}
```

#### 5.2.2 Verifikasi Hasil Percobaan
![alt text](<../screenshots/Screenshot 2024-03-20 115326.png>)
![alt text](<../screenshots/Screenshot 2024-03-20 115450.png>)

#### 5.2.3 Pertanyaan
#### 1. Terdapat di method apakah proses bubble sort?
    Jawab : ada di method bubbleShort()
#### 2. Di dalam method bubbleSort(), terdapat baris program seperti di bawah ini:
![alt text](<../screenshots/Screenshot 2024-03-23 232003.png>)
#### Untuk apakah proses tersebut?
    Jawab : digunakan untuk mengurutkan data array listMhs berdasarkan IPK mahasiswa. proses ini membandingkan IPK dua elemen array yang berdekatan dan menukan posisinya jika tidak terurut.
#### 3. Perhatikan perulangan di dalam bubbleSort() di bawah ini:
![alt text](<../screenshots/Screenshot 2024-03-23 232120.png>)
#### a. Apakah perbedaan antara kegunaan perulangan i dan perulangan j? b. Mengapa syarat dari perulangan i adalah i<listMhs.length-1 ? c. Mengapa syarat dari perulangan j adalah j<listMhs.length-i ? d. Jika banyak data di dalam listMhs adalah 50, maka berapakali perulangan i akan berlangsung? Dan ada berapa Tahap bubble sort yang ditempuh?

    Jawab : a. perulangan i dan j berguna untuk mengurutkan seluruh elemen array listMhs.
    b. syarat i < listMhs.length - 1 pada perulangan luar Bubble Sort bertujuan untuk mengoptimalkan proses pengurutan dengan menghindari perbandingan elemen yang sudah terurut dan elemen di luar batas array.
    c. syarat j < listMhs.length - i pada perulangan j membantu algoritma Bubble Sort untuk menghindari pengulangan yang tidak perlu pada elemen yang sudah terurut dan meningkatkan efisiensi dan performa algoritma.
    d. Perulangan i pada Bubble Sort dengan 50 data akan berlangsung sebanyak 49 kali dan jumlah tahap Bubble Sort tergantung pada urutan data awal. best case memerlukan 1 tahap, sedangkan worst case memerlukan 49 tahap.

### 5.3 Mengurutkan Data Mahasiswa Berdasarkan IPK Menggunakan Selection Sort
#### 5.3.1. Langkah-langkah Percobaan
#### CLASS
```java
    void selectionSort(){
        for(int i=0; i<listMhs.length-1; i++){
            int idxMin = i;
            for(int j=i+1; j<listMhs.length; j++){
                if(listMhs[j].ipk < listMhs[idxMin].ipk){
                    idxMin = j;
                }
            }
            Mahasiswa26 tmp = listMhs[idxMin];
            listMhs[idxMin] = listMhs[i];
            listMhs[i] = tmp;
        }
    }
```
#### MAIN
```java
            System.out.println("Data mahasiswa setelah sorting asc berdasarkan ipk");
            list.selectionSort();
            list.tampil();
```
#### 5.3.2. Verifikasi Hasil Percobaan
![alt text](<../screenshots/Screenshot 2024-03-23 233834.png>)

### 5.3.3. Pertanyaan
#### Di dalam method selection sort, terdapat baris program seperti di bawah ini:
![alt text](<../screenshots/Screenshot 2024-03-23 234225.png>)
#### Untuk apakah proses tersebut, jelaskan!
    Jawab : Proses tersebut merupakan bagian dari algoritma Selection Sort yang digunakan untuk menemukan indeks minimum dalam array listMhs. Proses ini membantu dalam mengurutkan elemen array berdasarkan IPK dari yang terendah hingga tertinggi.


### 5.4 Mengurutkan Data Mahasiswa Berdasarkan IPK Menggunakan Insertion Sort
#### 5.4.1 Langkah-langkah Percobaan
#### CLASS
```java
    void insertionSort(){
        for(int i=1; i<listMhs.length; i++){
            Mahasiswa26 tmp = listMhs[i];
            int j = i;
            while(j>=0 && listMhs[j-1].ipk > tmp.ipk){
                listMhs[j] = listMhs[j-1];
                j--;
            }
            listMhs[j] = tmp;
        }
    }
```
#### MAIN
```java
            System.out.println("Data mahasiswa setelah sorting asc berdasarkan ipk (menggunakan insertion sort)");
            list.insertionSort();
            list.tampil();
```
#### 5.4.2 Verifikasi Hasil Percobaan
![alt text](<../screenshots/Screenshot 2024-03-23 235221.png>)

### 5.4.3 Pertanyaan
#### Ubahlah fungsi pada InsertionSort sehingga fungsi ini dapat melaksanakan proses sorting dengan cara descending.
    Jawab :
```java
     void insertionSort(){
        for(int i=1; i<listMhs.length; i++){
            Mahasiswa26 tmp = listMhs[i];
            int j = i;
            while(j>=1 && listMhs[j-1].ipk < tmp.ipk){
                listMhs[j] = listMhs[j-1];
                j--;
            }
            listMhs[j] = tmp;
        }
    }
```
#### Outputnya
![alt text](<../screenshots/Screenshot 2024-03-23 235759.png>)

### Latihan Praktikum
#### Sebuah platform travel yang menyediakan layanan pemesanan kebutuhan travelling sedang mengembangkan backend untuk sistem pemesanan/reservasi akomodasi (penginapan), salah satu fiturnya adalah menampilkan daftar penginapan yang tersedia berdasarkan pilihan filter yang diinginkan user. Daftar penginapan ini harus dapat disorting berdasarkan

#### 1. Harga dimulai dari harga termurah ke harga tertinggi.
#### 2. Rating bintang penginapan dari bintang tertinggi (5) ke terendah (1)

#### Buatlah proses sorting data untuk kedua filter tersebut dengan menggunakan algoritma bubble sort dan selection sort.

![alt text](<../screenshots/Screenshot 2024-03-26 172002.png>)




#### CLASS HOTEL
```java
package Pertemuan6;

public class Hotel25 {
    String nama, kota;
    int harga;
    Byte rating;

    Hotel25(String n, String k, int h, Byte r) {
        nama = n;
        kota = k;
        harga = h;
        rating = r;
    }

    void tampil() {
        System.out.println("Nama : " + nama);
        System.out.println("Kota : " + kota);
        System.out.println("Harga : Rp." + harga);
        System.out.println("Bintang : " + rating);
    }
}

```

#### CLASS HOTELSERVICE
```java
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
```

#### MAIN HOTEL
```java
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
```

#### Outputnya
![alt text](<../screenshots/Screenshot 2024-03-26 173959.png>)
![alt text](<../screenshots/Screenshot 2024-03-26 174010.png>)
![alt text](<../screenshots/Screenshot 2024-03-26 174018.png>)