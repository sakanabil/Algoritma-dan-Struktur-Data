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


## JOBSHEET - VII
## STACK
### 2.1 Percobaan 1: Penyimpanan Tumpukan Barang dalam Gudang
#### CLASS Barang25
```java
public class Barang25 {
    int kode;
    String nama, kategori;

    public Barang25 (int kode, String nama, String kategori) {
        this.kode = kode;
        this.nama = nama;
        this.kategori = kategori;
    }
    
}
```
#### CLASS Gudang25
```java
public class Gudang25 {
    Barang25[] tumpukan;
    int size, top;

    public Gudang25(int kapasitas) {
        size = kapasitas;
        tumpukan = new Barang25[size];
        top = -1;
    }

    public boolean cekKosong() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean cekPenuh() {
        if (top == size - 1) {
            return true;
        } else {
            return false;
        }
    }

    public void tambahBarang(Barang25 brg) {
        if (!cekPenuh()) {
            top++;
            tumpukan[top] = brg;
            System.out.println("Barang " + brg.nama + " berhasil ditambahkan ke Gudang");
        } else {
            System.out.println("Gagal! Tumpukan barang di Gudang sudah penuh");
        }
    }

    public Barang25 ambilBarang() {
        if (!cekKosong()) {
            Barang25 delete = tumpukan[top];
            top--;
            System.out.println("Barang " + delete.nama + " diambil dari Gudang.");
            return delete;
        } else {
            System.out.println("Tumpukan barang kosong.");
            return null;
        }
    }

    public Barang25 lihatBarangTeratas() {
        if (!cekKosong()) {
            Barang25 barangTeratas = tumpukan[top];
            System.out.println("Barang teratas: " + barangTeratas.nama);
            return barangTeratas;
        } else {
            System.out.println("Tumpukan barang kosong.");
            return null;
        }
    }

    public void tampilkanBarang() {
        if (!cekKosong()) {
            System.out.println("Rincian tumpukan barang di Gudang:");
            //for (int i = top; i >= 0; i--) {
            for (int i = top; i >= 0; i--) {
                System.out.printf("Kode %s: %s (Kategori %s)\n", tumpukan[i].kode, tumpukan[i].nama, tumpukan[i].kategori);
            }
        } else {
            System.out.println("Tumpukan barang kosong.");
        }
    }
}
```

#### CLASS Utama25
```java
import java.util.Scanner;
public class Utama25 {

    public static void main(String[] args) {
        Gudang25 gudang = new Gudang25(7);
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah barang");
            System.out.println("2. Ambil barang");
            System.out.println("3. Tampilkan tumpukan barang");
            System.out.println("4. Keluar");
            System.out.print("Pilih operasi: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();
        
            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan kode barang: ");
                    int kode = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Masukkan nama barang: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan nama kategori: ");
                    String kategori = scanner.nextLine();
                    Barang25 barangBaru = new Barang25(kode, nama, kategori);
                    gudang.tambahBarang(barangBaru);
                    break;
                case 2:
                    gudang.ambilBarang();
                    break;
                case 3:
                    gudang.tampilkanBarang();
                    break;
                case 4:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                
            }
        }
    }
}
```
### 2.1.2 Verifikasi Hasil Percobaan
![alt text](<screenshots/Screenshot 2024-04-03 111256.png>)
![alt text](<screenshots/Screenshot 2024-04-03 111320.png>)

### 2.1.3 Pertanyaan
#### 1. Lakukan perbaikan pada kode program, sehingga keluaran yang dihasilkan sama dengan verifikasi hasil percobaan! Bagian mana saja yang perlu diperbaiki?
   Jawab : Pada method tampilkanBarang pada bagian
```java
            for (int i = top; i >= 0; i--) {
```
#### 2. Berapa banyak data barang yang dapat ditampung di dalam tumpukan? Tunjukkan potongan kode programnya!
   Jawab : Data yang dapat disimpan dalam tumpukan adalah sebanyak 7
