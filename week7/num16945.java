package week7;

import java.util.*;
 /*매직 스퀘어로 변경하기 */
public class num16945 {
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int[][] input = new int[3][3];

         // 입력 받기
         for (int i = 0; i < 3; i++) {
             for (int j = 0; j < 3; j++) {
                 input[i][j] = sc.nextInt();
             }
         }

         // 3x3 매직 스퀘어 8가지 경우
         int[][][] magicSquares = {
                 {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},
                 {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
                 {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},
                 {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}},
                 {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
                 {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}},
                 {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},
                 {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}}
         };

         int minCost = Integer.MAX_VALUE;

         // 각 매직 스퀘어와 비교하여 최소 비용 계산
         for (int[][] magic : magicSquares) {
             int cost = 0;
             for (int i = 0; i < 3; i++) {
                 for (int j = 0; j < 3; j++) {
                     cost += Math.abs(input[i][j] - magic[i][j]);
                 }
             }
             minCost = Math.min(minCost, cost);
         }

         System.out.println(minCost);
     }
 }