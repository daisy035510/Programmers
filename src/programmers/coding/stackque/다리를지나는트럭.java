package programmers.coding.stackque;

import java.util.*;

public class 다리를지나는트럭 {

    public static void main(String[] args) {

        solution(2, 10, new int[]{7,4,5,6});
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Truck> bridge = new LinkedList<>();
        int currentWeight = 0;
        int index = 0;
        int time = 0;

        while(index < truck_weights.length) {

            time++;

            if(!bridge.isEmpty() && ((time - bridge.peek().time) == bridge_length)) {
                Truck truck = bridge.poll();
                currentWeight -= truck.weight;
            }

            if(bridge.size() >= bridge_length) {
                continue;
            }

            if((currentWeight + truck_weights[index]) > weight) {
                continue;
            }

            currentWeight += truck_weights[index];
            bridge.add(new Truck(truck_weights[index], time));

            index++;
        }

        return time + bridge_length;
    }

}

class Truck {
    int weight;
    int time;

    public Truck(int weight, int time) {
        this.weight = weight;
        this.time = time;
    }
}