```java
        Gudang25 gudang = new Gudang25(7);
```
#### 3. Mengapa perlu pengecekan kondisi !cekKosong() pada method tampilkanBarang? Kalau kondisi tersebut dihapus, apa dampaknya?
   Jawab : Pengecekan !cekKosong() digunakan untuk memastikan bahwa tumpukan barang tidak kosong sebelum menampilkan rinciannya. Jika kondisi tersebut dihapus, maka program akan mencoba menampilkan rincian barang tanpa memeriksa apakah tumpukan kosong terlebih dahulu. Hal ini dapat mengakibatkan error saat mencoba mengakses tumpukan barang yang kosong.

#### 4. Modifikasi kode program pada class Utama sehingga pengguna juga dapat memilih operasi lihat barang teratas, serta dapat secara bebas menentukan kapasitas gudang!
   Jawab : 
```java
                case 4:
                    gudang.lihatBarangTeratas();
                    break;
```
```java
        System.out.println("Masukkan kapasitas Gudang: ");
        int kapasitas = scanner.nextInt();
        Gudang25 gudang = new Gudang25(kapasitas);
```
#### Outputnya
![alt text](<screenshots/Screenshot 2024-04-03 113433.png>)
![alt text](<screenshots/Screenshot 2024-04-03 113446.png>)

#### 5. Commit dan push kode program ke Github
   Jawab : Sudah.

### 2.2 Percobaan 2: Konversi Kode Barang ke Biner
#### CLASS Gudang25
```java
    public String konversiDesimalKeBiner(int kode) {
        StackKonversi25 stack = new StackKonversi25();
        while (kode > 0) {
            int sisa = kode % 2;
            stack.push(sisa);
            kode = kode / 2;
        }
        String biner = new String();
        while (!stack.isEmpty()) {
            biner += stack.pop();
        }
        return biner;
    }
```
#### CLASS StackKonversi25
```java
public class StackKonversi25 {
    int size;
    int[] tumpukanBiner;
    int top;

    public StackKonversi25() {
        this.size = 32;
        tumpukanBiner = new int[size];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public void push(int data) {
        if (isFull()) {
            System.out.println("Stack penuh");
        } else {
            top++;
            tumpukanBiner[top] = data;
        }
    }   

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack kosong");
            return -1;
        } else {
            int data = tumpukanBiner[top];
            top--;
            return data;
        }
    }
}
```
#### CLASS Gudang25 pada method ambilBarang
```java
    public Barang25 ambilBarang() {
        if (!cekKosong()) {
            Barang25 delete = tumpukan[top];
            top--;
            System.out.println("Barang " + delete.nama + " diambil dari Gudang.");
            System.out.println("Kode unik dalam biner: " + konversiDesimalKeBiner(delete.kode));
            return delete;
        } else {
            System.out.println("Tumpukan barang kosong.");
            return null;
        }
    }
```

### 2.2.2 Verifikasi Hasil Percobaan
![alt text](<screenshots/Screenshot 2024-04-03 114832.png>)


### 2.2.3 Pertanyaan
#### 1. Pada method konversiDesimalKeBiner, ubah kondisi perulangan menjadi while (kode != 0), bagaimana hasilnya? Jelaskan alasannya!
   Jawab : Hasilnya akan tetap sama. Perulangan akan terus berjalan selama nilai kode lebih besar dari 0 dalam kedua kasus tersebut.
#### 2. Jelaskan alur kerja dari method konversiDesimalKeBiner!
   Jawab : Objek StackKonversi25 dibuat untuk menyimpan sisa pembagian bilangan desimal dengan 2. kemudian Selama nilai kode lebih besar dari 0, akan dilakukan perulangan, Sisa pembagian kode dengan 2 dihitung dan disimpan dalam variabel sisa. Nilai sisa dimasukkan ke dalam stack menggunakan metode push. Nilai kode dibagi dengan 2 untuk mengurangi nilainya. Setelah selesai perulangan, dilakukan inisialisasi string biner. Selama stack tidak kosong, akan dilakukan perulangan, Nilai dari stack diambil menggunakan metode pop dan ditambahkan ke dalam string biner. Nilai biner yang telah terbentuk dari perulangan sebelumnya dikembalikan sebagai output dari metode.

