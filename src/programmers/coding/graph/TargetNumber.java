package programmers.coding.graph;

/**
 * 프로그래머스에서는 시간 복잡도 500만번 이하면 괜찮다
 * 완전탐색(최악의 시간 복잡도)과 비교
 */

public class TargetNumber{

    public static void main(String[] args) {


        //  numbers	target	return
        // case1 : [1, 1, 1, 1, 1]	3	5
        // case2 : [4, 1, 2, 1]	4	2

        TargetNumberSolution target = new TargetNumberSolution();
        int n = target.solution(new int[]{1, 1, 1, 1, 1}, 3); // 5
//        int n = target.solution(new int[]{4, 1, 2, 1}, 4); // 2

        System.out.println("rslt >> " + n);
    }
}

class TargetNumberSolution {

    private int target;
    private int answer;
    private int[] numbers;

    public int solution(int[] numbers, int target) {

        this.answer = 0;
        this.numbers = numbers;
        this.target = target;

        dfs(0,0);

        return this.answer;
    }

    public void dfs(int index, int sum) {

        // 1. 탈출조건
        if(index == this.numbers.length) {
            if(sum == this.target) {
                this.answer++;
            }

            // System.out.println("탈출했나");
//            System.out.println("index :" + index + ", sum : "  + sum  + ", this.numbers.length : " + this.numbers.length);
            return;
        }

        // 2. 수행동작
        dfs(index + 1, sum + this.numbers[index]);
        dfs(index + 1, sum - this.numbers[index]);
    }
}
