package day6.이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());

    int[] arr = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i=0; i<n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

//    각 쿼리마다 해당 수가 배열에 존재하면 인덱스(0부터 시작)를, 존재하지 않으면 -1을 출력
    int q = Integer.parseInt(br.readLine());

    for (int i=0; i<q; i++) {
      int target = Integer.parseInt(br.readLine());

      // 이진탐색으로 찾기
      boolean flag = false;
      int low = 0, high = n-1;
      while(low <= high) {
        // 중간 찾기
        int mid = (low + high) / 2;
        if (arr[mid] == target) { // 배열의 중간값이 타겟값인 경우
          sb.append(mid).append("\n");
          flag = true;
          break;
        } else if (arr[mid] < target) { // 타겟값이 중간값보다 오른쪽에 있는 경우
          low = mid + 1;
        } else { // 타겟값이 중간값보다 왼쪽
          high = mid - 1;
        }

      }
      if (!flag) {
        sb.append("-1").append("\n");
      }
    }

    System.out.println(sb);
  }
}