### 2.3 Percobaan 3: Konversi Notasi Infix ke Postfix
#### CLASS Postfix25
```java
public class Postfix25 {
    int n, top, push;
    char[] stack;

    public Postfix25(int total) {
        n = total;
        top = -1;
        stack = new char[n];
        push ('(');
    }

    public void push(char c) {
        top++;
        stack[top] = c;
    }

    public char pop() {
        char item = stack[top];
        top--;
        return item;
    }

    public boolean isOperand(char c) {
        if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == ' ' || c == '.') {
            return true;
        } else {
            return false;
        }
    }

    public boolean isOperator(char c) {
        if (c == '^' || c == '%' || c == '/' || c == '*' || c == '-' || c == '+') {
            return true;
        } else {
            return false;
        }
    }

    public int derajat(char c) {
        switch (c) {
            case '^':
                return 3;
            case '%':
                return 2;
            case '/':
                return 2;
            case '*':
                return 2;
            case '-':
                return 1;
            case '+':
                return 1;
            default:
                return 0;
        }
    }

    public String konversi(String Q) {
        String P = "";
        char c;
        for (int i = 0; i < n; i++) {
            c = Q.charAt(i);
            if (isOperand(c)) {
                P = P + c;
            }
            if (c == '(') {
                push(c);
            }
            if (c == ')') {
                while (stack[top] != '(') {
                    P = P + pop();
                }
                pop();
            }
            if (isOperator(c)) {
                while (derajat(stack[top]) >= derajat(c)) {
                    P = P + pop();
                }
                push(c);
            }
        }
        return P;
    }
}
```
#### CLASS PostfixMain25
```java
import java.util.Scanner;
public class PostfixMain25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String P, Q;
        System.out.println("Masukkan ekspresi matematika (infix): ");
        Q = sc.nextLine();
        Q = Q.trim();
        Q = Q + ")";

        int total = Q.length();

        Postfix25 post = new Postfix25(total);
        P = post.konversi(Q);
        System.out.println("Postfix: " + P);
    }
}
```
### 2.3.2 Verifikasi Hasil Percobaan
![alt text](<screenshots/Screenshot 2024-04-03 124909.png>)

### 2.3.3 Pertanyaan
#### 1. Pada method derajat, mengapa return value beberapa case bernilai sama? Apabila return value diubah dengan nilai berbeda-beda setiap case-nya, apa yang terjadi?
   Jawab : Pada method derajat, return value beberapa case bernilai sama karena operator tersebut memiliki tingkat prioritas yang sama dalam ekspresi matematika. Jika return value diubah dengan nilai berbeda-beda setiap casenya, maka akan menghasilkan hitungan yang berbeda sesuai dengan prioritas operator yang baru.
#### 2. Jelaskan alur kerja method konversi!
   Jawab : Pertama membuat string kosong P yang digunakan untuk menyimmpan hasil konversi, kemudian melakukan iterasi pada String Q untuk setiap karakternya, jika karakter tsb adalah operand maka akan ditambahkan ke string P, jika karakter tsb adalah "(", maka akan dimasukkan ke dalam stack. jika karakter tsb adalah ")" maka dilakukan pengosongan stack sampai ditemukan "(" setiap karakter yang dikeluarkan dari stack dimasukkan kedalam string P. jika karakter tsb adalah operator maka akan dilakukan pengecekan prioritas operator dii stack, jika sudah di cek maka akan dimasukkan ke dalam string P, Hal ini dilakukan hingga prioritas operator di stack lebih rendah dari operator saat ini. Kemudian operator saat ini dimasukkan ke dalam stack. Setelah iterasi selesai, hasil konversi yang disimpan dalam string P dikembalikan.
#### 3. Pada method konversi, apa fungsi dari potongan kode berikut?
![alt text](<screenshots/Screenshot 2024-04-03 130745.png>)
<br>
   Jawab : Potongan kode c = Q.charAt(i); berfungsi untuk mengambil karakter pada indeks ke-i dari string Q dan menyimpannya ke dalam variabel c.