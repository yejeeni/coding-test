package day22.배열돌리기3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

  static int n;
  static int m;
  static int[][] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    int r = Integer.parseInt(st.nextToken());

    arr = new int[n][m];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < r; i++) {
      int cmd = Integer.parseInt(st.nextToken());

      if (cmd == 1) {
        arr = vertical();
      } else if (cmd == 2) {
        arr = horizontal();
      } else if (cmd == 3) {
        arr = rightSpin();
        int tmp = n;
        n = m;
        m = tmp;
      } else if (cmd == 4) {
        arr = leftSpin();
        int tmp = n;
        n = m;
        m = tmp;
      } else if (cmd == 5) {
        arr = cmd5();
      } else {
        arr = cmd6();
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        sb.append(arr[i][j]).append(" ");
      }
      sb.append("\n");
    }

    System.out.print(sb);
  }

  static int[][] vertical() {
    int[][] result = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        result[i][j] = arr[n - i - 1][j];
      }
    }
    return result;
  }

  static int[][] horizontal() {
    int[][] result = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        result[i][j] = arr[i][m - j - 1];
      }
    }
    return result;
  }

  static int[][] rightSpin() {
    int[][] result = new int[m][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        result[j][n - i - 1] = arr[i][j];
      }
    }
    return result;
  }

  static int[][] leftSpin() {
    int[][] result = new int[m][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        result[m - j - 1][i] = arr[i][j];
      }
    }
    return result;
  }

  static int[][] cmd5() {
    int[][] result = new int[n][m];

    // 배열을 4등분...
    int r = n / 2;
    int c = m / 2;

    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        result[i][c+j] = arr[i][j];
        result[r+i][c+j] = arr[i][c+j];
        result[r+i][j] = arr[r+i][c+j];
        result[i][j] = arr[r+i][j];
      }
    }
    return result;
  }


  static int[][] cmd6() {
    int[][] result = new int[n][m];
    int r = n / 2;
    int c = m / 2;

    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        result[r+i][j] = arr[i][j];
        result[r+i][c+j] = arr[r+i][j];
        result[i][c+j] = arr[r+i][c+j];
        result[i][j] = arr[i][c+j];
      }
    }
    return result;
  }

}
