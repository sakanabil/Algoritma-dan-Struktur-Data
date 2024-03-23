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


## JOBSHEET - 5
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
