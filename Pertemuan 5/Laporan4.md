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


## JOBSHEET IV
## BRUTE FORCE DAN DIVIDE CONQUER

### 4.2 Menghitung Nilai Faktorial dengan Algoritma Brute Force dan Divide and Conquer
### 4.2.1 Langkah-langkah Percobaan
#### CLASS 
```java
public class Faktorial {
    public int nilai;

    public int faktorialBF(int n) {
        int fakto = 1;
        for (int i = 1; i <= n; i++) {
            fakto = fakto * i;
        }
        return fakto;
    }

    public int faktorialDC(int n) {
        if (n == 1) {
            return 1;
        } else {
            int fakto = n * faktorialDC(n - 1);
            return fakto;
        }
    }
}
```
<br>

#### MAIN
```java
import java.util.Scanner;
public class MainFaktorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------");
        System.out.println("Masukkan jumlah elemen: ");
        int iJml = sc.nextInt();

        Faktorial[] fk = new Faktorial[10];

        for(int i=0; i<iJml; i++){
            fk[i] = new Faktorial();
            System.out.println("Masukkan elemen ke-"+(i+1)+":");
            fk[i].nilai = sc.nextInt();

        }

        System.out.println("HASIL - BRUTE FORCE");
        for(int i=0; i<iJml; i++){
            System.out.println("Hasil penghitungan faktorial menggunakan Brute Force adalah " + fk[i].faktorialBF(fk[i].nilai));
        }
        System.out.println("HASIL - DIVIDE AND CONQUER");
        for(int i=0; i<iJml; i++){
            System.out.println("Hasil penghitungan faktorial menggunakan Divide and Conquer adalah " + fk[i].faktorialDC(fk[i].nilai));
        }
    }
}
```
### 4.2.2 Verifikasi Hasil Percobaan
![alt text](<screenshots/Screenshot 2024-03-13 113723.png>)

### 4.2.3 Pertanyaan
#### 1. Pada base line Algoritma Divide Conquer untuk melakukan pencarian nilai faktorial, jelaskan perbedaan bagian kode pada penggunaan if dan else!
    Jawab : Perbedaan bagian if dan else pada base line Algoritma Divide Conquer untuk melakukan pencarian nilai faktorial yaitu, bagian IF adalah base case untuk menghentikan rekursi ketika n mencapai 1, sedangkan bagian ELSE adalah rekursif call untuk memecah masalah menjadi lebih kecil dengan menghitung faktorial n-1 dan menggabungkannya dengan nilai n.
#### 2. Apakah memungkinkan perulangan pada method faktorialBF() dirubah selain menggunakan for?Buktikan!
    Jawab : Bisa, 


```java
    public int faktorialBF(int n) {
        int fakto = 1;
        int i = 1;
        while (int i <= n) {
            fakto = fakto * i;
            i++;
        }
        return fakto;
    }
```

#### 3. Jelaskan perbedaan antara fakto *= i; dan int fakto = n * faktorialDC(n-1); !
    Jawab : fakto *= i; digunakan untuk memperbaharui nilai faktorial secara bertahap secara iteratif, sedangkan int fakto = n * faktorialDC(n-1); digunakan untuk menetapkan nilai faktorial baru hasil dari perhitungan rekursif dalam pendekatan Divide and Conquer.

<br>

### 4.3 Menghitung Hasil Pangkat dengan Algoritma Brute Force dan Divide and Conquer
### 4.3.1 Langkah-langkah Percobaan
### CLASS
```java
public class Pangkat {
    public int nilai, pangkat;

    int pangkatBF(int a, int n){
        int hasil = 1;
        for (int i=0; i<n; i++){
            hasil *= a;
        }
        return hasil;
    }

    int pangkatDC(int a, int n){
        if(n==0){
            return 1;
        }else{
            if(n%2==1)
            {
                return (pangkatDC(a,n/2)*pangkatDC(a,n/2)*a);
            }else{
                return (pangkatDC(a,n/2)*pangkatDC(a,n/2));
            }
        }
    }
}
```
<br>

### MAIN
```java
import java.util.Scanner;

public class MainPangkat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=============================");
        System.out.println("Masukkan jumlah elemen yang dihitung: ");
        int elemen = sc.nextInt();

        Pangkat[] png = new Pangkat[elemen];
        for (int i=0; i<elemen; i++){
            png[i] = new Pangkat();
            System.out.println("Masukkan nilai yang hendak dipangkatkan: ");
            png[i].nilai = sc.nextInt();
            System.out.println("Masukkan nilai pemangkat: ");
            png[i].pangkat = sc.nextInt();
        }

        System.out.println("HASIL PANGKAT - BRUTE FORCE");
        for (int i=0; i<elemen; i++){
            System.out.println("Hasil dari " + png[i].nilai + " pangkat " + png[i].pangkat + " adalah " + png[i].pangkatBF(png[i].nilai, png[i].pangkat));
        }
        System.out.println("HASIL PANGKAT - DIVIDE AND CONQUER");
        for (int i=0; i<elemen; i++){
            System.out.println("Hasil dari " + png[i].nilai + " pangkat " + png[i].pangkat + " adalah " + png[i].pangkatDC(png[i].nilai, png[i].pangkat));
        }
    }
}
```

