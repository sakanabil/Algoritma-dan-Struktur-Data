<p align ="center"> LAPORAN PRAKTIKUM ALGORITMA DAN STRUKTUR DATA </p>
<br><br><br><br>

<p align="center">
   <img src="https://static.wikia.nocookie.net/logopedia/images/8/8a/Politeknik_Negeri_Malang.png/revision/latest?cb=20190922202558" width="30%"> </p>

<br><br><br><br><br>

<p align = "center"> Nama  : Saka Nabil </p>
<p align = "center"> NIM   : 2341720108 </p>
<p align = "center"> Prodi : TEKNIK INFOMATIKA</p>
<p align = "center"> Kelas : 1B </p>
<p align = "center"> Absen : 25 </p>

## JOBSHEET - 10
##  QUEUE

### 10.2 Praktikum 1
#### Class Queue25
```java
public class Queue25 {
    int[] data;
    int front, rear, size, max;

    public Queue25(int n) {
        max = n;
        data = new int[max];
        size = 0;
        front = rear = -1;
    }

    public boolean IsEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean IsFull() {
        if (size == max) {
            return true;
        } else {
            return false;
        }
    }

    public void peek() {
        if (!IsEmpty()) {
            System.out.println("Elemen terdepan: " + data[front]);
        } else {
            System.out.println("Queue masih kosong");
        }
    }

    public void print() {
        if (IsEmpty()) {
            System.out.println("Queue masih kosong");
        } else {
            int i = front;
            while (i != rear) {
                System.out.print(data[i] + " ");
                i = (i + 1) % max;
            }
            System.out.println(data[i] + " ");
            System.out.println("Jumlah elemen = " + size);
        }
    }

    public void clear() {
        if (!IsEmpty()) {
            front = rear = -1;
            size = 0;
            System.out.println("Queue berhasil dikosongkan");
        } else {
            System.out.println("Queue masih kosong");
        }
    }

    public void Enqueue(int dt) {
        if (IsFull()) {
            System.out.println("Queue sudah penuh");
        } else {
            if (IsEmpty()) {
                front = rear = 0;
            } else {
                if (rear == max - 1) {
                    rear = 0;
                } else {
                    rear++;
                }
            }
            data[rear] = dt;
            size++;
        }
    }

    public int Dequeue() {
        int dt = 0;
        if (IsEmpty()) {
            System.out.println("Queue masih kosong");
        } else {
            dt = data[front];
            size--;
            if (IsEmpty()) {
                front = rear = -1;
            } else {
                if (front == max - 1) {
                    front = 0;
                } else {
                    front++;
                }
            }
        }
        return dt;
    }
}
```
#### QueueMain25
```java
import java.util.Scanner;

public class QueueMain25 {
    public static void menu() {
        System.out.println("Masukkan operasi yang diinginkan:");
        System.out.println("1. Enqueue");
        System.out.println("2. Dequeue");
        System.out.println("3. Print");
        System.out.println("4. Peek");
        System.out.println("5. Clear");
        System.out.println("--------------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan kapasitas Queue: ");
        int n = sc.nextInt();

        Queue25 Q = new Queue25(n);
        int pilih;

        do {
            menu();
            pilih = sc.nextInt();
            switch (pilih) {
                case 1:
                    System.out.print("Masukkan data baru: ");
                    int dataMasuk = sc.nextInt();
                    Q.Enqueue(dataMasuk);
                    break;
                case 2:
                    int dataKeluar = Q.Dequeue();
                    if (dataKeluar != 0) {
                        System.out.println("Data yang dikeluarkan: " + dataKeluar);
                        break;
                    }
                case 3:
                    Q.print();
                case 4:
                    Q.peek();
                case 5:
                    Q.clear();
                    break;
            }
        } while (pilih == 1 || pilih == 2 || pilih == 3 || pilih == 4 || pilih == 5);
    }
}
```
#### Verifikasi Hasil
![alt text](<screenshots/Screenshot 2024-04-28 210850.png>)

### 10.2.3 Pertanyaan
#### 1. Pada konstruktor, mengapa nilai awal atribut front dan rear bernilai -1, sementara atribut size bernilai 0?
   Jawab : Atribut front dan rear diatur menjadi -1 karena saat awal, antrian tersebut masih kosong dan belum ada elemen apa pun di dalamnya. Karena itu, kedua atribut tersebut menunjukkan posisi yang tidak valid dalam array data. Begitu juga, atribut size diatur ke nilai 0 karena saat awal tidak ada elemen yang ada dalam antrian. size digunakan untuk melacak jumlah elemen yang ada dalam antrian.
#### 2. Pada method Enqueue, jelaskan maksud dan kegunaan dari potongan kode berikut!
   Jawab : Antrian digunakan untuk mengelola sekuensensi penambahan dan penghapusan elemen. Ketika elemen baru ditambahkan ke antrian, rear akan bertambah dan menunjukkan posisi terakhir yang digunakan untuk menambahkan elemen. Namun, jika rear mencapai batas maksimum array, penambahan elemen akan dimulai lagi dari awal array. Elemen-elemen yang sudah ada akan mengisi ruang yang tersedia, bahkan setelah rear mencapai indeks maksimum array.
