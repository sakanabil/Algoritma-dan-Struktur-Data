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


## JOBSHEET 
## DOUBLE LINKED LIST
### Percobaan 1
#### CLASS Node25
```java
package Pertemuan13.doublelinkedlists;

public class Node25 {
    int data;
    Node25 prev, next;

    Node25 (Node25 prev, int data, Node25 next){
        this.prev = prev;
        this.data = data;
        this.next = next;
    }
}
```
#### CLASS DoubleLinkedList25
```java
package Pertemuan13.doublelinkedlists;

public class DoubleLinkedLists25 {
    
    Node25 head;
    int size;

    public DoubleLinkedLists25() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(int item) {
        if (isEmpty()) {
            head = new Node25(null, item, null);
        } else {
            Node25 newNode = new Node25(null, item, head);
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(int item) {
        if (isEmpty()) {
            addFirst(item);
        } else {
            Node25 current = head;
            while (current.next != null) {
                current = current.next;
            }
            Node25 newNode = new Node25(current, item, null);
            current.next = newNode;
            size++;
        }
    }

    public void add(int item, int index) throws Exception {
        if (isEmpty()) {
            addFirst(item);
        } else if (index < 0 || index > size) {
            throw new Exception("Nilai indeks diluar batas");
        } else {
            Node25 current = head;
            int i = 0;
            while (i < index) {
                current = current.next;
                i++;
            }
            if (current.prev == null) {
                Node25 newNode = new Node25(null, item, current);
                current.prev = newNode;
                head = newNode;
            } else {
                Node25 newNode = new Node25(current.prev, item, current);
                newNode.prev = current.prev;
                newNode.next = current;
                current.prev.next = newNode;
                current.prev = newNode;
            }
        }
        size++;
    }

    public int size() {
        return size;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public void print() {
        if (!isEmpty()) {
            Node25 tmp = head;
            while (tmp != null) {
                System.out.print(tmp.data + "\t");
                tmp = tmp.next;
            }
            System.out.println("\nberhasil diisi");
        } else {
            System.out.println("Linked List Kosong");
        }
    }
}
```
#### CLASS DoubleLinkedListMain25
```java
package Pertemuan13.doublelinkedlists;

public class DoubleLinkedListsMain25 {

    public static void main(String[] args) throws Exception {
        DoubleLinkedLists25 dll = new DoubleLinkedLists25();
        dll.print();
        System.out.println("Size  : " + dll.size());
        System.out.println("=============================================");
        dll.addFirst(3);
        dll.addLast(4);
        dll.addFirst(7);
        dll.print();
        System.out.println("Size  : " + dll.size());
        System.out.println("=============================================");
        dll.add (40, 1);
        dll.print();
        System.out.println("Size  : " + dll.size());
        System.out.println("=============================================");
        dll.clear();
        dll.print();
        System.out.println("Size  : " + dll.size());
    }
}
```

#### OUTPUTNYA
![alt text](<screenshots/Screenshot 2024-06-04 211832.png>)

### Pertanyaan
#### 1. Jelaskan perbedaan antara single linked list dengan double linked lists!
    Jawab :  Perbedaan utama antara Single Linked List dan Double Linked List adalah bahwa Single Linked List hanya memiliki pointer ke node berikutnya, sedangkan Double Linked List memiliki pointer ke node sebelumnya dan node berikutnya.
#### 2. Perhatikan class Node, di dalamnya terdapat atribut next dan prev. Untuk apakah atribut tersebut?
    Jawab : Atribut next dan prev dalam class Node adalah pointer yang digunakan untuk menghubungkan node dengan node lainnya dalam struktur data double linked list.
#### 3. Perhatikan konstruktor pada class DoubleLinkedLists. Apa kegunaan inisialisasi atribut head dan size seperti pada gambar berikut ini?
![alt text](<screenshots/Screenshot 2024-06-04 213034.png>)
    Jawab : Kegunaan pada inisialisasi atribut head pada class DoubleLinkedList adalah untuk menginisialisasi atribut pada head menjadi null dan size menjadi 0
