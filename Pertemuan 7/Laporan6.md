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


## JOBSHEET - VI
## SEARCHING
### 6.2. Searching / Pencarian Menggunakan Agoritma Sequential Search


#### CLASS BUKU
```java
public class Buku25 {
    int kodeBuku;
    String judulBuku;
    int tahunTerbit;
    String pengarang;
    int stock;
    
    public Buku25(int kodeBuku, String judulBuku, int tahunTerbit, String pengarang, int stock) {
        this.kodeBuku = kodeBuku;
        this.judulBuku = judulBuku;
        this.tahunTerbit = tahunTerbit;
        this.pengarang = pengarang;
        this.stock = stock;
    }

    public void tampilDataBuku(){
        System.out.println("===========================");
        System.out.println("Kode buku : "+kodeBuku);
        System.out.println("Judul buku : "+judulBuku);
        System.out.println("Tahun Terbit : "+tahunTerbit);
        System.out.println("Pengarang :"+pengarang);
        System.out.println("Stock : "+stock);
    }
    
}
```

#### CLASS PENCARIANBUKU
```java
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

    public int FindSeqSearch(int cari) {
        int posisi = -1;
        for (int j = 0; j < listBk.length; j++) {
            if (listBk[j].kodeBuku == cari) {
                posisi = j; 
                break;
            }
        }
        return posisi;
    }

    public void Tampilposisi(int x, int pos) {
        if (pos != -1) {
            System.out.println("data " + x + " ditemukan pada index-" + pos);
        } else {
            System.out.println("data " + x + " tidak ditemukan");
        }
    }    
}
```

#### CLASS BUKUMAIN
```java
import java.util.Scanner;

public class BukuMain25 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);

        PencarianBuku25 data = new PencarianBuku25();
        int jumBuku = 5;

        System.out.println("----------------------------------------------------");
        System.out.println("Masukkan data Buku secara Urut dari KodeBuku Terkecil : ");
        for (int i = 0; i < jumBuku; i++) {
            System.out.print("Kode Buku \t: ");
            int kodeBuku = s.nextInt();
            System.out.print("Judul Buku \t: ");
            String judulBuku = s1.nextLine();
            System.out.print("Tahun Terbit \t: ");
            int tahunTerbit = s.nextInt();
            System.out.print("Pengarang \t: ");
            String pengarang = s1.nextLine();
            System.out.print("Stock \t\t: ");
            int stock = s.nextInt();
        System.out.println("-------------------------");

            Buku25 m = new Buku25(kodeBuku, judulBuku, tahunTerbit, pengarang, stock);
            data.tambah(m);
        }
        System.out.println("---------------------------------------------------");
        System.out.println("Data keseluruhan Buku : ");
        data.tampil();

        System.out.println("---------------------------------------------------");
        System.out.println("---------------------------------------------------");
        System.out.println("Pencarian Data : ");
        System.out.print("Masukkan kode buku yang dicari :");
        int cari = s.nextInt();
        System.out.println("Menggunakan sequential Search");
        int posisi = data.FindSeqSearch(cari);
        data.Tampilposisi(cari, posisi);
    }
}
```

#### 6.2.2. Verifikasi Hasil Percobaan
![alt text](<screenshots/Screenshot 2024-03-27 114125.png>)
![alt text](<screenshots/Screenshot 2024-03-27 114135.png>)
#### Jika Data ditemukan :
![alt text](<screenshots/Screenshot 2024-03-27 114144.png>)
#### Jika Data tidak ditemukan :
![alt text](<screenshots/Screenshot 2024-03-27 114534.png>)

### 6.2.3. Pertanyaan
#### 1. Jelaskan fungsi break yang ada pada method FindSeqSearch!
    Jawab : Fungsi break pada method FindSeqSearch adalah untuk menghentikan perulangan for ketika elemen yang dicari sudah ketemu, dan memastikan nilai yang dikembalikan adalah posisi elemen yang dicari atau -1 elemen tidak ditemukan.
#### 2. Jika Data Kode Buku yang dimasukkan tidak terurut dari kecil ke besar. Apakah program masih dapat berjalan? Apakah hasil yang dikeluarkan benar? Tunjukkan hasil screenshoot untuk bukti dengan kode Buku yang acak. Jelaskan Mengapa hal tersebut bisa terjadi?
    Jawab : Hasil yang dikeluarkan benar.
![alt text](<screenshots/Screenshot 2024-03-27 120055.png>)
![alt text](<screenshots/Screenshot 2024-03-27 120113.png>)
#### 3. Buat method baru dengan nama FindBuku menggunakan konsep sequential search dengan tipe method dari FindBuku adalah BukuNoAbsen. Sehingga Anda bisa memanggil method tersebut pada class BukuMain seperti gambar berikut :
![alt text](<screenshots/Screenshot 2024-03-27 114805.png>)
<br>
    Jawab : 
