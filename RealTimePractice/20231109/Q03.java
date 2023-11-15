/**
 * [회의실 배정]
 * https://www.acmicpc.net/problem/1931
 * 
 * <그리디 알고리즘>
 * '탐욕 선택'이 이후의 결과에 영향을 미치지 않는다.
 * -> 
 * 이전의 선택 결과가 이후의 결과에 영향을 미치지 않으려면 
 * 먼저 이전 종료 시간과, 이후 선택의 시작 시간이 겹치지 않으면 된다.
 * 그리고 최대한 많은 활동을 선택하려면 종료시간이 빨라야 할 수 밖에 없을 것이다.
 * ->
 * 종료 시간을 기준으로 정렬을 하는 것.
 */
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[][] time = new int[N][2]; //[0]:시작시간 [1]:종료시간
        
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) { //종료시간이 같다면 시작시간이 빠른 순으로
                    return o1[0] - o2[0];
                } 
                return o1[1] - o2[1];
            }
        });
        
        int cnt = 0;
        int prev_end = 0;
        
        for(int i=0; i<N; i++) {
            //직전 종료 시간이 다음 회의 시작 시간보다 작거나 같다면 갱신
            if(prev_end <= time[i][0]) {
                prev_end = time[i][1];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}

