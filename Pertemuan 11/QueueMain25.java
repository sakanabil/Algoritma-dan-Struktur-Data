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