/**
 * [회의실 배정] 미완 (틀림)
 * https://www.acmicpc.net/problem/1931
 */
import java.util.*;
import java.io.*;

public class MyClass {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int meetings = Integer.parseInt(br.readLine());
        
        int start_time = 0;
        int end_time = 0; 
        int cnt = 0;
        
        for(int i=0; i<meetings; i++) {
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            
            if(s < end_time) {
                continue;
            }
            cnt++;
            start_time = s;
            end_time = e;
        }
        
        System.out.println(cnt);
    }
}
