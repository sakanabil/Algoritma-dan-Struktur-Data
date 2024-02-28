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


## 3. Praktikum
### 3.2 Percobaan 1: Membuat Array dari Object, Mengisi dan Menampilkan
```java
public class PersegiPanjang26 {
    int panjang;
    int lebar;

}
```
<br>

``` java
public class ArrayObjects {

    public static void main(String[] args) {
        PersegiPanjang26[] ppArray = new PersegiPanjang26[3];

        ppArray[0] = new PersegiPanjang26();
        ppArray[0].panjang = 110;
        ppArray[0].lebar = 30;

        ppArray[1] = new PersegiPanjang26();
        ppArray[1].panjang = 80;
        ppArray[1].lebar = 40;

        ppArray[2] = new PersegiPanjang26();
        ppArray[2].panjang = 100;
        ppArray[2].lebar = 20;

        System.out.println("Persegi Panjang ke-0, panjang: " + ppArray[0].panjang + ", lebar: " + ppArray[0].lebar);
        System.out.println("Persegi Panjang ke-1, panjang: " + ppArray[1].panjang + ", lebar: " + ppArray[1].lebar);
        System.out.println("Persegi Panjang ke-2, panjang: " + ppArray[2].panjang + ", lebar: " + ppArray[2].lebar);
    }
}
```

### 3.2.2 Verifikasi Hasil Percobaan
![alt text](<screenshots/Screenshot 2024-02-28 110717.png>)

### 3.2.3 Pertanyaan
#### 1. Berdasarkan uji coba 3.2, apakah class yang akan dibuat array of object harus selalu memiliki atribut dan sekaligus method? Jelaskan!
   Jawab : Tidak, class yang akan dibuat sebagai array of object tidak harus selalu memiliki atribut dan method. Sebagai contoh, dalam contoh sebelumnya, class PersegiPanjang26 hanya memiliki atribut panjang dan lebar tanpa memiliki method. Hal ini memperlihatkan bahwa sebuah class bisa digunakan hanya untuk menyimpan data (atribut) tanpa perlu memiliki method tertentu. 

#### 2. Apakah class PersegiPanjang memiliki konstruktor?Jika tidak, kenapa dilakukan pemanggilan konstruktur pada baris program berikut :
![alt text](<screenshots/Screenshot 2024-02-28 111840.png>) <br>
   Jawab : Tidak, pemanggilan konstruktor pada baris ppArray[1] = new PersegiPanjang(); adalah pemanggilan konstruktor default yang dibuat secara otomatis oleh java.

#### 3. Apa yang dimaksud dengan kode berikut ini:
![alt text](<screenshots/Screenshot 2024-02-28 112419.png>) <br>
   Jawab : Kode diatas mendeklarasikan suatu array dengan nama ppArray yang bisa menyimpan objek dari class PersegiPanjang26. Array tsb memiliki panjang 3, yang berarti bisa menyimpan 3 objek.

#### 4. Apa yang dimaksud dengan kode berikut ini:
![alt text](<screenshots/Screenshot 2024-02-28 112842.png>)<br>
   Jawab : Kode tsb menginisialisasi objek kedua dalam array ppArray. pada baris pertama digunakan untuk membuat objek baru dari class PersegiPanjan26 dan mengisi indeks 1. baris kedua dan ketiga adalah tempat nilai atribut panjang dan lebar dari objek kedua dalam array ppArray yg diatur menjadi panjang = 80 dan lebar = 40.

#### 5. Mengapa class main dan juga class PersegiPanjang dipisahkan pada uji coba 3.2?
   Jawab : Pemisahan class ArrayObjects dan class PersegiPanjang26 berguna agar kode dapat dikelola dengan lebih baik dan mudah.

<br>
<br>

### 3.3 Percobaan 2: Menerima Input Isian Array Menggunakan Looping
```java
import java.util.Scanner;
public class ArrayObjects {

    public static void main(String[] args) {
        PersegiPanjang26[] ppArray = new PersegiPanjang26[3];

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++) 
        {
            ppArray[i] = new PersegiPanjang26();
            System.out.println("Persegi Panjang ke-" + i);
            System.out.println("Masukkan panjang: ");
            ppArray[i].panjang = sc.nextInt();
            System.out.println("Masukkan lebar: ");
            ppArray[i].lebar = sc.nextInt();
        }

        for (int i = 0; i < 3; i++)
        {
            System.out.println("Persegi Panjang ke-" + i);
            System.out.println("Panjang: " + ppArray[i].panjang + " Lebar: " + ppArray[i].lebar);
        }
    }
}
```
### 3.3.2 Verifikasi Hasil Percobaan
![alt text](<screenshots/Screenshot 2024-02-28 123915.png>)