#### 3. Pada method Dequeue, jelaskan maksud dan kegunaan dari potongan kode berikut!
   Jawab : Code tersebut untuk mengimplementasikan siklus antrian agar dapat terus menghapus elemen dari antrian dengan benar, bahkan setelah front mencapai indeks maksimum array.
#### 4. Pada method print, mengapa pada proses perulangan variabel i tidak dimulai dari 0 (int i=0), melainkan int i=front?
   Jawab : agar dapat mencetak elemen-elemen dalam antrian secara berurutan, dimulai dari elemen pertama tanpa mencetak elemen yang tidak valid
#### 5. Perhatikan kembali method print, jelaskan maksud dari potongan kode berikut!
   Jawab : Potongan kode i = (i + 1) % max; digunakan dalam method print untuk memindahkan pointer i ke indeks selanjutnya dalam array data. Saat i bertambah satu, operasi modulo % max digunakan untuk memastikan bahwa jika i mencapai batas maksimum array (max), maka akan kembali ke indeks awal array (0).
#### 6. Tunjukkan potongan kode program yang merupakan queue overflow!
   Jawab :
```java
   public boolean IsFull() {
        if (size == max) {
            return true;
        } else {
            return false;
        }
    }
```
#### 7. Pada saat terjadi queue overflow dan queue underflow, program tersebut tetap dapat berjalan dan hanya menampilkan teks informasi. Lakukan modifikasi program sehingga pada saat terjadi queue overflow dan queue underflow, program dihentikan
   Jawab :
```java
   public boolean IsEmpty() {
        if (size == 0) {
            System.out.println("Queue underflow!");
            System.exit(0);
            return true;
        } else {
            return false;
        }
    }

    public boolean IsFull() {
        if (size == max) {
            System.out.println("Queue overflow!");
            System.exit(0);
            return true;
        } else {
            return false;
        }
    }
```


### 10.3 Praktikum 2
#### Class Nasabah25
```java
package Praktikum2;
public class Nasabah25 {
    String norek, nama, alamat;
    int umur;
    double saldo;

    Nasabah25(String norek, String nama, String alamat, int umur, double saldo) {
        this.norek = norek;
        this.nama = nama;
        this.alamat = alamat;
        this.umur = umur;
        this.saldo = saldo;
    }

    Nasabah25() {

    }
}
```

#### Class Queue25
```java
package Praktikum2;

public class Queue25 {
    Nasabah25[] data;
    int front, rear, size, max;

    public Queue25(int n) {
        max = n;
        data = new Nasabah25[max];
        size = 0;
        front = rear = -1;
    }

    public boolean IsEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean IsFull() {
        if (size == max) {
            return true;
        } else {
            return false;
        }
    }

    public void peek() {
        if (!IsEmpty()) {
            System.out.println("Elemen terdepan: " + data[front].norek + " " + data[front].nama
                    + " " + data[front].alamat + " " + data[front].umur + " " + data[front].saldo);
        } else {
            System.out.println("Queue masih kosong");
        }
    }

    public void print() {
        if (IsEmpty()) {
            System.out.println("Queue masih kosong");
        } else {
            int i = front;
            while (i != rear) {
                System.out.println(data[i].norek + " " + data[i].nama
                        + " " + data[i].alamat + " " + data[i].umur + " " + data[i].saldo);
                i = (i + 1) % max;
            }
            System.out.println(data[i].norek + " " + data[i].nama
                    + " " + data[i].alamat + " " + data[i].umur + " " + data[i].saldo);
            System.out.println("Jumlah elemen = " + size);
        }
    }

    public void clear() {
        if (!IsEmpty()) {
            front = rear = -1;
            size = 0;
            System.out.println("Queue berhasil dikosongkan");
        } else {
            System.out.println("Queue masih kosong");
        }
    }

    public void Enqueue(Nasabah25 dt) {
        if (IsFull()) {
            System.out.println("Queue sudah penuh");
        } else {
            if (IsEmpty()) {
                front = rear = 0;
            } else {
                if (rear == max - 1) {
                    rear = 0;
                } else {
                    rear++;
                }
            }
            data[rear] = dt;
            size++;
        }
    }

    public Nasabah25 Dequeue() {
        Nasabah25 dt = new Nasabah25();
        if (IsEmpty()) {
            System.out.println("Queue masih kosong");
        } else {
            dt = data[front];
            size--;
            if (IsEmpty()) {
                front = rear = -1;
            } else {
                if (front == max - 1) {
                    front = 0;
                } else {
                    front++;
                }
            }
        }
        return dt;
    }
}
```