### 4.3.2 Verifikasi Hasil Percobaan
![alt text](<screenshots/Screenshot 2024-03-13 133137.png>)

### 4.3.3 Pertanyaan
#### 1. Jelaskan mengenai perbedaan 2 method yang dibuat yaitu PangkatBF() dan PangkatDC()!
    Jawab : pangkatBF lebih efisien untuk nilai n yang kecil karena menggunakan perulangan iteratif yang sederhana. sedangkan pangkatDC lebih efisien untuk nilai n yang besar karena menggunakan divide and conquer memecah perhitungan menjadi lebih kecil dengan pembagian n/2 namun membutuhkan overhead pemanggila fungsi rekursif.
#### 2. Apakah tahap combine sudah termasuk dalam kode tersebut?Tunjukkan!
    Jawab : Ya, tahap combine sudah termasuk dalam kode tersebut
```java
if (n % 2 == 1) {
    return (pangkatDC(a, n / 2) * pangkatDC(a, n / 2) * a);
} else {
    return (pangkatDC(a, n / 2) * pangkatDC(a, n / 2));
    }
```

#### 3. Modifikasi kode program tersebut, anggap proses pengisian atribut dilakukan dengan konstruktor.
    Jawab :
#### CLASS
```java
public class Pangkat {
    public int nilai, pangkat;

    public Pangkat(int nilai, int pangkat) {
        this.nilai = nilai;
        this.pangkat = pangkat;
    }

    int pangkatBF(int a, int n) {
        int hasil = 1;
        for (int i = 0; i < n; i++) {
            hasil *= a;
        }
        return hasil;
    }

    int pangkatDC(int a, int n) {
        if (n == 0) {
            return 1;
        } else {
            if (n % 2 == 1) {
                return (pangkatDC(a, n / 2) * pangkatDC(a, n / 2) * a);
            } else {
                return (pangkatDC(a, n / 2) * pangkatDC(a, n / 2));
            }
        }
    }
}
```
#### MAIN
```java
import java.util.Scanner;

public class MainPangkat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("========================================");
        System.out.println("Masukkan jumlah elemen yang dihitung: ");
        int elemen = sc.nextInt();

        Pangkat[] png = new Pangkat[elemen];
        for (int i = 0; i < elemen; i++) { 
            System.out.println("Masukkan nilai yang hendak dipangkatkan: ");
            int nilai = sc.nextInt();
            System.out.println("Masukkan nilai pemangkat: ");
            int pangkat = sc.nextInt();
            png[i] = new Pangkat(nilai, pangkat);
        }

        System.out.println("HASIL PANGKAT - BRUTE FORCE");
        for (int i = 0; i < elemen; i++) {
            System.out.println("Hasil dari "+ png[i].nilai + " pangkat "+ png[i].pangkat + " adalah "+ png[i].pangkatBF(png[i].nilai, png[i].pangkat));
        }
        System.out.println("HASIL PANGKAT - DIVIDE AND CONQUER");
        for (int i = 0; i < elemen; i++) {
            System.out.println("Hasil dari "+ png[i].nilai + " pangkat "+ png[i].pangkat + " adalah "+ png[i].pangkatDC(png[i].nilai, png[i].pangkat));
        }
    }
}
```

#### 4. Tambahkan menu agar salah satu method yang terpilih saja yang akan dijalankan menggunakan switch-case!
    Jawab :