```java
        public Buku25 FindBuku(int cari) {
        for (int j = 0; j < listBk.length; j++){
            if (listBk[j].kodeBuku == cari){
                return listBk[j];
            }
        }    
        return null;
    }
```
```java
        Buku25 dataBuku = data.FindBuku(cari);
        dataBuku.tampilDataBuku();
```
<br>


### 6.3. Searching / Pencarian Menggunakan Binary Search
#### Method FindBinarySearch
```java
    public int FindBinarySearch(int cari, int left, int right) {
        int mid;
        if (right >= left) {
            mid = (left + right) / 2;
            if (listBk[mid].kodeBuku == cari) {
                return mid;
            } else if (listBk[mid].kodeBuku > cari) {
                return FindBinarySearch(cari, left, mid - 1);
            } else {
                return FindBinarySearch(cari, mid + 1, right);
            }
        }
        return -1;
    }
```

#### Panggil Method ke BukuMain25
```java
        System.out.println("---------------------------------------------------");
        System.out.println("Mengguanakn Binary Search");
        posisi = data.FindBinarySearch(cari, 0, jumBuku - 1);
        data.TampilPosisi(cari, posisi);
        data.TampilData(cari, posisi);
```

#### 6.3.2. Verifikasi Hasil Percobaan
![alt text](<screenshots/Screenshot 2024-03-27 121117.png>)

### 6.3.3. Pertanyaan
#### 1. Tunjukkan pada kode program yang mana proses divide dijalankan!
    Jawab : proses divide dijalankan ketika menghitung nilai tengah (mid) dari pencarian menggunakan operasi (left + right) / 2. Operasi ini membagi pencarian menjadi dua bagian.
#### 2. Tunjukkan pada kode program yang mana proses conquer dijalankan!
    Jawab :  proses conquer terjadi ketika melakukan dua pemanggilan rekursif ke metode FindBinarySearch dengan memperbarui nilai left dan right sesuai dengan hasil perbandingan nilai tengah listBk[mid].kodeBuku dengan cari.
#### 3. Jika data Kode Buku yang dimasukkan tidak urut. Apakah program masih dapat berjalan? Mengapa demikian! Tunjukkan hasil screenshoot untuk bukti dengan kode Buku yang acak. Jelaskan Mengapa hal tersebut bisa terjadi?
    Jawab : Tidak bisa, karena belum di sorting
![alt text](<screenshots/Screenshot 2024-03-27 132058.png>)
![alt text](<screenshots/Screenshot 2024-03-27 132109.png>)
#### 4. Jika Kode Buku yang dimasukkan dari Kode Buku terbesar ke terkecil (missal : 20215, 20214, 20212, 20211, 20210) dan elemen yang dicari adalah 20210. Bagaimana hasil dari binary search? Apakah sesuai? Jika tidak sesuai maka ubahlah kode program binary seach agar hasilnya sesuai!
    Jawab : dengan memodifikasi dan menambahkan method sorting
    Method Sorting :
```java
        void bubbleSort(){
        for(int i=0; i<listBk.length-1; i++){
            for(int j=1; j<listBk.length-i; j++){
                if(listBk[j-1].kodeBuku > listBk[j].kodeBuku){
                    Buku25 tmp = listBk[j];
                    listBk[j] = listBk[j-1];
                    listBk[j-1] = tmp;
                }
            }
        }
    }
```
    Method Binary Search :
```java
    public int FindBinarySearch(int cari) {
        bubbleSort();
        int left = 0;
        int right = listBk.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (listBk[mid].kodeBuku == cari) {
                return mid;
            } else if (listBk[mid].kodeBuku < cari) {
                left = mid + 1;
            } else {
                right = mid - 1; 
            }
        }
        return -1;
    }
```
    Outputnya
![alt text](<screenshots/Screenshot 2024-03-27 131010.png>)
![alt text](<screenshots/Screenshot 2024-03-27 131024.png>)

