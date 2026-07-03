package day22.행렬K번회전;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken()); // n*n 행렬
    int k = Integer.parseInt(st.nextToken()); // 시계방향으로 k번 회전

    int[][] matrix = new int[n][n];
    for (int i=0; i<n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j=0; j<n; j++) {
        matrix[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int[][] temp = new int[n][n];
    for (int t = 0; t < k%4; t++) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          // 90도 회전
          temp[j][n - i - 1] = matrix[i][j];
        }
      }
      // temp 값을 매트릭스에 다시 저장
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          matrix[i][j] = temp[i][j];
        }
      }
      // 더 나은 코드
//      for (int i = 0; i < n; i++) {
//        matrix[i] = temp[i].clone();
//      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        sb.append(matrix[i][j]).append(" ");
      }
      sb.append("\n");
    }

    System.out.println(sb);
  }
}
