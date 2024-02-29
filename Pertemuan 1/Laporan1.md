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
### 2.1 Pemilihan
```java
import java.util.Scanner;

public class Pemilihan26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Program Menghitung Nilai Akhir");

        System.out.println("============================");
        System.out.print("Masukkan nilai Tugas: ");
        double tugas = sc.nextDouble();

        System.out.print("Masukkan nilai Kuis: ");
        double kuis = sc.nextDouble();

        System.out.print("Masukkan nilai UTS: ");
        double uts = sc.nextDouble();

        System.out.print("Masukkan nilai UAS: ");
        double uas = sc.nextDouble();
        System.out.println("============================");

        if (!isValid(tugas) || !isValid(kuis) || !isValid(uts) || !isValid(uas)) {
            System.out.println("============================");
            System.out.println("Nilai tidak valid");
            System.out.println("============================");
            System.out.println("============================");
        } else {
            double nilaiAkhir = 0.2 * tugas + 0.2 * kuis + 0.3 * uts + 0.3 * uas;
            String nilaiHuruf;
            if (nilaiAkhir >= 80) {
                nilaiHuruf = "A";
            } else if (nilaiAkhir >= 73) {
                nilaiHuruf = "B+";
            } else if (nilaiAkhir >= 65) {
                nilaiHuruf = "B";
            } else if (nilaiAkhir >= 60) {
                nilaiHuruf = "C+";
            } else if (nilaiAkhir >= 50) {
                nilaiHuruf = "C";
            } else if (nilaiAkhir >= 39) {
                nilaiHuruf = "D";
            } else {
                nilaiHuruf = "E";
            }

            String keterangan = nilaiHuruf.equals("D") || nilaiHuruf.equals("E") ? "ANDA TIDAK LULUS"
                    : "SELAMAT ANDA LULUS";

            System.out.println("============================");
            System.out.println("Nilai Akhir: " + nilaiAkhir);
            System.out.println("Nilai Huruf: " + nilaiHuruf);
            System.out.println("============================");
            System.out.println("============================");
            System.out.println(keterangan);
        }
    }

    public static boolean isValid(double nilai) {
        return nilai >= 0 && nilai <= 100;
    }
}
```
Outpunya : <br>
![alt text](<screenshots/Screenshot 2024-02-29 111136.png>)

### 2.2 Perulangan
```java
import java.util.Scanner;

public class Perulangan26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan NIM: ");
        String nim = sc.nextLine();

        int n = Integer.parseInt(nim.substring(nim.length() - 2));

        if (n < 10) {
            n += 10;
        }

        System.out.println("=====================");
        System.out.println("n : " + n);
        System.out.print("");

        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0) {
                System.out.print("* ");
            } else if (i == 6 || i == 10) {
                continue;
            } else {
                System.out.print(i + " ");
            }
        }
    }
}
```
Outputnya : <br>
![alt text](<screenshots/Screenshot 2024-02-29 111841.png>)


### 2.3 Array
```java
import java.util.Scanner;

public class Array26 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] mataKuliah = { "Pancasila", "Konsep Teknologi Informasi", "Critical Thinking and Problem Solving",
                "Matematika Dasar", "Bahasa Inggris", "Dasar Pemrograman", "Praktikum Dasar Pemrograman",
                "Keselamatan dan Kesehatan Kerja" };
        double[] sks = { 2, 2, 2, 3, 2, 2, 3, 2 };

        System.out.println("==============================");
        System.out.println("Program Menghitung IP Semester");
        System.out.println("==============================");

        double[] nilaiAngka = new double[mataKuliah.length];

        for (int i = 0; i < mataKuliah.length; i++) {
            System.out.print("Masukkan nilai Angka untuk MK " + mataKuliah[i] + ": ");
            nilaiAngka[i] = input.nextDouble();
        }

        System.out.println("\nHasil Konversi Nilai");
        System.out.println("==============================");
        System.out.printf("%-40s %-15s %-15s %-15s\n", "MK", "Nilai Angka", "Nilai Huruf", "Bobot Nilai");

        double totalBobotSks = 0;
        double totalSks = 0;

        for (int i = 0; i < mataKuliah.length; i++) {
            String nilaiHuruf = konversiNilaiHuruf(nilaiAngka[i]);
            double bobotNilai = konversiNilaiSetara(nilaiAngka[i]);
            double bobotSks = bobotNilai * sks[i];
            totalBobotSks += bobotSks;
            totalSks += sks[i];
            System.out.printf("%-40s %-15.2f %-15s %-15.2f\n", mataKuliah[i], nilaiAngka[i], nilaiHuruf,
                    bobotNilai);
        }

        double ipSemester = totalBobotSks / totalSks;
        System.out.println("==============================");
        System.out.println("IP : " + String.format("%.2f", ipSemester));
    }

    public static String konversiNilaiHuruf(double nilaiAngka) {
        if (nilaiAngka >= 80) {
            return "A";
        } else if (nilaiAngka >= 75) {
            return "B+";
        } else if (nilaiAngka >= 65) {
            return "B";
        } else if (nilaiAngka >= 60) {
            return "C+";
        } else if (nilaiAngka >= 50) {
            return "C";
        } else if (nilaiAngka >= 40) {
            return "D";
        } else {
            return "E";
        }
    }

    public static double konversiNilaiSetara(double nilaiAngka) {
        if (nilaiAngka >= 80) {
            return 4;
        } else if (nilaiAngka >= 75) {
            return 3.5;
        } else if (nilaiAngka >= 65) {
            return 3;
        } else if (nilaiAngka >= 60) {
            return 2.5;
        } else if (nilaiAngka >= 50) {
            return 2;
        } else if (nilaiAngka >= 40) {
            return 1;
        } else {
            return 0;
        }
    }
}
```
Outputnya : <br>
![alt text](<screenshots/Screenshot 2024-02-29 113354.png>)

