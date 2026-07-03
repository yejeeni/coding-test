package day4.성적순위표;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());

    // 1. HashMap으로 이름:점수 저장하고 정렬하기
    HashMap<String, Integer> nameScore = new HashMap<>();
    for (int i=0; i<n; i++) {
      st = new StringTokenizer(br.readLine());
      // name: score 저장
      nameScore.put(st.nextToken(), Integer.parseInt(st.nextToken()));
    }

    // HashMap에서 entry 목록을 ArrayList로 꺼내기
    ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(nameScore.entrySet());

    // 점수 내림차순, 동점이면 이름 오름차순으로 정렬
    list.sort((a, b) -> {
      if (!a.getValue().equals(b.getValue())) { // 두 점수가 다를 경우
        return b.getValue() - a.getValue(); // 점수 내림차순
      }
      return a.getKey().compareTo(b.getKey()); // 이름 문자 compareTo()로 비교하고 오름차순
    });

    st = new StringTokenizer(br.readLine());
    int q = Integer.parseInt(st.nextToken());

    for (int i=0; i<q; i++) {
      st = new StringTokenizer(br.readLine());
      if (st.nextToken().equals("rank")) {
//      rank name — name의 등수를 출력 (동점자가 있으면 같은 등수, 등수는 나보다 점수 높은 사람 수 + 1)
        String name = st.nextToken();
        Integer score = nameScore.get(name);

        int rank = 0;
        for (int j=0; j<list.size(); j++) {
          if (list.get(j).getValue() > score) { // 정렬해둔 목록에서 나보다 점수 높은 사람이 있는 경우
            rank++;
          }
        }

        System.out.println(rank+1);
      } else {
//      top K — 점수 상위 K명의 이름을 점수 내림차순으로 출력 (동점이면 이름 오름차순)
        int k = Integer.parseInt(st.nextToken());

        for (int j=0; j<k; j++) {
          System.out.print(list.get(j).getKey());
          if (j != k-1) {
            System.out.print(" ");
          }
        }
      }
    }
  }
}
