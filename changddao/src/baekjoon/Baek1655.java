package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baek1655 {
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a); //큰값을 root값으로
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (minHeap.size() == maxHeap.size()) {
                maxHeap.add(num);
                if (minHeap.size() != 0 && minHeap.peek() < maxHeap.peek()) {
                    maxHeap.add(minHeap.poll());
                    minHeap.add(maxHeap.poll());
                }
            }else{
                minHeap.add(num);
                if (maxHeap.peek() > minHeap.peek()) {
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(minHeap.poll());
                }
            }
            sb.append(maxHeap.peek()).append("\n");
        }
        System.out.println(sb.toString());
    }

}
