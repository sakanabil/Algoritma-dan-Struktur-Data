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
## TREE
### Percobaan 1
#### CLASS Node25
```java
public class Node25 {
    int data;
    Node25 left;
    Node25 right;

    public Node25() {
    }

    Node25(Node25 left, int data, Node25 right) {
        this.left = null;
        this.data = data;
        this.right = null;
    }
}
```
#### CLASS BinaryTree25
```java
public class BinaryTree25 {
    Node25 root;

    public BinaryTree25() {
        root = null;
    }

    boolean isEmpty() {
        return root == null;
    }

    void add(int data) {
        if (isEmpty()) { // tree is empty
            root = new Node25(null, data, null);
        } else {
            Node25 current = root;
            while (true) {
                if (data < current.data) { 
                    if (current.left != null) {
                        current = current.left;
                    } else {
                        current.left = new Node25(null, data, null);
                        break;
                    }
                } else if (data > current.data) { 
                    if (current.right != null) {
                        current = current.right;
                    } else {
                        current.right = new Node25(null, data, null);
                        break;
                    }
                } else { 
                    break;
                }
            }
        }
    }

    boolean find(int data) {
        boolean result = false;
        Node25 current = root;
        while (current != null) { 
            if (current.data == data) { 
                result = true;
                break;
            } else if (data < current.data) { 
                current = current.left;
            } else {
                current = current.right; 
            }
        }
        return result;
    }

    void traversePreOrder(Node25 node) {
        if (node != null) {
            System.out.print(" " + node.data);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    void traversePostOrder(Node25 node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.print(" " + node.data);
        }
    }

    void traverseInOrder(Node25 node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.data);
            traverseInOrder(node.right);
        }
    }

    Node25 getSuccessor(Node25 del) {
        Node25 successor = del.right;
        Node25 successorParent = del;
        while (successor.left != null) {
            successorParent = successor;
            successor = successor.left;
        }
        if (successor != del.right) {
            successorParent.left = successor.right;
            successor.right = del.right;
        }
        return successor;
    }

    void delete(int data) {
        if (isEmpty()) {
            System.out.println("Tree is empty");
            return;
        }

        Node25 parent = root;
        Node25 current = root;
        boolean isLeftChild = false;
        while (current != null) {
            if (current.data == data) {
                break;
            } else if (data < current.data) {
                parent = current;
                current = current.left;
                isLeftChild = true;
            } else if (data > current.data) {
                parent = current;
                current = current.right;
                isLeftChild = false;
            }
        }

        if (current == null) {
            System.out.println("Could not find data!");
            return;
        } else {
            if (current.left == null && current.right == null) {
                if (current == root) {
                    root = null;
                } else {
                    if (isLeftChild) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                }
            } else if (current.left == null) { 
                if (current == root) {
                    root = current.right;
                } else if (isLeftChild) {
                    parent.left = current.right;
                } else {
                    parent.right = current.right;
                }
            } else if (current.right == null) {
                if (current == root) {
                    root = current.left;
                } else {
                    if (isLeftChild) {
                        parent.left = current.left;
                    } else {
                        parent.right = current.left;
                    }
                }
            } else { 
                Node25 successor = getSuccessor(current);
                if (current == root) {
                    root = successor;
                } else {
                    if (isLeftChild) {
                        parent.left = successor;
                    } else {
                        parent.right = successor;
                    }
                    successor.left = current.left;
                }
            }
        }
    }
}
```
#### CLASS BinaryTreeMain25
```java
public class BinaryTreeMain25 {
    public static void main(String[] args) {

        BinaryTree25 bt = new BinaryTree25();
        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);
        bt.add(10);
        bt.add(15);
        System.out.print("PreOrder Travesal : ");
        bt.traversePreOrder(bt.root);
        System.out.println("");
        System.out.print("InOrder Travesal : ");
        bt.traverseInOrder(bt.root);
        System.out.println("");
        System.out.print("PostOrder Travesal : ");
        bt.traversePostOrder(bt.root);
        System.out.println("");
        System.out.println("Find Node : " + bt.find(5));
        System.out.println("Delete Node 8 ");
        bt.delete(8);
        System.out.println("");
        System.out.print("PreOrder Travesal : ");
        bt.traversePreOrder(bt.root);
        System.out.println("");
    }
}
```
#### Outputnya
![alt text](<screenshots/Screenshot 2024-06-04 225059.png>)

### Pertanyaan
#### 1. Mengapa dalam binary search tree proses pencarian data bisa lebih efektif dilakukan dibanding binary tree biasa?
    Jawab : Karena dalam binary search tree, node-node diatur dalam urutan tertentu berdasarkan nilai kunci. Kepemilikan urutan ini memungkinkan pencarian yang lebih efisien.
