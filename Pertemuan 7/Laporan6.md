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
