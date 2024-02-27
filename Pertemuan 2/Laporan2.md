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


## 2. Praktikum
### 2.1 Percobaan 1: Deklarasi Class, Atribut dan Method
``` java
public class Buku26 {
    String judul, pengarang;
    int halaman, stok, harga;

    void tampilInformasi() {
        System.out.println("Judul: " + judul);
        System.out.println("Pengarang: " + pengarang);
        System.out.println(" Jumlah halaman: " + halaman);
        System.out.println("Sisa stok: " + stok);
        System.out.println("Harga: Rp " + harga);
    }

    void terjual(int jml) {
        stok -= jml;
    }

    void restock(int jml) {
        stok += jml;
    }

    void gantiHarga(int hrg) {
        harga = hrg;
    }
}
```
### 2.1.2 Verifikasi Hasil Percobaan
![Verivikasi](<../Screenshot (354).png>)

### 2.1.3 Pertanyaan
#### 1. Sebutkan dua karakteristik class atau object!
    Jawab : Mempunyai sesuatu & Memiliki sesuatu.

#### 2. Perhatikan class Buku pada Praktikum 1 tersebut, ada berapa atribut yang dimiliki oleh class Buku? Sebutkan apa saja atributnya!
    Jawab : Judul (String), pengarang (String), halaman (int), stok (int), harga (int).

#### 3. Ada berapa method yang dimiliki oleh class tersebut? Sebutkan apa saja methodnya!
    Jawab : tampilInformasi(), terjual(int jml), restock(int jml), gantiHarga(int hrg).

#### 4. Perhatikan method terjual() yang terdapat di dalam class Buku. Modifikasi isi method tersebut sehingga proses pengurangan hanya dapat dilakukan jika stok masih ada (lebih besar dari 0)!
    Jawab : 
``` java
    void terjual(int jml) {
        if (stok > 0 && jml <= stok) {
            stok -= jml;
        } else {
            System.out.println("Stok habis!");
        }
    }
```
    Output :
![alt text](<../Screenshot 2024-02-21 133832.png>)

#### 5. Menurut Anda, mengapa method restock() mempunyai satu parameter berupa bilangan int?
    Jawab : method restock() memiliki parameter bertipe integer karena parameter tersebut mewakili jumlah barang yang ditambahkan kembali ke stok. Pengguna dapat menentukan jumlah yang tepat untuk di restock yang berbentuk bilangan bulat.

#### 6. Commit dan push kode program ke Github
    Jawab : Sudah.
<br>
<br>

### 2.2 Percobaan 2: Instansiasi Object, serta Mengakses Atribut dan Method
``` java
public class BukuMain26 {
    public static void main(String[] args) {
        Buku26 bk1 = new Buku26();
        bk1.judul = "Today Ends Tomorrow Comes";
        bk1.pengarang = "Denanda Pratiwi";
        bk1.halaman = 198;
        bk1.stok = 13;
        bk1.harga = 71000;

        bk1.tampilInformasi();
        bk1.terjual(5);
        bk1.gantiHarga(60000);
        bk1.tampilInformasi();
    }
}
```
### 2.2.2 Verifikasi Hasil Percobaan
![verivikasi](<../Screenshot 2024-02-21 130700.png>)

### 2.2.3 Pertanyaan
#### 1. Pada class BukuMain, tunjukkan baris kode program yang digunakan untuk proses instansiasi! Apa nama object yang dihasilkan?
    Jawab : Proses instansiasi berada di baris 3 yaitu Buku26 bk1 = new Buku26(); dan object yang dihasilkan adalah bk1.

#### 2. Bagaimana cara mengakses atribut dan method dari suatu objek?
    Jawab : untuk **atribut** dapat menggunakan **namaObjek.namaAtribut**, contoh : jika ingin mengakses **atribut judul** dari objek bk1, yaitu dengan **bk1.judul** , kemudian untuk mengakses **method** menggunakan **namaObjek.namaMethod**

#### 3. Mengapa hasil output pemanggilan method tampilInformasi() pertama dan kedua berbeda?
    Jawab : Hasil output pemanggilan method tampilInformasi() pertama dan kedua berbeda karena pada pemanggilan pertama, nilai atribut stok adalah 13, sedangkan pada pemanggilan kedua, nilai atribut stok telah berubah setelah pemanggilan method terjual(5) sehingga menghasilkan output yang berbeda untuk atribut stok. sama juga pada atribut harga.
