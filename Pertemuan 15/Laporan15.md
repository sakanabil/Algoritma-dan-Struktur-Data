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
## GRAPH
### Percobaan 1
#### CLASS Node25
```java
public class Node25 {
    int data;
    Node25 prev, next;
    int jarak;

    Node25 (Node25 prev, int data, int jarak, Node25 next){
        this.prev = prev;
        this.data = data;
        this.next = next;
        this.jarak = jarak;
    }
}
```
#### CLASS DoubleLinkedList25
```java
public class DoubleLinkedList25 {
    
    Node25 head;
    int size;

    public DoubleLinkedList25() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(int item, int jarak) {
        if (isEmpty()) {
            head = new Node25 (null, item, jarak, null);
        } else {
            Node25 newNode = new Node25 (null, item, jarak, head);
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(int item, int jarak) {
        if (isEmpty()) {
            addFirst(item, jarak);
        } else {
            Node25 current = head;
            while (current.next != null) {
                current = current.next;
            }
            Node25 newNode = new Node25(current, item, jarak, null);
            current.next = newNode;
            size++;
        }
    }

    public void add(int item, int index, int jarak) throws Exception {
        if (isEmpty()) {
            addFirst(item, jarak);
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
                Node25 newNode = new Node25(null, item, jarak, current);
                current.prev = newNode;
                head = newNode;
            } else {
                Node25 newNode = new Node25(current.prev, item, jarak, current);
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

    public void remove(int index) {
        Node25 current = head;
        while (current != null) {
            if (current.data == index) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                }
                break;
            }
            current = current.next;
        }
        size--;
    }
    
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
    public int getJarak (int index) throws Exception {
        if (isEmpty() || index >= size) {
            throw new Exception("Nilai indeks di luar batas");
        }
        Node25 tmp = head;
        for (int i=0; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp.jarak;
    }   
}
```
#### CLASS Graph25
```java
public class Graph25 {
    int vertex;
    DoubleLinkedList25 list[];

    public Graph25(int v) {
            vertex = v;
            list = new DoubleLinkedList25[v];
            for (int i=0; i < v; i++) {
                list[i] = new DoubleLinkedList25();
        }
    }

    public void addEdge(int asal, int tujuan, int jarak) {
        list[asal].addFirst(tujuan, jarak);
    }
        

    public void degree(int asal) throws Exception {
        int k, totalin = 0, totalout = 0;
            for (int i = 0; i < vertex; i++) {
                for (int j = 0; j < list[i].size(); j++) {
                    if (list[i].get(j) == asal) {
                        ++totalin;
                    }
                }
            for (k = 0; k < list[asal].size(); k++) {
                    list[asal].get(k);
                }
                totalout = k;
            }
        System.out.println("InDegree dari Gedung " + (char) ('A' +asal) + ":" + totalin); 
        System.out.println("OutDegree dari Gedung " + (char) ('A' + asal) + ":" + totalout);
        System.out.println("Degree dari Gedung " +(char) ('A' +asal)+":"+ (totalin + totalout));
    }

    public void removeEdge(int asal, int tujuan) throws Exception {
        for (int i = 0; i < vertex; i++) {
            if (i == tujuan) {
                list[asal].remove(tujuan);
            }
        }
    }

    public void removeAllEdges() {
        for (int i=0; i < vertex; i++) {
        list[i].clear();
        }
        System.out.println("Graph berhasil dikosongkan");
    }

    public void printGraph() throws Exception {
        for (int i=0; i < vertex; i++) { 
            if (list[i].size() > 0) {
                System.out.println("Gedung " + (char) ('A'+ i)+" terhubung dengan ");
                for (int j = 0; j < list[i].size(); j++) {
                    System.out.print((char) ('A' + list[i].get(j))+" ("+ list[i].getJarak(j)+"m), ");
                    }
                System.out.println("");
            }
        }
        System.out.println("");
    }
}
```
#### CLASS GraphMain25
```java
public class GraphMain25 {
    public static void main(String[] args) throws Exception {
        Graph25 gedung = new Graph25(6);

        gedung.addEdge(0, 1, 50); 
        gedung.addEdge(0, 2, 100);
        gedung.addEdge (1, 3, 70);
        gedung.addEdge(2, 3, 40);
        gedung.addEdge(3, 4, 60);
        gedung.addEdge(4, 5, 80);
        gedung.degree(0);
        gedung.printGraph();

        gedung.removeEdge(1, 3);
        gedung.printGraph();
    }
}
```
#### Output
#### Langkah 14
![alt text](<screenshots/Screenshot 2024-06-05 113238.png>)
#### Langkah 17
![alt text](<screenshots/Screenshot 2024-06-05 114200.png>)


