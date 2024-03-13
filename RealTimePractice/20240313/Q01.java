/*
 * 우체국
 * https://www.acmicpc.net/problem/2141
 * 
 * 우체국이 직선좌표 위에 놓인다는 것, 우체국이 마을이 있는 위치에 지어진다는 것
 * -> 두 가지를 놓치고 헤매고 있었음.
 * 
 */

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MyClass {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        long totalPeople = 0;
        long result = 0;
        
        PriorityQueue<Town> queue = new PriorityQueue<>();
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            long point, people;
            point = Integer.parseInt(st.nextToken());
            people = Integer.parseInt(st.nextToken());

            queue.offer(new Town(point, people));            
            totalPeople += people;
        }
        
        long temp = 0;
        for(int i=0; i<N; i++) {
            Town t = queue.poll();
            temp += t.people;
            
            if( (totalPeople + 1) / 2 <= temp ) {
                //더 커진다면...
                result = t.point;
                break;
            }
            
        }
        
        System.out.println(result);
    }
    
    public static class Town implements Comparable<Town> {
        long point, people;
        
        public Town(long point, long people) {
            this.point = point;
            this.people = people;
        }
        
        @Override
        public int compareTo(Town t) {
            
            if(this.point > t.point) {
                return 1;
            } else if (this.point == t.point) {
                return 0;
            } else {
                return -1;
            }
            
        }
        
    }
    
    
    
    
}