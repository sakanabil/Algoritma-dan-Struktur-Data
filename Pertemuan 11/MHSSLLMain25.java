

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