package day19.소수구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int m = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());

    boolean[] isComposite = new boolean[n+1];
    isComposite[0] = isComposite[1] = true;

    // 2단계: 2부터 √N까지 반복하면서, isComposite[i]가 false(소수)이면 i*i부터 i의 배수를 전부 true
    for (int i=2; i*i<=n; i++) {
      if (!isComposite[i]) { // i번째 수가 소수면
        // i*i부터 i의 배수를 전부 true
        // i보다 작은 수와의 곱은 이미 그 수를 처리할 때 지워짐
        for (int j=i*i; j<=n; j=j+i) {
          isComposite[j] = true;
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i=m; i<=n; i++) {
      if (!isComposite[i]) {
        sb.append(i).append("\n");
      }
    }

    System.out.print(sb);
  }

}
