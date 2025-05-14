package week7;

import java.util.*;
/*로마 숫자 만들기 */
public class num16922 {

static int N;
static int[] values = {1, 5, 10, 50}; // I, V, X, L
static Set<Integer> resultSet = new HashSet<>();

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();

    dfs(0, 0); // depth, sum

    System.out.println(resultSet.size());
}

// 중복을 허용하면서 N개 고르기 (순서는 상관 없음)
static void dfs(int depth, int sum) {
    if (depth == N) {
        resultSet.add(sum);
        return;
    }

    for (int i = 0; i < 4; i++) {
        dfs(depth + 1, sum + values[i]);
    }
}
}
