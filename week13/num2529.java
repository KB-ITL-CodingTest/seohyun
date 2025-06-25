package week13;

import java.util.*;

/*부등호*/

public class num2529 {
    static int k;
    static char[] signs;
    static boolean[] used = new boolean[10]; // 숫자 사용 여부
    static List<String> results = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        signs = new char[k];
        for (int i = 0; i < k; i++) {
            signs[i] = sc.next().charAt(0);
        }

        // 최소값 찾기 (작은 수부터 시도)
        dfs(0, "");
        Collections.sort(results);
        System.out.println(results.get(results.size() - 1)); // 최대값
        System.out.println(results.get(0)); // 최소값
    }

    // depth: 현재 자릿수
    // num: 현재까지 만들어진 숫자 문자열
    static void dfs(int depth, String num) {
        if (depth == k + 1) {
            results.add(num);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (used[i]) continue;
            if (depth == 0 || isValid(num.charAt(depth - 1) - '0', i, signs[depth - 1])) {
                used[i] = true;
                dfs(depth + 1, num + i);
                used[i] = false;
            }
        }
    }

    // 부등호 검사
    static boolean isValid(int a, int b, char op) {
        if (op == '<') return a < b;
        else return a > b;
    }
}