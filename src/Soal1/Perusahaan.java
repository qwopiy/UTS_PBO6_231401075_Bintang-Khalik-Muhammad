package Soal1;

import java.io.FileWriter;
import java.util.Scanner;
import java.io.File;            // untuk membaca, menghapus, dan menulis data ke file
import java.io.IOException;             // error handling


public class Perusahaan {
    Scanner sc = new Scanner(System.in);

    // array yang berisi karyawan2 dalam perusahaan, dengan limit 100.
    Karyawan[] karyawan = new Karyawan[100];

    // index yang digunakan untuk menentukan karyawan indeks ke berapa yang dapat diisi
    int indexKaryawanNull = 0;

    // inisialisasi penyimpanan data dalam database.txt
    public void createDatabase() {
        try {
            File myObj = new File("src\\Soal1\\Database.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

    // menyimpan data ke database.txt
    public void saveToDatabase() {
        try {
            FileWriter wr = new FileWriter("src\\Soal1\\Database.txt");
            for (int i = 0; i < 100; i++) {
                if (karyawan[i] != null) {
                    wr.write(i + " "
                            + karyawan[i].id + " "
                            + karyawan[i].nama + " "
                            + karyawan[i].posisi + " "
                            + karyawan[i].gaji + "\n");
                }
            }
            wr.close();
        } catch (IOException e) {
            System.out.println("An error occured.");
        }
    }

    // mengambil data dari database
    public void loadFromDatabase() {
        try {
            File db = new File("src\\Soal1\\Database.txt");
            Scanner readDB = new Scanner(db);
            // karena data berformat seperti ini, 0 100 Bintang Boss 2000000
            // maka digunakan logika ini untuk membagi semua nilai yang dipisah dengan whitespace
            while (readDB.hasNextLine()) {
                String line = readDB.nextLine();
                String[] data = line.split(" ");

                karyawan[Integer.parseInt(data[0])] = new Karyawan(
                        data[1],
                        data[2],
                        data[3],
                        Integer.parseInt(data[4])
                );
            }
            readDB.close();
        } catch (Exception e) {
            System.out.println("An error occured.");
            throw new RuntimeException(e);
        }
    }

    // menambah karyawan baru
    public Karyawan tambahKaryawan() {
        try {
            System.out.print("Masukkan id     = ");
            String id = sc.nextLine();

            // Validasi untuk id karyawan agar tidak terjadi duplikat
            for (Karyawan i : karyawan) {
                if (i != null && i.id.equals(id)) {
                    System.out.println("Id sudah dipakai.");
                    throw new RuntimeException();
                }
            }

            System.out.print("Masukkan Nama   = ");
            String nama = sc.nextLine();
            nama = nama.replaceAll(" ", "");        // untuk menghilangkan whitespace agar dapat disimpan dalam database

            System.out.print("Masukkan Posisi = ");
            String posisi = sc.nextLine();
            posisi = posisi.replaceAll(" ","");     // untuk menghilangkan whitespace agar dapat disimpan dalam database

            System.out.print("Masukkan Gaji   = ");
            int gaji = sc.nextInt();
            sc.nextLine();

            // Validasi agar gaji tidak bernilai negatif
            if (gaji < 0) {
                System.out.println("Gaji tidak bisa negatif.");
                throw new RuntimeException();
            }

            return new Karyawan(id, nama, posisi, gaji);
        } catch (Exception e) {
            return null;
        }
    }

    // menghapus karyawan
    public void hapusKaryawan() {
        System.out.print("Masukkan id karyawan yang ingin dihapus = ");
        String id = sc.nextLine();

        // Mengecek apakah ada karyawan dengan id yang diinput
        for (int i = 0; i < 100; i++) {
            if (karyawan[i] != null && karyawan[i].id.equals(id)) {
                karyawan[i] = null;
                System.out.println("Karyawan berhasil dihapus.");
                return;
            }
        }
        System.out.println("Tidak ada karyawan dengan id " + id + ".");
    }

    public void ubahPosisiKaryawan() {
        System.out.print("Masukkan id karyawan yang ingin diubah posisi = ");
        String id = sc.nextLine();

        for (Karyawan i : karyawan) {
            if (i != null && i.id.equals(id)) {
                System.out.print("Masukkan posisi baru " + i.nama + " = ");
                i.posisi = sc.nextLine();
                System.out.println("Perubahan Berhasil.");
                return;
            }
        }
        System.out.println("Tidak ada karyawan dengan id " + id + ".");
    }

    public void ubahGajiKaryawan() {
        System.out.print("Masukkan id karyawan yang ingin diubah gajinya = ");
        String id = sc.nextLine();

        for (Karyawan i : karyawan) {
            if (i != null && i.id.equals(id)) {
                System.out.print("Masukkan gajinya yang baru " + i.nama + " = ");
                i.gaji = sc.nextInt();
                sc.nextLine();
                System.out.println("Perubahan Berhasil.");
                return;
            }
        }
        System.out.println("Tidak ada karyawan dengan id " + id + ".");
    }

    public void tampilkanSeluruhKaryawan() {
        boolean empty = true;
        for (Karyawan i : karyawan) {
            if (i != null) {
                System.out.println("ID     = " + i.id);
                System.out.println("Nama   = " + i.nama);
                System.out.println("Posisi = " + i.posisi);
                System.out.println("Gaji   = " + i.gaji);
                System.out.println();
                empty = false;
            }
        }
        if (empty) {
            System.out.println("Perusahaan ini tidak memiliki karyawan.");
        }
    }

    public void cariKaryawanDariID() {
        System.out.print("Masukkan id karyawan yang ingin dicari = ");
        String id = sc.nextLine();

        for (Karyawan i : karyawan) {
            if (i != null && i.id.equals(id)) {
                System.out.println("ID     = " + i.id);
                System.out.println("Nama   = " + i.nama);
                System.out.println("Posisi = " + i.posisi);
                System.out.println("Gaji   = " + i.gaji);
                System.out.println();
                return;
            }
        }
    }

    // Method ini untuk mencari index dalam array karyawan yang bernilai null
    public void cariIndexKaryawanKosong() {
        for (int i = 0; i < 100; i++) {
            if (karyawan[i] == null) {
                indexKaryawanNull = i;
                return;
            }
        }
    }
}