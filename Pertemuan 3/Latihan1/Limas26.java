package Latihan1;

public class Limas26 {
    double sisiAlas;
    double tinggi;

    public Limas26(double sisiAlas, double tinggi) {
        this.sisiAlas = sisiAlas;
        this.tinggi = tinggi;
    }
    public double hitungLuasPermukaan() {
        double luasAlas = sisiAlas * sisiAlas;
        double luasSegitiga = (sisiAlas * tinggi) / 2;
        return luasAlas + 4 * luasSegitiga;
    }
    public double hitungVolume() {
        return (sisiAlas * sisiAlas * tinggi) / 3;
    }
}