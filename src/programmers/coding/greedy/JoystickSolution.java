package programmers.coding.greedy;

class JoystickSolution {

    public static void main(String[] args) {

        // JEROEN
        // JAN
        int rlst = solution("JEROEN");
        System.out.println("결과값 :" + rlst);
    }
    public static int solution(String name) {

        int upDown  = 0;
        int len     = name.length();
        int move    = len - 1; // 오른쪽으로 쭉 간 회수

        for(int i = 0; i < len; i++) {

            upDown += Math.min(name.charAt(i) - 'A', 26 - (name.charAt(i) - 'A'));
            int nextIndex = i + 1;
            // 다음 단어가 A이고, 단어가 끝나기 전까지 nextIndex 증가
            while(nextIndex < len && name.charAt(nextIndex) == 'A') {
                nextIndex++;
            }
            //min=Math.min(min,i+length-next+Math.min(i,length-next));
            move = Math.min(move, i * 2 + (name.length() - nextIndex));// 오른쪽으로 갔다 다시 왼쪽으로 꺾기(BBAAAAAYYY)
            move = Math.min(move, i + (name.length() - nextIndex) * 2);// 왼쪽으로 갔다 다시 오른쪽으로 꺾기(CCCAAAAAAY)
        }

        System.out.println("upDown : " + upDown);
        System.out.println("move : " + move);

        int answer = upDown + move;
        return answer;
    }


}

