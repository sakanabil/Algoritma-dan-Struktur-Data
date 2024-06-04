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