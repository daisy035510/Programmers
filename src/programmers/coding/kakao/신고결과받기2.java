package programmers.coding.kakao;

import java.util.*;

public class 신고결과받기2 {
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

        HashMap<String, HashSet<String>> reportHash = new HashMap<String, HashSet<String>>();
        HashMap<String, Integer> count = new HashMap<String, Integer>();

        int[] answer = new int[id_list.length];

        for(String id : id_list) {
            reportHash.put(id, new HashSet<String>());
            count.put(id, 0);
        }

        for(String s : report) {
            String[] str = s.split(" ");

            if(!reportHash.get(str[0]).contains(str[1])) {
                int cnt = count.get(str[1]);
                count.put(str[1], cnt+1);
                reportHash.get(str[0]).add(str[1]);
            }

        }

        for(int i=0;i<id_list.length;i++) {
            int cnt = 0;

            for(String id:reportHash.get(id_list[i])) {
                if(count.get(id) >= k) {
                    cnt++;
                }
            }


            answer[i] = cnt;
        }


        Arrays.stream(answer).forEach(System.out::println);
        return answer;
    }

}


