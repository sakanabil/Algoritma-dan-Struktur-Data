public class Segitiga26 {
    public int alas;
    public int tinggi;

    public Segitiga26(int a, int t) {
        alas = a;
        tinggi = t;
    }

    public int hitungLuas() {
        return (alas * tinggi) / 2;
    }

    public double hitungKeliling() {
        double sisiMiring = Math.sqrt((alas * alas) + (tinggi * tinggi));
        double keliling = alas + tinggi + sisiMiring;
        return keliling;
    }
}