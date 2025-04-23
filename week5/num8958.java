package week5;

import java.util.Scanner;

public class num8958 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String answer = null;
        int score = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            score=0;
            answer = sc.next();
            for (int j = 0; j < answer.length(); j++) {
                if (answer.charAt(j) == 'O') {
                    count++;
                    score = score + count;
                } else if (answer.charAt(j) == 'X') {
                    count = 0;
                }
            }
        }
        System.out.println(score);
    }
}
