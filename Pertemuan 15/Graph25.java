public class Graph25 {
    int vertex;
    DoubleLinkedList25 list[];

    public Graph25(int v) {
            vertex = v;
            list = new DoubleLinkedList25[v];
            for (int i=0; i < v; i++) {
                list[i] = new DoubleLinkedList25();
        }
    }

    public void addEdge(int asal, int tujuan, int jarak) {
        list[asal].addFirst(tujuan, jarak);
    }
        

    public void degree(int asal) throws Exception {
        int k, totalin = 0, totalout = 0;
            for (int i = 0; i < vertex; i++) {
                for (int j = 0; j < list[i].size(); j++) {
                    if (list[i].get(j) == asal) {
                        ++totalin;
                    }
                }
            for (k = 0; k < list[asal].size(); k++) {
                    list[asal].get(k);
                }
                totalout = k;
            }
        System.out.println("InDegree dari Gedung " + (char) ('A' +asal) + ":" + totalin); 
        System.out.println("OutDegree dari Gedung " + (char) ('A' + asal) + ":" + totalout);
        System.out.println("Degree dari Gedung " +(char) ('A' +asal)+":"+ (totalin + totalout));
    }

    public void removeEdge(int asal, int tujuan) throws Exception {
        for (int i = 0; i < vertex; i++) {
            if (i == tujuan) {
                list[asal].remove(tujuan);
            }
        }
    }

    public void removeAllEdges() {
        for (int i=0; i < vertex; i++) {
        list[i].clear();
        }
        System.out.println("Graph berhasil dikosongkan");
    }

    public void printGraph() throws Exception {
        for (int i=0; i < vertex; i++) { 
            if (list[i].size() > 0) {
                System.out.println("Gedung " + (char) ('A'+ i)+" terhubung dengan ");
                for (int j = 0; j < list[i].size(); j++) {
                    System.out.print((char) ('A' + list[i].get(j))+" ("+ list[i].getJarak(j)+"m), ");
                    }
                System.out.println("");
            }
        }
        System.out.println("");
    }
}