#### 4. Pada method addFirst(), kenapa dalam pembuatan object dari konstruktor class Node prev dianggap sama dengan null? Node newNode = new Node(null, item, head);
    Jawab : Karena digunakan sebagai nilai awal untuk prev karena node baru saat ini belum memiliki node sebelumnya.
#### 5. Perhatikan pada method addFirst(). Apakah arti statement head.prev = newNode ?
    Jawab : Statement head.prev = newNode memiliki arti untuk mengupdate nilai prev dari node head yang adalah node pertama dalam linked list menjadi newNode.
#### 6. Perhatikan isi method addLast(), apa arti dari pembuatan object Node dengan mengisikan parameter prev dengan current, dan next dengan null? Node newNode = new Node(current, item, null);
    Jawab : Pada baris kode Node newNode = new Node(current, item, null);, kita membuat objek newNode dengan prev yang diisi dengan current dan next yang diisi dengan null untuk menandai bahwa node baru tersebut adalah node terakhir dalam linked list.
#### 7. Pada method add(), terdapat potongan kode program sebagai berikut:
![alt text](<screenshots/Screenshot 2024-06-04 213121.png>)
#### jelaskan maksud dari bagian yang ditandai dengan kotak kuning
    Jawab : Jika current.prev bernilai null, itu berarti current adalah node pertama dalam daftar yang terhubung. Ketika current.prev bernilai null, kita ingin menambahkan node baru sebagai node pertama dalam daftar yang terhubung. Untuk melakukan ini, kita membuat objek baru dari class Node dengan parameter konstruktor null, item, dan current.


### Percobaan 2
#### CLASS DoubleLinkedLists25
```java
    public void removeFirst() throws Exception {
        if (isEmpty()) {
            throw new Exception("Linked List masih kosong, tidak dapat dihapus!");
        } else if (size == 1) {
            removeLast();
        } else {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    public void removeLast() throws Exception {
        if (isEmpty()) {
            throw new Exception("Linked List masih kosong, tidak dapat dihapus!");
        } else if (head.next == null) {
            head = null;
            size--;
            return;
        }
        Node25 current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
        size--;
    }

    public void remove(int index) throws Exception {
        if (isEmpty() || index >= size) {
            throw new Exception("Nilai indeks di luar batas");
        } else if (index == 0) {
            removeFirst();
        } else {
            Node25 current = head;
            int i = 0;
            while (i < index) {
                current = current.next;
                i++;
            }
            if (current.next == null) {
                current.prev.next = null;
            } else if (current.prev == null) {
                current = current.next;
                current.prev = null;
                head = current;
            } else {
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
            size--;
        }
    }
```
#### CLASS DoubleLinkedListsMain25
```java
        dll.addLast(50);
        dll.addLast(40);
        dll.addLast(10);
        dll.addLast(20);
        dll.print();
        System.out.println("Size  : " + dll.size());
        System.out.println("=============================================");
        dll.removeFirst();
        dll.print();
        System.out.println("Size  : " + dll.size());
        System.out.println("=============================================");
        dll.removeLast();
        dll.print();
        System.out.println("Size  : " + dll.size());
        System.out.println("=============================================");
        dll.remove(1);
        dll.print();
        System.out.println("Size  : " + dll.size());
        System.out.println("=============================================");
```

#### Outputnya
![alt text](<screenshots/Screenshot 2024-06-04 214157.png>)

### Pertanyaan
#### 1. Apakah maksud statement berikut pada method removeFirst()?
#### head = head.next;
#### head.prev = null;
#### 2. Bagaimana cara mendeteksi posisi data ada pada bagian akhir pada method removeLast()?
#### 3. Jelaskan alasan potongan kode program di bawah ini tidak cocok untuk perintah remove!
![alt text](<screenshots/Screenshot 2024-06-04 214423.png>)
#### 4. Jelaskan fungsi kode program berikut ini pada fungsi remove!
![alt text](<screenshots/Screenshot 2024-06-04 214451.png>)