### 6.4. Percobaan Pengayaan Divide and Conquer
#### CLASS MERGESORTING
```java
public class MergeSorting25 {
    public void mergeSort(int[] data) {
    }

    public void merge(int data[], int left, int middle, int right) {
        int[] temp = new int[data.length];
        for (int i = left; i <= right; i++) {
            temp[i] = data[i];
        }
        int a = left;
        int b = middle + 1;
        int c = left;

        while (a <= middle && b <= right) {
            if (temp[a] <= temp[b]) {
                data[c] = temp[a];
                a++;
            } else {
                data[c] = temp[b];
                b++;
            }
            c++;
        }
        int s = middle - a + 1;
        for (int i = 0; i < s; i++) {
            data[c + i] = temp[a + i];
        }
    }

    public void sort(int data[], int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            sort(data, left, middle);
            sort(data, middle + 1, right);
            merge(data, left, middle, right);
        }
    }

    public void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
```
#### MAIN CLASS
```java
public class MergeSortMain25 {
    public static void main(String[] args) {
        int data[] = { 10, 40, 30, 50, 70, 20, 100, 90 };
        System.out.println("Sorting dengan merge sort");
        MergeSorting25 mSort = new MergeSorting25();
        System.out.println("Data awal");
        mSort.printArray(data);
        mSort.mergeSort(data);
        System.out.println("Setelah diurutkan");
        mSort.printArray(data);
    }
}
```
#### 6.4.2. Verifikasi Hasil Percobaan
![alt text](<screenshots/Screenshot 2024-04-02 205922.png>)

### 6.5. Latihan Praktikum
#### 1. Modifikasi percobaan searching diatas dengan ketentuan berikut ini
#### - Ubah tipe data dari kode Buku yang awalnya int menjadi String
#### - Tambahkan method untuk pencarian kode Buku (bertipe data String) dengan menggunakan sequential search dan binary search.
    Jawab :
#### CLASS BUKU25
```java
public class Buku25 {
    String kodeBuku, judulBuku, pengarang;
    int tahunTerbit, stock;
    
    public Buku25(String kodeBuku, String judulBuku, int tahunTerbit, String pengarang, int stock) {
        this.kodeBuku = kodeBuku;
        this.judulBuku = judulBuku;
        this.tahunTerbit = tahunTerbit;
        this.pengarang = pengarang;
        this.stock = stock;
    }

    public void tampilDataBuku(){
        System.out.println("===========================");
        System.out.println("Kode buku : "+kodeBuku);
        System.out.println("Judul buku : "+judulBuku);
        System.out.println("Tahun Terbit : "+tahunTerbit);
        System.out.println("Pengarang :"+pengarang);
        System.out.println("Stock : "+stock);
    }
    
}
```
#### CLASS PENCARIANBUKU25
```java
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
}
```
#### CLASS BUKUMAIN25
```java
import java.util.Scanner;

public class BukuMain25 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);

        PencarianBuku25 data = new PencarianBuku25();
        int jumBuku = 5;

        System.out.println("----------------------------------------------------");
        System.out.println("Masukkan data Buku secara Urut dari KodeBuku Terkecil : ");
        for (int i = 0; i < jumBuku; i++) {
            System.out.print("Kode Buku \t: ");
            int kodeBuku = s.nextInt();
            System.out.print("Judul Buku \t: ");
            String judulBuku = s1.nextLine();
            System.out.print("Tahun Terbit \t: ");
            int tahunTerbit = s.nextInt();
            System.out.print("Pengarang \t: ");
            String pengarang = s1.nextLine();
            System.out.print("Stock \t\t: ");
            int stock = s.nextInt();
        System.out.println("-------------------------");

            Buku25 m = new Buku25(Integer.toString(kodeBuku), judulBuku, tahunTerbit, pengarang, stock);
            data.tambah(m);
        }
        System.out.println("---------------------------------------------------");
        System.out.println("Data keseluruhan Buku : ");
        data.tampil();

        System.out.println("---------------------------------------------------");
        System.out.println("---------------------------------------------------");
        System.out.println("Pencarian Data : ");
        System.out.print("Masukkan kode buku yang dicari :");
        int cari = s.nextInt();
        System.out.println("Menggunakan sequential Search");
        int posisi = data.FindSeqSearch(Integer.toString(cari));
        data.TampilPosisi(cari, posisi);
        data.TampilData(cari, posisi);
        Buku25 dataBuku = data.FindBuku(Integer.toString(cari));
        dataBuku.tampilDataBuku();

        System.out.println("---------------------------------------------------");
        System.out.println("Mengguanakn Binary Search");
        posisi = data.FindBinarySearch(Integer.toString(cari));
        data.TampilPosisi(cari, posisi);
        data.TampilData(cari, posisi);

    }
}
```
<br>
<br>

#### 2. Modifikasi percobaan searching diatas dengan ketentuan berikut ini
#### - Tambahkan method pencarian judul buku menggunakan sequential search dan binary search. Sebelum dilakukan searching dengan binary search data harus dilakukan pengurutan dengan menggunakan algoritma Sorting (bebas pilih algoritma sorting apapun)! Sehingga ketika input data acak, maka algoritma searching akan tetap berjalan
#### - Buat aturan untuk mendeteksi hasil pencarian judul buku yang lebih dari 1 hasil dalam bentuk kalimat peringatan! Pastikan algoritma yang diterapkan sesuai dengan kasus yang diberikan!
    Jawab :