#### 2. Untuk apakah di class Node, kegunaan dari atribut left dan right?
    Jawab : Dalam class Node, atribut left dan right digunakan untuk menyimpan referensi ke node-node yang berada di sebelah kiri dan kanan dari node tersebut.
#### 3. a. Untuk apakah kegunaan dari atribut root di dalam class BinaryTree?
    Jawab : Atribut root digunakan untuk menyimpan referensi ke node root dari pohon binari.
#### b. Ketika objek tree pertama kali dibuat, apakah nilai dari root?
    Jawab : nilai dari root adalah null
#### 4. Ketika tree masih kosong, dan akan ditambahkan sebuah node baru, proses apa yang akan terjadi?
    Jawab : Ketika tree masih kosong, dan akan ditambahkan sebuah node baru maka yang terjadi adalah node baru tersebut akan menjadi root dari tree.
#### 5. Perhatikan method add(), di dalamnya terdapat baris program seperti di bawah ini. Jelaskan secara detil untuk apa baris program tersebut?
![alt text](<screenshots/Screenshot 2024-06-04 225417.png>)
    Jawab : if(data<current.data){: Baris ini digunakan untuk memeriksa apakah nilai kunci dari node baru (data) lebih kecil dari nilai kunci dari node saat ini (current.data). Jika iya, maka kita akan melanjutkan ke langkah selanjutnya.
    if(current.left!=null){: Baris ini digunakan untuk memeriksa apakah node saat ini (current) memiliki child kiri (current.left) yang tidak null. Jika iya, maka kita akan memindahkan current menjadi node child kiri (current = current.left) dan melanjutkan ke langkah selanjutnya.
    current.left = new Node(data);: Baris ini digunakan untuk menambahkan node baru dengan nilai kunci data sebagai child kiri dari node saat ini (current). Dengan mengatur current.left menjadi referensi ke objek Node yang baru dibuat, kita menunjukkan bahwa node tersebut menjadi child kiri dari node saat ini.
    break;: Baris ini digunakan untuk menghentikan perulangan (while loop) yang sedang berjalan. Ini berarti bahwa setelah menambahkan node baru sebagai child kiri dari node saat ini, kita tidak perlu melanjutkan perulangan lagi dan keluar dari method add().
### Percobaan 2
#### CLASS BinaryTreeArray25
```java
public class BinaryTreeArray25 {
    int[] data;
    int idxLast;

    public BinaryTreeArray25() {
        data = new int[10];
    }

    void populateData(int data[], int idxLast) {
        this.data = data;
        this.idxLast = idxLast;
    }

    void traverseInOrder(int idxStart) {
        if (idxStart <= idxLast) {
            traverseInOrder(2 * idxStart + 1);
            System.out.print(data[idxStart] + " ");
            traverseInOrder(2 * idxStart + 2);
        }
    }
}
```
#### CLASS BinaryTreeArrayMain25
```java
public class BinaryTreeArrayMain25 {
    public static void main(String[] args) {
        BinaryTreeArray25 bta = new BinaryTreeArray25();
        int[] data = { 6, 4, 8, 3, 5, 7, 9, 0, 0, 0 };
        int idxLast = 6;
        bta.populateData(data, idxLast);
        System.out.print("InOrder Travesal : ");
        bta.traverseInOrder(0);
        System.out.print("\n");
    }
}
```
#### Outputnya
![alt text](<screenshots/Screenshot 2024-06-04 225657.png>)

### Pertanyaan 
#### 1. Apakah kegunaan dari atribut data dan idxLast yang ada di class BinaryTreeArray?
    Jawab : array data menyediakan struktur dasar untuk pohon biner, sedangkan idxLast mengelola ukuran dan penelusuran pohon secara efisien dengan melacak bagian terisi dari array data.
#### 2. Apakah kegunaan dari method populateData()?
    Jawab : method populateData() digunakan untuk mengisi atribut data dan idxLast dengan nilai yang diberikan. Method ini menerima dua parameter, yaitu array data dan idxLast, dan mengatur atribut data dan idxLast menjadi nilai yang diberikan.method populateData() digunakan untuk mengisi atribut data dan idxLast dengan nilai yang diberikan. Method ini menerima dua parameter, yaitu array data dan idxLast, dan mengatur atribut data dan idxLast menjadi nilai yang diberikan.
#### 3. Apakah kegunaan dari method traverseInOrder()?
    Jawab : method traverseInOrder() digunakan untuk melakukan traversal dalam urutan (in-order) pada pohon binari yang diwakili oleh array data dan idxLast.
#### 4. Jika suatu node binary tree disimpan dalam array indeks 2, maka di indeks berapakah posisi left child dan rigth child masin-masing?
    Jawab : Jika suatu node binary tree disimpan dalam array indeks 2, maka posisi left child-nya adalah pada indeks 5, sedangkan posisi right child-nya adalah pada indeks 6.
#### 5. Apa kegunaan statement int idxLast = 6 pada praktikum 2 percobaan nomor 4?
    Jawab : Statement int idxLast = 6 pada praktikum 2 percobaan nomor 4 digunakan untuk menginisialisasi nilai awal variabel idxLast dengan nilai 6. nilai idxLast diinisialisasi dengan 6 karena pohon binari yang diwakili oleh array data memiliki 6 elemen yang terisi. Ini berarti bahwa pohon binari memiliki size maksimum pohon adalah 2^2 - 1 = 7.
### Tugas
#### 1.Buat method di dalam class BinaryTree yang akan menambahkan node dengan cara rekursif.
```java

    void tambahRekursif(Node25 current, int data) { 
        if (current == null) {
            current = new Node25(null, data, null);
        } else {
            if (data < current.data) {
                if (current.left != null) {
                    tambahRekursif(current.left, data);
                } else {
                    current.left = new Node25(null, data, null);
                }
            } else if (data > current.data) {
                if (current.right != null) {
                    tambahRekursif(current.right, data);
                } else {
                    current.right = new Node25(null, data, null);
                }
            }
        }
    }
}
```
#### 2.Buat method di dalam class BinaryTree untuk menampilkan nilai paling kecil dan yang paling besar yang ada di dalam tree.
```java
    int findMin() {
        Node25 current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.data;
    }

    int findMax() {
        Node25 current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.data;
    }
```
#### 3.Buat method di dalam class BinaryTree untuk menampilkan data yang ada di leaf.
```java
    void tampilLeaf(Node25 node) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                System.out.print(" " + node.data);
            } else {
                tampilLeaf(node.left);
                tampilLeaf(node.right);
            }
        }
    }
```
#### 4.Buat method di dalam class BinaryTree untuk menampilkan berapa jumlah leaf yang ada di dalam tree
```java
    int tampilJmlLeaf(Node25 node) {
        if (node == null) {
            return 0;
        } else if (node.left == null && node.right == null) {
            System.out.println(" " + node.data);
            return 1;
        } else {
            return tampilJmlLeaf(node.left) + tampilJmlLeaf(node.right);
        }
    }
```
#### Outputnya
![alt text](<screenshots/Screenshot 2024-06-04 231439.png>)
#### 5. Modifikasi class BinaryTreeArray, dan tambahkan : 
#### • method add(int data) untuk memasukan data ke dalam tree 
#### • method traversePreOrder() dan traversePostOrder(
#### CLASS BinaryTreeArray25
```java
public class BinaryTreeArray25 {
    int[] data;
    int idxLast;

    public BinaryTreeArray25() {
        data = new int[10];
        idxLast = -1; 
    }

    void populateData(int data[], int idxLast) {
        this.data = data;
        this.idxLast = idxLast;
    }

    void traverseInOrder(int idxStart) {
        if (idxStart <= idxLast) {
            traverseInOrder(2 * idxStart + 1);
            System.out.print(data[idxStart] + " ");
            traverseInOrder(2 * idxStart + 2);
        }
    }

    void add(int data) {
        if (idxLast == this.data.length - 1) {
            System.out.println("Tree sudah Penuh");
            return;
        }
        idxLast++;
        this.data[idxLast] = data;
    }

    void traversePreOrder(int idxStart) {
        if (idxStart <= idxLast) {
            System.out.print(this.data[idxStart] + " ");
            traversePreOrder(2 * idxStart + 1);
            traversePreOrder(2 * idxStart + 2);
        }
    }

    void traversePostOrder(int idxStart) {
        if (idxStart <= idxLast) {
            traversePostOrder(2 * idxStart + 1);
            traversePostOrder(2 * idxStart + 2);
            System.out.print(this.data[idxStart] + " ");
        }
    }
}
```
#### CLASS BinaryTreeArrayMain25
```java
public class BinaryTreeArrayMain25 {
    public static void main(String[] args) {
        BinaryTreeArray25 bta = new BinaryTreeArray25();

        int[] data = { 6, 4, 8, 3, 5, 7, 9, 0, 0, 0 };
        int idxLast = 6;
        bta.populateData(data, idxLast);
        System.out.print("InOrder Travesal : ");
        bta.traverseInOrder(0);
        System.out.print("\n");

        System.out.println("PreOrder Traversal: ");
        bta.traversePreOrder(0);
        System.out.println(" ");
        System.out.println("PostOrder Traversal: ");
        bta.traversePostOrder(0);
        System.out.println(" ");
    }
}
```
#### Outputnya
![alt text](<screenshots/Screenshot 2024-06-04 231042.png>)
