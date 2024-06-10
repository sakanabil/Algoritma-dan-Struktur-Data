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