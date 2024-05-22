package Kuis2;
class DoubleLinkedList {
    Node head;
    int size;

    public DoubleLinkedList() {
        head = null;
        size = 0;
    }

    public void addClub(Club club) {
        Node newNode = new Node(club);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
        size++;
    }

    public Club findClub(String name) {
        Node current = head;
        while (current != null) {
            if (current.club.name.equalsIgnoreCase(name)) {
                return current.club;
            }
            current = current.next;
        }
        return null;
    }

    public void sortClubs() {
        if (head == null || head.next == null) {
            return;
        }

        boolean swapped;
        Node current;
        Node last = null;

        do {
            swapped = false;
            current = head;

            while (current.next != last) {
                if (current.club.points < current.next.club.points) {
                    Club temp = current.club;
                    current.club = current.next.club;
                    current.next.club = temp;
                    swapped = true;
                }
                current = current.next;
            }
            last = current;
        } while (swapped);
    }

    public void printList() {
        System.out.printf("%-5s %-35s %2s %6s %6s %6s%n", "NO", "NAMA TIM", "MP", "MENANG", "KALAH", "POINTS");
        Node current = head;
        int rank = 1;
        while (current != null) {
            System.out.printf("%-5d %s%n", rank++, current.club);
            current = current.next;
        }
    }
}