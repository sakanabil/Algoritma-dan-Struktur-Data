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