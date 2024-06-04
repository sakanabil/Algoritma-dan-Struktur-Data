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