### Pertanyaan
#### 1. Perbaiki kode program Anda apabila terdapat error atau hasil kompilasi kode tidak sesuai!
    Jawab : Sudah.
#### 2. Pada class Graph, terdapat atribut list[] bertipe DoubleLinkedList. Sebutkan tujuan pembuatan variabel tersebut!
    Jawab : Variabel list[] dalam kelas Graph25 merupakan array yang digunakan untuk menyimpan referensi ke objek DoubleLinkedList25 untuk setiap vertex dalam graph.
#### 3. Jelaskan alur kerja dari method removeEdge!
    Jawab : Method removeEdge menerima dua parameter, yaitu asal dan tujuan. Method removeEdge melakukan perulangan for untuk mengiterasi setiap elemen dalam array list[] sebanyak vertex kali. Dalam perulangan for, method removeEdge memeriksa apakah i sama dengan tujuan.
    Jika i sama dengan tujuan, method removeEdge menghapus elemen tujuan dari linked list list[asal] menggunakan method remove(). Setelah perulangan selesai, method removeEdge tidak mengembalikan nilai atau menghasilkan efek samping.
#### 4. Apakah alasan pemanggilan method addFirst() untuk menambahkan data, bukan method add jenis lain saat digunakan pada method addEdge pada class Graph?
    Jawab : Pemanggilan method addFirst() dalam method addEdge() pada class Graph memiliki alasan yaitu terkait dengan efisiensi dan kesederhanaan implementasi. 
#### 5. Modifikasi kode program sehingga dapat dilakukan pengecekan apakah terdapat jalur antara suatu node dengan node lainnya, seperti contoh berikut (Anda dapat memanfaatkan Scanner).
#### CLASS Graph25
```java
public void cekEdge(int asal, int tujuan) throws Exception {
        boolean found = false;
        for (int i = 0; i < list[asal].size(); i++) {
            if (list[asal].get(i) == tujuan) {
                found = true;
            break;
            }
        }
        if (found) {
            System.out.println("Gedung " + (char) ('A' + asal) + " Dan " + (char) ('A' + tujuan) + " Bertetangga");
        } else {
            System.out.println("Gedung " + (char) ('A' + asal) + " Dan " + (char) ('A' + tujuan) + " Tidak Bertetangga");
        }
    }
```
#### CLASS GraphMain25
```java
import java.util.Scanner;
public class GraphMain01 {
    public static void main(String[] args) throws Exception {
        Graph01 gedung = new Graph01(6);
        Scanner sc = new Scanner(System.in);
        gedung.addEdge(0, 1, 50);
        gedung.addEdge(0, 2, 100);
        gedung.addEdge(1, 3, 70);
        gedung.addEdge(2, 3, 40);
        gedung.addEdge(3, 4, 60);
        gedung.addEdge(4, 5, 80);
        gedung.degree(0);
        gedung.printGraph();
        gedung.removeEdge(1, 3);
        gedung.printGraph();
        System.out.print("Asal Gedung : ");
        int asal = sc.nextInt();
        System.out.print("Tujuan Gedung : ");
        int tujuan = sc.nextInt();
        gedung.cekEdge(asal, tujuan);
```

### Percobaan 2
#### CLASS GraphMatriks25
```java
public class GraphMatriks25 {
    int vertex;
    int[][] matriks;

    public GraphMatriks25(int v) {
        vertex = v;
        matriks = new int[v][v];
    }

    public void makeEdge(int asal, int tujuan, int jarak) {
        matriks[asal][tujuan] = jarak;
    }
    
    public void removeEdge(int asal, int tujuan) {
        matriks[asal][tujuan] = 0;
    }

    public void printGraph() {
        for (int i = 0; i < vertex; i++) {
            System.out.print("Gedung " + (char) ('A' + i) + ": ");
            for (int j = 0; j < vertex; j++) {
                if (matriks[i][j] != -1) {
                    System.out.print("Gedung " + (char) ('A'+ j) + " ("+ matriks[i][j]+" m), ");
                }
            }
        System.out.println();
        }
    }
}
```
#### CLASS GraphMain25
```java
        GraphMatriks25 gdg = new GraphMatriks25(4);
        gdg.makeEdge(0, 1, 50); 
        gdg.makeEdge(1, 0, 60);
        gdg.makeEdge(1, 2, 70);
        gdg.makeEdge(2, 1, 80);
        gdg.makeEdge(2, 3, 40);
        gdg.makeEdge(3, 0, 90);
        gdg.printGraph();
        System.out.println("Hasil setelah penghapusan edge");
        gdg.removeEdge(2, 1);
        gdg.printGraph();
    }
}
```
#### Outputnya
![alt text](<screenshots/Screenshot 2024-06-05 144729.png>)
### Pertanyaan
#### 1. Perbaiki kode program Anda apabila terdapat error atau hasil kompilasi kode tidak sesuai!
    Jawab : Sudah.