<br>
<br>

### 2.3 Percobaan 3: Membuat Konstruktor
#### 1. Modifikasi class Buku26
``` java
public Buku26() {
    
}

public Buku26(String jud, String pg, int hal, int stok, int har) {
    judul = jud;
    pengarang = pg;
    halaman = hal;
    this.stok = stok;
    harga = har;
}
```
#### 2. Modifikasi class BukuMain26
``` java
    Buku26 bk2 = new Buku26("Self Reward", "Maheera Ayesha", 160, 59000);
    bk2.terjual(11);
    bk2.tampilInformasi();
```

### 2.3.2 Verifikasi Hasil Percobaan
![Verivikasi](<../Screenshot 2024-02-21 144942.png>)

### 2.3.3 Pertanyaan
#### 1. Pada class Buku di Percobaan 3, tunjukkan baris kode program yang digunakan untuk mendeklarasikan konstruktor berparameter!
    Jawab :

``` java
public Buku26(String jud, String pg, int hal, int stok, int har) {
    judul = jud;
    pengarang = pg;
    halaman = hal;
    this.stok = stok;
    harga = har;
}
```

#### 2. Perhatikan class BukuMain. Apa sebenarnya yang dilakukan pada baris program berikut?
![alt text](<../Screenshot 2024-02-21 145954.png>)

    Jawab : Baris program tersebut membuat objek bk2 dari kelas Buku26 dengan menggunakan konstruktor berparameter. Nilai yang diberikan sebagai argumen pada konstruktor ("Self Reward", "Maheera Ayesha", 160, 29, 59000) akan digunakan untuk menginisialisasi atribut-atribut dari objek bk2.
#### 3. Hapus konstruktor default pada class Buku, kemudian compile dan run program. Bagaimana hasilnya? Jelaskan mengapa hasilnya demikian!
![alt text](<../Screenshot 2024-02-21 150516.png>)

    Jawab : Dengan menghapus konstruktor default, konstruktor default yang biasanya dibuat oleh compilator tidak akan lagi tersedia, dan instansiasi objek Buku26 tanpa argumen akan mengakibatkan kesalahan compile.
#### 4. Setelah melakukan instansiasi object, apakah method di dalam class Buku harus diakses secara berurutan? Jelaskan alasannya!
    Jawab : Tidak harus, method di dalam class Buku tidak harus diakses secara berurutan. Method" dalam sebuah class bisa dipanggil sesuai kebutuhan, dan tidak harus secara berurutan. Karena setiap method dipanggil berdasarkan kebutuhan atau urutan operasi yang diinginkan.
#### 5. Buat object baru dengan nama bukuNamaMahasiswa menggunakan konstruktor berparameter dari class Buku!
    Jawab :

``` java
    Buku26 bukuSakaNabil = new Buku26("Bumi", "Tere Liye", 516, 11, 96000);
    bukuSakaNabil.terjual(10);
    bukuSakaNabil.tampilInformasi();
```
    Outputnya : 

![alt text](<../Screenshot 2024-02-21 152354.png>)

#### 6. Commit dan push kode program ke Github
    Jawab : Sudah.
<br>
<br>

## 2.4 Latihan Praktikum
### 1. LATIHAN 1
``` java
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
```
### Outputnya :
![alt text](<../Screenshot 2024-02-27 210006.png>)
<br>
<br>

### LATIHAN 2
``` java
public class Dragon26 {
    int x, y, width, height;

    Dragon26(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    void moveLeft() {
        x--;
        if (x < 0 || x > width) {
            detectCollision();
        }
    }

    void moveRight() {
        x++;
        if (x < 0 || x > width) {
            detectCollision();
        }
    }

    void moveUp() {
        y--;
        if (y < 0 || y > height) {
            detectCollision();
        }
    }

    void moveDown() {
        y++;
        if (y < 0 || y > height) {
            detectCollision();
        }
    }

    void printPosition() {
        System.out.println("Posisi Dragon: (" + x + ", " + y + ")");
    }

    void detectCollision() {
        System.out.println("Game Over");
    }
}
```