### Percobaan 3
#### CLASS DoubleLinkedLists25
```java
    public int getFirst() throws Exception {
        if (isEmpty()) {
            throw new Exception("Linked List masih kosong");
        }
        return head.data;
    }

    public int getLast() throws Exception {
        if (isEmpty()) {
            throw new Exception("Linked List masih kosong");
        }
        Node25 tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        return tmp.data;
    }

    public int get(int index) throws Exception {
        if (isEmpty() || index >= size) {
            throw new Exception("Nilai indeks di luar batas");
        }
        Node25 tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp.data;
    }
```
#### CLASS DoubleLinkedListsMain25
```java
    dll.print();
    System.out.println("Size  : " + dll.size());
    System.out.println("=============================================");
    dll.addFirst(3);
    dll.addLast(4);
    dll.addFirst(7);
    dll.print();
    System.out.println("Size  : " + dll.size());
    System.out.println("=============================================");
    dll.add (40, 1);
    dll.print();
    System.out.println("Size  : " + dll.size());
    System.out.println("=============================================");
    System.out.println("Data awal pada Linked Lists adalah: " + dll.getFirst());
    System.out.println("Data akhir pada Linked Lists adalah: " + dll.getLast());
    System.out.println("Data indeks ke-1 pada Linked Lists adalah: " + dll.get(1));
    System.out.println("=============================================");
```

#### Outputnya
![alt text](<screenshots/Screenshot 2024-06-04 215113.png>)

### Pertanyaan
#### 1. Jelaskan method size() pada class DoubleLinkedLists!
#### 2. Jelaskan cara mengatur indeks pada double linked lists supaya dapat dimulai dari indeks ke 1!
#### 3. Jelaskan perbedaan karakteristik fungsi Add pada Double Linked Lists dan Single Linked Lists! 
#### 4. Jelaskan perbedaan logika dari kedua kode program di bawah ini
![alt text](<screenshots/Screenshot 2024-06-04 215404.png>)

### Tugas
#### 1. Buat program antrian vaksinasi menggunakan queue berbasis double linked list sesuai ilustrasi dan menu di bawah ini! (counter jumlah antrian tersisa di menu cetak(3) dan data orang yang telah divaksinasi di menu Hapus Data(2) harus ada)
#### CLASS Node25
```java
package Pertemuan13.tugas;
public class Node25 {
    String nama;
    int nomorAntrian;
    Node25 next, prev;

    public Node25(Node25 prev, int nomorAntrian, String nama, Node25 next) {
        this.prev = prev;
        this.nomorAntrian = nomorAntrian;
        this.nama = nama;
        this.next = next;
    }
}
```
#### CLASS Queue25
```java
package Pertemuan13.tugas;

public class Queue25 {
    Node25 head;
    Node25 tail;
    int size;

    public void menu() {
        System.out.println("++++++++++++++++++++++++++++++++++++");
        System.out.println("PENGANTRI VAKSIN EXTRAVAGANZA");
        System.out.println("++++++++++++++++++++++++++++++++++++");
        System.out.println("1. Tambah Data Penerima Vaksin");
        System.out.println("2. Hapus Data Pengantri Vaksin");
        System.out.println("3. Daftar Penerima Vaksin");
        System.out.println("4. Keluar");
        System.out.println("++++++++++++++++++++++++++++++++++++");
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int nomorUrut, String nama) {
        Node25 newNode = new Node25(tail, nomorUrut, nama, null);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public String dequeue() {
        if (isEmpty()) {
            return null;
        }
        String nama = head.nama;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        size--;
        System.out.println(nama + " telah divaksinasi.");
        return nama;
    }

    public void printQueue() {
        Node25 temp = head;
        System.out.println("+++++++++++++++++++++++++++++++++");
        System.out.println("Daftar Penerima Vaksin");
        System.out.println("+++++++++++++++++++++++++++++++++");
        System.out.printf("%-7s | %-20s |\n", "No.", "Nama");

        while (temp != null) {
            System.out.printf("%-7d | %-20s |\n", temp.nomorAntrian, temp.nama);
            temp = temp.next;
        }
        System.out.println("Sisa Antrian: " + size);
    }

    public int getSize() {
        return size;
    }
}
```
#### CLASS Tugas1Main25
```java
package Pertemuan13.tugas;

import java.util.Scanner;

public class Tugas1Main25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Queue25 vaksin = new Queue25();
        vaksin.menu();
        int pilih = sc.nextInt();
        while (pilih != 4) {
            if (pilih == 1) {
                System.out.println("-------------------------------");
                System.out.println("Masukkan data penerima Vaksin");
                System.out.println("-------------------------------");
                System.out.print("Nomor Antrian anda : ");
                int nomorAntrian = sc.nextInt();
                System.out.print("Masukkan nama anda : ");
                String nama = sc.next();
                vaksin.enqueue(nomorAntrian, nama);
            } else if (pilih == 2) {
                vaksin.dequeue();
            } else if (pilih == 3) {
                vaksin.printQueue();
            }
            vaksin.menu();
            pilih = sc.nextInt();
        }

    }
}
```
### Outputnya
![alt text](<screenshots/Screenshot 2024-06-04 220620.png>)
![alt text](<screenshots/Screenshot 2024-06-04 220721.png>)
![alt text](<screenshots/Screenshot 2024-06-04 220843.png>)