### 3.3.3 Pertanyaan
#### 1. Apakah array of object dapat diimplementasikan pada array 2 Dimensi?
   Jawab : Ya, array of object dapat diimplementasikan pada array 2 dimensi.
#### 2. Jika jawaban soal no satu iya, berikan contohnya! Jika tidak, jelaskan!
```java
public class ArrayObjects {

    public static void main(String[] args) {
        PersegiPanjang[][] ppArray = new PersegiPanjang[3][2];

        ppArray[0][0] = new PersegiPanjang(110, 30);
        ppArray[0][1] = new PersegiPanjang(80, 40);

                for (int i = 0; i < ppArray.length; i++) {
            for (int j = 0; j < ppArray[i].length; j++) {
                System.out.println("Persegi Panjang ke-" + i + "," + j + ": " + ppArray[i][j]);
            }
        }
    }
}
```
#### 3. Jika diketahui terdapat class Persegi yang memiliki atribut sisi bertipe integer, maka kode dibawah ini akan memunculkan error saat dijalankan. Mengapa?
![alt text](<screenshots/Screenshot 2024-02-28 130142.png>)<br>
Jawab : Kode dibawah akan error karena kode tersebut butuh kode pgArray[5] = new Persegi(); diatas kode pgArray[5].sisi = 20 dan dibawah kode Persegi[] pgArray = new Persegi[100].
#### 4. Modifikasi kode program pada praktikum 3.3 agar length array menjadi inputan dengan Scanner!
```java
import java.util.Scanner;
public class ArrayObjects {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Masukkan panjang array: ");
        int array = sc.nextInt();
        PersegiPanjang26[] ppArray = new PersegiPanjang26[array];

        for (int i = 0; i < array; i++) 
        {
            ppArray[i] = new PersegiPanjang26();
            System.out.println("Persegi Panjang ke-" + i);
            System.out.println("Masukkan panjang: ");
            ppArray[i].panjang = sc.nextInt();
            System.out.println("Masukkan lebar: ");
            ppArray[i].lebar = sc.nextInt();
        }

        for (int i = 0; i < array; i++)
        {
            System.out.println("Persegi Panjang ke-" + i);
            System.out.println("Panjang: " + ppArray[i].panjang + " Lebar: " + ppArray[i].lebar);
        }
    }
}
```
Outputnya :<br>
![alt text](<screenshots/Screenshot 2024-02-28 131742.png>)

#### 5. Apakah boleh Jika terjadi duplikasi instansiasi array of objek, misalkan saja instansiasi dilakukan pada ppArray[i] sekaligus ppArray[0]?Jelaskan !
Jawab : Bisa saja jika terjadi duplikasi instansiasi array of object, namun tidak boleh karena akan menyebabkan kehilangan referensi objek yang sebelumnya disimpan pada ppArray[0], contohnya jika kita run kodenya kemudian menginput panjang dan lebar pada persegi panjang ke-0 maka output yang akan keluar 0.

### 3.4 Percobaan 3: Penambahan Operasi Matematika di Dalam Method
```java
package ArrayBalok;

public class Balok26 {
    public int panjang;
    public int lebar;
    public int tinggi;

    public Balok26(int p, int l, int t) 
    {
        panjang = p;
        lebar = l;
        tinggi = t;
    }
        
    public int hitungVolume()
    {
        return panjang * lebar * tinggi;
    }
    
}
```
```java
package ArrayBalok;

public class ArrayBalok26 {
    public static void main(String[] args) {
        Balok26[] blArray = new Balok26[3];

        blArray[0] = new Balok26(100, 30, 12);
        blArray[1] = new Balok26(120, 40, 15);
        blArray[2] = new Balok26(210, 50, 25);

        for (int i = 0; i < 3; i++)
        {
            System.out.println("Volume balok ke " + i + ": " + blArray[i].hitungVolume());
        }
    }
}
```
### 3.4.2 Verifikasi Hasil Percobaan
![alt text](<screenshots/Screenshot 2024-02-28 134634.png>)

