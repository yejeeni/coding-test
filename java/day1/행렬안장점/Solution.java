package day1.행렬안장점;

import java.io.*;
import java.util.*;

public class 행렬안장점 {
  public static void main(String args[]) throws IOException{
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    // 행, 열
    int n = Integer.parseInt(stringTokenizer.nextToken());
    int m = Integer.parseInt(stringTokenizer.nextToken());
    int[][] matrix = new int[n][m];

    for (int i=0; i<n; i++) {
      stringTokenizer = new StringTokenizer(bufferedReader.readLine());

      for (int j=0; j<m; j++) {
        matrix[i][j] = Integer.parseInt(stringTokenizer.nextToken());
      }
    }

    int a = Integer.MIN_VALUE; // A = 각 행의 최솟값들 중 최댓값 (row-min의 max)
    int b = Integer.MAX_VALUE; // B = 각 열의 최댓값들 중 최솟값 (col-max의 min)

    // 각 행의 최솟값들 중 최댓값 (row-min의 max) 구하기
    for (int[] row : matrix) {
      // 현재 행의 최솟값
      int min = Integer.MAX_VALUE;
      for (int val : row) {
        if (val < min) {
          min = val;
        }
      }
      // 최솟값 중 최대값
      if (min > a) {
        a = min;
      }
    }

    // 각 열의 최댓값들 중 최솟값 (col-max의 min)
    for (int j=0 ; j<m; j++) {
      int max = Integer.MIN_VALUE; // 각 열의 최댓값

      for (int i=0; i<n; i++) {
        int col = matrix[i][j];
        if (col > max) {
          max = col;
        }
      }

      if (max < b) {
        b = max;
      }
    }

    // A와 B가 같으면 SADDLE POINT: {값} 을 출력하고, 다르면 A={A값} B={B값} 을 출력하시오.
    if (a == b) {
      System.out.print("SADDLE POINT: " + a);
    } else {
      System.out.print("A=" + a + " B=" + b);
    }
    }
}
