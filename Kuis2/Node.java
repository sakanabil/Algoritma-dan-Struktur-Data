package Kuis2;
public class Node {
    Club club;
    Node prev;
    Node next;

    public Node(Club club) {
        this.club = club;
        this.prev = null;
        this.next = null;
    }
}