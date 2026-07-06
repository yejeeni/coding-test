package round2.d0705;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken()); // n 일간
    int m = Integer.parseInt(st.nextToken()); // m 번만 인출
    int arr[] = new int[n];

    int low = -1;
    int high = 0;
    for (int i=0; i<n; i++) {
      int money = Integer.parseInt(br.readLine());
      arr[i] = money; // 매번 인출할 금액
      // 하루 사용 금액이 남은 돈보다 많으면, 돈을 넣고 다시 k원 인출
      // 인출횟수 m번을 맞추기 위해 남은 돈이 충분해도 강제로 반납 및 인출 가능
      high += money;
      if (money > low) {
        low = money;
      }
    }

    int result = Integer.MAX_VALUE;
    while(low <= high) {
      int mid = (low + high) / 2;
      int nowMoney = mid;
      int cnt = 1;

      for (int i=0; i<n; i++) {
        int useMoney = arr[i];
        if (nowMoney < useMoney) { // 가진 돈이 쓸 돈보다 적음
          // 인출
          nowMoney = mid;
          cnt++;
        }
        nowMoney -= useMoney;


      }
      if (cnt <= m) {
        high = mid - 1;
        result = mid;
      } else {
        low = mid + 1;
      }
    }
    System.out.println(result);
  }
}