### 3.4.3 Pertanyaan
#### 1. Dapatkah konstruktor berjumlah lebih dalam satu kelas? Jelaskan dengan contoh!
Jawab : Ya bisa, satu kelas dapat memiliki lebih dari satu konstruktor.
Contoh : 
```java
public class PersegiPanjang26 {
    public int panjang;
    public int lebar;

    public PersegiPanjang26() {
        panjang = 0;
        lebar = 0;
    }

    public PersegiPanjang26(int p, int l) {
        panjang = p;
        lebar = l;
    }
}
```
#### 2. Jika diketahui terdapat class Segitiga seperti berikut ini:
![alt text](<screenshots/Screenshot 2024-02-28 135111.png>)
#### Tambahkan konstruktor pada class Segitiga tersebut yang berisi parameter int a, int t yang masing-masing digunakan untuk mengisikan atribut alas dan tinggi.
Jawab :
```java
public class Segitiga26 {
    public int alas;
    public int tinggi;

    public Segitiga26(int a, int t) 
    {
    alas = a;
    tinggi = t;
    }
}
```
#### 3. Tambahkan method hitungLuas() dan hitungKeliling() pada class Segitiga tersebut. Asumsi segitiga adalah segitiga siku-siku. (Hint: Anda dapat menggunakan bantuan library Math pada Java untuk mengkalkulasi sisi miring)
Jawab :
```java
public class Segitiga26 {
    public int alas;
    public int tinggi;

    public Segitiga26(int a, int t) {
        alas = a;
        tinggi = t;
    }

    public int hitungLuas() {
        return (alas * tinggi) / 2;
    }

    public double hitungKeliling() {
        double sisiMiring = Math.sqrt((alas * alas) + (tinggi * tinggi));
        double keliling = alas + tinggi + sisiMiring;
        return keliling;
    }
}
```
```java
public class ArraySegitiga26 {
    public static void main(String[] args) {
        Segitiga26[] sgArray = new Segitiga26[3];

        sgArray[0] = new Segitiga26(5, 10);
        sgArray[1] = new Segitiga26(4, 8);
        sgArray[2] = new Segitiga26(3, 6);

        for (int i = 0; i < 3; i++)
        {
            System.out.println("Luas segitiga ke " + i + ": " + sgArray[i].hitungLuas());
            System.out.println("Keliling segitiga ke " + i + ": " + sgArray[i].hitungKeliling());
        }
    }  
}
```
Output : <br>
![alt text](<screenshots/Screenshot 2024-02-28 145921.png>)
#### 4. Pada fungsi main, buat array Segitiga sgArray yang berisi 4 elemen, isikan masing-masing atributnya sebagai berikut: 
#### sgArray ke-0 alas: 10, tinggi: 4 
#### sgArray ke-1 alas: 20, tinggi: 10 
#### sgArray ke-2 alas: 15, tinggi: 6 
#### sgArray ke-3 alas: 25, tinggi: 10
Jawab : 
```java
public class ArraySegitiga26 {
    public static void main(String[] args) {
        Segitiga26[] sgArray = new Segitiga26[4];

        sgArray[0] = new Segitiga26(10, 4);
        sgArray[1] = new Segitiga26(20, 10);
        sgArray[2] = new Segitiga26(15, 6);
        sgArray[3] = new Segitiga26(25, 10);

        for (int i = 0; i < 4; i++)
        {
            System.out.println("Luas segitiga ke " + i + ": " + sgArray[i].hitungLuas());
            System.out.println("Keliling segitiga ke " + i + ": " + sgArray[i].hitungKeliling());
        }
    }
}
```
Outputnya : <br>
![alt text](<screenshots/Screenshot 2024-02-28 150544.png>)
#### 5. Kemudian menggunakan looping, cetak luas dan keliling dengan cara memanggil method hitungLuas() dan hitungKeliling()
Jawab : 
```java
        for (int i = 0; i < 4; i++)
        {
            System.out.println("Luas segitiga ke " + i + ": " + sgArray[i].hitungLuas());
            System.out.println("Keliling segitiga ke " + i + ": " + sgArray[i].hitungKeliling());
        }
    }
}
```

### 3.5 Latihan Praktikum