### 2.4 Fungsi
```java
public class Fungsi26 {
    
    static int stokBunga[][] = {
            { 10, 5, 15, 7 },
            { 6, 11, 9, 12 },
            { 2, 10, 10, 5 },
            { 5, 7, 12, 9 }
    };
    
    static int hargaBunga[] = { 75000, 50000, 60000, 10000 };
    
    static void pendapatanCabang() {
        System.out.println("Pendapatan cabang Royal Garden");
        System.out.println("===============================");
        for (int i = 0; i < stokBunga.length; i++) {
            int totalPendapatan = 0;
            for (int j = 0; j < stokBunga[i].length; j++) {
                totalPendapatan += stokBunga[i][j] * hargaBunga[j];
            }
            System.out.println("Pendapatan cabang Royal Garden " + (i + 1) + ": Rp " + totalPendapatan);
        }
    }
    
    static String NamaBunga(int index) {
        switch (index) {
            case 0:
                return "Aglonema";
            case 1:
                return "Keladi";
            case 2:
                return "Alocasia";
            case 3:
                return "Mawar";
            default:
                return "Bunga Tidak Ada";
        }
    }
    static void jumlahStockPerJenisBunga() {
        System.out.println("=================================================");
        System.out.println("Sisa stok bunga pada cabang Royal Garden 4: ");
        System.out.println("=================================================");
        System.out.println("Stok " + NamaBunga(0) + ": " + (stokBunga[3][0] - 1));
        System.out.println("Stok " + NamaBunga(1) + ": " + (stokBunga[3][1] - 2));
        System.out.println("Stok " + NamaBunga(2) + ": " + stokBunga[3][2]);
        System.out.println("Stok " + NamaBunga(3) + ": " + (stokBunga[3][3] - 5));
    }
    
    public static void main(String[] args) {
        pendapatanCabang();
        jumlahStockPerJenisBunga();
    }
}
```
Outputnya : <br>
![alt text](<screenshots/Screenshot 2024-02-29 113951.png>)

## 3. Tugas
### TUGAS 1
```java
import java.util.Scanner;

public class Tugas126 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] kodePlat = {'A', 'B', 'D', 'E', 'F', 'G', 'H', 'L', 'N', 'T'};
        char[][] kota = {
            { 'B', 'A', 'N', 'T', 'E', 'N' },
            { 'J', 'A', 'K', 'A', 'R', 'T', 'A' },
            { 'B', 'A', 'N', 'D', 'U', 'N', 'G' },
            { 'C', 'I', 'R', 'E', 'B', 'O', 'N' },
            { 'B', 'O', 'G', 'O', 'R' },
            { 'P', 'E', 'K', 'A', 'L', 'O', 'N', 'G', 'A', 'N' },
            { 'S', 'E', 'M', 'A', 'R', 'A', 'N', 'G' },
            { 'S', 'U', 'R', 'A', 'B', 'A', 'Y', 'A' },
            { 'M', 'A', 'L', 'A', 'N', 'G' },
            { 'T', 'E', 'G', 'A', 'L' }
        };
        
        System.out.print("Masukkan kode plat nomor : ");
        char kode = sc.next().charAt(0);

        int index = -1;
        
        for (int i = 0; i < kodePlat.length; i++) {
            if (kodePlat[i] == kode) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            
            System.out.println("Kota yang sesuai dengan kode plat nomor " + kode + " adalah : ");
            for (int i = 0; i < kota[index].length; i++) {
                System.out.print(kota[index][i] + " "); 
            }
        } else {
            System.out.println("Kode plat nomor tidak valid.");
        }
    }
}
```
Outputnya : <br>
![alt text](<screenshots/Screenshot 2024-02-29 114904.png>)

### TUGAS 2
```java
import java.util.Scanner;

public class Tugas226 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int menu;
        do {
            System.out.println("Pilih Menu:");
            System.out.println("1. Hitung Kecepatan");
            System.out.println("2. Hitung Jarak");
            System.out.println("3. Hitung Waktu");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1-4): ");
            menu = sc.nextInt();

            switch (menu) {
                case 1:
                    hitungKecepatan();
                    break;
                case 2:
                    hitungJarak();
                    break;
                case 3:
                    hitungWaktu();
                    break;
                case 4:
                    System.out.println("Keluar Program.");
                    break;
                default:
                    System.out.println("Menu tidak ada.");
            }
        } while (menu != 4);
    }

    static void hitungKecepatan() {
        System.out.print("Masukkan jarak (km): ");
        double jarak = sc.nextDouble();
        System.out.print("Masukkan waktu (jam): ");
        double waktu = sc.nextDouble();

        double kecepatan = jarak / waktu;
        System.out.println("Kecepatan = " + kecepatan + " km/jam");
    }

    static void hitungJarak() {
        System.out.print("Masukkan kecepatan (km/jam): ");
        double kecepatan = sc.nextDouble();
        System.out.print("Masukkan waktu (jam): ");
        double waktu = sc.nextDouble();

        double jarak = kecepatan * waktu;
        System.out.println("Jarak = " + jarak + " km");
    }

    static void hitungWaktu() {
        System.out.print("Masukkan jarak (km): ");
        double jarak = sc.nextDouble();
        System.out.print("Masukkan kecepatan (km/jam): ");
        double kecepatan = sc.nextDouble();

        double waktu = jarak / kecepatan;
        System.out.println("Waktu = " + waktu + " jam");
    }
}
```

Outputnya : <br>
![alt text](<screenshots/Screenshot 2024-02-29 115711.png>)