```java
import java.util.Scanner;

public class MainPangkat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("========================================");
        System.out.println("Masukkan jumlah elemen yang dihitung: ");
        int elemen = sc.nextInt();

        Pangkat[] png = new Pangkat[elemen];
        for (int i = 0; i < elemen; i++) {
            System.out.println("Masukkan nilai yang hendak dipangkatkan: ");
            int nilai = sc.nextInt();
            System.out.println("Masukkan nilai pemangkat: ");
            int pangkat = sc.nextInt();
            png[i] = new Pangkat(nilai, pangkat);
        }

        System.out.println("Pilih metode:");
        System.out.println("1. Brute Force");
        System.out.println("2. Divide and Conquer");
        System.out.print("Pilihan Anda: ");
        int pilihan = sc.nextInt();

        switch (pilihan) {
            case 1:
                System.out.println("HASIL PANGKAT - BRUTE FORCE");
                for (int i = 0; i < elemen; i++) {
                    int hasil = png[i].pangkatBF(png[i].nilai, png[i].pangkat);
                    System.out.println("Hasil dari " + png[i].nilai + " pangkat " + png[i].pangkat + " adalah " + hasil);
                }
                break;
            case 2:
                System.out.println("HASIL PANGKAT - DIVIDE AND CONQUER");
                for (int i = 0; i < elemen; i++) {
                    int hasil = png[i].pangkatDC(png[i].nilai, png[i].pangkat);
                    System.out.println("Hasil dari " + png[i].nilai + " pangkat " + png[i].pangkat + " adalah " + hasil);
                }
                break;
            default:
                System.out.println("Pilihan tidak valid.");
        }
    }
}
```

### 4.4 Menghitung Sum Array dengan Algoritma Brute Force dan Divide and Conquer
### 4.4.1 Langkah-langkah Percobaan
### CLASS
```java
public class Sum26 {
    int elemen;
    double keuntungan[], total;

    Sum26(int elemen) {
        this.elemen = elemen;
        this.keuntungan = new double[elemen];
        this.total = 0;
    }

    double totalBF(double arr[]) {
        for (int i = 0; i < elemen; i++) {
            total = total + arr[i];
        }
        return total;
    }

    double totalDC(double arr[], int l, int r) {
        if (l == r) {
            return arr[l];
        } else if (l < r) {
            int mid = (l + r) / 2;
            double lsum = totalDC(arr, l, mid);
            double rsum = totalDC(arr, mid + 1, r);
            return lsum + rsum;
        }
        return 0;
    }
}
```

### MAIN
```java
import java.util.Scanner;
public class MainSum26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=======================================================");
        System.out.println("Program Menghitung Keuntungan Total (Satuan Juta. Misal 5.9)");
        System.out.print("Masukkan jumlah Bulan : ");
        int elm = sc.nextInt();

        Sum26 sm = new Sum26(elm);
        System.out.println("=======================================================");
        for (int i = 0; i < elm; i++){
            System.out.print("Masukkan untung Bulan ke-"+(i+1)+" = ");
            sm.keuntungan[i] = sc.nextDouble();
        }

        System.out.println("=======================================================");
        System.out.println("Algoritma Brute Force");
        System.out.println("Total keuntungan perusahaan = " + sm.elemen + " bulan adalah = "+sm.totalBF(sm.keuntungan));
        System.out.println("=======================================================");
        System.out.println("Algoritma Divide and Conquer");
        System.out.println("Total keuntungan perusahaan selama = " + sm.elemen + " bulan adalah = "+sm.totalDC(sm.keuntungan, 0, sm.elemen-1));
    }
}
```

### 4.4.2 Verifikasi Hasil Percobaan
![alt text](<screenshots/Screenshot 2024-03-23 221742.png>)

### 4.4.3 Pertanyaan
#### 1. Mengapa terdapat formulasi return value berikut?Jelaskan!
    Jawab : return arr[1]; berperan sebagai penghentian rekursi ketika function totalDC telah mencapai elemen tunggal pada array arr. yang menandakan bahwa proses pembagian masalah menjadi lebih kecil sudah selesai dan bisa mulai menggabungkan hasil perhitungan dari pembagian tsb.
#### 2. Kenapa dibutuhkan variable mid pada method TotalDC()?
    Jawab : Variabel mid berperan penting dalam implementasi metode divide and conquer untuk memecahkan masalah penjumlahan masalah penjumlahan elemen array. berfungsi sbg titik pemisah array, mengontron jangkauan pemanggilan rekursif dan memungkinkan penggabungan hasil secara bertahap untuk menghasilkan solusi akhir.

#### 3. Program perhitungan keuntungan suatu perusahaan ini hanya untuk satu perusahaan saja. Bagaimana cara menghitung sekaligus keuntungan beberapa bulan untuk beberapa perusahaan.(Setiap perusahaan bisa saja memiliki jumlah bulan berbeda-beda)? Buktikan dengan program!
    Jawab :
