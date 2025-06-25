package week13;


/*테르로미노*/
/*정사각형은 서로 겹치면 안 된다.
도형은 모두 연결되어 있어야 한다.
정사각형의 변끼리 연결되어 있어야 한다.
즉, 꼭짓점과 꼭짓점만 맞닿아 있으면 안 된다.*/

import java.util.*;

public class num14500 {
    static int N, M;
    static int[][] map;
    static int max = 0;

    // 19가지 테트로미노 모양 (4칸 상대 좌표)
    static int[][][] tetromino = {
            // ㅡ
            {{0,0},{0,1},{0,2},{0,3}},
            {{0,0},{1,0},{2,0},{3,0}},
            // ㅁ
            {{0,0},{0,1},{1,0},{1,1}},
            // ㄴ자 계열
            {{0,0},{1,0},{2,0},{2,1}},
            {{0,0},{1,0},{2,0},{2,-1}},
            {{0,0},{0,1},{0,2},{1,2}},
            {{0,0},{0,1},{0,2},{-1,2}},
            {{0,0},{1,0},{1,1},{1,2}},
            {{0,0},{1,0},{1,-1},{1,-2}},
            // 번개자 계열
            {{0,0},{0,1},{1,1},{1,2}},
            {{0,0},{0,1},{-1,1},{-1,2}},
            {{0,0},{1,0},{1,1},{2,1}},
            {{0,0},{1,0},{1,-1},{2,-1}},
            // ㅗ자 계열
            {{0,0},{0,1},{0,2},{1,1}},
            {{0,0},{1,0},{2,0},{1,1}},
            {{0,0},{1,0},{1,-1},{1,1}},
            {{0,0},{0,1},{-1,1},{1,1}},
            // 반대 ㄴ자 계열
            {{0,0},{1,0},{2,0},{0,1}},
            {{0,0},{0,1},{1,1},{2,1}}
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];

        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                map[i][j] = sc.nextInt();
            }
        }

        // 모든 위치에서 19개 테트로미노 시도
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                for(int[][] shape : tetromino) {
                    int sum = 0;
                    boolean valid = true;

                    for(int[] block : shape) {
                        int ni = i + block[0];
                        int nj = j + block[1];

                        if(ni<0 || nj<0 || ni>=N || nj>=M) {
                            valid = false;
                            break;
                        }
                        sum += map[ni][nj];
                    }

                    if(valid) max = Math.max(max, sum);
                }
            }
        }

        System.out.println(max);
    }
}
