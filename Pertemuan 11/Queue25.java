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