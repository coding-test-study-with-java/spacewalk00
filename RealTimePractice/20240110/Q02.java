/**
 * 스터디 그룹
 * https://www.acmicpc.net/problem/14572
 * 
 * [그리디]
 * 최대한의 학생을 그룹에 포함시킬수록 이득
 * 
 * [투포인터 알고리즘]
 * [s, e]에서 s, e를 어떻게 구성할지

 * 1. (e의 실력 - s의 실력)이 D 초과
 * 1-1. s가 알고있는 알고리즘들을 E를 계산할 때 필요한 요소들에서 제외, s를 증가.
 * 2. D 이하
 * 2-1. E의 최대치를 갱신한 후, e를 증가시킴. 그리고 증가된 e에 해당하는 학생이 알고맀는 알고리즘을 E의 요소들을 계산할 수 있도록 추가.
 */
import java.util.*;
import java.io.*;

public class MyClass {
    
    public static class Member implements Comparable<Member> {
        public int ability;
        public List<Integer> algors;
        
        public Member(int ability, List<Integer> algors) {
            this.ability = ability;
            this.algors = algors;
        }
        
        @Override
        public int compareTo(Member m) {
            return this.ability - m.ability;
        }
    }

    public static List<Member> memberList;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        
        memberList = new ArrayList<Member>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            
            List<Integer> algorsList = new ArrayList<>(M);
            String[] algors = br.readLine().split(" ");
            for(int j=0; j<M; j++) {
                algorsList.add(Integer.parseInt(algors[j]));
            }
            memberList.add(new Member(d, algorsList));
        }
        
        Collections.sort(memberList);

        //투포인터 알고리즘
        int max = 0;
        int s = 0, e = 0;
        int[] algorsCnt = new int[K+1]; //알고리즘(1, 2, 3, 4, ...)당 개수
        for(int t : memberList.get(0).algors) {
            algorsCnt[t]++;
        }
    
        while(true) {
            int gap = memberList.get(e).ability - memberList.get(s).ability;
            if(gap <= D) {
                max = Math.max(max, getE(algorsCnt, s, e));
                e++;
                if(e >= N) {
                    break;
                }
                
                for(int t : memberList.get(e).algors) {
                    algorsCnt[t]++;
                }
                continue;
            }
            
            for(int t : memberList.get(s).algors) {
                algorsCnt[t]--; //현재 start에 위치한 학생이 알고 있는 알고리즘 제외
            }
            s++;
        }
        System.out.println(max);
    }

    public static int getE(int[] arr, int s, int e) { //E 계산함수
        int cnt1 = 0;
        int cnt2 = 0;
        int n = e-s+1;
        
        for(int i=0; i<arr.length; i++) {
            
            if(arr[i] != 0) {
                cnt1++;
            } 
            if(arr[i] == n) {
                cnt2++;
            }
        }
        return (cnt1-cnt2)*n;
    }
    
}