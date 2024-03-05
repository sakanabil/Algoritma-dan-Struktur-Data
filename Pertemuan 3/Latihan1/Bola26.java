package Latihan1;

public class Bola26 {
    double jariJari;
    
    public Bola26(double jariJari) {
        this.jariJari = jariJari;
    }
    public double hitungLuasPermukaan() {
        return 4 * Math.PI * jariJari * jariJari;
    }
    public double hitungVolume() {
        return (4.0 / 3.0) * Math.PI * jariJari * jariJari * jariJari;
    }
}