#### 2. Buatlah program daftar film yang terdiri dari id, judul dan rating menggunakan double linked lists, bentuk program memiliki fitur pencarian melalui ID Film dan pengurutan Rating secara descending. Class Film wajib diimplementasikan dalam soal ini.
#### CLASS Film25
```java
package Pertemuan13.tugas;

class Film25 {
int id;
String judul;
double rating;
Film25 prev, next;

    Film25(int id, String judul, double rating) {
        this.id = id;
        this.judul = judul;
        this.rating = rating;
    }
}
```
#### CLASS DLLFilm25
```java
package Pertemuan13.tugas;

class DLLFilm25 {
 
    private Film25 head, tail;

    public void tambahAwal(int id, String judul, double rating) {
        Film25 newFilm = new Film25(id, judul, rating);
        if (head == null) {
            head = tail = newFilm;
        } else {
            newFilm.next = head;
            head.prev = newFilm;
            head = newFilm;
        }
    }

    public void tambahAkhir(int id, String judul, double rating) {
        Film25 newFilm = new Film25(id, judul, rating);
        if (tail == null) {
            head = tail = newFilm;
        } else {
            tail.next = newFilm;
            newFilm.prev = tail;
            tail = newFilm;
        }
    }

    public void tambahPadaIndex(int index, int id, String judul, double rating) {
        if (index <= 0) {
            tambahAwal(id, judul, rating);
            return;
        }
        
        Film25 newFilm = new Film25(id, judul, rating);
        Film25 current = head;
        for (int i = 0; i < index - 1; i++) {
            if (current == null) {
                break;
            }
            current = current.next;
        }

        if (current == null || current.next == null) {
            tambahAkhir(id, judul, rating);
        } else {
            newFilm.next = current.next;
            newFilm.prev = current;
            current.next.prev = newFilm;
            current.next = newFilm;
        }
    }

    public void hapusPertama() {
        if (head != null) {
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
        }
    }

    public void hapusTerakhir() {
        if (tail != null) {
            if (head == tail) {
                head = tail = null;
            } else {
                tail = tail.prev;
                tail.next = null;
            }
        }
    }

    public void hapusPadaIndex(int index) {
        if (index <= 0) {
            hapusPertama();
            return;
        }

        Film25 current = head;
        for (int i = 0; i < index; i++) {
            if (current == null) {
                return;
            }
            current = current.next;
        }

        if (current == null || current.prev == null) {
            hapusTerakhir();
        } else {
            current.prev.next = current.next;
            if (current.next != null) {
                current.next.prev = current.prev;
            }
        }
    }

    public void cetak() {
        Film25 current = head;
        while (current != null) {
            System.out.println("ID: " + current.id + ", Judul: " + current.judul + ", Rating: " + current.rating);
            current = current.next;
        }
    }

    public Film25 cariID(int id) {
        Film25 current = head;
        while (current != null) {
            if (current.id == id) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void urutRatingDesc() {
        if (head == null) return;
        boolean swapped;
        do {
            swapped = false;
            Film25 current = head;
            while (current.next != null) {
                if (current.rating < current.next.rating) {
                    double tempRating = current.rating;
                    current.rating = current.next.rating;
                    current.next.rating = tempRating;

                    int tempId = current.id;
                    current.id = current.next.id;
                    current.next.id = tempId;

                    String tempJudul = current.judul;
                    current.judul = current.next.judul;
                    current.next.judul = tempJudul;

                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }
}
```
#### CLASS Tugas2Main25
```java
package Pertemuan13.tugas;

import java.util.Scanner;

public class Tugas2Main25 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DLLFilm25 dll = new DLLFilm25();
        int choice, id, index;
        String judul;
        double rating;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Data Awal");
            System.out.println("2. Tambah Data Akhir");
            System.out.println("3. Tambah Data Index Tertentu");
            System.out.println("4. Hapus Data Pertama");
            System.out.println("5. Hapus Data Terakhir");
            System.out.println("6. Hapus Data Tertentu");
            System.out.println("7. Cetak");
            System.out.println("8. Cari ID Film");
            System.out.println("9. Urut Data Rating Film-DESC");
            System.out.println("10. Keluar");
            System.out.print("Masukkan pilihan Anda: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Masukkan ID: ");
                    id = scanner.nextInt();
                    scanner.nextLine(); // flush scanner
                    System.out.print("Masukkan Judul: ");
                    judul = scanner.nextLine();
                    System.out.print("Masukkan Rating: ");
                    rating = scanner.nextDouble();
                    dll.tambahAwal(id, judul, rating);
                    break;
                case 2:
                    System.out.print("Masukkan ID: ");
                    id = scanner.nextInt();
                    scanner.nextLine(); // flush scanner
                    System.out.print("Masukkan Judul: ");
                    judul = scanner.nextLine();
                    System.out.print("Masukkan Rating: ");
                    rating = scanner.nextDouble();
                    dll.tambahAkhir(id, judul, rating);
                    break;
                case 3:
                    System.out.print("Masukkan Index: ");
                    index = scanner.nextInt();
                    System.out.print("Masukkan ID: ");
                    id = scanner.nextInt();
                    scanner.nextLine(); // flush scanner
                    System.out.print("Masukkan Judul: ");
                    judul = scanner.nextLine();
                    System.out.print("Masukkan Rating: ");
                    rating = scanner.nextDouble();
                    dll.tambahPadaIndex(index, id, judul, rating);
                    break;
                case 4:
                    dll.hapusPertama();
                    break;
                case 5:
                    dll.hapusTerakhir();
                    break;
                case 6:
                    System.out.print("Masukkan Index untuk dihapus: ");
                    index = scanner.nextInt();
                    dll.hapusPadaIndex(index);
                    break;
                case 7:
                    dll.cetak();
                    break;
                case 8:
                    System.out.print("Masukkan ID Film yang dicari: ");
                    id = scanner.nextInt();
                    Film25 foundFilm = dll.cariID(id);
                    if (foundFilm != null) {
                        System.out.println("Film ditemukan: ID: " + foundFilm.id + ", Judul: " + foundFilm.judul + ", Rating: " + foundFilm.rating);
                    } else {
                        System.out.println("Film dengan ID tersebut tidak ditemukan.");
                    }
                    break;
                case 9:
                    dll.urutRatingDesc();
                    break;
                case 10:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
            }
        } while (choice != 10);
        scanner.close();
    }
}
```
#### Outputnya
![alt text](<screenshots/Screenshot 2024-06-04 222220.png>)
![alt text](<screenshots/Screenshot 2024-06-04 222327.png>)
![alt text](<screenshots/Screenshot 2024-06-04 222358.png>)
