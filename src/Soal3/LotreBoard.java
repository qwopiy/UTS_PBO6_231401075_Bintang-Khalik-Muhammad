package Soal3;

import java.util.Random;

public class LotreBoard {
    char[][] board = new char[4][5];
    boolean[][] revealed = new boolean[4][5];
    int[][] data = new int[4][5];
    int[][] answer = new int[2][2];

    // Menghasilkan papan dengan 2 bom di posisi acak
    void generateBoard() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                // inisialisasi array board
                board[i][j] = '*';

                // inisialisasi array revealed
                revealed[i][j] = false;

                // inisialisasi array data
                data[i][j] = 0;
            }
        }

        // mengambil angka acak untuk bom, dan
        // validasi agar tidak terjadi duplikat indeks
        Random r = new Random();

        int x1 = r.nextInt(4), x2;
        int y1 = r.nextInt(5), y2;

        do {
            x2 = r.nextInt(4);
            y2 = r.nextInt(5);
        } while ((x1 == x2) && (y1 == y2));

        answer[0][0] = x1;
        answer[0][1] = y1;

        answer[1][0] = x2;
        answer[1][1] = y2;

        data[x1][y1] = 1;
        data[x2][y2] = 1;
    }

    // Menampilkan papan saat ini ke layar
    // (* untuk kotak yang belum dibuka,
    // O untuk aman, X jika bom ditemukan)
    void displayBoard() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(" " + board[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    // Memproses tebakan pemain. Mengembalikan false jika pemain
    // mengenai bom, true jika aman
    boolean guess(int row, int col) {
        if (data[row][col] == 0) {
            if (!revealed[row][col]) {
                System.out.println("Kotak aman");
                revealed[row][col] = true;
            } else {
                System.out.println("Bagian ini sudah terbuka...");
            }
            return true;
        }
        revealed[row][col] = true;
        System.out.println("BOOM! Permainan berakhir");
        return false;
    }

    // Mengecek apakah permainan selesai (menemukan bom atau berhasil
    // membuka semua aman)
    boolean isGameOver() {
        displayBoard();
        if (revealed[answer[0][0]][answer[0][1]] || revealed[answer[1][0]][answer[1][1]]) {
            System.out.println("Terima kasih sudah bermain! ;)");
            return true;
        }
        return false;
    }
}
