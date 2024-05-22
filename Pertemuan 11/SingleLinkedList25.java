public class SingleLinkedList25 {
    Node25 head, tail;

    boolean isEmpty() {
        return head == null;
    }

    void print() {
        if (isEmpty()) {
            System.out.println("Linked List kosong");
        } else {
            Node25 tmp = head;
            System.out.print("Isi Linked List:\t");
            while (tmp != null) {
                System.out.print(tmp.data + "\t");
                tmp = tmp.next;
            }
            System.out.println("");
        }
    }
    
    void addFirst(int input) {
        Node25 ndInput = new Node25(input, null);
        if(isEmpty()) {
            head = ndInput;
            tail = ndInput;
        } else {
            ndInput.next = head;
            head = ndInput;
        }
    }

    void addLast(int input) {
        Node25 ndInput = new Node25(input, null);
        if(isEmpty()) {
            head = ndInput;
            tail = ndInput;
        } else {
            tail.next = ndInput;   
            tail = ndInput;
        }
    }

    void insertAfter(int key, int input) {
        Node25 ndInput = new Node25(input, null);
        Node25 temp = head;
        do{
            if(temp.data == key) {
                ndInput.next = temp.next;
                temp.next = ndInput;
                if(ndInput.next == null) {
                    tail = ndInput;
                }
            }
            temp = temp.next;
        } while (temp != null); 
    }

    void insertAt(int index, int input) {
        if (index < 0) {
            System.out.println("Indeks tidak valid");
            return;
        } else if (index == 0) {
            addFirst(input);
            return;
        } else {
            Node25 ndInput = new Node25(input, null);
            Node25 temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            ndInput.next = temp.next;
            temp.next = ndInput;
            if (ndInput.next == null) {
                tail = ndInput;
            }
        }
    }
    int getData(int index) {
        Node25 tmp = head;
        for (int i = 0; i < index - 1; i++) {
            tmp = tmp.next;
        }
        return tmp.next.data;
    }

    int indexOf(int key) {
        Node25 tmp = head;
        int index = 0;
        while (tmp != null && tmp.data != key) {
            tmp = tmp.next;
            index++;
        }
        if(tmp == null) {
            return -1;
        } else {
            return index;
        }
    }

    void removeFirst() {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong," 
                        + " tidak bisa di hapus");
        } else if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
        }
    }

    void removeLast() {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong," 
                        + " tidak bisa di hapus");
        } else if (head == tail) {
            head = tail = null;
        } else {
            Node25 temp = head;
            while (temp.next == null) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp.next;
        }
    }

    void remove(int key) {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong," 
                        + " tidak bisa di hapus");
        } else {
            Node25 temp = head;
            while (temp != null) {
                if(head.data == key && temp == head){
                    removeFirst();
                    break;
                } else if (temp.next.data == key){
                    temp.next = temp.next.next;
                    if(temp.next == null){
                        tail = temp;
                    }
                    break;
                }
                temp = temp.next;
            }
        }
    }

    public void removeAt (int index) {
        if (index ==0 ) {
            removeFirst();
        } else {
            Node25 temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            if (temp.next == null) {
                tail = temp;
            }
        }
    }
}