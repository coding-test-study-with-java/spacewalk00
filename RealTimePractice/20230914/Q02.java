/**
 * 프로세스
 * LEVEL 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/42587
 * 
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 * 
 * 1차 풀이: 'queue로 풀려 하다 큰 값을 갱신하는 부분이 문제가 돼서 실패'
 * 2차 풀이: '큰 값 갱신을 priorityQueue를 활용해서 성공'
 */
import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {  
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); //내림차순
        
        for(int num : priorities) {
            pq.add(num);
        }
        while(!pq.isEmpty()) {
            for(int i=0; i<priorities.length; i++) {
                if(priorities[i] == pq.peek()) { //값이 일치할 때
                    pq.poll();
                    answer++;
                    if(i == location) { //인덱스도 동일할 때
                        return answer;
                    }
                }
            }
        }
        return answer;
        
        //Queue<Element> queue = new LinkedList<Element>();
        //Queue<Element> newQueue = new LinkedList<Element>();
        /*int max = -1;
        for(int i=(priorities.length-1); i>=0; i--) {
            if(max < priorities[i]) {
                max = priorities[i];
            }
            char pro = (char)('A' + i);
            queue.offer(new Element(pro, priorities[i]));
        }
        
        int cnt = 0;
        while(!queue.isEmpty()) {
            if(queue.peek().priority < max) {
                queue.offer(queue.peek()); //꺼낸 걸 다시 넣는 코드...
            } else { //queue.peek() == max
                char target = (char)('A'+location);
                if(target == queue.peek().process) {
                    return ++cnt;
                }
                //큰 값을 갱신하는 부분 부재
                //newQueue.offer(queue.peek());
            }
            queue.poll();
        }
        
        //char target = (char)('A'+location);
        //int cnt = 0;
        /*while(!newQueue.isEmpty()) {
            cnt++;
            if(target == newQueue.peek().process) {
                return cnt;
            }
            newQueue.poll();
        }
        return -1;*/
    }
    /*public static class Element {
        char process;
        int priority;
        public Element(char process, int priority) {
            this.process = process;
            this.priority = priority;
        }
    }*/
}