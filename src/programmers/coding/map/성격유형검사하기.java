package programmers.coding.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class 성격유형검사하기 {

    public static final String[] INDEX = {"RT", "CF", "JM", "AN"}; // 성격유형검사 지표
    public static final int STANDARD  = 4; // 점수 기준점
    public static void main(String[] args) {

        // survey	choices	result
        // ["AN", "CF", "MJ", "RT", "NA"]	[5, 3, 2, 7, 5]	"TCMA"
        // ["TR", "RT", "TR"]	[7, 1, 3]	"RCJA"

//        solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5});
        solution(new String[]{"TR", "RT", "TR"}, new int[]{7, 1, 3});


    }
    public static String solution(String[] survey, int[] choices) {

        String answer = "";
        Map<Character, Integer> hashMap = new HashMap<>();

        // 1. map 으로 초기화
        for(int i = 0; i < survey.length; i++) {

            char[] chArr = survey[i].toCharArray();
            int score = choices[i];

            char left = chArr[0];   // 왼쪽 성격 유형검사
            char right = chArr[1];  // 오른쪽 성격 유형검사

            // 4보다 작다면 왼쪽 성격유형검사 선택
            if(score < STANDARD) {
                hashMap.put(left, hashMap.getOrDefault(left, 0) + -(score - STANDARD));
            } else {
                hashMap.put(right, hashMap.getOrDefault(right, 0) + (score - STANDARD));
            }
        }


        // 2. INDEX 와 비교해서 성격유형 도출
        for(String strArr : INDEX) {
            // {"RT", "CF", "JM", "AN"};
            char[] chArr = strArr.toCharArray();

            int lScore = hashMap.containsKey(chArr[0]) ? hashMap.get(chArr[0]) : 0;
            int rScore = hashMap.containsKey(chArr[1]) ? hashMap.get(chArr[1]) : 0;

            // 왼쪽 점수가 더 높다면
            if(lScore < rScore) {
                answer += chArr[1];
            } else {
                answer += chArr[0];
            }
        }

        System.out.println("answer >> " + answer);
        return answer;
    }

}
