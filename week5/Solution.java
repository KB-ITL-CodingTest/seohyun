package week5;
/*무인도 여행*/

import java.util.*;

class Solution{
    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static int N, M;
    static char[][] map;

    public int[] solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        map = new char[N][M];
        visited = new boolean[N][M];

        // map 초기화
        for (int i = 0; i < N; i++) {
            map[i] = maps[i].toCharArray();
        }

        List<Integer> islandDays = new ArrayList<>();

        // 모든 위치 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] != 'X') {
                    int days = dfs(i, j);
                    islandDays.add(days);
                }
            }
        }

        if (islandDays.isEmpty()) {
            return new int[]{-1};
        }

        Collections.sort(islandDays);
        return islandDays.stream().mapToInt(i -> i).toArray();
    }


    static int dfs(int x, int y) {
        visited[x][y] = true;
        int sum = map[x][y] - '0';

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if (!visited[nx][ny] && map[nx][ny] != 'X') {
                    sum += dfs(nx, ny);
                }
            }
        }

        return sum;
    }
}