#### 2. Apa jenis graph yang digunakan pada Percobaan 2?
    Jawab :  Directed weighted graph.
#### 3. Apa maksud dari dua baris kode berikut?
![alt text](<screenshots/Screenshot 2024-06-05 121512.png>)
    Jawab : Dua baris kode tersebut digunakan untuk membuat hubungan antara dua titik dalam grafik. Baris pertama gdg.makeEdge(1, 2, 70); menambahkan hubungan antara titik pertama dan titik kedua dengan jarak 70 m. Baris kedua gdg.makeEdge(2, 1, 80); menambahkan hubungan antara titik kedua dan titik pertama dengan jarak 80 m.
#### 4. Modifikasi kode program sehingga terdapat method untuk menghitung degree, termasuk inDegree dan outDegree!
```java
public void degree(int asal) {
        int totalIn = 0, totalOut = 0;
        for(int i = 0; i < vertex; i++){
            if (matriks[i][asal] != 0) {
            totalIn++;
            }
        }
        for (int i = 0; i < vertex; i++) {
            if (matriks[asal][i] != 0) {
            totalOut++;
            }
        }
        System.out.println("InDegree dari gedung " + (char)('A' + asal) + " : " + totalIn);
        System.out.println("OutDegree dari gedung " + (char)('A' + asal) + " : " + totalOut);
        System.out.println("Degree dari gedung " + (char)('A' + asal) + " : " + (totalIn + totalOut)); 
    }
```

