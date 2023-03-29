package programmers.coding.kakao;

import java.util.*;

public class 신고결과받기 {
    public static void main(String[] args) {

        /**
         *  case1 ) String[] id_list = {"muzi", "frodo", "apeach", "neo"}
         *          String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}
         *          int k = 2
         *  return ) int[] answer = {2,1,1,0}
         */
        solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}, 2);
        /**
         *  case2 ) String[] id_list = {"con", "ryan"}
         *          String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"}
         *          int k = 3
         *  return ) int[] answer = {0,0}
         */



    }

    public static int[] solution(String[] id_list, String[] report, int k) {

        int[] answer = new int[id_list.length];

        Map<String, HashSet<String>> reportMap      = new HashMap<>();
        Map<String, Integer> countMap               = new HashMap<>();

        // 초기화
        Arrays.stream(id_list).forEach(r -> {
            reportMap.put(r, new HashSet<>());
            countMap.put(r, 0);
        });

        Arrays.asList(report).forEach(r -> {

            String[] arr    = r.split(" ");
            String id       = arr[0];   // 신고한 사람
            String target   = arr[1];   // 신고 당한 사람

            if(!reportMap.get(id).contains(target)) {

                // reportMap 값 넣기
                reportMap.get(id).add(target);
                // countMap 값 넣기
                countMap.put(target, countMap.get(target) + 1);
            }
        });


        for(int i = 0; i < id_list.length; i++) {
            int cnt = 0;
            for(String id:reportMap.get(id_list[i])) {
                if(countMap.get(id) >= k) {
                    cnt++;
                }
            }
            answer[i] = cnt;
        }

//        Arrays.stream(answer).forEach(System.out::println);
        return answer;
    }
}




