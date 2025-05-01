package Soal3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] jawab = new int[2];
        Scanner sc = new Scanner(System.in);
        LotreBoard game = new LotreBoard();
        game.generateBoard();
        // DEBUG
        System.out.println("1 = " + game.answer[0][0] + " " + game.answer[0][1]);
        System.out.println("1 = " + game.answer[1][0] + " " + game.answer[1][1]);

        System.out.println("Welcome to Lotre!");
        game.displayBoard();
        do {

            System.out.print("Masukkan tebakan anda (baris dan kolom) = ");
            for (int i = 0; i < 2; i++) {
                jawab[i] = sc.nextInt();
            }

            // validasi jawaban
            if ((jawab[0] < 0 || jawab[0] > 3) || (jawab[1] < 0 || jawab[1] > 4)) {
                System.out.println("Angka salah, harusnya antara 0 0 sampai 3 4");
            } else {
                if (game.guess(jawab[0], jawab[1])) {
                    game.board[jawab[0]][jawab[1]] = 'O';
                } else {
                    game.board[jawab[0]][jawab[1]] = 'X';
                }
            }

        } while (!game.isGameOver());
        sc.close();
    }
}
