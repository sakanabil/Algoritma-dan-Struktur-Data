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


## JOBSHEET - XI
## LINKED LIST
### Percobaan 1
#### CLASS Node25
```java
public class Node25 {
    int data;
    Node25 next;

    Node25(int nilai, Node25 berikutnya){
        data = nilai;
        next = berikutnya;
    }
}
```
#### CLASS LinkedList25
```java
public class SingleLinkedList25 {
    Node25 head, tail;

    boolean isEmpty() {
        return head == null;
    }

    void print() {
        if (isEmpty()) {
            System.out.println("Linked List kosong");
        } else {
            Node25 tmp = head;
            System.out.print("Isi Linked List:\t");
            while (tmp != null) {
                System.out.print(tmp.data + "\t");
                tmp = tmp.next;
            }
            System.out.println("");
        }
    }
    
    void addFirst(int input) {
        Node25 ndInput = new Node25(input, null);
        if(isEmpty()) {
            head = ndInput;
            tail = ndInput;
        } else {
            ndInput.next = head;
            head = ndInput;
        }
    }

    void addLast(int input) {
        Node25 ndInput = new Node25(input, null);
        if(isEmpty()) {
            head = ndInput;
            tail = ndInput;
        } else {
            tail.next = ndInput;   
            tail = ndInput;
        }
    }

    void insertAfter(int key, int input) {
        Node25 ndInput = new Node25(input, null);
        Node25 temp = head;
        do{
            if(temp.data == key) {
                ndInput.next = temp.next;
                temp.next = ndInput;
                if(ndInput.next == null) {
                    tail = ndInput;
                }
            }
            temp = temp.next;
        } while (temp != null); 
    }

    void insertAt(int index, int input) {
        if (index < 0) {
            System.out.println("Indeks tidak valid");
            return;
        } else if (index == 0) {
            addFirst(input);
            return;
        } else {
            Node25 ndInput = new Node25(input, null);
            Node25 temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            ndInput.next = temp.next;
            temp.next = ndInput;
            if (ndInput.next == null) {
                tail = ndInput;
            }
        }
    }
}
```
#### CLASS SLLMain25
```java
public class SLLMain25 {
    public static void main(String[] args) {
        SingleLinkedList25 singLL = new SingleLinkedList25();
        singLL.print();
        singLL.addFirst(890);
        singLL.print();
        singLL.addLast(760);
        singLL.print();
        singLL.addFirst(700);
        singLL.print();
        singLL.insertAfter(700, 999);
        singLL.print();
        singLL.insertAt(3, 833);
        singLL.print();
    }
}
```

#### Verifikasi Hasil
![alt text](<screenshots/Screenshot 2024-05-22 070319.png>)

### Pertanyaan
#### 1. Mengapa hasil compile kode program di baris pertama menghasilkan “Linked List Kosong”?
    Jawab : Baris pertama memanggil method 'print()' dari sebuah objek 'SingleLinkedList25' yang baru dibuat. Ketika objek tersebut dibuat, linked list masih kosong karena 'head' dan 'tail' diinisialisasi sebagai 'null'. Oleh karena itu, ketika 'print()' dipanggil, kondisi 'isEmpty()' mengembalikan 'true', dan pesan "Linked List kosong" dicetak.
#### 2. Jelaskan kegunaan variable temp secara umum pada setiap method!
    Jawab : Variable temp digunakan dalam setiap metode untuk menyimpan referensi ke node saat ini saat melakukan iterasi atau manipulasi linked list.
#### 3. Perhatikan class SingleLinkedList, pada method insertAt Jelaskan kegunaan kode berikut
```java
if(temp.next.next==null) tail=temp.next;
```
    Jawab : digunakan untuk mengecek apakah node saat ini (temp) adalah node terakhir dalam linked list. Jika ya, maka tail diperbarui untuk menunjuk ke node terakhir yang baru diinputkan.

