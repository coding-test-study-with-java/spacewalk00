package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//큰 수의 법칙
//M이 100억 이상 커졌을 때 시간 초과!
public class Q02 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }
        
        Arrays.sort(arr); 
        
        int max = arr[N-1];
        int second_max = arr[N-2];
        
        int result = 0;
        /*while(true) {
            for(int i=0; i<K; i++) {
                if(M == 0) {
                    break;
                }
                result += max;
                M--;
            }
            if(M == 0) {
                break;
            }
            result += second_max;
            M--;
        }*/
        //가장 큰 수가 더해지는 횟수 계산
        int count = M / (K+1) * K;
        count += M % (K+1);

        result += count * max;
        result += (M - count) * second_max;
                
        System.out.println(result);
    }
}
