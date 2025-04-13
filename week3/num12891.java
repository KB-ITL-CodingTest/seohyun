/* DNA 비밀번호 */
import java.util.Scanner;

public class num12891 {
    static int[] required = new int[4]; // 최소 조건
    static int[] current = new int[4];  // 현재 윈도우 안 문자 개수
    static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int S = sc.nextInt(); // 전체 DNA 문자열 길이
        int P = sc.nextInt(); // 부분 문자열 길이
        String dna = sc.next(); // DNA 문자열

        for (int i = 0; i < 4; i++) {
            required[i] = sc.nextInt();
        }

        char[] dnaArr = dna.toCharArray();

        // 초기 윈도우 설정
        for (int i = 0; i < P; i++) {
            add(dnaArr[i]);
        }

        if (isValid()) result++;

        // 슬라이딩 윈도우
        for (int i = P; i < S; i++) {
            add(dnaArr[i]);
            remove(dnaArr[i - P]);
            if (isValid()) result++;
        }

        System.out.println(result);
    }

    static void add(char c) {
        switch (c) {
            case 'A': current[0]++; break;
            case 'C': current[1]++; break;
            case 'G': current[2]++; break;
            case 'T': current[3]++; break;
        }
    }

    static void remove(char c) {
        switch (c) {
            case 'A': current[0]--; break;
            case 'C': current[1]--; break;
            case 'G': current[2]--; break;
            case 'T': current[3]--; break;
        }
    }

    static boolean isValid() {
        for (int i = 0; i < 4; i++) {
            if (current[i] < required[i]) return false;
        }
        return true;
    }
}