### Modifikasi Elemen pada Single Linked List
#### CLASS SingleLinkedList25
```java
public class SingleLinkedList25 {
    Node25 head, tail;

    boolean isEmpty() {
        return head == null;
    }

    void print() {
        if (isEmpty()) {
            System.out.println("Linked List kosong");
        } else {
            Node25 tmp = head;
            System.out.print("Isi Linked List:\t");
            while (tmp != null) {
                System.out.print(tmp.data + "\t");
                tmp = tmp.next;
            }
            System.out.println("");
        }
    }
    
    void addFirst(int input) {
        Node25 ndInput = new Node25(input, null);
        if(isEmpty()) {
            head = ndInput;
            tail = ndInput;
        } else {
            ndInput.next = head;
            head = ndInput;
        }
    }

    void addLast(int input) {
        Node25 ndInput = new Node25(input, null);
        if(isEmpty()) {
            head = ndInput;
            tail = ndInput;
        } else {
            tail.next = ndInput;   
            tail = ndInput;
        }
    }

    void insertAfter(int key, int input) {
        Node25 ndInput = new Node25(input, null);
        Node25 temp = head;
        do{
            if(temp.data == key) {
                ndInput.next = temp.next;
                temp.next = ndInput;
                if(ndInput.next == null) {
                    tail = ndInput;
                }
            }
            temp = temp.next;
        } while (temp != null); 
    }

    void insertAt(int index, int input) {
        if (index < 0) {
            System.out.println("Indeks tidak valid");
            return;
        } else if (index == 0) {
            addFirst(input);
            return;
        } else {
            Node25 ndInput = new Node25(input, null);
            Node25 temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            ndInput.next = temp.next;
            temp.next = ndInput;
            if (ndInput.next == null) {
                tail = ndInput;
            }
        }
    }
    int getData(int index) {
        Node25 tmp = head;
        for (int i = 0; i < index - 1; i++) {
            tmp = tmp.next;
        }
        return tmp.next.data;
    }

    int indexOf(int key) {
        Node25 tmp = head;
        int index = 0;
        while (tmp != null && tmp.data != key) {
            tmp = tmp.next;
            index++;
        }
        if(tmp == null) {
            return -1;
        } else {
            return index;
        }
    }

    void removeFirst() {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong," 
                        + " tidak bisa di hapus");
        } else if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
        }
    }

    void removeLast() {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong," 
                        + " tidak bisa di hapus");
        } else if (head == tail) {
            head = tail = null;
        } else {
            Node25 temp = head;
            while (temp.next == null) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp.next;
        }
    }

    void remove(int key) {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong," 
                        + " tidak bisa di hapus");
        } else {
            Node25 temp = head;
            while (temp != null) {
                if(head.data == key && temp == head){
                    removeFirst();
                    break;
                } else if (temp.next.data == key){
                    temp.next = temp.next.next;
                    if(temp.next == null){
                        tail = temp;
                    }
                    break;
                }
                temp = temp.next;
            }
        }
    }

    public void removeAt (int index) {
        if (index ==0 ) {
            removeFirst();
        } else {
            Node25 temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            if (temp.next == null) {
                tail = temp;
            }
        }
    }
}
```
#### CLASS SLLMain25
```java
public class SLLMain25 {
    public static void main(String[] args) {
        SingleLinkedList25 singLL = new SingleLinkedList25();

        singLL.print();
        singLL.addFirst(890);
        singLL.print();
        singLL.addLast(760);
        singLL.print();
        singLL.addFirst(700);
        singLL.print();
        singLL.insertAfter(700, 999);
        singLL.print();
        singLL.insertAt(3, 833);
        singLL.print();

        System.out.println("Data pada indeks ke-1 = " + singLL.getData(1));
        System.out.println("Data 3 berada pada indeks ke-" + singLL.indexOf(760));

        singLL.remove(999);
        singLL.print();
        singLL.removeAt(0);
        singLL.print();
        singLL.removeFirst();
        singLL.print();
        singLL.removeLast();
        singLL.print();
    }
}
```
#### Outputnya
![alt text](<screenshots/Screenshot 2024-05-22 071556.png>)
### Pertanyaan
#### 1. Mengapa digunakan keyword break pada fungsi remove? Jelaskan!
    Jawab : break memastikan pencarian berhenti setelah node yang tepat ditemukan dan dihapus.
#### 2. Jelaskan kegunaan kode dibawah pada method remove
```java
else if (temp.next.data == key) {
    temp.next = temp.next.next;
}
```
    Jawab : Baris kode temp.next = temp.next.next; pada metode remove digunakan untuk menghapus node yang ditemukan dari linked list.

