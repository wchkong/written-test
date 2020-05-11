package fall2019.t23mihoyo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        char[][] game = new char[x][y];
        for (int i = 0; i < x; i++) {
            String s = scanner.nextLine();
            char[] chars = s.toCharArray();
            game[i] = chars;
        }
        int startx = scanner.nextInt();
        int starty = scanner.nextInt();
        int endx = scanner.nextInt();
        int endy = scanner.nextInt();

        char temp = game[startx][starty];
        game[startx][starty] = game[endx][endy];
        game[endx][endy] = temp;

        int del = del(game, startx, starty);
        int del1 = del(game, endx, endy);
        System.out.print(del + del1);
    }

    public static int del(char[][] game, int startx, int starty) {

        List<Character> characterList = new ArrayList<>();
        List<Character> characterList1 = new ArrayList<>();
        for (int i = startx > 1 ? startx - 2 : 0;
             i < (startx + 2 > game.length ? game.length : startx + 2); i++) {
            characterList.add(game[startx][i]);
        }
        for (int i = starty > 1 ? starty - 2 : 0;
             i < (starty + 2 > game[0].length ? game[0].length : starty + 2); i++) {
            characterList1.add(game[i][starty]);
        }
        if (check(characterList) && check(characterList1)) {
            return 5;
        } else if (check(characterList) || check(characterList1)) {
            return 3;
        }
        return 0;
    }

    public static boolean check(List<Character> characterList) {
        int length = 1;
        char last = characterList.get(0);
        for (int i = 1; i < characterList.size(); i++) {
            Character character = characterList.get(i);
            if (character == last) {
                length ++;
            } else {
                last = character;
            }
        }
        if (length >= 3) {
            return true;
        }
        return false;
    }
}
