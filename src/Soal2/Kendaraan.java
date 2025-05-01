package Soal2;

public class Kendaraan {
    String jenisKendaraan;
    int lamaParkir;
    double hargaParkir;

    Kendaraan(String jenisKendaraan) {
        this.jenisKendaraan = jenisKendaraan;
    }

    // Untuk menghitung biaya dengan nominal yang berbeda
    public double biayaParkir(int biaya, int jam) {
        if (jam > 5) {
            return biaya * jam * 0.9;
        }
        return biaya * jam;
    }

    public void hitungParkir(int jam) {
        lamaParkir = jam;
        hargaParkir =  switch (jenisKendaraan) {
            case "Mobil" -> biayaParkir(5000, (jam));
            case "Motor" -> biayaParkir(3000, (jam));
            case "Truk" -> biayaParkir(8000, (jam));
            default -> 0;
        };
    }

    public void hitungParkir(int jamMasuk, int jamKeluar) {
        lamaParkir = jamKeluar - jamMasuk;
        hargaParkir =  switch (jenisKendaraan) {
            case "Mobil" -> biayaParkir(5000, (jamKeluar - jamMasuk));
            case "Motor" -> biayaParkir(3000, (jamKeluar - jamMasuk));
            case "Truk" -> biayaParkir(8000, (jamKeluar - jamMasuk));
            default -> 0;
        };
    }

    public void Info() {
        System.out.println("------ Bon Parkir ------");
        System.out.println("Jenis kendaraan = " + jenisKendaraan);
        System.out.println("Lama Parkir     = " + lamaParkir + " jam");
        System.out.println("Total Biaya     = Rp." + hargaParkir);
    }
}