#### QueueMain25
```java
package Praktikum2;

import java.util.Scanner;

public class QueueMain25 {
    public static void menu() {
        System.out.println("Pilih menu: ");
        System.out.println("1. Antrian baru");
        System.out.println("2. Antrian keluar");
        System.out.println("3. Cek Antrian terdepan");
        System.out.println("4. Cek Semua Antrian");
        System.out.println("-------------------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner Scanner = new Scanner(System.in);
        System.out.print("Masukkan kapasitas queue: ");
        int jumlah = sc.nextInt();
        Queue25 antri = new Queue25(jumlah);
        int pilih;

        do {
            menu();
            pilih = sc.nextInt();
            switch (pilih) {
                case 1:
                    System.out.print("No rekening : ");
                    String norek = Scanner.nextLine();
                    System.out.print("Nama : ");
                    String nama = Scanner.nextLine();
                    System.out.print("Alamat : ");
                    String alamat = Scanner.nextLine();
                    System.out.print("Umur : ");
                    int umur = sc.nextInt();
                    System.out.print("Saldo : ");
                    double saldo = sc.nextDouble();
                    sc.nextLine();
                    Nasabah25 nb = new Nasabah25(norek, nama, alamat, umur, saldo);
                    sc.nextLine();
                    antri.Enqueue(nb);
                    break;
                case 2:
                    Nasabah25 data = antri.Dequeue();
                    if (!"".equals(data.norek) && !"".equals(data.nama) && !"".equals(data.alamat)
                            && data.umur != 0 && data.saldo != 0) {
                        System.out.println("Antrian yang keluar : " + data.norek + " " + data.nama + " "
                                + data.alamat + " " + data.umur + " " + data.saldo);
                        break;
                    }
                case 3:
                    antri.peek();
                    break;
                case 4:
                    antri.print();
                    break;
            }
        } while (pilih == 1 || pilih == 2 || pilih == 3 || pilih == 4);
    }
}
```

#### Verifikasi Hasil
![alt text](<screenshots/Screenshot 2024-04-28 215108.png>)

### 10.3.3 Pertanyaan
#### 1. Pada class QueueMain, jelaskan fungsi IF pada potongan kode program berikut!
   Jawab : program memastikan bahwa hanya data nasabah01 yang valid yang akan ditampilkan setelah proses dequeue, dan jika data tersebut tidak valid, maka tidak akan ditampilkan.
#### 2. Lakukan modifikasi program dengan menambahkan method baru bernama peekRear pada class Queue yang digunakan untuk mengecek antrian yang berada di posisi belakang! Tambahkan pula daftar menu 5. Cek Antrian paling belakang pada class QueueMain sehingga method peekRear dapat dipanggil!
   Jawab :
#### Class Queue25
```java
public void peekRear() {
        if (!IsEmpty()) {
            System.out.println("Elemen paling belakang: " + data[rear].norek + " " + data[rear].nama
                    + " " + data[rear].alamat + " " + data[rear].umur + " " + data[rear].saldo);
        } else {
            System.out.println("Queue masih kosong");
        }
    }
```
#### QueueMain25
```java
package Praktikum2;

import java.util.Scanner;

public class QueueMain01 {
    public static void menu() {
        System.out.println("Pilih menu: ");
        System.out.println("1. Antrian baru");
        System.out.println("2. Antrian keluar");
        System.out.println("3. Cek Antrian terdepan");
        System.out.println("4. Cek Semua Antrian");
        System.out.println("5. Cek Antrian paling belakang");
        System.out.println("--------------------------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner Scanner = new Scanner(System.in);
        System.out.print("Masukkan kapasitas queue: ");
        int jumlah = sc.nextInt();
        Queue01 antri = new Queue01(jumlah);
        int pilih;

        do {
            menu();
            pilih = sc.nextInt();
            switch (pilih) {
                case 1:
                    System.out.print("No rekening : ");
                    String norek = Scanner.nextLine();
                    System.out.print("Nama : ");
                    String nama = Scanner.nextLine();
                    System.out.print("Alamat : ");
                    String alamat = Scanner.nextLine();
                    System.out.print("Umur : ");
                    int umur = sc.nextInt();
                    System.out.print("Saldo : ");
                    double saldo = sc.nextDouble();
                    sc.nextLine();
                    Nasabah01 nb = new Nasabah01(norek, nama, alamat, umur, saldo);
                    sc.nextLine();
                    antri.Enqueue(nb);
                    break;
                case 2:
                    Nasabah01 data = antri.Dequeue();
                    if (!"".equals(data.norek) && !"".equals(data.nama) && !"".equals(data.alamat)
                            && data.umur != 0 && data.saldo != 0) {
                        System.out.println("Antrian yang keluar : " + data.norek + " " + data.nama + " "
                                + data.alamat + " " + data.umur + " " + data.saldo);
                        break;
                    }
                case 3:
                    antri.peek();
                    break;
                case 4:
                    antri.print();
                    break;
                case 5:
                    antri.peekRear();
                    break;
            }
        } while (pilih == 1 || pilih == 2 || pilih == 3 || pilih == 4 || pilih == 5);
    }
}
```






