package day6.LowerUpperBound;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      int num = Integer.parseInt(st.nextToken());
      arr[i] = num;
    }

    st = new StringTokenizer(br.readLine());
    int k = Integer.parseInt(st.nextToken());

    // lowerBound: K가 처음 등장하는 인덱스 (없으면 K보다 큰 수가 처음 등장하는 인덱스) 찾기
    int lowerBound = 100000 + 1;
    int low = 0;
    int high = n - 1;
    int mid = 0;
    while (low <= high) {
      mid = (low + high) / 2;
      if (arr[mid] == k) { // 중간값이 k인 경우
        lowerBound = mid;
        high = mid - 1; // 앞부분에 같은 값이 나오는지 봐야되므로 줄여서 탐색해보기

      } else if (arr[mid] < k) { // k가 중간값보다 오른쪽에 있는 경우
        low = mid + 1;

      } else { // k가 중간값보다 왼쪽
        high = mid - 1;
      }
    }
    if (lowerBound == 100000 + 1) { // k가 등장하지 않은 경우
      lowerBound = low;
    }
    sb.append(lowerBound).append(" ");

    // upper bound: K보다 큰 수가 처음 등장하는 인덱스
    int upperBound = -1;
    low = 0;
    high = n - 1;
    while (low <= high) {
      mid = (low + high) / 2;

      if (arr[mid] == k) { // 중간값이 k인 경우
        upperBound = mid + 1;
        low = mid + 1; // 뒷부분에 같은 값이 나오는지 봐야되므로 줄여서 탐색해보기

      } else if (arr[mid] < k) { // k가 중간값보다 오른쪽에 있는 경우
        low = mid + 1;

      } else { // k가 중간값보다 왼쪽
        high = mid - 1;
      }
    }

    if (upperBound == -1) {
      upperBound = low;
    }
    sb.append(upperBound);
    System.out.println(sb);
  }
}
