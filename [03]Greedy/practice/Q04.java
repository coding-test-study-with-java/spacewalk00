package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//1이 될 때까지
public class Q04 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int result = 0;
        while(N != 1) {
            if(N % K != 0) {
                N -= 1;
            } else {
                N /= K;
            }
            result += 1;
        }
        System.out.println(result);
    }
}
