public class MainMobil26 {
    public static void main(String[] args) {

        DaftarMobil26 outputMobil = new DaftarMobil26();
        System.out.println("Mobil Top Acceleration Tertinggi : "
                + outputMobil.maxAcceleration(outputMobil.topAcceleration, 0, outputMobil.topAcceleration.length - 1));
        System.out.println("Mobil Top Acceleration Terendah : "
                + outputMobil.minAcceleration(outputMobil.topAcceleration, 0, outputMobil.topAcceleration.length - 1));
        System.out.println("Rata-rata Top Power Adalah " + outputMobil.rataPower());
    }
}