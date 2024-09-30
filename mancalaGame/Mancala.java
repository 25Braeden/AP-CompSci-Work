package mancalaGame;

import java.util.Arrays;

public class Mancala {
    private static final int BOARD_SIZE = 14;
    private static final int store1 = BOARD_SIZE / 2;
    private static final int store2 = 0;
    private int[] board;

    public Mancala(int n) {
        board = new int[BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (i == store1 || i == store2) {
                board[i] = 0;
            } else {
                board[i] = n;
            }
        }
    }

    public boolean move(int k) {
        int seeds = board[k];
        board[k] = 0;
        int currentIndex = k;

        while (seeds > 0) {
            currentIndex = (currentIndex + 1) % BOARD_SIZE;
            if (currentIndex == store2 && k > store1) continue;
            if (currentIndex == store1 && k < store1) continue;
            board[currentIndex]++;
            --seeds;
        }

        return currentIndex == store1 || currentIndex == store2;
    }

    public boolean move2(int k) {
        int seeds = board[k];
        board[k] = 0;
        int currentIndex = k;

        while (seeds > 0) {
            currentIndex = (currentIndex + 1) % BOARD_SIZE;
            if (currentIndex == store2 && k > store1) continue;
            if (currentIndex == store1 && k < store1) continue;
            board[currentIndex]++;
            seeds--;
        }

        if (currentIndex != store1 && currentIndex != store2 && board[currentIndex] == 1) {
            int oppositeIndex = BOARD_SIZE - currentIndex;
            int capturedSeeds = board[oppositeIndex];
            board[oppositeIndex] = 0;
            board[currentIndex] = 0;
            if (k < store1) {
                board[store1] += capturedSeeds + 1;
            } else {
                board[store2] += capturedSeeds + 1;
            }
        }

        return currentIndex == store1 || currentIndex == store2;
    }

    public String toString() {
        return Arrays.toString(board);
    }

    public static void main(String[] args) {
        Mancala game = new Mancala(3);
        System.out.println(game);
        System.out.println(4 + " " + game.move(4));
        System.out.println(game);
        System.out.println(8 + " " + game.move(8));
        System.out.println(game);
        System.out.println();

        game = new Mancala(10);
        System.out.println(game);
        System.out.println(6 + " " + game.move(6));
        System.out.println(game);
        System.out.println();

        System.out.println("Test modified rules:");
        game = new Mancala(10);
        System.out.println(game);
        System.out.println(2 + " " + game.move2(2));
        System.out.println(game);
        System.out.println(4 + " " + game.move2(4));
        System.out.println(game);
    }
}