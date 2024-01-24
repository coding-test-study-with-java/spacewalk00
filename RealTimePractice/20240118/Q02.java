/*
 * [뉴스 전하기]
 * https://www.acmicpc.net/problem/1135
 * 
 * 도시락 먼저 데우기 알고리즘 
 * : 먹는데 시간이 오래 걸리는 음식을 먼저 데우기..
 * 
 * 이 문제에서는 부하 직원들 중에 가장 전파가 오래 걸리는 직원한테 먼저 전파해야 함.
 * 탐색할 때 가장 오래 걸리는 부하 직원을 정렬하고, 차례대로 카운트를 붙여 늘려준 합산이 상사가 선택할 부하직원임.
 * 
 * 깊이 우선 탐색 + 동적 계획법 !
*/
import java.util.*;
import java.io.*;

public class MyClass {
    public static List<Integer>[] tree;
    public static int[] dp;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N];
        
        for(int i=0; i<N; i++) {
            tree[i] = new ArrayList<>(); //tree의 인덱스는 상사번호
        }
        
        String[] nums = br.readLine().split(" ");
        int[] superior = new int[N];
        for(int i=0; i<N; i++) {
            superior[i] = Integer.parseInt(nums[i]);
        }
        
        for(int i=1; i<N; i++) {
            tree[superior[i]].add(i); 
        }
        dp = new int[N];
        
        System.out.println(dfs(0));
    }
    
    public static int dfs(int su) {
        int cnt = 0, max = 0;
        
        PriorityQueue<int[]> underQueue = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]); //내림차순
        
        for(int under : tree[su]) {
            dp[under] = dfs(under); //최댓값 얻고 저장
            underQueue.add(new int[]{under, dp[under]}); //최댓값이 가장 큰 부분(전파속도가 오래걸리는 부분)부터 차례로. 
        }
        
        while(!underQueue.isEmpty()) {
            int[] node = underQueue.poll();
            cnt++; //부하 직원 수 만큼 카운트 하는 이유 : A의 부하 직원이 B~Z까지 라면, A가 전파하는데 걸리는 시간은 부하직원 수 만큼 걸릴 것이기 때문
            max = Math.max(max, node[1] + cnt); 
        }
        return max;
    }
}