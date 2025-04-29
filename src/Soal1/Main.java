package Soal1;

public class Main extends Perusahaan {
    public static void main(String[] args) {

        Main PT = new Main();

        // inisialisasi database dan nilai awal
        PT.createDatabase();
        PT.loadFromDatabase();
        char repeat = 'n';

        do {
            // Tampilan Utama
            System.out.println("======|| MENU UTAMA ||======");
            System.out.println("1. Tambah Karyawan");
            System.out.println("2. Hapus Karyawan");
            System.out.println("3. Ubah Posisi");
            System.out.println("4. Ubah Gaji");
            System.out.println("5. Cari Karyawan");
            System.out.println("6. Tampilkan Semua Karyawan");
            System.out.println("0. Exit");
            System.out.print("\nPilihan anda = ");
            int pilihan = PT.sc.nextInt();
            PT.sc.nextLine();

            switch (pilihan) {
                case 1:
                    PT.cariIndexKaryawanKosong();
                    PT.karyawan[PT.indexKaryawanNull] = PT.tambahKaryawan();
                    break;
                case 2:
                    PT.hapusKaryawan();
                    break;
                case 3:
                    PT.ubahPosisiKaryawan();
                    break;
                case 4:
                    PT.ubahGajiKaryawan();
                    break;
                case 5:
                    PT.cariKaryawanDariID();
                    break;
                case 6:
                    PT.tampilkanSeluruhKaryawan();
                    break;
                case 0:
                    return;

                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
            System.out.print("Apakah anda ingin ulang? (y/n) ");
            repeat = PT.sc.next().charAt(0);
            System.out.println("\n\n\n\n\n");
        } while ((repeat == 'y') || (repeat == 'Y'));

        PT.saveToDatabase();
        PT.sc.close();
    }
}
