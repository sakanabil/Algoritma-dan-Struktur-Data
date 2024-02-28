public class ArraySegitiga26 {
    public static void main(String[] args) {
        Segitiga26[] sgArray = new Segitiga26[4];

        sgArray[0] = new Segitiga26(10, 4);
        sgArray[1] = new Segitiga26(20, 10);
        sgArray[2] = new Segitiga26(15, 6);
        sgArray[3] = new Segitiga26(25, 10);

        for (int i = 0; i < 4; i++)
        {
            System.out.println("Luas segitiga ke " + i + ": " + sgArray[i].hitungLuas());
            System.out.println("Keliling segitiga ke " + i + ": " + sgArray[i].hitungKeliling());
        }
    }
}
