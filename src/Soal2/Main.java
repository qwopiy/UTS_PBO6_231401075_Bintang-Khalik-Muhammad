package Soal2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char repeat = 'n';
        int index = 0;
        Kendaraan[] kendaraan = new Kendaraan[100];

        System.out.println("|=====| Parking-Chan |=====|");
        do {
            System.out.print("\nMasukkan jenis kendaraan (Mobil/Motor/Truk) = ");
            String jenis = sc.nextLine();
            if (!(jenis.equals("Mobil") || jenis.equals("Motor") || jenis.equals("Truk"))) {
                System.out.println("Kendaraan apa itu?");
                break;
            }
            kendaraan[index] = new Kendaraan(jenis);

            System.out.print("Masukkan durasi (Manual/Time) = ");
            String pilihanDurasi = sc.nextLine();

            switch (pilihanDurasi) {
                case "Manual":
                    System.out.print("Masukkan durasi (Jam) = ");
                    kendaraan[index].hitungParkir(sc.nextInt());
                    sc.nextLine();
                    break;
                case "Time":
                    System.out.print("Masukkan jam masuk  = ");
                    int jamIn = sc.nextInt();
                    System.out.print("Masukkan jam keluar = ");
                    int jamOut = sc.nextInt();
                    sc.nextLine();
                    kendaraan[index].hitungParkir(jamIn, jamOut);
                    break;
                default:
                    System.out.println("Pilihan invalid");
                    break;
            }
            kendaraan[index++].Info();
            System.out.print("Apakah ada kendaraan lain? (y/n) = ");
            repeat = sc.nextLine().charAt(0);
        } while (repeat == 'y' || repeat == 'Y');

        double totalBiaya = 0;
        for (Kendaraan i : kendaraan) {
            if (i != null)
                totalBiaya += i.hargaParkir;
        }
        System.out.println("======= TOTAL =======");
        System.out.println("Total Kendaraan = " + index);
        System.out.println("Total Biaya     = " + totalBiaya);

        sc.close();
    }
}