#### CLASS BUKU25
```java
public class Buku25 {
    String kodeBuku, judulBuku, pengarang;
    int tahunTerbit, stock;
    
    public Buku25(String kodeBuku, String judulBuku, int tahunTerbit, String pengarang, int stock) {
        this.kodeBuku = kodeBuku;
        this.judulBuku = judulBuku;
        this.tahunTerbit = tahunTerbit;
        this.pengarang = pengarang;
        this.stock = stock;
    }

    public void tampilDataBuku(){
        System.out.println("===========================");
        System.out.println("Kode buku : "+kodeBuku);
        System.out.println("Judul buku : "+judulBuku);
        System.out.println("Tahun Terbit : "+tahunTerbit);
        System.out.println("Pengarang :"+pengarang);
        System.out.println("Stock : "+stock);
    }
    
}
```
#### CLASS PENCARIANBUKU25
```java
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
```
#### CLASS BUKUMAIN25
```java
import java.util.Scanner;

public class BukuMain25 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);

        PencarianBuku25 data = new PencarianBuku25();
        int jumBuku = 5;

        System.out.println("----------------------------------------------------");
        System.out.println("Masukkan data Buku secara Urut dari KodeBuku Terkecil : ");
        for (int i = 0; i < jumBuku; i++) {
            System.out.print("Kode Buku \t: ");
            int kodeBuku = s.nextInt();
            System.out.print("Judul Buku \t: ");
            String judulBuku = s1.nextLine();
            System.out.print("Tahun Terbit \t: ");
            int tahunTerbit = s.nextInt();
            System.out.print("Pengarang \t: ");
            String pengarang = s1.nextLine();
            System.out.print("Stock \t\t: ");
            int stock = s.nextInt();
        System.out.println("-------------------------");

            Buku25 m = new Buku25(Integer.toString(kodeBuku), judulBuku, tahunTerbit, pengarang, stock);
            data.tambah(m);
        }
        System.out.println("---------------------------------------------------");
        System.out.println("Data keseluruhan Buku : ");
        data.tampil();

        System.out.println("---------------------------------------------------");
        System.out.println("---------------------------------------------------");
        System.out.println("Pencarian Data : ");
        System.out.print("Masukkan kode buku yang dicari :");
        int cari = s.nextInt();
        System.out.println("Menggunakan sequential Search");
        int posisi = data.FindSeqSearch(Integer.toString(cari));
        data.TampilPosisi(cari, posisi);
        data.TampilData(cari, posisi);
        Buku25 dataBuku = data.FindBuku(Integer.toString(cari));
        dataBuku.tampilDataBuku();

        System.out.println("---------------------------------------------------");
        System.out.println("Mengguanakn Binary Search");
        posisi = data.FindBinarySearch(Integer.toString(cari));
        data.TampilPosisi(cari, posisi);
        data.TampilData(cari, posisi);

        System.out.println("Masukan Judul Buku yang dicari : ");
        System.out.print("Judul Buku : ");
        String cariJudul = s1.next();
        System.out.println("Menggunakan Sequential Search");
        int posisiJudulBukuSequential = data.FindJudulBukuSeq(cariJudul);
        data.TampilPosisi(cariJudul, posisiJudulBukuSequential);
        data.TampilData(cariJudul, posisiJudulBukuSequential);
        int jumlahJudulSequential = 0;
        for (Buku25 buku : data.listBk) {
            if (buku != null && buku.judulBuku.equals(cariJudul)) {
                jumlahJudulSequential++;
            }
        }
        if (jumlahJudulSequential > 1) {
            System.out.println("Peringatan: Terdapat lebih dari satu hasil dengan judul buku '" + cariJudul + "'!");
        }
        System.out.println("---------------------------------------");
        System.out.println("Menggunakan Binary Search");
        int posisiJudulBinary = data.findJudulBinary(cariJudul);
        data.TampilPosisi(cariJudul, posisiJudulBinary);
        data.TampilData(cariJudul, posisiJudulBinary);
        int jumlahJudulBinary = 0;
        for (Buku25 buku : data.listBk) {
            if (buku != null && buku.judulBuku.equals(cariJudul)) {
                jumlahJudulBinary++;
            }
        }
        if (jumlahJudulBinary > 1) {
            System.out.println("Peringatan: Terdapat lebih dari satu hasil dengan judul buku '" + cariJudul + "'!");
        }
    }
}
```