### TUGAS
#### 1. Implementasikan ilustrasi Linked List Berikut. Gunakan 4 macam penambahan data yang telah dipelajari sebelumnya untuk menginputkan data.
#### Jawab :
#### CLASS Mahasiswa25
```java
public class Mahasiswa25 {
    String nim, nama;
    Mahasiswa25 next;

    Mahasiswa25(String nim, String nama, Mahasiswa25 next) {
        this.nim = nim;
        this.nama = nama;
        this.next = next;
    }
}
```
#### CLASS MHSSingleLinkedList25
```java
public class SingleLinkedList25 {
    Node25 head, tail;

    boolean isEmpty() {
        return head == null;
    }

    void print() {
        if (isEmpty()) {
            System.out.println("Linked List kosong");
        } else {
            Node25 tmp = head;
            System.out.print("Isi Linked List:\t");
            while (tmp != null) {
                System.out.print(tmp.data + "\t");
                tmp = tmp.next;
            }
            System.out.println("");
        }
    }
    
    void addFirst(int input) {
        Node25 ndInput = new Node25(input, null);
        if(isEmpty()) {
            head = ndInput;
            tail = ndInput;
        } else {
            ndInput.next = head;
            head = ndInput;
        }
    }

    void addLast(int input) {
        Node25 ndInput = new Node25(input, null);
        if(isEmpty()) {
            head = ndInput;
            tail = ndInput;
        } else {
            tail.next = ndInput;   
            tail = ndInput;
        }
    }

    void insertAfter(int key, int input) {
        Node25 ndInput = new Node25(input, null);
        Node25 temp = head;
        do{
            if(temp.data == key) {
                ndInput.next = temp.next;
                temp.next = ndInput;
                if(ndInput.next == null) {
                    tail = ndInput;
                }
            }
            temp = temp.next;
        } while (temp != null); 
    }

    void insertAt(int index, int input) {
        if (index < 0) {
            System.out.println("Indeks tidak valid");
            return;
        } else if (index == 0) {
            addFirst(input);
            return;
        } else {
            Node25 ndInput = new Node25(input, null);
            Node25 temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            ndInput.next = temp.next;
            temp.next = ndInput;
            if (ndInput.next == null) {
                tail = ndInput;
            }
        }
    }
    int getData(int index) {
        Node25 tmp = head;
        for (int i = 0; i < index - 1; i++) {
            tmp = tmp.next;
        }
        return tmp.next.data;
    }

    int indexOf(int key) {
        Node25 tmp = head;
        int index = 0;
        while (tmp != null && tmp.data != key) {
            tmp = tmp.next;
            index++;
        }
        if(tmp == null) {
            return -1;
        } else {
            return index;
        }
    }

    void removeFirst() {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong," 
                        + " tidak bisa di hapus");
        } else if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
        }
    }

    void removeLast() {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong," 
                        + " tidak bisa di hapus");
        } else if (head == tail) {
            head = tail = null;
        } else {
            Node25 temp = head;
            while (temp.next == null) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp.next;
        }
    }

    void remove(int key) {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong," 
                        + " tidak bisa di hapus");
        } else {
            Node25 temp = head;
            while (temp != null) {
                if(head.data == key && temp == head){
                    removeFirst();
                    break;
                } else if (temp.next.data == key){
                    temp.next = temp.next.next;
                    if(temp.next == null){
                        tail = temp;
                    }
                    break;
                }
                temp = temp.next;
            }
        }
    }

    public void removeAt (int index) {
        if (index ==0 ) {
            removeFirst();
        } else {
            Node25 temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            if (temp.next == null) {
                tail = temp;
            }
        }
    }
}
```
#### CLASS MHSSLLMain25

```java
public class MHSSLLMain25 {
    public static void main(String[] args) {
        MHSSingleLinkedList25 singLL = new MHSSingleLinkedList25();

        singLL.addFirst("111", "Anton");
        singLL.addLast("115", "Sari");
        singLL.insertAfter("111", "112", "Prita");
        singLL.insertAfter("112", "113", "Yusuf");
        singLL.insertAt(3, "114", "Doni");

        singLL.print();
    }
}
```
#### Outputnya
![alt text](<screenshots/Screenshot 2024-05-22 072701.png>)

#### 2 Buatlah implementasi program antrian layanan unit kemahasiswaan sesuai dengan kondisi yang ditunjukkan pada soal nomor 1! Ketentuan
#### a. Implementasi antrian menggunakan Queue berbasis Linked List!
#### b. Program merupakan proyek baru, bukan modifikasi dari soal nomor 1!

#### Jawab 
#### CLASS MahasiswaQueue25
```java
class MahasiswaQueue25 {
    int nim;
    String nama;
    MahasiswaQueue25 next;

    MahasiswaQueue25(int nim, String nama) {
        this.nim = nim;
        this.nama = nama;
        this.next = null;
    }
}
```
#### CLASS Queue25
```java
public class Queue25 {
    MahasiswaQueue25 front, rear;

    boolean isEmpty() {
        return front == null;
    }

    void enqueue(int nim, String nama) {
        MahasiswaQueue25 newNode = new MahasiswaQueue25(nim, nama);
        if (this.rear == null) {
            this.front = this.rear = newNode;
            return;
        }
        this.rear.next = newNode;
        this.rear = newNode;
    }

    void dequeue() {
        if (isEmpty()) {
            System.out.println("Antrian kosong");
        } else {
            front = front.next;
            if (front == null) {
                rear = null;
            }
        }
    }

    void print() {
        if (isEmpty()) {
            System.out.println("Antrian kosong");
        } else {
            MahasiswaQueue25 tmp = front;
            System.out.println("Antrian: ");
            while (tmp != null) {
                System.out.println("NIM: " + tmp.nim + ", Nama: " + tmp.nama);
                tmp = tmp.next;
            }
        }
    }
}
```
#### CLASS QueueMain25
```java
public class QueueMain25 {
    public static void main(String[] args) {
        Queue25 queue = new Queue25();
        queue.enqueue(111, "Anton");
        queue.enqueue(112, "Prita");
        queue.enqueue(113, "Yusuf");
        queue.enqueue(114, "Doni");
        queue.enqueue(115, "Sari");

        queue.print();

        System.out.println("Dequeue: ");
        queue.dequeue();
        queue.print();
    }
}
```
#### Outputnya
![alt text](<screenshots/Screenshot 2024-05-22 073821.png>)