### LATIHAN
#### CLASS Node25
```java
public class Node25 {
    int data;
    Node25 prev, next;
    int jarak;

    Node25 (Node25 prev, int data, int jarak, Node25 next){
        this.prev = prev;
        this.data = data;
        this.next = next;
        this.jarak = jarak;
    }
}
```
#### CLASS DooubleLinkedList25
```java
public class DoubleLinkedList25 {
    Node25 head;
    int size;

    public DoubleLinkedList25() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(int item, int jarak) {
        if (isEmpty()) {
            head = new Node25(null, item, jarak, null);
        } else {
            Node25 newNode01 = new Node25(null, item, jarak, head);
            head.prev = newNode01;
            head = newNode01;
        }
        size++;
    }

    public int getJarak(int index) throws Exception {
        if (isEmpty() || index >= size) {
            throw new Exception("Nilai indeks di luar batas");
        }
        Node25 tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp.jarak;
    }

    public void remove(int indeks) {
        Node25 current = head;
            while (current != null) {
                if (current.data == indeks) {
                    if (current.prev != null) {
                        current.prev.next = current.next;
                    } else {
                        head = current.next;
                    }
                    if (current.next != null) {
                        current.next.prev = current.prev;
                    }
                    size--;
                    break;
                }
                current = current.next;
            }
    }

    public int size() {
        return size;    
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public int get(int index) throws Exception {
        if (isEmpty() || index >=size) {
            throw new Exception("Nilai indeks di luar batas");
        }
        Node25 tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp.data;
    }

    public void updateJarak(int index, int jarak) throws Exception {
        if (isEmpty() || index >=size) {
            throw new Exception("Nilai indeks di luar batas");
        }
        Node25 tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        tmp.jarak = jarak;
    }
}
```
#### CLASS Graph25
```java
public class Graph25 {
    int vertex;
    DoubleLinkedList25 list[];

    public Graph25(int v) {
        vertex = v;
        list = new DoubleLinkedList25[v];
        for (int i = 0; i < v; i++) {
            list[i] = new DoubleLinkedList25();
        }
    }

    public void addEdge(int asal, int tujuan, int jarak) {
        list[asal].addFirst(tujuan, jarak); //directed
    }

    public void degree(int asal) throws Exception {
        int k, totalIn = 0, totalOut = 0;
        for(int i = 0; i < vertex; i++){
            for(int j = 0; j < list[i].size(); j++){
                if(list[i].get(j) == asal)
                    ++totalIn;
            }
            for(k = 0; k < list[asal].size(); k++){
                list[asal].get(k);
            }
            totalOut = k;
        }
        System.out.println("InDegree dari Gedung " +(char) ('A' + asal) + ": " + totalIn);
        System.out.println("OutDegree dari Gedung " +(char) ('A' + asal) + ": " + totalOut);
        System.err.println("Degree dari Gedung " +(char) ('A' + asal) + ": " + (totalIn + totalOut));
    }

    public void removeEdge(int asal, int tujuan) throws Exception {
        for (int i = 0; i < vertex; i++) {
            if (i == tujuan) {
                list[asal].remove(tujuan);
            }
        }
    }

    public void removeAllEdges() {
        for (int i = 0; i < vertex; i++) {
            list[i].clear();
        }
        System.out.println("Graf berhasil dikosongkan");
    }

    public void printGraph() throws Exception {
        for (int i = 0; i < vertex; i++) {
            if (list[i].size() > 0) {
                System.out.println("Gedung " + (char) ('A' + i) + " terhubung dengan ");
                for (int j = 0; j < list[i].size(); j++) {
                    System.out.print((char) ('A' + list[i].get(j)) + " (" + list[i].getJarak(j) + "m),");
                }
                System.out.println("");
            }
        }
        System.out.println("");
    }

    public void cekEdge(int asal, int tujuan) throws Exception {
        boolean found = false;
        for (int i = 0; i < list[asal].size(); i++) {
            if (list[asal].get(i) == tujuan) {
                found = true;
            break;
            }
        }
        if (found) {
            System.out.println("Gedung " + (char) ('A' + asal) + " Dan " + (char) ('A' + tujuan) + " Bertetangga");
        } else {
            System.out.println("Gedung " + (char) ('A' + asal) + " Dan " + (char) ('A' + tujuan) + " Tidak Bertetangga");
        }
    }

    public void updateJarak(int asal, int tujuan, int jarak) throws Exception{
        boolean found = false;
        for (int i = 0; i < list[asal].size(); i++) {
            if (list[asal].get(i) == tujuan) {
                list[asal].updateJarak(i, jarak);
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Berhasil diupdate");
        } else {
            System.out.println("Edge tidak ditemukan");
        }
    }

    public int hitungEdge() {
        int totalEdges = 0;
        for (int i = 0; i < vertex; i++) {
            totalEdges += list[i].size();
        }
        return totalEdges;
    }
}
```
#### CLASS GraphMain25
```java
import java.util.Scanner;
public class GraphMain25 {
    public static void main(String[] args) throws Exception {
        Graph25 gedung = new Graph25(6);
        Scanner sc = new Scanner(System.in);
        int menu;

        do {
        System.out.println("=========================");
        System.out.println("|          Menu         |");
        System.out.println("=========================");
        System.out.println("1. Add Edge");
        System.out.println("2. Remove Edge");
        System.out.println("3. Degree");
        System.out.println("4. Print Graph");
        System.out.println("5. Cek Edge");
        System.out.println("6. Update Jarak");
        System.out.println("7. Hitung Edge");
        System.out.println("0. Keluar");
        System.out.println("=========================");
        
        System.out.print("Pilih Menu : ");
        menu = sc.nextInt();
        sc.nextLine();
        
            switch (menu) {
                case 1:
                System.out.println("Penambahan Data");
                System.out.print("Asal : ");
                int asal = sc.nextInt();
                System.out.print("Tujuan : ");
                int tujuan = sc.nextInt();
                System.out.print("Jarak : ");
                int jarak = sc.nextInt();
                gedung.addEdge(asal, tujuan, jarak);
                break;

                case 2:
                System.out.println("Penghapusan Data");
                System.out.print("Asal : ");
                int asal1 = sc.nextInt();
                System.out.print("Tujuan : ");
                int tujuan1 = sc.nextInt();
                gedung.removeEdge(asal1, tujuan1);
                break;

                case 3:
                System.out.println("Degree");
                System.out.print("Asal : ");
                int asal2 = sc.nextInt();
                gedung.degree(asal2);
                break;

                case 4:
                System.out.println("Print Graph");
                gedung.printGraph();
                break;

                case 5:
                System.out.println("Cek Data");
                System.out.print("Asal   : ");
                int asal3 = sc.nextInt();
                System.out.print("Tujuan : ");
                int tujuan3 = sc.nextInt();
                gedung.cekEdge(asal3, tujuan3);
                break;

                case 6:
                System.out.println("Cek Data");
                System.out.print("Asal   : ");
                int asal4 = sc.nextInt();
                System.out.print("Tujuan : ");
                int tujuan4 = sc.nextInt();
                System.out.print("Update Jarak ");
                System.out.print("Jarak : ");
                int jarak4 = sc.nextInt();
                gedung.updateJarak(asal4, tujuan4, jarak4);
                break;

                case 7:
                System.out.println("Edge ada : " + gedung.hitungEdge());
                break;

                default:
                System.out.println("Pilihan Salah");
                break;
            }
        } while (menu != 0);
    }
}
```