#### CLASS
```java
public class Sum26 {
    int elemen;
    double[] keuntungan;
    double total;

    Sum26(int elemen) {
        this.elemen = elemen;
        this.keuntungan = new double[elemen];
        this.total = 0;
    }

    public void setKeuntungan(double[] keuntungan) {
        this.keuntungan = keuntungan;
    }

    double totalBF() {
        total = 0;
        for (int i = 0; i < elemen; i++) {
            total = total + keuntungan[i];
        }
        return total;
    }

    double totalDC(int l, int r) {
        if (l == r) {
            return keuntungan[l];
        } else if (l < r) {
            int mid = (l + r) / 2;
            double lsum = totalDC(l, mid);
            double rsum = totalDC(mid + 1, r);
            return lsum + rsum;
        }
        return 0;
    }
}
```
#### MAIN
```java
import java.util.Scanner;

public class MainSum26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("============================================================");
        System.out.println("Program Menghitung Keuntungan Total (Satuan Juta, Misal 5,9)");
        System.out.print("Masukkan jumlah perusahaan: ");
        int jumlahPerusahaan = sc.nextInt();
        System.out.print("Masukkan jumlah bulan: ");
        int jumlahBulan = sc.nextInt();

        double[][] keuntunganPerusahaan = new double[jumlahPerusahaan][jumlahBulan];

        for (int i = 0; i < jumlahPerusahaan; i++) {
            System.out.println("============================================================");
            System.out.println("Masukkan data keuntungan untuk Perusahaan " + (i + 1) + ":");
            for (int j = 0; j < jumlahBulan; j++) {
                System.out.print("Masukkan untung bulan ke-" + (j + 1) + " = ");
                keuntunganPerusahaan[i][j] = sc.nextDouble();
            }
        }

        for (int i = 0; i < jumlahPerusahaan; i++) {
            Sum26 sm = new Sum26(jumlahBulan);
            sm.setKeuntungan(keuntunganPerusahaan[i]);
            System.out.println("============================================================");
            System.out.println("Perusahaan " + (i + 1));
            System.out.println("Algoritma Brute Force");
            System.out.println("Total keuntungan perusahaan selama " + jumlahBulan + " bulan adalah = " + sm.totalBF());
            System.out.println("Algoritma Divide Conquer");
            System.out.println("Total keuntungan perusahaan selama " + jumlahBulan + " bulan adalah = " + sm.totalDC(0, jumlahBulan - 1));
        }
    }
}
```

#### Outputnya
![alt text](<screenshots/Screenshot 2024-03-23 230421.png>)

### 4.5 Latihan Praktikum
### CLASS
```java
public class DaftarMobil26 {
    String merk[] = { "BMW", "Ford", "Nissan", "Subaru", "Toyota", "Volkswagen" };
    String tipe[] = { "M2 Coupe", "Fiesta ST", "370Z", "BRZ", "Impreza WRX STI", "AE86 Trueno", "86/GT86", "Golf GTI" };
    int tahun[] = { 2016, 2014, 2009, 2014, 2013, 1986, 2014, 2014 };
    int topAcceleration[] = { 6816, 3921, 4360, 4058, 6255, 3700, 4180, 4180 };
    int topPower[] = { 728, 575, 657, 609, 703, 553, 609, 631 };

    int maxAcceleration(int arr[], int l, int r) {
        if (l == r) {
            return arr[l];
        } else {
            int mid = (l + r) / 2;
            int left = maxAcceleration(arr, l, mid);
            int right = maxAcceleration(arr, mid + 1, r);

            int maxAcceleration;
            if (left > right) {
                maxAcceleration = left;
            } else {
                maxAcceleration = right;
            }
            return maxAcceleration;
        }
    }
    int minAcceleration(int arr[], int l, int r) {
        if (l == r) {
            return arr[l];
        } else {
            int mid = (l + r) / 2;
            int left = minAcceleration(arr, l, mid);
            int right = minAcceleration(arr, mid + 1, r);

            int minAcceleration;
            if (left < right) {
                minAcceleration = left;
            } else {
                minAcceleration = right;
            }
            return minAcceleration;
        }
    }
    double rataPower() {
        double totalPower = 0;
        for (int i = 0; i < topPower.length; i++) {
            totalPower += topPower[i];
        }
        return totalPower / topPower.length;
    }
}
```
### MAIN
```java
public class MainMobil26 {
    public static void main(String[] args) {

        DaftarMobil26 outputMobil = new DaftarMobil26();
        System.out.println("Mobil Top Acceleration Tertinggi : "
                + outputMobil.maxAcceleration(outputMobil.topAcceleration, 0, outputMobil.topAcceleration.length - 1));
        System.out.println("Mobil Top Acceleration Terendah : "
                + outputMobil.minAcceleration(outputMobil.topAcceleration, 0, outputMobil.topAcceleration.length - 1));
        System.out.println("Rata-rata Top Power Adalah " + outputMobil.rataPower());
    }
}
```
### Outputnya
![alt text](<screenshots/Screenshot 2024-03-23 222540.png>)







